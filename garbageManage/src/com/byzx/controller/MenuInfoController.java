package com.byzx.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.byzx.model.MenuInfo;
import com.byzx.model.UserInfo;
import com.byzx.service.MenuInfoService;
import com.byzx.service.RoleInfoService;
import com.byzx.util.ResponseUtil;
import com.byzx.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**@文件名: MenuInfoController.java
 * @类功能说明: 
 * @作者: LiuChunHui
 * @Email: 508499598@qq.com
 * @日期: 2019年10月18日下午6:50:25
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: LiuChunHui</li> 
 * 	 <li>日期: 2019年10月18日下午6:50:25</li> 
 *	 <li>内容: </li>
 * </pre>
 */
@Controller
@RequestMapping("/menuInfo")
public class MenuInfoController {
	
	@Autowired
	private MenuInfoService menuInfoService;
	
	@Autowired
	private RoleInfoService roleInfoService;
	
	@RequestMapping("/findAllMenuInfo")
	public void findAllMenuInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String parentId="-1";
		HttpSession session=request.getSession();
		UserInfo currentUserInfo=(UserInfo) session.getAttribute("UserInfo");
		System.out.println(currentUserInfo.getRole_id() + "**********");
		String menuIds=roleInfoService.getMenuIdsByRoleId(currentUserInfo.getRole_id());
		List<Integer> listMenuIds=StringUtil.stringToArry(menuIds);
		JSONArray jsonArray=menuInfoService.findAllMenuInfo(parentId,listMenuIds);
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("MenuInfo", jsonArray);
		System.out.println(jsonObject);
		ResponseUtil.write(response, jsonObject);
	}
	
	@RequestMapping("/findAllMenuInfoEmpower.do")
	public void findAllMenuInfoEmpower(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String parentId="-1";
		String menu_ids=request.getParameter("menu_ids");
		JSONArray jsonArray=menuInfoService.findAllMenuInfoEmpower(parentId,menu_ids);
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("MenuInfo", jsonArray);
		System.out.println(jsonObject);
		ResponseUtil.write(response, jsonObject);
	}
	
	@RequestMapping("/findMenuInfoAll.do")
	public void findMenuInfoAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String parentId="-1";
		JSONArray jsonArray=menuInfoService.findMenuInfoAll(parentId);
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("rows", jsonArray);
		System.out.println(jsonObject);
		ResponseUtil.write(response, jsonObject);
	}
	
	@RequestMapping("/saveMenuInfo")
	public void saveMenuInfo(MenuInfo menuInfo,HttpServletRequest request,HttpServletResponse response) throws Exception{
		HttpSession session=request.getSession();
		UserInfo userInfos=(UserInfo) session.getAttribute("UserInfo");
		menuInfo.setOpt_id(userInfos.getOpt_id());
		int result=menuInfoService.saveMenuInfo(menuInfo);
		JSONObject jsonObject=new JSONObject();
		if(result>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	@RequestMapping("/updateMenuInfo.do")
	public void updateMenuInfo(MenuInfo menuInfo,HttpServletRequest request,HttpServletResponse response) throws Exception{
		int result=menuInfoService.updateMenuInfo(menuInfo);
		System.out.println(menuInfo);
		JSONObject jsonObject=new JSONObject();
		if(result>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		System.out.println(jsonObject);
		ResponseUtil.write(response, jsonObject);
	}
	
	@RequestMapping("/deleteMenuInfo.do")
	public void deleteMenuInfo(int menu_id,HttpServletRequest request,HttpServletResponse response) throws Exception{
		int result=menuInfoService.deleteMenuInfo(menu_id);
		JSONObject jsonObject=new JSONObject();
		if(result>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		ResponseUtil.write(response, jsonObject);
	}
	
}
