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
	//�û���ҳ��
	private int pageSize1 = 5;
	
	/**
	 * �û�����
	 * @param model
	 * @return
	 */
	@RequestMapping({"/",""})
	public String toUser(Model model, HttpServletRequest request) {
		model.addAttribute("title", "�û�����");
		model.addAttribute(new Room());
		
		List<User> userList = userservice.getAllUser();
		//�����ҳ��Ϣ
		request.setAttribute("usercounts", userList.size());
		request.setAttribute("userpagesize", pageSize1);
		return "showUser";
	}
	
	/**
	 * ajax��ҳ����
	 * @param pageIndex ��ǰҳ��
	 * @param pageSize ÿҳ��С
	 * @param totalPage �ܹ���������
	 * @return
	 */
	@RequestMapping("/ajax_operation")
	public @ResponseBody List<Object> findContactAjax(String pageIndex,String pageSize,String totalPage) {  
	    //��ȡ��ǰҳ����ÿҳ��С
		Integer pageIndex1 = Integer.parseInt(pageIndex);
	    Integer pageSize1 = Integer.parseInt(pageSize);
	    Integer totalPage1 = Integer.parseInt(totalPage);
	    //System.out.println(pageIndex1);
	    //System.out.println(pageSize1);
	    //��ȡ��Ӧҳ������
		List<User> userList = userservice.getAllUser();		
		List<List<String>> dateList = new ArrayList<List<String>>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� HHʱmm��ss��");
		
		for(int i = 0; i < userList.size(); i++) {
			List<String> date = new ArrayList<String>();
			date.add(sdf.format(userList.get(i).getRegtime()));
			date.add(sdf.format(userList.get(i).getLastlogintime()));
			
			dateList.add(date);
		}
		//�����ҳ����
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
		//�������ݲ�����
		List<Object> resultList = new ArrayList<Object>();
	    resultList.add(userList1);
	    resultList.add(dateList1);
		return resultList; 
    }  
	
	/**
	 * ��ʾ�û���¼����
	 * @param model
	 * @return
	 */
	@RequestMapping("/showLogin")
	public String showLogin(Model model) {
		model.addAttribute(new User());
		return "showLogin";
	}
	
	/**
	 * ��¼����
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
			model.addAttribute("message", "�û������������");
			return "showLogin";
		}else if(!user1.getPassword().equals(password)){
			model.addAttribute("message", "�û������������");
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
			model.addAttribute("title", "��ҳ");
			return "showHome"; 
		}
	}
	
	/**
	 * �û��ǳ�
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(Model model, HttpServletRequest request) {
		List<Room> roomList = roomService.getAllRoom();
		model.addAttribute("roomList", roomList);
		request.getSession().setAttribute("user", null);
		model.addAttribute("title", "��ҳ");
		return "showHome";
	}
	
	
	/**
	 * ��ʾ�û�ע�����
	 * @param model
	 * @return
	 */
	@RequestMapping("/showRegister")
	public String showRegister(Model model,HttpServletRequest request) {
		model.addAttribute(new User());
		//��������,��ֹ�ظ��ύ
		String token = TokenProccessor.getInstance().makeToken();
		request.getSession().setAttribute("token", token);//�ڷ�����ʹ��session��������
		
		return "showRegister";
	}
	
	/**
	 * �û�ע��
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register(@ModelAttribute("user") User user, Model model, HttpServletRequest request) {
		
		boolean b = isRepeatSubmit(request);//�ж��û��Ƿ��ظ��ύ
		if(b == true) {
			model.addAttribute("message", "ע��ɹ�");
			return "showRegisterSuccess";
		}
		
		request.getSession().removeAttribute("token");//�Ƴ�session�е�token
		
		String username = user.getUsername();
		List<User> userList = userservice.getAllUser();
		//�ж����ݿ����Ƿ���ڵ�ǰ�û���
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
			
			//���浽���ݿ�
			userservice.addUser(user);
			model.addAttribute("message", "ע��ɹ�");
			return "showRegisterSuccess";
		}else {
			model.addAttribute("message", "�˺��Ѵ���!");
			return "showRegister";
		}
	}
	
	
	/**
	 * ��ʾ�һ��������
	 * @param request
	 * @return
	 */
	@RequestMapping("/showFindPassword")
	public String showFindPassword(Model model) {
		model.addAttribute("pageInfo", 1);
		return "showFindPassword1";
	}
	
	/**
	 * ��ʾ��֤�û���
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
			model.addAttribute("message", "���˺Ų�����");
			model.addAttribute("pageInfo", 1);
			return "showFindPassword1";
		}
	}
	
	/**
	 * ��ʾ��֤�绰����ҳ��
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
			//��������,��ֹ�ظ��ύ
			String token = TokenProccessor.getInstance().makeToken();
			request.getSession().setAttribute("token", token);//�ڷ�����ʹ��session��������
			return "showFindPassword3";
		}else {
			model.addAttribute("message", "�绰���벻��ȷ");
			model.addAttribute("pageInfo", 2);
			return "showFindPassword2";
		}
	}
	
	/**
	 * ������
	 * @param request
	 * @return
	 */
	@RequestMapping("/updatePassword")
	public String showFindPassword3(Model model, HttpServletRequest request) {
		
		boolean b = isRepeatSubmit(request);//�ж��û��Ƿ��ظ��ύ
		if(b == true) {
			model.addAttribute("message", "��������ɹ�");
			model.addAttribute("pageInfo", 4);
			return "showUpdateSuccess";
		}
		
		request.getSession().removeAttribute("token");//�Ƴ�session�е�token
		
		String userid = request.getParameter("userid");
		//System.out.println(userid);
		String password = request.getParameter("password");
		User user = userservice.getUserById(Integer.parseInt(userid));
		
		user.setPassword(MD5Util.getMD5Code(password));
		userservice.updateUser(user);
		//System.out.println("hah ");
		model.addAttribute("message", "��������ɹ�");
		model.addAttribute("pageInfo", 4);
		return "showFindPassword4";	
	}
	
	/**
	 * ��ʾ�޸��û���Ϣ
	 * @param request
	 * @return
	 */
	@RequestMapping("/showUpdateInfo")
	public String showUpdateInfo(HttpServletRequest request) {
		//��������,��ֹ�ظ��ύ
		String token = TokenProccessor.getInstance().makeToken();
		request.getSession().setAttribute("token", token);//�ڷ�����ʹ��session��������
		request.setAttribute("title", "�޸��û���Ϣ");
		
		return "showUpdateInfo";
	}
	
	/**
	 * �޸��û���Ϣ
	 * @param request
	 * @return
	 */
	@RequestMapping("/updateInfo")
	public String updateInfo(HttpServletRequest request) {
		
		boolean b = isRepeatSubmit(request);//�ж��û��Ƿ��ظ��ύ
		if(b == true) {
			request.setAttribute("message", "�޸��û���Ϣ�ɹ�");
			request.setAttribute("title", "�޸��û���Ϣ");
			return "showUpdateSuccess";
		}
		
		request.getSession().removeAttribute("token");//�Ƴ�session�е�token
		
		//��ȡ�޸���Ϣ
		boolean sex = Boolean.parseBoolean(request.getParameter("sex"));
		String phone = request.getParameter("phone");
		//��ȡ�û���Ϣ
		User user = (User)request.getSession().getAttribute("user");
		//�޸��û���Ϣ
		user.setSex(sex);
		user.setPhone(phone);
		userservice.updateUser(user);
		//System.out.println(sex+phone);
		request.setAttribute("message", "�޸��û���Ϣ�ɹ�");
		request.setAttribute("title", "�޸��û���Ϣ");
		
		return "showUpdateSuccess";
	}
	
	/**
	 * ��ʾ�û���Ϣ
	 * @param request
	 * @return
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping("/showUserInfo")
	public String showUserInfo(HttpServletRequest request) {
		//��session�л�ȡ�û���Ϣ
		User user = (User)request.getSession().getAttribute("user");
		//�����˻�����
		String old = "";
		Date time= new java.sql.Date(new java.util.Date().getTime());
		int oldYear = time.getYear() - user.getRegtime().getYear();
		if(oldYear == 0) {
			old = "С��1��";
		}else {
			old = oldYear + "��";
		}
		//�����û���Ϣ
		request.setAttribute("user", user);
		request.setAttribute("old", old);
		
		//ת�����һ�ε�¼ʱ��
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� HHʱmm��ss��");
		request.setAttribute("lastlogintime", sdf.format(user.getLastlogintime()));
		//���һ�ε�¼ip
		String ip[] = user.getLastloginip().split("\\.");
		request.setAttribute("lastloginip", ip[0] + "." + ip[1] + ".*.*");
		request.setAttribute("title", "�û���Ϣ");
		return "showUserInfo";
	}
	
	/**
     * �жϿͻ����ύ���������ƺͷ����������ɵ������Ƿ�һ��
     * @param request
     * @return 
     *         true �û��ظ��ύ�˱� 
     *         false �û�û���ظ��ύ��
     */
    private boolean isRepeatSubmit(HttpServletRequest request) {
        String client_token = request.getParameter("token");
        //1������û��ύ�ı�������û��token�����û����ظ��ύ�˱�
        if(client_token==null){
            return true;
        }
        //ȡ���洢��Session�е�token
        String server_token = (String) request.getSession().getAttribute("token");
        //2�������ǰ�û���Session�в�����Token(����)�����û����ظ��ύ�˱�
        if(server_token==null){
            return true;
        }
        //3���洢��Session�е�Token(����)����ύ��Token(����)��ͬ�����û����ظ��ύ�˱�
        if(!client_token.equals(server_token)){
            return true;
        }
        
        return false;
    }
	
	
	/**
	 * ��ȡ��ʵ��ip��ַ
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
