package com.byzx.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.byzx.service.RecycleGoodsInfoService;
import com.byzx.util.ResponseUtil;

import net.sf.json.JSONArray;

/**@鏂囦欢鍚�: RecycleGoodsInfoCotroller.java
 * @绫诲姛鑳借鏄�: 
 * @浣滆��: BaiHaoJie
 * @Email: 596315150@qq.com
 * @鏃ユ湡: 2019骞�11鏈�4鏃ヤ笂鍗�10:28:19
 * @淇敼璇存槑:<br> 
 * <pre>
 * 	 <li>浣滆��: BaiHaoJie</li> 
 * 	 <li>鏃ユ湡: 2019骞�11鏈�4鏃ヤ笂鍗�10:28:19</li> 
 *	 <li>鍐呭: </li>
 * </pre>
 */
@Controller
@RequestMapping("/RecycleGoodsInfo")
public class RecycleGoodsInfoCotroller {

	@Autowired
	private RecycleGoodsInfoService RecycleGoodsInfoService;
	@RequestMapping("/findAllRecycleGoodsId")
	public void findAllRecycleGoodsId(HttpServletResponse response) throws Exception {
		JSONArray jsonArray = RecycleGoodsInfoService.findAllRecycleGoodsId();
		ResponseUtil.write(response, jsonArray);
		
	}
}

















