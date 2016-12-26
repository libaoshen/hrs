package com.libaoshen.hrs.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.libaoshen.hrs.bean.Room;
import com.libaoshen.hrs.service.IRoomService;

@Controller
@RequestMapping("/")
public class MainController {
	@Resource
	IRoomService roomService;
	
	@RequestMapping("")
	public String toHome(Model model){
		List<Room> roomList = roomService.getAllRoom();
		model.addAttribute("roomList", roomList);
		model.addAttribute("which", 1);
		model.addAttribute("title", "首页");
		return "showHome";
	}
	
	@RequestMapping("showHelp")
	public String toHelp(Model model){
		model.addAttribute("title", "使用指南");
		model.addAttribute("which", 2);
		return "showHelp";
	}
}
