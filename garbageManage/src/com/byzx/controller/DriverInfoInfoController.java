package com.byzx.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.byzx.model.PageBean;
import com.byzx.service.DriverInfoInfoService;
import com.byzx.util.ResponseUtil;
import com.byzx.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**@�ļ���: DriverInfoInfoController.java
 * @�๦��˵��: 
 * @����: WangSiYuan
 * @Email: 1512972568@qq.com
 * @����: 2019��11��1������5:07:53
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: WangSiYuan
 * 	 <li>����: 2019��11��1������5:07:53</li> 
 *	 <li>����: </li>
 * </pre>
 */
@Controller
@RequestMapping("/DriverInfoInfo")
public class DriverInfoInfoController {
	
	@Autowired
	private DriverInfoInfoService driverInfoInfoService;
	
	
	@RequestMapping("/findAllDriverInfo")
	public void findAllDriverInfo(int page,int rows,String user_name,HttpServletResponse response)throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		if(StringUtil.isNotEmpty(user_name)) {
			map.put("user_name", user_name);
		}
		PageBean pageBean = new PageBean(page, rows);
		map.put("pageBean", pageBean);
		JSONArray jsonArray=driverInfoInfoService.findAllDriverInfo(map);
		int total=driverInfoInfoService.findAllDriverInfoCount(map);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("rows", jsonArray);
		jsonObject.put("total", total);
		ResponseUtil.write(response, jsonObject);
		
		
	}
	
	
	
	
	
	

}










