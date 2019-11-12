package com.byzx.controller;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.byzx.model.CarInfo;
import com.byzx.model.PageBean;
import com.byzx.model.UserInfo;
import com.byzx.service.CarInfoService;
import com.byzx.util.ResponseUtil;
import com.byzx.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**@文件名: CarInfoController.java
 * @类功能说明: 
 * @作者: ChongYangYang
 * @Email: 1103222824@qq.com
 * @日期: 2019年10月30日下午5:19:13
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: ChongYangYang</li> 
 * 	 <li>日期: 2019年10月30日下午5:19:13</li> 
 *	 <li>内容: </li>
 * </pre>
 */
@Controller
@RequestMapping("/carInfo")
public class CarInfoController {
	
	@Autowired
	private CarInfoService carInfoService;

	@RequestMapping("/findAllCarInfo")
	public void findAllCarInfo(HttpServletRequest request,HttpServletResponse response) throws Exception {
		JSONArray jsonArray =carInfoService.findAllCarInfo();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("carInfo", jsonArray);
		ResponseUtil.write(response, jsonObject);
	}
	
	@RequestMapping("/findAllCar")
	public void findAllCar(String c_number,int page, int rows,HttpServletResponse response)throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		if(StringUtil.isNotEmpty(c_number)) {
			map.put("c_number", c_number);
		}
		PageBean pageBean = new PageBean(page, rows);
		map.put("pageBean", pageBean);
		JSONArray jsonArray=carInfoService.findAllCar(map);
		int total=carInfoService.findAllCarCount(map);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("rows", jsonArray);
		jsonObject.put("total", total);
		ResponseUtil.write(response, jsonObject);
	}

	
	@RequestMapping("/findThisCarInfo")
	public void findThisCarInfo(String c_location,HttpServletRequest request,HttpServletResponse response) throws Exception {
		JSONArray jsonArray =carInfoService.findThisCarInfo(c_location);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("carInfo", jsonArray);
		ResponseUtil.write(response, jsonObject);
	}
	@RequestMapping("/deleteCarInfo")
	public void deleteCarInfo(int c_carid,HttpServletResponse response)throws Exception{
		JSONObject jsonObject = new JSONObject();
		int result=carInfoService.deleteCarInfo(c_carid);
		if(result>0) {
			jsonObject.put("msg", true);
			jsonObject.put("count", result);
		}else {
			jsonObject.put("msg", false);
		}
		ResponseUtil.write(response, jsonObject);
	}

	@RequestMapping("/saveCarInfo")
	public void saveCarInfo(@RequestBody CarInfo carInfo,HttpServletRequest request,HttpServletResponse response)throws Exception {
		HttpSession session = request.getSession();
		UserInfo currentUser=(UserInfo) session.getAttribute("currentUserInfo");
		carInfo.setOpt_id(currentUser.getUser_id());
		int result=carInfoService.saveCarInfo(carInfo);
		JSONObject jsonObject = new JSONObject();
		if(result>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	@RequestMapping("/updateCarInfo")
	public void updateCarInfo(@RequestBody CarInfo carInfo,HttpServletResponse response)throws Exception {
		int result=carInfoService.updateCarInfo(carInfo);
		JSONObject jsonObject = new JSONObject();
		if(result>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		ResponseUtil.write(response, jsonObject);
	}
}










