package com.byzx.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.byzx.model.ResidentInfo;
import com.byzx.service.ResidentInfoService;
import com.byzx.util.ResponseUtil;

import net.sf.json.JSONObject;

/**@鏂囦欢鍚�: userLoginController.java
 * @绫诲姛鑳借鏄�: 
 * @浣滆��: HeGuangYao
 * @Email: 105302097@qq.com
 * @鏃ユ湡: 2019骞�10鏈�30鏃ヤ笂鍗�10:43:32
 * @淇敼璇存槑:<br> 
 * <pre>
 * 	 <li>浣滆��: HeGuangYao</li> 
 * 	 <li>鏃ユ湡: 2019骞�10鏈�30鏃ヤ笂鍗�10:43:32</li> 
 *	 <li>鍐呭: </li>
 * </pre>
 */
@Controller
@RequestMapping("/userLogin")
public class ResidentInfoController {

	@Autowired
	private ResidentInfoService residentInfoService;
	
	@RequestMapping("/login1")
	public String queryuser(ResidentInfo residentInfo,String yzm,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		System.out.println(yzm+"*************************");
		String sRand = (String) session.getAttribute("sRand");
		ResidentInfo currentUserSession=(ResidentInfo) session.getAttribute("ResidentInfo");
		if(currentUserSession!=null) {
			return "redirect:/html/app.html";
		}else {
			if(!sRand.equals(yzm)) {
				return "redirect:/html/login.html?error=1&r_name=" + residentInfo.getR_name() + "&r_password=" + residentInfo.getR_password() + "&yzm=" + yzm ;
			}else {
				ResidentInfo rdi = residentInfoService.findResidentInfo(residentInfo);
				if(rdi!=null) {
					session.setAttribute("ResidentInfo", rdi);
					return "redirect:/html/app.html"; 
				}else {
					return "redirect:/html/login.html?error=2&r_name=" + residentInfo.getR_name() + "&r_password=" + residentInfo.getR_password() + "&yzm=" + yzm ;
				}
			}	
		}
	}
	
	@RequestMapping("/findResidentInfoByName")
	public void findResidentInfoByName(String r_name,HttpServletRequest request, HttpServletResponse response)throws Exception {
		int result=residentInfoService.findResidentInfoByName(r_name);
		JSONObject jsonObject=new JSONObject();
		
		if(result>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	@RequestMapping("/insertResidentInfo")
	public void insertResidentInfo(ResidentInfo residentInfo,HttpServletRequest request,HttpServletResponse response)throws Exception{
		HttpSession session = request.getSession();
		ResidentInfo residentInfos=(ResidentInfo) session.getAttribute("ResidentInfo");
		//residentInfo.setOpt_id(residentInfos.getR_id());
		int result=residentInfoService.insertResidentInfo(residentInfo);
		JSONObject jsonObject=new JSONObject();
		if(result>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		ResponseUtil.write(response, jsonObject);
	}
}

















