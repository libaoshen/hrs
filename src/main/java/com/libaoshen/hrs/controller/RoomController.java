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
	
	//��ҳ��
	private int pageSize = 5;
	
	/**
	 * �������
	 * @param model
	 * @return
	 */
	@RequestMapping({"/",""})
	public String toRoom(Model model) {
		//��ȡ���еķ�����Ϣ
		List<Room> roomList = roomService.getAllRoom();
		int pages = 5;
		model.addAttribute("roompages", pages);
		model.addAttribute("roomcounts", roomList.size());
		//model.addAttribute("roomList",roomList);
		model.addAttribute("title", "�������");
		model.addAttribute(new Room());
		return "showRoom";
	}
	
	/**
	 * ajax��ҳ����
	 * @param pageIndex ��ǰҳ��
	 * @param pageSize ÿҳ��С
	 * @param totalPage �ܹ���������
	 * @return
	 */
	@RequestMapping("/ajax_operation")
	public @ResponseBody List<Room> findContactAjax(String pageIndex,String pageSize,String totalPage) {  
	    //��ȡ��ǰҳ����ÿҳ��С
		Integer pageIndex1 = Integer.parseInt(pageIndex);
	    Integer pageSize1 = Integer.parseInt(pageSize);
	    Integer totalPage1 = Integer.parseInt(totalPage);
	    //System.out.println(pageIndex1);
	    //System.out.println(pageSize1);
	    //��ȡ��Ӧҳ������
		List<Room> roomList = roomService.getAllRoom();
		List<Room> roomList1 = null;
		//System.out.println(totalPage1/pageSize1);
		if(pageIndex1 <= totalPage1/pageSize1){
			roomList1 = roomList.subList((pageIndex1-1) * pageSize1, pageIndex1 * pageSize1);
		}else {
			roomList1 = roomList.subList((pageIndex1-1) * pageSize1, totalPage1);
		}
		//�������ݲ�����
	    return roomList1;  
    }  
	
	/**
	 * ��ӷ�����Ϣ
	 * @param room ǰ̨����ķ�����Ϣ
	 * @param model
	 * @return
	 */
	@RequestMapping("/addRoom")
	public String addRoom(@ModelAttribute("room") Room room, @RequestParam("imageInfo") MultipartFile image, Model model, HttpServletRequest request) {
		
		if(roomService.getRoomByRoomName(room.getRoomname()) == null) {
			room.setRoomleftnum(room.getRoomtotalnum());
			//����ͼƬ
			Date date = new Date();
			String imageName = date.getTime() + ".jpg";
			saveImage(request.getServletContext().getRealPath("/images/room") + "/" + imageName, image);
			room.setImginfo(imageName);
			roomService.addRoom(room);
			model.addAttribute("feedback_addroom", 1);
		}else {
			model.addAttribute("feedback_addroom", 2);
			model.addAttribute("message", "�������Ѵ���");
		}
		
		List<Room> roomList = roomService.getAllRoom();
		//int pages = 5;
		model.addAttribute("roompages", pageSize);
		model.addAttribute("roomcounts", roomList.size());
		//model.addAttribute("roomList",roomList);
		model.addAttribute("title", "�������");
		model.addAttribute(new Room());
		return "showRoom";
	}
	
	/**
	 * ����ͼƬ������
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
	 * ɾ��������Ϣ
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/deleteRoom")
	public String deleteRoom(Model model ,HttpServletRequest request) {
		String id = request.getParameter("id");
		Room room = roomService.getRoomById(Integer.parseInt(id));
		//��ȡ���еķ�����Ϣ
		//List<Room> roomList = roomService.getAllRoom();
//		int pages = 5;
//		model.addAttribute("roompages", pages);
//		model.addAttribute("roomcounts", roomList.size());
		if(room != null) {
			roomService.deleteRoomByRoomId(Integer.parseInt(id));
			model.addAttribute("feedback_addroom", 3);//3����ɾ���ɹ�
		}else {
			model.addAttribute("feedback_addroom", 4);//4����ɾ���ķ�����Ϣ������
		}
		
		List<Room> roomList = roomService.getAllRoom();
		//int pages = 5;
		model.addAttribute("roompages", pageSize);
		model.addAttribute("roomcounts", roomList.size());
		model.addAttribute("title", "�������");
		model.addAttribute(new Room());
		return "showRoom";
	}
	
	/**
	 * ��ʾ�޸ķ�����Ϣ����
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/showUpdateRoom")
	public String toUpdateRoom(Model model, HttpServletRequest request){
		String id = request.getParameter("id");
		Room room = roomService.getRoomById(Integer.parseInt(id));
		//��ȡ���еķ�����Ϣ
		List<Room> roomList = roomService.getAllRoom();
		//int pages = 5;
		model.addAttribute("roompages", pageSize);
		model.addAttribute("roomcounts", roomList.size());
		if(room == null) {
			model.addAttribute(new Room());
			model.addAttribute("feedback_addroom", 6);//6�����޸ķ�����Ϣ��id������
			//model.addAttribute(new Room());
		}else {
			model.addAttribute(room);
			model.addAttribute("feedback_addroom", 5);//5�����޸ķ�����Ϣ
			//model.addAttribute(new Room());
		}
		
		model.addAttribute("title", "�������");
		return "showRoom";
	}
	/**
	 * �޸�room��Ϣ
	 * @param room
	 * @param image
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/updateRoom")
	public String updateRoom(@ModelAttribute("room") Room room, @RequestParam("imageInfo1") MultipartFile image, Model model, HttpServletRequest request){
		//�ж�roomname�Ƿ������roomname�ظ�
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
		//�ж�flag
		if(flag) {
			if(request.getParameter("imageInfo") == null){
				//���޸�ͼƬ
				Room room1 = roomService.getRoomById(room.getRoomid());
				room.setImginfo(room1.getImginfo());
				
			}else {
				//����ͼƬ
				Date date = new Date();
				String imageName = date.getTime() + ".jpg";
				saveImage(request.getServletContext().getRealPath("/images/room") + "/" + imageName, image);
				room.setImginfo(imageName);
			}
			
			//�޸ķ�����Ϣ
			roomService.updateRoom(room);
			model.addAttribute("feedback_addroom", 7);//�޸ķ�����Ϣ�ɹ�
			//��ȡ���еķ�����Ϣ
			
		}else {
			model.addAttribute("feedback_addroom", 8);//������Ϣ�ظ�
			//model.addAttribute("message1", "�������Ѵ���");
		}
		
		//��ȡ���еķ�����Ϣ������
		List<Room> roomList = roomService.getAllRoom();
		//int pages = 5;
		model.addAttribute("roompages", pageSize);
		model.addAttribute("roomcounts", roomList.size());
		model.addAttribute(new Room());
		model.addAttribute("title", "�������");
		return "showRoom";
	}
}
