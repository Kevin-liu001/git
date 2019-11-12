package com.byzx.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.byzx.model.GoodsDetailInfo;
import com.byzx.model.PageBean;
import com.byzx.model.UserInfo;
import com.byzx.service.GoodsDetailInfoService;
import com.byzx.util.ResponseUtil;
import com.byzx.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**@鏂囦欢鍚�: GoodsDetailInfoController.java
 * @绫诲姛鑳借鏄�: 
 * @浣滆��: LiuChunHui
 * @Email: 508499598@qq.com
 * @鏃ユ湡: 2019骞�10鏈�30鏃ヤ笅鍗�12:14:22
 * @淇敼璇存槑:<br> 
 * <pre>
 * 	 <li>浣滆��: LiuChunHui</li> 
 * 	 <li>鏃ユ湡: 2019骞�10鏈�30鏃ヤ笅鍗�12:14:22</li> 
 *	 <li>鍐呭: </li>
 * </pre>
 */
@Controller
@RequestMapping("/goodsDetailInfo")
public class GoodsDetailInfoController {

	@Autowired
	private GoodsDetailInfoService goodsDetailInfoService;
	
	@RequestMapping("/findAllGoodsDetailInfo.do")
	public void findAllGoodsDetailInfo(int page,int rows,String s_roleName,HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("*********"+s_roleName);
		Map<String,Object> map=new HashMap<String,Object>();
		if(StringUtil.isNotEmpty(s_roleName)) {
			map.put("s_roleName", s_roleName);
		}
		PageBean pageBean=new PageBean(page,rows);
		map.put("pageBean", pageBean);
		JSONArray jsonArray=goodsDetailInfoService.findAllGoodsDetailInfo(map);
		int total=goodsDetailInfoService.findAllGoodsDetailInfoCount(map);
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("rows", jsonArray);
		jsonObject.put("total", total);
		ResponseUtil.write(response, jsonObject);
	}
	
	@RequestMapping("/saveGoodsDetailInfo.do")
	public void saveGoodsDetailInfo(GoodsDetailInfo goodsDetailInfo,HttpServletRequest request,HttpServletResponse response) throws Exception{
		HttpSession session=request.getSession();
		UserInfo userInfos=(UserInfo) session.getAttribute("UserInfo");
		goodsDetailInfo.setGt_optid(userInfos.getOpt_id());
		int result=goodsDetailInfoService.saveGoodsDetailInfo(goodsDetailInfo);
		JSONObject jsonObject=new JSONObject();
		if(result>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	@RequestMapping("/updateGoodsDetailInfo.do")
	public void updateGoodsDetailInfo(GoodsDetailInfo goodsDetailInfo,HttpServletRequest request,HttpServletResponse response) throws Exception{
		int result=goodsDetailInfoService.updateGoodsDetailInfo(goodsDetailInfo);
		JSONObject jsonObject=new JSONObject();
		
		if(result>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		ResponseUtil.write(response, jsonObject);
	}
	
	@RequestMapping("/deleteGoodsDetailInfo.do")
	public void deleteGoodsDetailInfo(String roleIds,HttpServletRequest request,HttpServletResponse response) throws Exception{
		int result=goodsDetailInfoService.deleteGoodsDetailInfo(roleIds);
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
