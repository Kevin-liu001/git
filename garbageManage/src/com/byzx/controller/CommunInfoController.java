package com.byzx.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.byzx.model.CommunInfo;
import com.byzx.model.UserInfo;
import com.byzx.service.CommunInfoService;
import com.byzx.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**@鏂囦欢鍚�: CommunInfoController.java
 * @绫诲姛鑳借鏄�: 
 * @浣滆��: LiuChunHui
 * @Email: 508499598@qq.com
 * @鏃ユ湡: 2019骞�10鏈�31鏃ヤ笂鍗�9:43:20
 * @淇敼璇存槑:<br> 
 * <pre>
 * 	 <li>浣滆��: LiuChunHui</li> 
 * 	 <li>鏃ユ湡: 2019骞�10鏈�31鏃ヤ笂鍗�9:43:20</li> 
 *	 <li>鍐呭: </li>
 * </pre>
 */
@Controller
@RequestMapping("/communInfo")
public class CommunInfoController {

	@Autowired
	private CommunInfoService communInfoService;
	
	@RequestMapping("/findAllCommunInfo")
	public void findAllCommunInfo(HttpServletRequest request, HttpServletResponse response) throws Exception{
		JSONArray jsonArray=communInfoService.findAllCommunInfo();
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("rows", jsonArray);
		ResponseUtil.write(response, jsonObject);
	}
	
	@RequestMapping("/findAllCommunInfoName")
	public void findAllCommunInfo1(HttpServletResponse response) throws Exception {
		JSONArray jsonArray = communInfoService.findAllCommunInfo();
		ResponseUtil.write(response, jsonArray);
	}

	
	@RequestMapping("/findAllCommunInfoByPoint")
	public void findAllCommunInfoByPoint(String plot_site,HttpServletRequest request, HttpServletResponse response) throws Exception{
		JSONObject jsonObject=new JSONObject();
		jsonObject=communInfoService.findAllCommunInfoByPoint(plot_site);
		jsonObject.put("row", jsonObject);
		ResponseUtil.write(response, jsonObject);
	}
	
	@RequestMapping("/saveCommunInfo.do")
	public void saveCommunInfo(@RequestBody CommunInfo communInfo,HttpServletRequest request,HttpServletResponse response) throws Exception{
		HttpSession session=request.getSession();
		UserInfo userInfos=(UserInfo) session.getAttribute("UserInfo");
		communInfo.setOptid(userInfos.getOpt_id());
		int result=communInfoService.saveCommunInfo(communInfo);
		JSONObject jsonObject=new JSONObject();
		if(result>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	@RequestMapping("/findRecycleNames.do")
	public void findRecycleNames(HttpServletRequest request, HttpServletResponse response) throws Exception{
		JSONArray jsonArray=communInfoService.findRecycleNames();
		
		
		ResponseUtil.write(response, jsonArray);
	}
	@RequestMapping("/deleteCommunInfo")
	public void deleteCommunInfo(int plot_id,HttpServletRequest request,HttpServletResponse response) throws Exception{
		int result=communInfoService.deleteCommunInfo(plot_id);
		JSONObject jsonObject=new JSONObject();
		if(result>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	@RequestMapping("/updateCommunInfo.do")
	public void updateCommunInfo(@RequestBody CommunInfo communInfo,HttpServletRequest request,HttpServletResponse response) throws Exception{
		int result=communInfoService.updateCommunInfo(communInfo);
		JSONObject jsonObject=new JSONObject();
		if(result>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		ResponseUtil.write(response, jsonObject);
	}
	
}
