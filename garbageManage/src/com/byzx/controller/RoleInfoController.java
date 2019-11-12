package com.byzx.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.byzx.model.PageBean;
import com.byzx.model.RoleInfo;
import com.byzx.model.UserInfo;
import com.byzx.service.RoleInfoService;
import com.byzx.util.ResponseUtil;
import com.byzx.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**@文件名: RoleInfoController.java
 * @类功能说明: 
 * @作者: LiuChunHui
 * @Email: 508499598@qq.com
 * @日期: 2019年10月21日上午8:40:35
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: LiuChunHui</li> 
 * 	 <li>日期: 2019年10月21日上午8:40:35</li> 
 *	 <li>内容: </li>
 * </pre>
 */
@Controller
@RequestMapping("/roleInfo")
public class RoleInfoController {

	@Autowired
	private RoleInfoService roleInfoService;
	
	@RequestMapping("/findAllRoleInfo.do")
	public void findAllUserInfo(int page,int rows,String s_roleName,HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("*********"+s_roleName);
		Map<String,Object> map=new HashMap<String,Object>();
		if(StringUtil.isNotEmpty(s_roleName)) {
			map.put("s_roleName", s_roleName);
		}
		PageBean pageBean=new PageBean(page,rows);
		map.put("pageBean", pageBean);
		JSONArray jsonArray=roleInfoService.findAllRoleInfo(map);
		int total=roleInfoService.findAllRoleInfoCount(map);
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("rows", jsonArray);
		jsonObject.put("total", total);
		ResponseUtil.write(response, jsonObject);
	}
	
	@RequestMapping("/saveRoleInfo.do")
	public void saveUserInfo(RoleInfo roseInfo,HttpServletRequest request,HttpServletResponse response) throws Exception{
		HttpSession session=request.getSession();
		UserInfo userInfos=(UserInfo) session.getAttribute("UserInfo");
		roseInfo.setOpt_id(userInfos.getOpt_id());
		int result=roleInfoService.saveRoleInfo(roseInfo);
		JSONObject jsonObject=new JSONObject();
		if(result>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	@RequestMapping("/findRoleInfoByRName.do")
	public void findRoleInfoByRName(String role_name,HttpServletRequest request,HttpServletResponse response) throws Exception{
		System.out.println(role_name);
		int result=roleInfoService.findRoleInfoByRName(role_name);
		System.out.println(result);
		JSONObject jsonObject=new JSONObject();
		
		if(result>0) {
			jsonObject.put("msg", true);
		}
		System.out.println(jsonObject);
		ResponseUtil.write(response, jsonObject);
	}
	
	@RequestMapping("/updateRoleInfo.do")
	public void updateRoleInfo(RoleInfo roseInfo,HttpServletRequest request,HttpServletResponse response) throws Exception{
		int result=roleInfoService.updateRoleInfo(roseInfo);
		System.out.println(result);
		JSONObject jsonObject=new JSONObject();
		
		if(result>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		System.out.println(jsonObject);
		ResponseUtil.write(response, jsonObject);
	}
	
	@RequestMapping("/deleteRoleInfo.do")
	public void deleteRoleInfo(String roleIds,HttpServletRequest request,HttpServletResponse response) throws Exception{
		int result=roleInfoService.deleteRoleInfo(roleIds);
		System.out.println(roleIds);
		JSONObject jsonObject=new JSONObject();
		if(result>0) {
			jsonObject.put("msg", true);
			jsonObject.put("count",result);
		}else {
			jsonObject.put("msg", false);
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	@RequestMapping("/roleInfoEmpower.do")
	public void roleInfoEmpower(int role_id,String rowIds,HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("menu_ids", rowIds);
		map.put("role_id", role_id);
		int result=roleInfoService.roleInfoEmpower(map);
		System.out.println(map);
		JSONObject jsonObject=new JSONObject();
		if(result>0) {
			jsonObject.put("msg", true);
			jsonObject.put("count",result);
		}else {
			jsonObject.put("msg", false);
		}
		ResponseUtil.write(response, jsonObject);
	}
	
}
