package com.byzx.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.byzx.model.RecycleStationInfo;
import com.byzx.model.UserInfo;
import com.byzx.service.RecycleStationInfoService;
import com.byzx.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**@閺傚洣娆㈤崥锟�: RecycleStationInfoCotroller.java
 * @缁濮涢懗鍊燁嚛閺勶拷: 
 * @娴ｆ粏锟斤拷: BaiHaoJie
 * @Email: 596315150@qq.com
 * @閺冦儲婀�: 2019楠烇拷10閺堬拷31閺冦儰绗呴崡锟�3:00:21
 * @娣囶喗鏁肩拠瀛樻:<br> 
 * <pre>
 * 	 <li>娴ｆ粏锟斤拷: BaiHaoJie</li> 
 * 	 <li>閺冦儲婀�: 2019楠烇拷10閺堬拷31閺冦儰绗呴崡锟�3:00:21</li> 
 *	 <li>閸愬懎顔�: </li>
 * </pre>
 */
@Controller
@RequestMapping("/recycleInfo")
public class RecycleStationInfoCotroller {

	@Autowired
	private RecycleStationInfoService recycleStationInfoService;
	
	@RequestMapping("/findAllRecycle")
	public void findAllRecycle(HttpServletRequest request,HttpServletResponse response) throws Exception {
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = recycleStationInfoService.findAllRecycle();
		jsonObject.put("msg", jsonArray);
		ResponseUtil.write(response, jsonObject);
	}
	
	@RequestMapping("/findRecycleByAddress")
	public void findRecycleByAddress(String recycle_address,HttpServletRequest request,HttpServletResponse response) throws Exception {
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = recycleStationInfoService.findRecycleByAddress(recycle_address);
		jsonObject.put("msg", jsonArray);
		ResponseUtil.write(response, jsonObject);
	}
	
	@RequestMapping("/saveRecycleInfo")
	public void saveRecycleInfo(@RequestBody RecycleStationInfo recycleStationInfo,HttpServletRequest request,HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		UserInfo currUser = (UserInfo) session.getAttribute("currentUserInfo");
		recycleStationInfo.setOptid(currUser.getUser_id());
		JSONObject jsonObject = new JSONObject();
		System.out.println(recycleStationInfo);
		int result = recycleStationInfoService.saveRecycleInfo(recycleStationInfo);
		if(result>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", true);
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	@RequestMapping("/deleteRecycleInfo")
	public void deleteRecycleInfo(int rsid,HttpServletRequest request,HttpServletResponse response) throws Exception {
		JSONObject jsonObject = new JSONObject();
		int result = recycleStationInfoService.deleteRecycleInfo(rsid);
		if(result>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	@RequestMapping("/updateRecycleInfo")
	public void updateRecycleInfo(@RequestBody RecycleStationInfo recycleInfo,HttpServletRequest request,HttpServletResponse response) throws Exception {
		JSONObject jsonObject = new JSONObject();
		HttpSession session = request.getSession();
		UserInfo currUser = (UserInfo) session.getAttribute("currentUser");
		recycleInfo.setOptid(currUser.getUser_id());
		int result = recycleStationInfoService.updateRecycleInfo(recycleInfo);
		if(result>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	
}














