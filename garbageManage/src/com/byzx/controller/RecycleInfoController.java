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

/**@文件名: RecycleInfoController.java
 * @类功能说明: 
 * @作者: WangSiYuan
 * @Email: 1512972568@qq.com
 * @日期: 2019年11月1日上午11:50:49
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: WangSiYuan
 * 	 <li>日期: 2019年11月1日上午11:50:49</li> 
 *	 <li>内容: </li>
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




