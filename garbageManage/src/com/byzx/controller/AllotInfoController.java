package com.byzx.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.byzx.model.AllotInfo;
import com.byzx.model.PageBean;
import com.byzx.model.UserInfo;
import com.byzx.service.AllotInfoService;
import com.byzx.util.ResponseUtil;
import com.byzx.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**@文件名: AllotInfoController.java
 * @类功能说明: 
 * @作者: ChongYangYang
 * @Email: 1103222824@qq.com
 * @日期: 2019年10月31日上午10:12:45
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: ChongYangYang</li> 
 * 	 <li>日期: 2019年10月31日上午10:12:45</li> 
 *	 <li>内容: </li>
 * </pre>
 */
@Controller
@RequestMapping("/allotInfo")
public class AllotInfoController {

	@Autowired
	private AllotInfoService allotInfoService;
	
	@RequestMapping("/findAllotInfo")
	public void findAllotInfo(int page,int rows,String searchByNumber,HttpServletRequest request,HttpServletResponse response) throws Exception {
		Map<String,Object> map=new HashMap<String,Object>();
		if(StringUtil.isNotEmpty(searchByNumber)) {
			map.put("searchByName", searchByNumber);
		}
		PageBean pageBean = new PageBean(page,rows);
		map.put("pageBean", pageBean);
		JSONArray jsonArray=allotInfoService.findAllotInfo(map);
		int total = allotInfoService.findAllotInfoCount(map);
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("rows", jsonArray);
		jsonObject.put("total", total);
		ResponseUtil.write(response, jsonObject);
	}
	
	@RequestMapping("/saveallotInfo")
	public void saveallotInfo(AllotInfo allotInfo,HttpServletRequest request,HttpServletResponse response)throws Exception{
		HttpSession session = request.getSession();
		UserInfo currentUser=(UserInfo) session.getAttribute("UserInfo");
		allotInfo.setOpt_id(currentUser.getUser_id());
		int result=allotInfoService.saveallotInfo(allotInfo);
		JSONObject jsonObject=new JSONObject();
		if(result>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	@RequestMapping("/findallotInfoByUNumber")
	public void findallotInfoByUNumber(int c_carid,HttpServletResponse response)throws Exception {
		int result=allotInfoService.findallotInfoByUNumber(c_carid);
		JSONObject jsonObject = new JSONObject();
		if(result>0) {
			jsonObject.put("msg", true);
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	@RequestMapping("/updateallotInfo")
	public void updateallotInfo(AllotInfo allotInfo,HttpServletResponse response)throws Exception{
		int result=allotInfoService.updateallotInfo(allotInfo);
		JSONObject jsonObject = new JSONObject();
		if(result>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	@RequestMapping("/deleteallotInfo")
	public void deleteallotInfo (String allotIds,HttpServletResponse response)throws Exception{
		JSONObject jsonObject = new JSONObject();
		int result=allotInfoService.deleteallotInfo(allotIds);
		if(result>0) {
			jsonObject.put("msg", true);
			jsonObject.put("count", result);
		}else {
			jsonObject.put("msg", false);
		}
		ResponseUtil.write(response, jsonObject);
	}
	
}















