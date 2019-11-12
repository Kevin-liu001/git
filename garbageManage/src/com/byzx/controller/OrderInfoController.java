package com.byzx.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.byzx.model.OrderInfo;
import com.byzx.model.PageBean;
import com.byzx.model.UserInfo;
import com.byzx.service.OrderInfoService;
import com.byzx.util.ResponseUtil;
import com.byzx.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**@文件名: OrderInfoController.java
 * @类功能说明: 
 * @作者: WangSiYuan
 * @Email: 1512972568@qq.com
 * @日期: 2019年11月2日上午10:56:24
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: WangSiYuan
 * 	 <li>日期: 2019年11月2日上午10:56:24</li> 
 *	 <li>内容: </li>
 * </pre>
 */
@Controller
@RequestMapping("/orderInfo")
public class OrderInfoController {

	@Autowired
	private OrderInfoService orderInfoService;
	
	
	@RequestMapping("/findAllOrderInfo")
	public void findAllOrderInfo(String searchByUserId,int page,int rows,HttpServletResponse response)throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringUtil.isNotEmpty(searchByUserId)) {
			map.put("searchByUserId", searchByUserId);
		}
		PageBean pageBean = new PageBean(page, rows);
		map.put("pageBean", pageBean);
		JSONArray jsonArray = orderInfoService.findAllOrderInfo(map);
		int total = orderInfoService.findAllOrderInfoCount(map);
		JSONObject jsonObject = new JSONObject();	
		jsonObject.put("rows", jsonArray);
		jsonObject.put("total", total);
		ResponseUtil.write(response, jsonObject);
		
	}
	
	
	@RequestMapping("/saveOrderInfo")
	public void saveOrderInfo(OrderInfo orderInfo,HttpServletRequest request,HttpServletResponse response)throws Exception {
		HttpSession session=request.getSession();
		UserInfo currUser=(UserInfo) session.getAttribute("currentUserInfo");
		orderInfo.setOptid(currUser.getUser_id());
		int result=orderInfoService.saveOrderInfo(orderInfo);
		JSONObject jsonObject=new JSONObject();
		if(result>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	
	@RequestMapping("/updateOrderInfo")
	public void updateOrderInfo(OrderInfo orderInfo,HttpServletRequest request,HttpServletResponse response)throws Exception{
		int result=orderInfoService.updateOrderInfo(orderInfo);
		JSONObject jsonObject=new JSONObject();
		if(result>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		ResponseUtil.write(response, jsonObject);
	}
		
	@RequestMapping("/deleteOrderInfo")
	public void deleteOrderInfo(String orderIds,HttpServletResponse response)throws Exception{
		JSONObject jsonObject = new JSONObject();
		int result=orderInfoService.deleteOrderInfo(orderIds);
		if(result>0) {
			jsonObject.put("msg", true);
			jsonObject.put("count", result);
		}else {
			jsonObject.put("msg", false);
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	
}





