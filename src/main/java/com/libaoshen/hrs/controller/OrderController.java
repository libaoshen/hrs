package com.libaoshen.hrs.controller;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.libaoshen.hrs.bean.Order;
import com.libaoshen.hrs.bean.Room;
import com.libaoshen.hrs.bean.User;
import com.libaoshen.hrs.service.IOrderService;
import com.libaoshen.hrs.service.IRoomService;
import com.libaoshen.hrs.service.IUserService;
import com.libaoshen.hrs.util.TokenProccessor;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Resource
	public IRoomService roomService;
	@Resource
	public IOrderService orderService;
	@Resource
	public IUserService userService;
	//��¼�ظ��ύ����һ�εĶ�����Ϣ
	private static Order order_previous = new Order();
	//��¼��̨������ҳ��
	private int pageSize = 5;
	
	/**
	 * ��������
	 * @param model
	 * @return
	 */
	@RequestMapping({"/",""})
	public String toOrder(Model model, HttpServletRequest request) {
		model.addAttribute("title", "��������");
		model.addAttribute(new Room());
		List<Order> orderList = orderService.getAllOrder();
		model.addAttribute("orderpagesize", pageSize);
  		model.addAttribute("ordercounts", orderList.size());
		return "showOrder";
	}
	
	/**
	 * ajax��ҳ�������еĶ���
	 * @param pageIndex ��ǰҳ��
	 * @param pageSize ÿҳ��С
	 * @param totalPage �ܹ���������
	 * @return
	 */
	@RequestMapping("/ajax_operation1")
	public @ResponseBody List<Object> findContactAjax1(String pageIndex,String pageSize,String totalPage) {  
	    return ajax_common(pageIndex, pageSize, totalPage, 1); 
    } 
	
	/**
	 * ajax��ҳ�������еĶ���,��������
	 * @param pageIndex ��ǰҳ��
	 * @param pageSize ÿҳ��С
	 * @param totalPage �ܹ���������
	 * @return
	 */
	@RequestMapping("/ajax_operation11")
	public @ResponseBody List<Integer> findContactAjax11() {  
		List<Order> orderList11 = orderService.getAllOrder();	
		List<Integer> page = new ArrayList<Integer>();
		page.add(orderList11.size());
		page.add(pageSize);
		return page;
    }
	
	/**
	 * ajax��ҳ������յĶ���
	 * @param pageIndex ��ǰҳ��
	 * @param pageSize ÿҳ��С
	 * @param totalPage �ܹ���������
	 * @return
	 */
	@RequestMapping("/ajax_operation2")
	public @ResponseBody List<Object> findContactAjax2(String pageIndex,String pageSize,String totalPage) {  
		return ajax_common(pageIndex, pageSize, totalPage, 2); 
    }  
	
	/**
	 * ajax��ҳ������յĶ���,��������
	 * @param pageIndex ��ǰҳ��
	 * @param pageSize ÿҳ��С
	 * @param totalPage �ܹ���������
	 * @return
	 */
	@RequestMapping("/ajax_operation22")
	public @ResponseBody List<Integer> findContactAjax22() {  
		List<Order> orderList11 = orderService.getAllOrder();
		//����
		int count = 0;
		//��count
		for(int i =0 ; i < orderList11.size(); i++) {
			Order o = orderList11.get(i);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");  
			Date time= new java.sql.Date(new java.util.Date().getTime());
			if(sdf.format(o.getOrdertime()).equals(sdf.format(time))) {
				count++;
			}
		}
		
		List<Integer> page = new ArrayList<Integer>();
		page.add(count);
		page.add(pageSize);
		return page;
    }
	
	/**
	 * ajax��ҳ����δ֧���Ķ���
	 * @param pageIndex ��ǰҳ��
	 * @param pageSize ÿҳ��С
	 * @param totalPage �ܹ���������
	 * @return
	 */
	@RequestMapping("/ajax_operation3")
	public @ResponseBody List<Object> findContactAjax3(String pageIndex,String pageSize,String totalPage) {  
		return ajax_common(pageIndex, pageSize, totalPage, 3);
    }  
	
	/**
	 * ajax��ҳ����δ֧���Ķ���,��������
	 * @param pageIndex ��ǰҳ��
	 * @param pageSize ÿҳ��С
	 * @param totalPage �ܹ���������
	 * @return
	 */
	@RequestMapping("/ajax_operation33")
	public @ResponseBody List<Integer> findContactAjax33() {  
		List<Order> orderList11 = orderService.getAllOrder();
		//����
		int count = 0;
		//��count
		for(int i =0 ; i < orderList11.size(); i++) {
			Order o = orderList11.get(i);
			if(o.getOrderstate().equals("δ֧��")) {
				count++;
			}
		}
		
		List<Integer> page = new ArrayList<Integer>();
		page.add(count);
		page.add(pageSize);
		//System.out.println(count);
		return page;
    }
	
	
	/**
	 * ajax��ҳ������֧���Ķ���
	 * @param pageIndex ��ǰҳ��
	 * @param pageSize ÿҳ��С
	 * @param totalPage �ܹ���������
	 * @return
	 */
	@RequestMapping("/ajax_operation4")
	public @ResponseBody List<Object> findContactAjax4(String pageIndex,String pageSize,String totalPage) {  
		return ajax_common(pageIndex, pageSize, totalPage, 4); 
    } 
	
	/**
	 * ajax��ҳ������֧���Ķ���,��������
	 * @param pageIndex ��ǰҳ��
	 * @param pageSize ÿҳ��С
	 * @param totalPage �ܹ���������
	 * @return
	 */
	@RequestMapping("/ajax_operation44")
	public @ResponseBody List<Integer> findContactAjax44() {  
		List<Order> orderList11 = orderService.getAllOrder();
		//����
		int count = 0;
		//��count
		for(int i =0 ; i < orderList11.size(); i++) {
			Order o = orderList11.get(i);
			if(o.getOrderstate().equals("��֧��")) {
				count++;
			}
		}
		
		List<Integer> page = new ArrayList<Integer>();
		page.add(count);
		page.add(pageSize);
		return page;
    }
	
	/**
	 * ajax��ҳ������ʧЧ�Ķ���
	 * @param pageIndex ��ǰҳ��
	 * @param pageSize ÿҳ��С
	 * @param totalPage �ܹ���������
	 * @return
	 */
	@RequestMapping("/ajax_operation5")
	public @ResponseBody List<Object> findContactAjax5(String pageIndex,String pageSize,String totalPage) {  
		return ajax_common(pageIndex, pageSize, totalPage, 5); 
    } 
	
	/**
	 * ajax��ҳ������֧���Ķ���,��������
	 * @param pageIndex ��ǰҳ��
	 * @param pageSize ÿҳ��С
	 * @param totalPage �ܹ���������
	 * @return
	 */
	@RequestMapping("/ajax_operation55")
	public @ResponseBody List<Integer> findContactAjax55() {  
		List<Order> orderList11 = orderService.getAllOrder();
		//����
		int count = 0;
		//��count
		for(int i =0 ; i < orderList11.size(); i++) {
			Order o = orderList11.get(i);
			if(o.getOrderstate().equals("��ʧЧ")) {
				count++;
			}
		}
		
		List<Integer> page = new ArrayList<Integer>();
		page.add(count);
		page.add(pageSize);
		return page;
    }
	
	/**
	 * ajax��̨��ѯ����ͨ�ú���
	 * @param pageIndex
	 * @param pageSize
	 * @param totalPage
	 * @param kind
	 * @return
	 */
	public List<Object> ajax_common(String pageIndex, String pageSize, String totalPage, Integer kind) {
		List<Order> orderList11 = orderService.getAllOrder();	
		List<Order> orderList = new ArrayList<Order>();
		Date now = new java.sql.Date(new java.util.Date().getTime());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");  
		
		//ˢ�¶�����״̬
		for(Order o : orderList11) {
			Room room = roomService.getRoomById(o.getRoomid());
			if(o.getDeadline().compareTo(now) < 0 && o.getOrderstate() != "��֧��") {
				o.setOrderstate("��ʧЧ");
				room.setRoomleftnum(room.getRoomleftnum() + o.getRoomnum());
			}else if(o.getOrderstate() != "��֧��" && o.getEndtime().compareTo(now) < 0) {
				room.setRoomleftnum(room.getRoomleftnum() + o.getRoomnum());
			}
			
			orderService.updateOrder(o);
			roomService.updateRoom(room);
		}
		
		if(kind == 1) {//���ж���
			orderList = orderList11;
		}else if(kind == 2) {//���ն���
			for(int i = 0 ; i < orderList11.size(); i++) {
				Order o = orderList11.get(i);
				if(sdf.format(o.getOrdertime()).equals(sdf.format(now))) {
					orderList.add(o);
				}
			}
		}else if(kind == 3) {//δ֧������
			for(int i = 0 ; i < orderList11.size(); i++) {
				Order o = orderList11.get(i);
				if(o.getOrderstate().equals("δ֧��")) {
					orderList.add(o);
				}
			}
		}else if(kind == 4) {//��֧������
			for(int i = 0 ; i < orderList11.size(); i++) {
				Order o = orderList11.get(i);
				if(o.getOrderstate().equals("��֧��")) {
					orderList.add(o);
				}
			}
		}else if(kind == 5) {
			for(int i = 0 ; i < orderList11.size(); i++) {
				Order o = orderList11.get(i);
				if(o.getOrderstate().equals("��ʧЧ")) {
					orderList.add(o);
				}
			}
		}
		
		//System.out.println(orderList.size());
		//��ȡ��ǰҳ����ÿҳ��С
		Integer pageIndex1 = Integer.parseInt(pageIndex);
		Integer pageSize1 = Integer.parseInt(pageSize);
		Integer totalPage1 = Integer.parseInt(totalPage);
//		System.out.println(pageIndex1);
//		System.out.println(pageSize1);
//		System.out.println(totalPage);
		//��ȡ��Ӧҳ������
		List<User> userList = new ArrayList<User>();
		List<Room> roomList = new ArrayList<Room>();
		List<List<String>> dateList = new ArrayList<List<String>>(); 
		//��ʽ������
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy��MM��dd��");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy��MM��dd�� HHʱmm��ss��");
		//ѭ��������û��Լ�ʱ������
		for(int i =0 ; i < orderList.size(); i++) {
			Order o = orderList.get(i);
			roomList.add(roomService.getRoomById(o.getRoomid()));
			userList.add(userService.getUserById(o.getUserid()));
			//����list�����ʽ��ʱ��
			List<String> date = new ArrayList<String>();
					
			date.add(sdf2.format(o.getOrdertime()));
			date.add(sdf2.format(o.getDeadline()));
			if(o.getPaytime() != null) {
				date.add(sdf2.format(o.getPaytime()));
			}else {
				date.add("");
			}
					
			date.add(sdf1.format(o.getStarttime()));
			date.add(sdf1.format(o.getEndtime()));
			date.add(sdf1.format(o.getOrdertime()));
					
			dateList.add(date);
		}
				
		//�����ҳ������
		List<Room> roomList1 = null;
		List<Order> orderList1 = null;
		List<User> userList1 = null;
		List<List<String>> dateList1 = null;
		//System.out.println(totalPage1/pageSize1);
		//��ȡ��ҳ����
		if(pageIndex1 <= totalPage1/pageSize1){
			orderList1 = orderList.subList((pageIndex1-1) * pageSize1, pageIndex1 * pageSize1);
			roomList1 = roomList.subList((pageIndex1-1) * pageSize1, pageIndex1 * pageSize1);
			userList1 = userList.subList((pageIndex1-1) * pageSize1, pageIndex1 * pageSize1);
			dateList1 = dateList.subList((pageIndex1-1) * pageSize1, pageIndex1 * pageSize1);
		}else {
			orderList1 = orderList.subList((pageIndex1-1) * pageSize1, totalPage1);
			roomList1 = roomList.subList((pageIndex1-1) * pageSize1, totalPage1);
			userList1 = userList.subList((pageIndex1-1) * pageSize1, totalPage1);
			dateList1 = dateList.subList((pageIndex1-1) * pageSize1, totalPage1);
		}
				
		//�������ݲ�����
		List<Object> resultList = new ArrayList<Object>();
		resultList.add(orderList1);
		resultList.add(roomList1);
		resultList.add(userList1);
		resultList.add(dateList1);
	    return resultList;  		
	}
	
	 
	
	/**
	 * ǰ̨��ʾ�û�����
	 * @param request
	 * @return
	 */
	@RequestMapping("/showUserOrder")
	public String showUserOrder(HttpServletRequest request) {
		//��ȡ�û���Ϣ
		User user = (User)request.getSession().getAttribute("user");
		List<Room> roomList = new ArrayList<Room>();
		List<List<String>> dateList = new ArrayList<List<String>>(); 
		
		//��ѯ�û��Ķ���
		List<Order> orderList = orderService.getOrdersByUserId(user.getUserid());
		//��ʽ��ʱ����Ϣ
		for(int i =0 ; i < orderList.size(); i++) {
			Order o = orderList.get(i);
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy��MM��dd��");
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy��MM��dd�� HHʱmm��ss��");
			roomList.add(roomService.getRoomById(o.getRoomid()));
			List<String> date = new ArrayList<String>();
			
			date.add(sdf2.format(o.getOrdertime()));
			date.add(sdf2.format(o.getDeadline()));
			if(o.getPaytime() != null) {
				date.add(sdf2.format(o.getPaytime()));
			}else {
				date.add("");
			}
			
			date.add(sdf1.format(o.getStarttime()));
			date.add(sdf1.format(o.getEndtime()));
			date.add(sdf1.format(o.getOrdertime()));
			
			dateList.add(date);
		} 
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy��MM��dd��");
		request.setAttribute("today", sdf1.format(new java.sql.Date(new java.util.Date().getTime())));
		request.setAttribute("dateList", dateList);
		request.setAttribute("orderList", orderList);
		request.setAttribute("roomList", roomList);
		request.setAttribute("title", "�û�����");
		return "showUserOrder";
	}
	
	/**
	 * ��ʾ��Ӷ�������
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/showAddOrder")
	public String showAddOrder(Model model, HttpServletRequest request){
		Integer roomid = Integer.parseInt(request.getParameter("roomid"));
		String startdate = request.getParameter("startdate");
		String enddate = request.getParameter("enddate");
		Integer days = Integer.parseInt(request.getParameter("days"));
//		Date sd = new Date();
//		Date ed = new Date();
//	    try  
//	    {  
//	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");  
//	        sd = sdf.parse(startdate);
//	        ed = sdf.parse(enddate);
//	    }  
//	    catch (ParseException e)  
//	    {  
//	        System.out.println(e.getMessage());  
//	    }  
	    
	    //System.out.println(startdate);
	    //System.out.println(enddate);
		
		//System.out.println(roomid + startdate + enddate);
		//����roomid��ѯroom
		Room room = roomService.getRoomById(roomid);
		model.addAttribute("room", room);
		model.addAttribute("startdate", startdate);
		model.addAttribute("enddate", enddate);
		model.addAttribute("days", days);
		model.addAttribute(new Order());
		model.addAttribute("title", "������д");
		
		//��������,��ֹ�ظ��ύ
		String token = TokenProccessor.getInstance().makeToken();
		request.getSession().setAttribute("token", token);//�ڷ�����ʹ��session��������
		return "showAddOrder";
	}
	
	/**
	 * ��Ӷ���
	 * @param request
	 * @return
	 */
	@RequestMapping("/addOrder")
	public String addOrder(HttpServletRequest request) {
		
		boolean b = isRepeatSubmit(request);//�ж��û��Ƿ��ظ��ύ
		if(b == true) {
			User user1 = userService.getUserById(order_previous.getUserid());
			Room room1 = roomService.getRoomById(order_previous.getRoomid());
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy��MM��dd��");
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy��MM��dd�� HHʱmm��ss��");
			request.setAttribute("order", order_previous);
			request.setAttribute("startdate", sdf1.format(order_previous.getStarttime()));
			request.setAttribute("enddate", sdf1.format(order_previous.getEndtime()));
			request.setAttribute("ordertime", sdf1.format(order_previous.getOrdertime()));
			request.setAttribute("deadline", sdf2.format(order_previous.getDeadline()));
			request.setAttribute("user", user1);
			request.setAttribute("room", room1);
			request.setAttribute("title", "����֧��");
			
			return "showOrderPay";
		}
		
		request.getSession().removeAttribute("token");//�Ƴ�session�е�token
		Order order = new Order();
		
		//��ȡ������Ϣ
		Integer roomId = Integer.parseInt(request.getParameter("roomid"));
		Room room = roomService.getRoomById(roomId);
		

		//��ȡ��ʼʱ��Ͷ����ύʱ���ip
		String startDate = request.getParameter("startdate");
		String endDate = request.getParameter("enddate");
		//��ȡ����
		Integer days = Integer.parseInt(request.getParameter("days"));
		//��ȡ�û���Ϣ
		User user = (User) request.getSession().getAttribute("user");
		//System.out.println(user.getUserid());
		String tel = user.getPhone();
		String tel_request = request.getParameter("phone");
		if(!tel.equals(tel_request)) {
			request.setAttribute("message", "�ֻ����벻ƥ��");
			request.setAttribute("room", room);
			request.setAttribute("startDate", startDate );
			request.setAttribute("endDate", "endDate");
			request.setAttribute("days", days);
			return "showAddOrder";
		} else {
			order.setUserid(user.getUserid());
			
			//System.out.println(roomId);
			order.setRoomid(roomId);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");  
			Date time= new java.sql.Date(new java.util.Date().getTime());
			order.setOrderid(time.getTime());
			try {
				order.setStarttime(sdf.parse(startDate));
				order.setEndtime(sdf.parse(endDate));
				order.setOrdertime(time);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String ip = getRemoteHost(request);
			order.setOrderip(ip);
			
			//��ȡ�����ܼۺͷ�������
			Float totalPrice = Float.parseFloat(request.getParameter("roomtotalprice"));
			order.setTotalprice(totalPrice);
			Integer roomNum = Integer.parseInt(request.getParameter("roomnumber"));
			order.setRoomnum(roomNum);
			//��ȡ�Ǽ���Ϣ
			String registerInfo = "";
			for(int i = 1;i <= roomNum;i++) {
				registerInfo += request.getParameter("room"+ i) + ";";
			}
			order.setRegisterinfo(registerInfo);
			
			//���ù���ʱ���
			Date time1 = new Date(time.getTime() + 1800000 );
			order.setDeadline(time1);
			//���ٷ�������
			room.setRoomleftnum(room.getRoomtotalnum() - order.getRoomnum());
			roomService.updateRoom(room);
			//���ö���״̬
			order.setOrderstate("δ֧��");
			
			//���涩�������ݿ�
			orderService.addOrder(order);
			order_previous = order;
			//System.out.println(startDate + endDate + totalPrice + roomNum + registerInfo);
			//���������Ϣ
			
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy��MM��dd��");
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy��MM��dd�� HHʱmm��ss��");
			request.setAttribute("order", order);
			request.setAttribute("startdate", sdf1.format(order.getStarttime()));
			request.setAttribute("enddate", sdf1.format(order.getEndtime()));
			request.setAttribute("ordertime", sdf1.format(order.getOrdertime()));
			request.setAttribute("deadline", sdf2.format(order.getDeadline()));
			request.setAttribute("user", user);
			request.setAttribute("room", room);
			request.setAttribute("order", order);
			request.setAttribute("title", "����֧��");
			//��������,��ֹ�ظ��ύ
			String token = TokenProccessor.getInstance().makeToken();
			request.getSession().setAttribute("token", token);//�ڷ�����ʹ��session��������
			
			return "showOrderPay";
		}
	}
	
	/**
	 * ��ʾ֧������
	 * @param request
	 * @return
	 */
	@RequestMapping("/showOrderPay")
	public String showOrderPay(HttpServletRequest request) {
		Long orderid = Long.parseLong(request.getParameter("orderid"));
		Order order = orderService.getOrderById(orderid);
		User user = userService.getUserById(order.getUserid());
		Room room = roomService.getRoomById(order.getRoomid());
		Date time= new java.sql.Date(new java.util.Date().getTime());
		if(time.compareTo(order.getDeadline()) > 0) {
			//order.setOrderstate("��ʧЧ");
			//room.setRoomleftnum(room.getRoomtotalnum() + order.getRoomnum());
			//roomService.updateRoom(room);
			//orderService.updateOrder(order);
			return "showOrderInvalid";
		}else {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��");
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy��MM��dd�� HHʱmm��ss��");
			request.setAttribute("startdate", sdf.format(order.getStarttime()));
			request.setAttribute("enddate", sdf.format(order.getEndtime()));
			request.setAttribute("ordertime", sdf1.format(order.getOrdertime()));
			request.setAttribute("deadline", sdf1.format(order.getDeadline()));
			request.setAttribute("user", user);
			request.setAttribute("room", room);
			request.setAttribute("order", order);
			request.setAttribute("title", "����֧��");
			return "showOrderPay";
		}
	}
	
	/**
	 * ֧��
	 * @param request
	 * @return
	 */
	@RequestMapping("/pay")
	public String pay(HttpServletRequest request) {
		
		boolean b = isRepeatSubmit(request);//�ж��û��Ƿ��ظ��ύ
		if(b == true) {
			request.setAttribute("title", "�������");
			return "showOrderSuccess";
		}
		
		request.getSession().removeAttribute("token");//�Ƴ�session�е�token
		
		String payMethod = request.getParameter("pay"); 
		String orderId = request.getParameter("orderid");
		Long orderId1 = Long.valueOf(orderId);
		boolean flag = true;
		if(payMethod.equals("zhifubao")) {
			flag = zhifubao();
		}else if(payMethod.equals("weixin")) {
			flag = weixin();
		}
		
		if(!flag) {
			return "showPayFail";
		}else {
			Order order = orderService.getOrderById(orderId1);
			Date paytime= new java.sql.Date(new java.util.Date().getTime());
			order.setOrderstate("��֧��");
			order.setPaytime(paytime);
			orderService.updateOrder(order);
			request.setAttribute("title", "�������");
			return "showOrderSuccess";
		}
	}
	
	/**
	 * ֧����
	 * @return
	 */
	public boolean zhifubao() {
		return true;
	}
	
	/**
	 * ΢��
	 * @return
	 */
	public boolean weixin() {
		return true;
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
