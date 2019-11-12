package com.byzx.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.byzx.service.SorterInfoServicea;
import com.byzx.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@Controller
@RequestMapping("/sorterInfo")
public class SorterInfoControllera {
	
	@Autowired
	private SorterInfoServicea sorterInfoService;
	
	@RequestMapping("/findAllSorterInfo")
	public void findAllSorterInfo(HttpServletRequest request,HttpServletResponse response)throws Exception{
		JSONArray jsonArray=sorterInfoService.findAllSorterInfo();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("rows", jsonArray);
		ResponseUtil.write(response, jsonObject);
	
	
	


	
	
	}

}










