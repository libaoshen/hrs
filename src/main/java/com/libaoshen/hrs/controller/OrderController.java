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
	//记录重复提交的上一次的订单信息
	private static Order order_previous = new Order();
	//记录后台订单分页数
	private int pageSize = 5;
	
	/**
	 * 订单管理
	 * @param model
	 * @return
	 */
	@RequestMapping({"/",""})
	public String toOrder(Model model, HttpServletRequest request) {
		model.addAttribute("title", "订单管理");
		model.addAttribute(new Room());
		List<Order> orderList = orderService.getAllOrder();
		model.addAttribute("orderpagesize", pageSize);
  		model.addAttribute("ordercounts", orderList.size());
		return "showOrder";
	}
	
	/**
	 * ajax分页处理所有的订单
	 * @param pageIndex 当前页数
	 * @param pageSize 每页大小
	 * @param totalPage 总共的数据数
	 * @return
	 */
	@RequestMapping("/ajax_operation1")
	public @ResponseBody List<Object> findContactAjax1(String pageIndex,String pageSize,String totalPage) {  
	    return ajax_common(pageIndex, pageSize, totalPage, 1); 
    } 
	
	/**
	 * ajax分页处理所有的订单,返回总数
	 * @param pageIndex 当前页数
	 * @param pageSize 每页大小
	 * @param totalPage 总共的数据数
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
	 * ajax分页处理今日的订单
	 * @param pageIndex 当前页数
	 * @param pageSize 每页大小
	 * @param totalPage 总共的数据数
	 * @return
	 */
	@RequestMapping("/ajax_operation2")
	public @ResponseBody List<Object> findContactAjax2(String pageIndex,String pageSize,String totalPage) {  
		return ajax_common(pageIndex, pageSize, totalPage, 2); 
    }  
	
	/**
	 * ajax分页处理今日的订单,返回总数
	 * @param pageIndex 当前页数
	 * @param pageSize 每页大小
	 * @param totalPage 总共的数据数
	 * @return
	 */
	@RequestMapping("/ajax_operation22")
	public @ResponseBody List<Integer> findContactAjax22() {  
		List<Order> orderList11 = orderService.getAllOrder();
		//计数
		int count = 0;
		//求count
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
	 * ajax分页处理未支付的订单
	 * @param pageIndex 当前页数
	 * @param pageSize 每页大小
	 * @param totalPage 总共的数据数
	 * @return
	 */
	@RequestMapping("/ajax_operation3")
	public @ResponseBody List<Object> findContactAjax3(String pageIndex,String pageSize,String totalPage) {  
		return ajax_common(pageIndex, pageSize, totalPage, 3);
    }  
	
	/**
	 * ajax分页处理未支付的订单,返回总数
	 * @param pageIndex 当前页数
	 * @param pageSize 每页大小
	 * @param totalPage 总共的数据数
	 * @return
	 */
	@RequestMapping("/ajax_operation33")
	public @ResponseBody List<Integer> findContactAjax33() {  
		List<Order> orderList11 = orderService.getAllOrder();
		//计数
		int count = 0;
		//求count
		for(int i =0 ; i < orderList11.size(); i++) {
			Order o = orderList11.get(i);
			if(o.getOrderstate().equals("未支付")) {
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
	 * ajax分页处理已支付的订单
	 * @param pageIndex 当前页数
	 * @param pageSize 每页大小
	 * @param totalPage 总共的数据数
	 * @return
	 */
	@RequestMapping("/ajax_operation4")
	public @ResponseBody List<Object> findContactAjax4(String pageIndex,String pageSize,String totalPage) {  
		return ajax_common(pageIndex, pageSize, totalPage, 4); 
    } 
	
	/**
	 * ajax分页处理已支付的订单,返回总数
	 * @param pageIndex 当前页数
	 * @param pageSize 每页大小
	 * @param totalPage 总共的数据数
	 * @return
	 */
	@RequestMapping("/ajax_operation44")
	public @ResponseBody List<Integer> findContactAjax44() {  
		List<Order> orderList11 = orderService.getAllOrder();
		//计数
		int count = 0;
		//求count
		for(int i =0 ; i < orderList11.size(); i++) {
			Order o = orderList11.get(i);
			if(o.getOrderstate().equals("已支付")) {
				count++;
			}
		}
		
		List<Integer> page = new ArrayList<Integer>();
		page.add(count);
		page.add(pageSize);
		return page;
    }
	
	/**
	 * ajax分页处理已失效的订单
	 * @param pageIndex 当前页数
	 * @param pageSize 每页大小
	 * @param totalPage 总共的数据数
	 * @return
	 */
	@RequestMapping("/ajax_operation5")
	public @ResponseBody List<Object> findContactAjax5(String pageIndex,String pageSize,String totalPage) {  
		return ajax_common(pageIndex, pageSize, totalPage, 5); 
    } 
	
	/**
	 * ajax分页处理已支付的订单,返回总数
	 * @param pageIndex 当前页数
	 * @param pageSize 每页大小
	 * @param totalPage 总共的数据数
	 * @return
	 */
	@RequestMapping("/ajax_operation55")
	public @ResponseBody List<Integer> findContactAjax55() {  
		List<Order> orderList11 = orderService.getAllOrder();
		//计数
		int count = 0;
		//求count
		for(int i =0 ; i < orderList11.size(); i++) {
			Order o = orderList11.get(i);
			if(o.getOrderstate().equals("已失效")) {
				count++;
			}
		}
		
		List<Integer> page = new ArrayList<Integer>();
		page.add(count);
		page.add(pageSize);
		return page;
    }
	
	/**
	 * ajax后台查询订单通用函数
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
		
		//刷新订单的状态
		for(Order o : orderList11) {
			Room room = roomService.getRoomById(o.getRoomid());
			if(o.getDeadline().compareTo(now) < 0 && o.getOrderstate() != "已支付") {
				o.setOrderstate("已失效");
				room.setRoomleftnum(room.getRoomleftnum() + o.getRoomnum());
			}else if(o.getOrderstate() != "已支付" && o.getEndtime().compareTo(now) < 0) {
				room.setRoomleftnum(room.getRoomleftnum() + o.getRoomnum());
			}
			
			orderService.updateOrder(o);
			roomService.updateRoom(room);
		}
		
		if(kind == 1) {//所有订单
			orderList = orderList11;
		}else if(kind == 2) {//今日订单
			for(int i = 0 ; i < orderList11.size(); i++) {
				Order o = orderList11.get(i);
				if(sdf.format(o.getOrdertime()).equals(sdf.format(now))) {
					orderList.add(o);
				}
			}
		}else if(kind == 3) {//未支付订单
			for(int i = 0 ; i < orderList11.size(); i++) {
				Order o = orderList11.get(i);
				if(o.getOrderstate().equals("未支付")) {
					orderList.add(o);
				}
			}
		}else if(kind == 4) {//已支付订单
			for(int i = 0 ; i < orderList11.size(); i++) {
				Order o = orderList11.get(i);
				if(o.getOrderstate().equals("已支付")) {
					orderList.add(o);
				}
			}
		}else if(kind == 5) {
			for(int i = 0 ; i < orderList11.size(); i++) {
				Order o = orderList11.get(i);
				if(o.getOrderstate().equals("已失效")) {
					orderList.add(o);
				}
			}
		}
		
		//System.out.println(orderList.size());
		//获取当前页数和每页大小
		Integer pageIndex1 = Integer.parseInt(pageIndex);
		Integer pageSize1 = Integer.parseInt(pageSize);
		Integer totalPage1 = Integer.parseInt(totalPage);
//		System.out.println(pageIndex1);
//		System.out.println(pageSize1);
//		System.out.println(totalPage);
		//获取相应页的数据
		List<User> userList = new ArrayList<User>();
		List<Room> roomList = new ArrayList<Room>();
		List<List<String>> dateList = new ArrayList<List<String>>(); 
		//格式化日期
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		//循环房间和用户以及时间数据
		for(int i =0 ; i < orderList.size(); i++) {
			Order o = orderList.get(i);
			roomList.add(roomService.getRoomById(o.getRoomid()));
			userList.add(userService.getUserById(o.getUserid()));
			//定义list保存格式化时间
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
				
		//保存分页的数据
		List<Room> roomList1 = null;
		List<Order> orderList1 = null;
		List<User> userList1 = null;
		List<List<String>> dateList1 = null;
		//System.out.println(totalPage1/pageSize1);
		//获取分页数据
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
				
		//保存数据并返回
		List<Object> resultList = new ArrayList<Object>();
		resultList.add(orderList1);
		resultList.add(roomList1);
		resultList.add(userList1);
		resultList.add(dateList1);
	    return resultList;  		
	}
	
	 
	
	/**
	 * 前台显示用户订单
	 * @param request
	 * @return
	 */
	@RequestMapping("/showUserOrder")
	public String showUserOrder(HttpServletRequest request) {
		//获取用户信息
		User user = (User)request.getSession().getAttribute("user");
		List<Room> roomList = new ArrayList<Room>();
		List<List<String>> dateList = new ArrayList<List<String>>(); 
		
		//查询用户的订单
		List<Order> orderList = orderService.getOrdersByUserId(user.getUserid());
		//格式化时间信息
		for(int i =0 ; i < orderList.size(); i++) {
			Order o = orderList.get(i);
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日");
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
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
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日");
		request.setAttribute("today", sdf1.format(new java.sql.Date(new java.util.Date().getTime())));
		request.setAttribute("dateList", dateList);
		request.setAttribute("orderList", orderList);
		request.setAttribute("roomList", roomList);
		request.setAttribute("title", "用户订单");
		return "showUserOrder";
	}
	
	/**
	 * 显示添加订单界面
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
		//根据roomid查询room
		Room room = roomService.getRoomById(roomid);
		model.addAttribute("room", room);
		model.addAttribute("startdate", startdate);
		model.addAttribute("enddate", enddate);
		model.addAttribute("days", days);
		model.addAttribute(new Order());
		model.addAttribute("title", "订单填写");
		
		//创建令牌,防止重复提交
		String token = TokenProccessor.getInstance().makeToken();
		request.getSession().setAttribute("token", token);//在服务器使用session保存令牌
		return "showAddOrder";
	}
	
	/**
	 * 添加订单
	 * @param request
	 * @return
	 */
	@RequestMapping("/addOrder")
	public String addOrder(HttpServletRequest request) {
		
		boolean b = isRepeatSubmit(request);//判断用户是否重复提交
		if(b == true) {
			User user1 = userService.getUserById(order_previous.getUserid());
			Room room1 = roomService.getRoomById(order_previous.getRoomid());
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日");
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
			request.setAttribute("order", order_previous);
			request.setAttribute("startdate", sdf1.format(order_previous.getStarttime()));
			request.setAttribute("enddate", sdf1.format(order_previous.getEndtime()));
			request.setAttribute("ordertime", sdf1.format(order_previous.getOrdertime()));
			request.setAttribute("deadline", sdf2.format(order_previous.getDeadline()));
			request.setAttribute("user", user1);
			request.setAttribute("room", room1);
			request.setAttribute("title", "在线支付");
			
			return "showOrderPay";
		}
		
		request.getSession().removeAttribute("token");//移除session中的token
		Order order = new Order();
		
		//获取房型信息
		Integer roomId = Integer.parseInt(request.getParameter("roomid"));
		Room room = roomService.getRoomById(roomId);
		

		//获取起始时间和订单提交时间和ip
		String startDate = request.getParameter("startdate");
		String endDate = request.getParameter("enddate");
		//获取天数
		Integer days = Integer.parseInt(request.getParameter("days"));
		//获取用户信息
		User user = (User) request.getSession().getAttribute("user");
		//System.out.println(user.getUserid());
		String tel = user.getPhone();
		String tel_request = request.getParameter("phone");
		if(!tel.equals(tel_request)) {
			request.setAttribute("message", "手机号码不匹配");
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
			
			//获取订单总价和房间数量
			Float totalPrice = Float.parseFloat(request.getParameter("roomtotalprice"));
			order.setTotalprice(totalPrice);
			Integer roomNum = Integer.parseInt(request.getParameter("roomnumber"));
			order.setRoomnum(roomNum);
			//获取登记信息
			String registerInfo = "";
			for(int i = 1;i <= roomNum;i++) {
				registerInfo += request.getParameter("room"+ i) + ";";
			}
			order.setRegisterinfo(registerInfo);
			
			//设置过期时间戳
			Date time1 = new Date(time.getTime() + 1800000 );
			order.setDeadline(time1);
			//减少房间数量
			room.setRoomleftnum(room.getRoomtotalnum() - order.getRoomnum());
			roomService.updateRoom(room);
			//设置订单状态
			order.setOrderstate("未支付");
			
			//保存订单到数据库
			orderService.addOrder(order);
			order_previous = order;
			//System.out.println(startDate + endDate + totalPrice + roomNum + registerInfo);
			//返回相关信息
			
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日");
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
			request.setAttribute("order", order);
			request.setAttribute("startdate", sdf1.format(order.getStarttime()));
			request.setAttribute("enddate", sdf1.format(order.getEndtime()));
			request.setAttribute("ordertime", sdf1.format(order.getOrdertime()));
			request.setAttribute("deadline", sdf2.format(order.getDeadline()));
			request.setAttribute("user", user);
			request.setAttribute("room", room);
			request.setAttribute("order", order);
			request.setAttribute("title", "在线支付");
			//创建令牌,防止重复提交
			String token = TokenProccessor.getInstance().makeToken();
			request.getSession().setAttribute("token", token);//在服务器使用session保存令牌
			
			return "showOrderPay";
		}
	}
	
	/**
	 * 显示支付界面
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
			//order.setOrderstate("已失效");
			//room.setRoomleftnum(room.getRoomtotalnum() + order.getRoomnum());
			//roomService.updateRoom(room);
			//orderService.updateOrder(order);
			return "showOrderInvalid";
		}else {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
			request.setAttribute("startdate", sdf.format(order.getStarttime()));
			request.setAttribute("enddate", sdf.format(order.getEndtime()));
			request.setAttribute("ordertime", sdf1.format(order.getOrdertime()));
			request.setAttribute("deadline", sdf1.format(order.getDeadline()));
			request.setAttribute("user", user);
			request.setAttribute("room", room);
			request.setAttribute("order", order);
			request.setAttribute("title", "在线支付");
			return "showOrderPay";
		}
	}
	
	/**
	 * 支付
	 * @param request
	 * @return
	 */
	@RequestMapping("/pay")
	public String pay(HttpServletRequest request) {
		
		boolean b = isRepeatSubmit(request);//判断用户是否重复提交
		if(b == true) {
			request.setAttribute("title", "订单完成");
			return "showOrderSuccess";
		}
		
		request.getSession().removeAttribute("token");//移除session中的token
		
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
			order.setOrderstate("已支付");
			order.setPaytime(paytime);
			orderService.updateOrder(order);
			request.setAttribute("title", "订单完成");
			return "showOrderSuccess";
		}
	}
	
	/**
	 * 支付宝
	 * @return
	 */
	public boolean zhifubao() {
		return true;
	}
	
	/**
	 * 微信
	 * @return
	 */
	public boolean weixin() {
		return true;
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
