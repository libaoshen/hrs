package com.libaoshen.hrs.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.libaoshen.hrs.bean.Room;
import com.libaoshen.hrs.bean.User;
import com.libaoshen.hrs.service.IRoomService;
import com.libaoshen.hrs.service.IUserService;
import com.libaoshen.hrs.util.MD5Util;
import com.libaoshen.hrs.util.TokenProccessor;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	IUserService userservice;
	@Resource
	IRoomService roomService;
	//用户分页数
	private int pageSize1 = 5;
	
	/**
	 * 用户管理
	 * @param model
	 * @return
	 */
	@RequestMapping({"/",""})
	public String toUser(Model model, HttpServletRequest request) {
		model.addAttribute("title", "用户管理");
		model.addAttribute(new Room());
		
		List<User> userList = userservice.getAllUser();
		//保存分页信息
		request.setAttribute("usercounts", userList.size());
		request.setAttribute("userpagesize", pageSize1);
		return "showUser";
	}
	
	/**
	 * ajax分页处理
	 * @param pageIndex 当前页数
	 * @param pageSize 每页大小
	 * @param totalPage 总共的数据数
	 * @return
	 */
	@RequestMapping("/ajax_operation")
	public @ResponseBody List<Object> findContactAjax(String pageIndex,String pageSize,String totalPage) {  
	    //获取当前页数和每页大小
		Integer pageIndex1 = Integer.parseInt(pageIndex);
	    Integer pageSize1 = Integer.parseInt(pageSize);
	    Integer totalPage1 = Integer.parseInt(totalPage);
	    //System.out.println(pageIndex1);
	    //System.out.println(pageSize1);
	    //获取相应页的数据
		List<User> userList = userservice.getAllUser();		
		List<List<String>> dateList = new ArrayList<List<String>>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		
		for(int i = 0; i < userList.size(); i++) {
			List<String> date = new ArrayList<String>();
			date.add(sdf.format(userList.get(i).getRegtime()));
			date.add(sdf.format(userList.get(i).getLastlogintime()));
			
			dateList.add(date);
		}
		//保存分页数据
		List<List<String>> dateList1 = new ArrayList<List<String>>();
		List<User> userList1 = new ArrayList<User>();
		//System.out.println(totalPage1/pageSize1);
		if(pageIndex1 <= totalPage1/pageSize1){
			userList1 = userList.subList((pageIndex1-1) * pageSize1, pageIndex1 * pageSize1);
			dateList1 = dateList.subList((pageIndex1-1) * pageSize1, pageIndex1 * pageSize1);
		}else {
			userList1 = userList.subList((pageIndex1-1) * pageSize1, totalPage1);
			dateList1 = dateList.subList((pageIndex1-1) * pageSize1, totalPage1);
		}
		//保存数据并返回
		List<Object> resultList = new ArrayList<Object>();
	    resultList.add(userList1);
	    resultList.add(dateList1);
		return resultList; 
    }  
	
	/**
	 * 显示用户登录界面
	 * @param model
	 * @return
	 */
	@RequestMapping("/showLogin")
	public String showLogin(Model model) {
		model.addAttribute(new User());
		return "showLogin";
	}
	
	/**
	 * 登录功能
	 * @param user
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/login")
	public String login(@ModelAttribute("user") User user, Model model, HttpServletRequest request) {
		List<User> userList = userservice.getAllUser();
		String username = user.getUsername();
		String password = MD5Util.getMD5Code(user.getPassword());
		User user1 = null;
		boolean flag = false;
		for(User u : userList){
			if(username.equals(u.getUsername())){
				flag = true;
				user1 = u;
				break;
			}
		}
		
		if(!flag){
			model.addAttribute("message", "用户名或密码错误");
			return "showLogin";
		}else if(!user1.getPassword().equals(password)){
			model.addAttribute("message", "用户名或密码错误");
			return "showLogin";
		}else {
			Date time= new java.sql.Date(new java.util.Date().getTime());
			user1.setLastlogintime(time);
			user1.setLastloginip(getRemoteHost(request));
			userservice.updateUser(user1);
			request.getSession().setAttribute("user", user1);
			model.addAttribute("which", 1);
			List<Room> roomList = roomService.getAllRoom();
			model.addAttribute("roomList", roomList);
			model.addAttribute("title", "首页");
			return "showHome"; 
		}
	}
	
	/**
	 * 用户登出
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(Model model, HttpServletRequest request) {
		List<Room> roomList = roomService.getAllRoom();
		model.addAttribute("roomList", roomList);
		request.getSession().setAttribute("user", null);
		model.addAttribute("title", "首页");
		return "showHome";
	}
	
	
	/**
	 * 显示用户注册界面
	 * @param model
	 * @return
	 */
	@RequestMapping("/showRegister")
	public String showRegister(Model model,HttpServletRequest request) {
		model.addAttribute(new User());
		//创建令牌,防止重复提交
		String token = TokenProccessor.getInstance().makeToken();
		request.getSession().setAttribute("token", token);//在服务器使用session保存令牌
		
		return "showRegister";
	}
	
	/**
	 * 用户注册
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register(@ModelAttribute("user") User user, Model model, HttpServletRequest request) {
		
		boolean b = isRepeatSubmit(request);//判断用户是否重复提交
		if(b == true) {
			model.addAttribute("message", "注册成功");
			return "showRegisterSuccess";
		}
		
		request.getSession().removeAttribute("token");//移除session中的token
		
		String username = user.getUsername();
		List<User> userList = userservice.getAllUser();
		//判断数据库中是否存在当前用户名
		boolean flag = true;
		for(User u : userList){
			if(u.getUsername().equals(username)){
				flag = false;
			}
		}
		
		if(flag){
			user.setRegip(getRemoteHost(request));
			user.setLastloginip(getRemoteHost(request));
			Date time= new java.sql.Date(new java.util.Date().getTime());
			user.setRegtime(time);
			user.setLastlogintime(time);
			user.setPassword(MD5Util.getMD5Code(user.getPassword()));
			
			//保存到数据库
			userservice.addUser(user);
			model.addAttribute("message", "注册成功");
			return "showRegisterSuccess";
		}else {
			model.addAttribute("message", "账号已存在!");
			return "showRegister";
		}
	}
	
	
	/**
	 * 显示找回密码界面
	 * @param request
	 * @return
	 */
	@RequestMapping("/showFindPassword")
	public String showFindPassword(Model model) {
		model.addAttribute("pageInfo", 1);
		return "showFindPassword1";
	}
	
	/**
	 * 显示验证用户名
	 * @param request
	 * @return
	 */
	@RequestMapping("/validateUsername")
	public String showFindPassword1(Model model, HttpServletRequest request) {
		String username = request.getParameter("username");
		User u = userservice.getUserByUserName(username);
		boolean flag = false;
		
		if(u != null) {
			flag = true;
		}
		
		if(flag) {
			model.addAttribute("userid", u.getUserid());
			//System.out.println(u.getUserid());
			model.addAttribute("pageInfo", 2);
			return "showFindPassword2";
		}else {
			model.addAttribute("message", "该账号不存在");
			model.addAttribute("pageInfo", 1);
			return "showFindPassword1";
		}
	}
	
	/**
	 * 显示验证电话号码页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/validatePhone")
	public String showFindPassword2(Model model, HttpServletRequest request) {
		String userid = request.getParameter("userid");
		//System.out.println(userid);
		String phone = request.getParameter("phone");
		User user = userservice.getUserById(Integer.parseInt(userid));
		boolean flag = false;
		
		if(user.getPhone().equals(phone)) {
			flag = true;
		}
		
		model.addAttribute("userid", user.getUserid());
		
		if(flag) {	
			model.addAttribute("pageInfo", 3);
			//创建令牌,防止重复提交
			String token = TokenProccessor.getInstance().makeToken();
			request.getSession().setAttribute("token", token);//在服务器使用session保存令牌
			return "showFindPassword3";
		}else {
			model.addAttribute("message", "电话号码不正确");
			model.addAttribute("pageInfo", 2);
			return "showFindPassword2";
		}
	}
	
	/**
	 * 改密码
	 * @param request
	 * @return
	 */
	@RequestMapping("/updatePassword")
	public String showFindPassword3(Model model, HttpServletRequest request) {
		
		boolean b = isRepeatSubmit(request);//判断用户是否重复提交
		if(b == true) {
			model.addAttribute("message", "重置密码成功");
			model.addAttribute("pageInfo", 4);
			return "showUpdateSuccess";
		}
		
		request.getSession().removeAttribute("token");//移除session中的token
		
		String userid = request.getParameter("userid");
		//System.out.println(userid);
		String password = request.getParameter("password");
		User user = userservice.getUserById(Integer.parseInt(userid));
		
		user.setPassword(MD5Util.getMD5Code(password));
		userservice.updateUser(user);
		//System.out.println("hah ");
		model.addAttribute("message", "重置密码成功");
		model.addAttribute("pageInfo", 4);
		return "showFindPassword4";	
	}
	
	/**
	 * 显示修改用户信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/showUpdateInfo")
	public String showUpdateInfo(HttpServletRequest request) {
		//创建令牌,防止重复提交
		String token = TokenProccessor.getInstance().makeToken();
		request.getSession().setAttribute("token", token);//在服务器使用session保存令牌
		request.setAttribute("title", "修改用户信息");
		
		return "showUpdateInfo";
	}
	
	/**
	 * 修改用户信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/updateInfo")
	public String updateInfo(HttpServletRequest request) {
		
		boolean b = isRepeatSubmit(request);//判断用户是否重复提交
		if(b == true) {
			request.setAttribute("message", "修改用户信息成功");
			request.setAttribute("title", "修改用户信息");
			return "showUpdateSuccess";
		}
		
		request.getSession().removeAttribute("token");//移除session中的token
		
		//获取修改信息
		boolean sex = Boolean.parseBoolean(request.getParameter("sex"));
		String phone = request.getParameter("phone");
		//获取用户信息
		User user = (User)request.getSession().getAttribute("user");
		//修改用户信息
		user.setSex(sex);
		user.setPhone(phone);
		userservice.updateUser(user);
		//System.out.println(sex+phone);
		request.setAttribute("message", "修改用户信息成功");
		request.setAttribute("title", "修改用户信息");
		
		return "showUpdateSuccess";
	}
	
	/**
	 * 显示用户信息
	 * @param request
	 * @return
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping("/showUserInfo")
	public String showUserInfo(HttpServletRequest request) {
		//从session中获取用户信息
		User user = (User)request.getSession().getAttribute("user");
		//计算账户年龄
		String old = "";
		Date time= new java.sql.Date(new java.util.Date().getTime());
		int oldYear = time.getYear() - user.getRegtime().getYear();
		if(oldYear == 0) {
			old = "小于1年";
		}else {
			old = oldYear + "年";
		}
		//返回用户信息
		request.setAttribute("user", user);
		request.setAttribute("old", old);
		
		//转换最近一次登录时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		request.setAttribute("lastlogintime", sdf.format(user.getLastlogintime()));
		//最近一次登录ip
		String ip[] = user.getLastloginip().split("\\.");
		request.setAttribute("lastloginip", ip[0] + "." + ip[1] + ".*.*");
		request.setAttribute("title", "用户信息");
		return "showUserInfo";
	}
	
	/**
     * 判断客户端提交上来的令牌和服务器端生成的令牌是否一致
     * @param request
     * @return 
     *         true 用户重复提交了表单 
     *         false 用户没有重复提交表单
     */
    private boolean isRepeatSubmit(HttpServletRequest request) {
        String client_token = request.getParameter("token");
        //1、如果用户提交的表单数据中没有token，则用户是重复提交了表单
        if(client_token==null){
            return true;
        }
        //取出存储在Session中的token
        String server_token = (String) request.getSession().getAttribute("token");
        //2、如果当前用户的Session中不存在Token(令牌)，则用户是重复提交了表单
        if(server_token==null){
            return true;
        }
        //3、存储在Session中的Token(令牌)与表单提交的Token(令牌)不同，则用户是重复提交了表单
        if(!client_token.equals(server_token)){
            return true;
        }
        
        return false;
    }
	
	
	/**
	 * 获取真实的ip地址
	 * @param request
	 * @return
	 */
	public String getRemoteHost(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
			ip = request.getHeader("Proxy-Client-IP");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
			ip = request.getRemoteAddr();
		}
		return ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip;
	}
}
