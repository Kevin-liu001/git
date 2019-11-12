package com.byzx.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.byzx.model.GoodsInfo;
import com.byzx.model.PageBean;
import com.byzx.model.UserInfo;
import com.byzx.service.GoodsInfoService;
import com.byzx.util.ResponseUtil;
import com.byzx.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**@鏂囦欢鍚�: GoodsInfoController.java
 * @绫诲姛鑳借鏄�: 
 * @浣滆��: LiuChunHui
 * @Email: 508499598@qq.com
 * @鏃ユ湡: 2019骞�10鏈�30鏃ヤ笂鍗�10:08:41
 * @淇敼璇存槑:<br> 
 * <pre>
 * 	 <li>浣滆��: LiuChunHui</li> 
 * 	 <li>鏃ユ湡: 2019骞�10鏈�30鏃ヤ笂鍗�10:08:41</li> 
 *	 <li>鍐呭: </li>
 * </pre>
 */
@Controller
@RequestMapping("/goodsInfo")
public class GoodsInfoController {

	@Autowired
	private GoodsInfoService goodsInfoService;
	
	
	@RequestMapping("/findAllGoodsInfo.do")
	public void findAllGoodsInfo(int page,int rows,String searchByName,HttpServletRequest request, HttpServletResponse response) throws Exception{
		Map<String,Object> map=new HashMap<String,Object>();
		if(StringUtil.isNotEmpty(searchByName)) {
			map.put("searchByName", searchByName);
		}
		
		PageBean pageBean=new PageBean(page,rows);
		map.put("pageBean", pageBean);
		JSONArray jsonArray=goodsInfoService.findAllGoodsInfo(map);
		int total=goodsInfoService.findAllGoodsInfoCount(map);
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("rows", jsonArray);
		jsonObject.put("total", total);
		ResponseUtil.write(response, jsonObject);
	}
	
	@RequestMapping("/saveGoodsInfo.do")
	public void saveGoodsInfo(GoodsInfo goodsInfo,HttpServletRequest request,HttpServletResponse response) throws Exception{
		HttpSession session=request.getSession();
		UserInfo userInfos=(UserInfo) session.getAttribute("UserInfo");
		goodsInfo.setOptid(userInfos.getOpt_id());
		int result=goodsInfoService.saveGoodsInfo(goodsInfo);
		JSONObject jsonObject=new JSONObject();
		if(result>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	@RequestMapping("/updateGoodsInfo.do")
	public void updateGoodsInfo(GoodsInfo goodsInfo,HttpServletRequest request,HttpServletResponse response) throws Exception{
		int result=goodsInfoService.updateGoodsInfo(goodsInfo);
		JSONObject jsonObject=new JSONObject();
		
		if(result>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		ResponseUtil.write(response, jsonObject);
	}
	@RequestMapping("/deleteGoodsInfo.do")
	public void deleteGoodsInfo(String goodsIds,HttpServletRequest request,HttpServletResponse response) throws Exception{
		int result=goodsInfoService.deleteGoodsInfo(goodsIds);
		JSONObject jsonObject=new JSONObject();
		if(result>0) {
			jsonObject.put("msg", true);
			jsonObject.put("count",result);
		}else {
			jsonObject.put("msg", false);
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	@RequestMapping("/findGoodsInfoByGCode.do")
	public void findGoodsInfoByGCode(String g_code,HttpServletRequest request,HttpServletResponse response) throws Exception{
		int result=goodsInfoService.findGoodsInfoByGCode(g_code);
		JSONObject jsonObject=new JSONObject();
		
		if(result>0) {
			jsonObject.put("msg", true);
		}
		System.out.println(jsonObject);
		ResponseUtil.write(response, jsonObject);
	}
	
	@RequestMapping("/findAllGoodsId")
	public void findAllGoodsId(HttpServletResponse response) throws Exception {
		JSONArray jsonArray = goodsInfoService.findAllGoodsId();
		ResponseUtil.write(response, jsonArray);
	}

}
