package com.libaoshen.hrs.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.libaoshen.hrs.bean.Room;
import com.libaoshen.hrs.service.IAdminService;
import com.libaoshen.hrs.service.IRoomService;

@Controller
@RequestMapping("/room")
public class RoomController {
	
	@Resource
	private IAdminService adminService;
	@Resource
	private IRoomService roomService;
	
	//分页数
	private int pageSize = 5;
	
	/**
	 * 房间管理
	 * @param model
	 * @return
	 */
	@RequestMapping({"/",""})
	public String toRoom(Model model) {
		//获取所有的房型信息
		List<Room> roomList = roomService.getAllRoom();
		int pages = 5;
		model.addAttribute("roompages", pages);
		model.addAttribute("roomcounts", roomList.size());
		//model.addAttribute("roomList",roomList);
		model.addAttribute("title", "房间管理");
		model.addAttribute(new Room());
		return "showRoom";
	}
	
	/**
	 * ajax分页处理
	 * @param pageIndex 当前页数
	 * @param pageSize 每页大小
	 * @param totalPage 总共的数据数
	 * @return
	 */
	@RequestMapping("/ajax_operation")
	public @ResponseBody List<Room> findContactAjax(String pageIndex,String pageSize,String totalPage) {  
	    //获取当前页数和每页大小
		Integer pageIndex1 = Integer.parseInt(pageIndex);
	    Integer pageSize1 = Integer.parseInt(pageSize);
	    Integer totalPage1 = Integer.parseInt(totalPage);
	    //System.out.println(pageIndex1);
	    //System.out.println(pageSize1);
	    //获取相应页的数据
		List<Room> roomList = roomService.getAllRoom();
		List<Room> roomList1 = null;
		//System.out.println(totalPage1/pageSize1);
		if(pageIndex1 <= totalPage1/pageSize1){
			roomList1 = roomList.subList((pageIndex1-1) * pageSize1, pageIndex1 * pageSize1);
		}else {
			roomList1 = roomList.subList((pageIndex1-1) * pageSize1, totalPage1);
		}
		//保存数据并返回
	    return roomList1;  
    }  
	
	/**
	 * 添加房型信息
	 * @param room 前台传入的房型信息
	 * @param model
	 * @return
	 */
	@RequestMapping("/addRoom")
	public String addRoom(@ModelAttribute("room") Room room, @RequestParam("imageInfo") MultipartFile image, Model model, HttpServletRequest request) {
		
		if(roomService.getRoomByRoomName(room.getRoomname()) == null) {
			room.setRoomleftnum(room.getRoomtotalnum());
			//保存图片
			Date date = new Date();
			String imageName = date.getTime() + ".jpg";
			saveImage(request.getServletContext().getRealPath("/images/room") + "/" + imageName, image);
			room.setImginfo(imageName);
			roomService.addRoom(room);
			model.addAttribute("feedback_addroom", 1);
		}else {
			model.addAttribute("feedback_addroom", 2);
			model.addAttribute("message", "房型名已存在");
		}
		
		List<Room> roomList = roomService.getAllRoom();
		//int pages = 5;
		model.addAttribute("roompages", pageSize);
		model.addAttribute("roomcounts", roomList.size());
		//model.addAttribute("roomList",roomList);
		model.addAttribute("title", "房间管理");
		model.addAttribute(new Room());
		return "showRoom";
	}
	
	/**
	 * 保存图片至本地
	 * @param imageName
	 * @param image
	 */
	private void saveImage(String imageName, MultipartFile image){
		
		File file = new File(imageName);
		try {
			FileUtils.writeByteArrayToFile(file, image.getBytes());
		} catch (IOException e) {
			e.printStackTrace(); 
		}
		
	}
	
	/**
	 * 删除房型信息
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/deleteRoom")
	public String deleteRoom(Model model ,HttpServletRequest request) {
		String id = request.getParameter("id");
		Room room = roomService.getRoomById(Integer.parseInt(id));
		//获取所有的房型信息
		//List<Room> roomList = roomService.getAllRoom();
//		int pages = 5;
//		model.addAttribute("roompages", pages);
//		model.addAttribute("roomcounts", roomList.size());
		if(room != null) {
			roomService.deleteRoomByRoomId(Integer.parseInt(id));
			model.addAttribute("feedback_addroom", 3);//3代表删除成功
		}else {
			model.addAttribute("feedback_addroom", 4);//4代表删除的房型信息不存在
		}
		
		List<Room> roomList = roomService.getAllRoom();
		//int pages = 5;
		model.addAttribute("roompages", pageSize);
		model.addAttribute("roomcounts", roomList.size());
		model.addAttribute("title", "房间管理");
		model.addAttribute(new Room());
		return "showRoom";
	}
	
	/**
	 * 显示修改房型信息界面
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/showUpdateRoom")
	public String toUpdateRoom(Model model, HttpServletRequest request){
		String id = request.getParameter("id");
		Room room = roomService.getRoomById(Integer.parseInt(id));
		//获取所有的房型信息
		List<Room> roomList = roomService.getAllRoom();
		//int pages = 5;
		model.addAttribute("roompages", pageSize);
		model.addAttribute("roomcounts", roomList.size());
		if(room == null) {
			model.addAttribute(new Room());
			model.addAttribute("feedback_addroom", 6);//6代表修改房型信息的id不存在
			//model.addAttribute(new Room());
		}else {
			model.addAttribute(room);
			model.addAttribute("feedback_addroom", 5);//5代表修改房型信息
			//model.addAttribute(new Room());
		}
		
		model.addAttribute("title", "房间管理");
		return "showRoom";
	}
	/**
	 * 修改room信息
	 * @param room
	 * @param image
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/updateRoom")
	public String updateRoom(@ModelAttribute("room") Room room, @RequestParam("imageInfo1") MultipartFile image, Model model, HttpServletRequest request){
		//判断roomname是否和其他roomname重复
		List<Room> rooms = roomService.getAllRoom();
		Room roomid = roomService.getRoomById(room.getRoomid());
		Boolean flag = true;
		for(int i = 0; i < rooms.size(); i++){
			if(roomid.getRoomname().equals(rooms.get(i).getRoomname())) {
				rooms.remove(i);
			} 
		}
		
		for(Room r : rooms){
			if(room.getRoomname().equals(r.getRoomname())) {
				flag = false;
			} 
		}
		//System.out.println(flag);
		//判断flag
		if(flag) {
			if(request.getParameter("imageInfo") == null){
				//不修改图片
				Room room1 = roomService.getRoomById(room.getRoomid());
				room.setImginfo(room1.getImginfo());
				
			}else {
				//保存图片
				Date date = new Date();
				String imageName = date.getTime() + ".jpg";
				saveImage(request.getServletContext().getRealPath("/images/room") + "/" + imageName, image);
				room.setImginfo(imageName);
			}
			
			//修改房型信息
			roomService.updateRoom(room);
			model.addAttribute("feedback_addroom", 7);//修改房型信息成功
			//获取所有的房型信息
			
		}else {
			model.addAttribute("feedback_addroom", 8);//房型信息重复
			//model.addAttribute("message1", "房型名已存在");
		}
		
		//获取所有的房型信息并返回
		List<Room> roomList = roomService.getAllRoom();
		//int pages = 5;
		model.addAttribute("roompages", pageSize);
		model.addAttribute("roomcounts", roomList.size());
		model.addAttribute(new Room());
		model.addAttribute("title", "房间管理");
		return "showRoom";
	}
}
