package com.byzx.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.byzx.model.PageBean;
import com.byzx.model.UserInfo;
import com.byzx.service.UserInfoService;
import com.byzx.util.ResponseUtil;
import com.byzx.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**@文件名: UserInfoController.java
 * @类功能说明: 
 * @作者: LiuChunHui
 * @Email: 508499598@qq.com
 * @日期: 2019年10月17日下午6:20:23
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: LiuChunHui</li> 
 * 	 <li>日期: 2019年10月17日下午6:20:23</li> 
 *	 <li>内容: </li>
 * </pre>
 */
@Controller
@RequestMapping("/userInfo")
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;
	
	@RequestMapping("/login.do")
	public String queryuser(UserInfo userInfo,String yzm,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session=request.getSession();
		String sRand=(String) session.getAttribute("sRand");
		UserInfo currentUserSession=(UserInfo) session.getAttribute("UserInfo");
		if(currentUserSession!=null) {
			return "main";
		}else {
			if(sRand==null) {
				return "redirect:../login.jsp";
			}else {
				if(!sRand.equals(yzm)) {
					return "redirect:../login.jsp?error=1&user_name=" + userInfo.getUser_name() + "&user_pwd=" + userInfo.getUser_pwd() + "&yzm=" + yzm ;
				}else {
					UserInfo usf=userInfoService.findUserInfo(userInfo);
					System.out.println(usf);
					if(usf!=null) {
						session.setAttribute("UserInfo", usf);
						return "main";
					}else {
						return "redirect:../login.jsp?error=2&user_name=" + userInfo.getUser_name() + "&user_pwd=" + userInfo.getUser_pwd() + "&yzm=" + yzm ;
					}
				}
			}
		}
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		session.removeAttribute("UserInfo");
		return "redirect:../login.jsp";
	}
	
	@RequestMapping("/findAllUserInfo.do")
	public void findAllUserInfo(int page,int rows,String searchByName,HttpServletRequest request, HttpServletResponse response) throws Exception{
		Map<String,Object> map=new HashMap<String,Object>();
		if(StringUtil.isNotEmpty(searchByName)) {
			map.put("searchByName", searchByName);
		}
		
		PageBean pageBean=new PageBean(page,rows);
		map.put("pageBean", pageBean);
		JSONArray jsonArray=userInfoService.findAllUserInfo(map);
		int total=userInfoService.findAllUserInfoCount(map);
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("rows", jsonArray);
		jsonObject.put("total", total);
		ResponseUtil.write(response, jsonObject);
	}
	@RequestMapping("/saveUserInfo.do")
	public void saveUserInfo(UserInfo userInfo,HttpServletRequest request,HttpServletResponse response) throws Exception{
		HttpSession session=request.getSession();
		UserInfo userInfos=(UserInfo) session.getAttribute("UserInfo");
		userInfo.setOpt_id(userInfos.getOpt_id());
		int result=userInfoService.saveUserInfo(userInfo);
		JSONObject jsonObject=new JSONObject();
		if(result>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	@RequestMapping("/findUserInfoByUName.do")
	public void findUserInfoByUName(String user_name,HttpServletRequest request,HttpServletResponse response) throws Exception{
		System.out.println(user_name);
		int result=userInfoService.findUserInfoByUName(user_name);
		System.out.println(result);
		JSONObject jsonObject=new JSONObject();
		
		if(result>0) {
			jsonObject.put("msg", true);
		}
		System.out.println(jsonObject);
		ResponseUtil.write(response, jsonObject);
	}
	
	@RequestMapping("/updateUserInfo.do")
	public void updateUserInfo(UserInfo userInfo,HttpServletRequest request,HttpServletResponse response) throws Exception{
		int result=userInfoService.updateUserInfo(userInfo);
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
	
	@RequestMapping("/deleteUserInfo.do")
	public void deleteUserInfo(String userIds,HttpServletRequest request,HttpServletResponse response) throws Exception{
		int result=userInfoService.deleteUserInfo(userIds);
		System.out.println(userIds);
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









