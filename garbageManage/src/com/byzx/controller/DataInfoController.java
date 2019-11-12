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

import com.byzx.model.DataInfo;
import com.byzx.model.PageBean;
import com.byzx.model.UserInfo;
import com.byzx.service.DataInfoService;
import com.byzx.util.ResponseUtil;
import com.byzx.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**@鏂囦欢鍚�: DataInfoController.java
 * @绫诲姛鑳借鏄�: 
 * @浣滆��: LiuChunHui
 * @Email: 508499598@qq.com
 * @鏃ユ湡: 2019骞�10鏈�25鏃ヤ笂鍗�11:05:57
 * @淇敼璇存槑:<br> 
 * <pre>
 * 	 <li>浣滆��: LiuChunHui</li> 
 * 	 <li>鏃ユ湡: 2019骞�10鏈�25鏃ヤ笂鍗�11:05:57</li> 
 *	 <li>鍐呭: </li>
 * </pre>
 */
@Controller
@RequestMapping("/dataInfo")
public class DataInfoController {

	@Autowired
	private DataInfoService dataInfoService;
	
	@RequestMapping("/findAllDataInfo")
	public void findAllDataInfo(int page,int rows,String searchValue,HttpServletRequest request, HttpServletResponse response) throws Exception{
		Map<String,Object> map=new HashMap<String,Object>();
		if(StringUtil.isNotEmpty(searchValue)) {
			map.put("searchValue", searchValue);
		}
		PageBean pageBean=new PageBean(page,rows);
		map.put("pageBean", pageBean);
		JSONArray jsonArray=dataInfoService.findAllDataInfo(map);
		int total=dataInfoService.findAllDataInfoCount(map);
		JSONObject jsonObject=new JSONObject();
		System.out.println(jsonArray);
		jsonObject.put("rows", jsonArray);
		jsonObject.put("total", total);
		ResponseUtil.write(response, jsonObject);
	}
	
	@RequestMapping("/addDataInfo.do")
	public void addDataInfo(@RequestBody DataInfo dataInfo,HttpServletRequest request,HttpServletResponse response) throws Exception{
		System.out.println(dataInfo);
		HttpSession session=request.getSession();
		UserInfo userInfos=(UserInfo) session.getAttribute("UserInfo");
		dataInfo.setOpt_id(userInfos.getOpt_id());
		int result=dataInfoService.addDataInfo(dataInfo);
		JSONObject jsonObject=new JSONObject();
		if(result>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	@RequestMapping("/updateDataInfo.do")
	public void updateDataInfo(@RequestBody DataInfo dataInfo,HttpServletRequest request,HttpServletResponse response) throws Exception{
		int result=dataInfoService.updateDataInfo(dataInfo);
		JSONObject jsonObject=new JSONObject();
		if(result>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	@RequestMapping("/deleteDataInfo.do")
	public void deleteDataInfo(int data_id,HttpServletRequest request,HttpServletResponse response) throws Exception{
		int result=dataInfoService.deleteDataInfo(data_id);
		JSONObject jsonObject=new JSONObject();
		if(result>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	@RequestMapping("/findDataInfoByDId")
	public void findDataInfoByDId(int data_id,HttpServletResponse response,HttpServletRequest request) throws Exception{
		JSONArray jsonArray=dataInfoService.findDataInfoByDId(data_id);
		ResponseUtil.write(response, jsonArray);
	}

}
