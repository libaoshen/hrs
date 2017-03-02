package com.libaoshen.hrs.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.libaoshen.hrs.bean.Admin;
import com.libaoshen.hrs.bean.Room;
import com.libaoshen.hrs.service.IAdminService;
import com.libaoshen.hrs.service.IRoomService;
import com.libaoshen.hrs.util.MD5Util;

/**
 * 管理员登录控制器
 * @author 404
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Resource
	private IAdminService adminService;
	@Resource
	private IRoomService roomService;
	
	/**
	 * 显示登录页面
	 * @param model
	 * @return
	 */
	@RequestMapping({"/",""})
	public String toLogin(Model model) {
		model.addAttribute(new Admin());
		return "showAdminLogin";
	}
	
	/**
	 * 显示首页界面
	 * @param model
	 * @return
	 */
	@RequestMapping("/home")
	public String toHome(Model model, HttpSession session) {
		model.addAttribute(new Room());
		model.addAttribute("title", "首页");
		return "showAdminHome";
	}
	
	/**
	 * 登录逻辑,返回视图信息和相关提示信息
	 * @param admin 前台传回的登录信息
	 * @param session 登录信息保存在session中
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("admin") Admin admin, Model model, HttpSession session){
		ModelAndView mav = new ModelAndView();	
		try {	
			String adminname = admin.getAdminname();
			//使用md5加密
			String password = MD5Util.getMD5Code(admin.getPassword());
			
			//判断用户名或密码是否正确
			for(Admin a : adminService.getAllAdmin()) {
				//用户名正确
				if(a.getAdminname().equals(adminname)) {
					//密码正确
					if(password.equalsIgnoreCase(a.getPassword())){
						session.setAttribute("admin", a);
						mav.addObject("title", "首页");
						mav.addObject(new Room());
						mav.setViewName("showAdminHome");
						return mav;
					}
					else{
						break;
					}
				}
			}
			
			//账号或密码错误
			String message = "账号或密码错误";
			mav.addObject("message",message);
			mav.setViewName("showAdminLogin");
			return mav;
		} catch (java.lang.NullPointerException e) {
			mav.addObject(new Admin());
			mav.setViewName("showAdminLogin");
			return mav;
		}
	}
	
	/**
	 * 安全退出
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(Model model, HttpSession session) {
		//如果已经登录,则清空session
		if(session.getAttribute("admin") != null) {
			session.setAttribute("admin", null);
		}
		model.addAttribute(new Admin());
		return "showAdminLogin";
	}
}
