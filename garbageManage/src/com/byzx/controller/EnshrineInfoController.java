package com.byzx.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.byzx.model.EnshrineInfo;
import com.byzx.model.PageBean;
import com.byzx.model.UserInfo;
import com.byzx.service.EnshrineInfoService;
import com.byzx.util.ResponseUtil;
import com.byzx.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @文件名: EnshrineInfoController.java
 * @类功能说明:
 * @作者: SongXinLei
 * @Email: 248382500@qq.com
 * @日期: 2019年10月17日下午6:20:23
 * @修改说明:<br>
 * 
 *            <pre>
 * 	 <li>作者: SongXinLei</li> 
 * 	 <li>日期: 2019年10月17日下午6:20:23</li> 
 *	 <li>内容: </li>
 *            </pre>
 */
@Controller
@RequestMapping("/enshrineInfo")
public class EnshrineInfoController {

	@Autowired
	private EnshrineInfoService enshrineInfoService;

	@RequestMapping("/findAllEnshrineInfo.do")
	public void findAllEnshrineInfo(int page, int rows, String searchByName, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringUtil.isNotEmpty(searchByName)) {
			map.put("searchByName", searchByName);
		}

		PageBean pageBean = new PageBean(page, rows);
		map.put("pageBean", pageBean);
		JSONArray jsonArray = enshrineInfoService.findAllEnshrineInfo(map);
		int total = enshrineInfoService.findAllEnshrineInfoCount(map);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("rows", jsonArray);
		jsonObject.put("total", total);
		ResponseUtil.write(response, jsonObject);
	}

	@RequestMapping("/saveEnshrineInfo.do")
	public void saveEnshrineInfo(EnshrineInfo enshrineInfo, HttpServletRequest request, HttpServletResponse response)throws Exception {
		HttpSession session = request.getSession();
		UserInfo userInfos = (UserInfo) session.getAttribute("UserInfo");
		enshrineInfo.setOpt_id(userInfos.getUser_id());
		int result = enshrineInfoService.saveEnshrineInfo(enshrineInfo);
		JSONObject jsonObject = new JSONObject();
		if (result > 0) {
			jsonObject.put("msg", true);
		} else {
			jsonObject.put("msg", false);
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	

	// 添加用户时提示该用户存不存在
	@RequestMapping("/findEnshrineInfoByUName.do")
	public void findEnshrineInfoByUName(String warehous_name, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println(warehous_name);
		int result = enshrineInfoService.findEnshrineInfoByUName(warehous_name);
		System.out.println(result);
		JSONObject jsonObject = new JSONObject();

		if (result > 0) {
			jsonObject.put("msg", true);
		}
		System.out.println(jsonObject);
		ResponseUtil.write(response, jsonObject);
	}

	@RequestMapping("/updateEnshrineInfo.do")
	public void updateEnshrineInfo(EnshrineInfo enshrineInfo, HttpServletRequest request, HttpServletResponse response)throws Exception {
		int result = enshrineInfoService.updateEnshrineInfo(enshrineInfo);
		System.out.println(result);
		JSONObject jsonObject = new JSONObject();

		if (result > 0) {
			jsonObject.put("msg", true);
		} else {
			jsonObject.put("msg", false);
		}
		System.out.println(jsonObject);
		ResponseUtil.write(response, jsonObject);
	}
	
	// 删除
	@RequestMapping("/deleteEnshrineInfo.do")
	public void deleteEnshrineInfo(String warehousIds, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int result = enshrineInfoService.deleteEnshrineInfo(warehousIds);
		System.out.println(warehousIds);
		JSONObject jsonObject = new JSONObject();
		if (result > 0) {
			jsonObject.put("msg", true);
			jsonObject.put("count", result);
		} else {
			jsonObject.put("msg", false);
		}
		ResponseUtil.write(response, jsonObject);
	}
}
