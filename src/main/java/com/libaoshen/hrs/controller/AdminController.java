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
 * ����Ա��¼������
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
	 * ��ʾ��¼ҳ��
	 * @param model
	 * @return
	 */
	@RequestMapping({"/",""})
	public String toLogin(Model model) {
		model.addAttribute(new Admin());
		return "showAdminLogin";
	}
	
	/**
	 * ��ʾ��ҳ����
	 * @param model
	 * @return
	 */
	@RequestMapping("/home")
	public String toHome(Model model, HttpSession session) {
		model.addAttribute(new Room());
		model.addAttribute("title", "��ҳ");
		return "showAdminHome";
	}
	
	/**
	 * ��¼�߼�,������ͼ��Ϣ�������ʾ��Ϣ
	 * @param admin ǰ̨���صĵ�¼��Ϣ
	 * @param session ��¼��Ϣ������session��
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("admin") Admin admin, Model model, HttpSession session){
		ModelAndView mav = new ModelAndView();	
		try {	
			String adminname = admin.getAdminname();
			//ʹ��md5����
			String password = MD5Util.getMD5Code(admin.getPassword());
			
			//�ж��û����������Ƿ���ȷ
			for(Admin a : adminService.getAllAdmin()) {
				//�û�����ȷ
				if(a.getAdminname().equals(adminname)) {
					//������ȷ
					if(password.equalsIgnoreCase(a.getPassword())){
						session.setAttribute("admin", a);
						mav.addObject("title", "��ҳ");
						mav.addObject(new Room());
						mav.setViewName("showAdminHome");
						return mav;
					}
					else{
						break;
					}
				}
			}
			
			//�˺Ż��������
			String message = "�˺Ż��������";
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
	 * ��ȫ�˳�
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(Model model, HttpSession session) {
		//����Ѿ���¼,�����session
		if(session.getAttribute("admin") != null) {
			session.setAttribute("admin", null);
		}
		model.addAttribute(new Admin());
		return "showAdminLogin";
	}
}
