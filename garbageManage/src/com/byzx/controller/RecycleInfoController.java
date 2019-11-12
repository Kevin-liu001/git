package com.byzx.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.byzx.model.PageBean;
import com.byzx.service.RecycleInfoService;
import com.byzx.util.ResponseUtil;
import com.byzx.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**@�ļ���: RecycleInfoController.java
 * @�๦��˵��: 
 * @����: WangSiYuan
 * @Email: 1512972568@qq.com
 * @����: 2019��11��1������11:50:49
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: WangSiYuan
 * 	 <li>����: 2019��11��1������11:50:49</li> 
 *	 <li>����: </li>
 * </pre>
 */
@Controller
@RequestMapping("/RecycleInfo")
public class RecycleInfoController {
	
	@Autowired
	private RecycleInfoService recycleInfoService;
	
	@RequestMapping("/findAllRecycle")
	public void findAllRecycle(String rsname,int page, int rows,HttpServletResponse response)throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		if(StringUtil.isNotEmpty(rsname)) {
			map.put("rsname", rsname);
		}
		PageBean pageBean = new PageBean(page, rows);
		map.put("pageBean", pageBean);
		JSONArray jsonArray=recycleInfoService.findAllRecycle(map);
		int total=recycleInfoService.findAllRecycleCount(map);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("rows", jsonArray);
		jsonObject.put("total", total);
		ResponseUtil.write(response, jsonObject);
	}
	
	
	

}




