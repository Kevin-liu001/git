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
import com.byzx.model.TransferInfo;
import com.byzx.model.UserInfo;
import com.byzx.service.TransferInfoService;
import com.byzx.util.ResponseUtil;
import com.byzx.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**@文件名: TransferInfoController.java
 * @类功能说明: 
 * @作者: WangSiYuan
 * @Email: 1512972568@qq.com
 * @日期: 2019年10月30日下午2:22:19
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: WangSiYuan
 * 	 <li>日期: 2019年10月30日下午2:22:19</li> 
 *	 <li>内容: </li>
 * </pre>
 */
@Controller
@RequestMapping("/transferInfo")
public class TransferInfoController {
	
	@Autowired
	private TransferInfoService transferInfoService;
	
	@RequestMapping("/findAllTransferInfo")
	public void findAllTransferInfo(int page, int rows, String searchByName,HttpServletRequest request,HttpServletResponse response)throws Exception {
		Map<String,Object> map=new HashMap<String,Object>();
		if(StringUtil.isNotEmpty(searchByName)) {
			map.put("searchByName", searchByName);
		}
		PageBean pageBean = new PageBean(page, rows);
		map.put("pageBean", pageBean);
		JSONArray jsonArray=transferInfoService.findAllTransferInfo(map);
		int total=transferInfoService.findAllTransferInfoCount(map);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("rows", jsonArray);
		jsonObject.put("total", total);
		ResponseUtil.write(response, jsonObject);
	}
	
	
	@RequestMapping("/saveTransferInfo")
	public void saveTransferInfo(TransferInfo transferInfo,HttpServletRequest request,HttpServletResponse response)throws Exception {
		HttpSession session=request.getSession();
		UserInfo currUser=(UserInfo) session.getAttribute("currentUserInfo");
		transferInfo.setOptid(currUser.getUser_id());
		int result=transferInfoService.saveTransferInfo(transferInfo);
		JSONObject jsonObject=new JSONObject();
		if(result>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	@RequestMapping("/updateTransferInfo")
	public void updateTransferInfo(TransferInfo transferInfo,HttpServletResponse response)throws Exception{
		int result=transferInfoService.updateTransferInfo(transferInfo);
		JSONObject jsonObject=new JSONObject();
		if(result>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	
	@RequestMapping("/deleteTransferInfo")
	public void deleteTransferInfo(String transIds,HttpServletResponse response)throws Exception{
		JSONObject jsonObject = new JSONObject();
		int result=transferInfoService.deleteTransferInfo(transIds);
		if(result>0) {
			jsonObject.put("msg", true);
			jsonObject.put("count", result);
		}else {
			jsonObject.put("msg", false);
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	
	
	
	
}







