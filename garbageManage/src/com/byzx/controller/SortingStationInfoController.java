package com.byzx.controller;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.byzx.model.SortingStationInfo;
import com.byzx.model.UserInfo;
import com.byzx.service.SortingStationInfoservice;
import com.byzx.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**@锟侥硷拷锟斤拷: SortingStationInfoController.java
 * @锟洁功锟斤拷说锟斤拷: 
 * @锟斤拷锟斤拷: LiuKaiWem
 * @Email: 1519960668@qq.com
 * @锟斤拷锟斤拷: 2019锟斤拷10锟斤拷31锟斤拷锟斤拷锟斤拷9:38:41
 * @锟睫革拷说锟斤拷:<br> 
 * <pre>
 * 	 <li>锟斤拷锟斤拷: LiuKaiWem</li> 
 * 	 <li>锟斤拷锟斤拷: 2019锟斤拷10锟斤拷31锟斤拷锟斤拷锟斤拷9:38:41</li> 
 *	 <li>锟斤拷锟斤拷: </li>
 * </pre>
 */

@Controller
@RequestMapping("/sortingStationInfo")
public class SortingStationInfoController {

	@Autowired
	private SortingStationInfoservice sortingStationInfoservice;
	/**@方法名: ${enclosing_method}
	 * @方法说明: 查询所有分拣站
	 * @作者: LiuKaiWen
	 * @邮箱：1519960668@qq.com
	 * @日期: ${date}${time}
	 * ${tags}
	 * @return: ${return_type}
	 */
	@RequestMapping("/findAllSortingStation")
	public void findAllSortingStation( HttpServletRequest request,HttpServletResponse response) throws Exception {
		JSONArray jsonArray =sortingStationInfoservice.findAllSortingStation();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("sortingStationInfo", jsonArray);
		ResponseUtil.write(response, jsonObject);
	}
	
	/**@方法名: ${enclosing_method}
	 * @方法说明: 查询所有分拣站的名字
	 * @作者: LiuKaiWen
	 * @邮箱：1519960668@qq.com
	 * @日期: ${date}${time}
	 * ${tags}
	 * @return: ${return_type}
	 */
	@RequestMapping("/findSortStationNames")
	public void findSortStationNames(HttpServletRequest request,HttpServletResponse response) throws Exception {
		/*JSONObject jsonObject = new JSONObject();*/
		JSONArray jsonArray = sortingStationInfoservice.findSortStationNames();
		/*System.out.println(jsonArray);
		jsonObject.put("msg", jsonArray);*/
		System.out.println(jsonArray);
		ResponseUtil.write(response, jsonArray);
	}

	/**@方法名: ${enclosing_method}
	 * @方法说明: 根据分拣站地址查询所有分拣站
	 * @作者: LiuKaiWen
	 * @邮箱：1519960668@qq.com
	 * @日期: ${date}${time}
	 * ${tags}
	 * @return: ${return_type}
	 */
	@RequestMapping("/findAllSSByAddress")
	public void findAllSSByAddress(String ss_address, HttpServletRequest request,HttpServletResponse response) throws Exception {
		JSONObject jsonObject = new JSONObject();
		jsonObject=sortingStationInfoservice.findAllSSByAddress(ss_address);
		jsonObject.put("sortUser", jsonObject);
		ResponseUtil.write(response, jsonObject);
	}
	
	/**@方法名: ${enclosing_method}
	 * @方法说明: 新增分拣站
	 * @作者: LiuKaiWen
	 * @邮箱：1519960668@qq.com
	 * @日期: ${date}${time}
	 * ${tags}
	 * @return: ${return_type}
	 */
	@RequestMapping("/addSortingStationInfo")
	public void addSortingStationInfo(@RequestBody SortingStationInfo sortingStationInfo,HttpServletRequest request,HttpServletResponse response) throws Exception  {
		System.out.println("222222222222"+sortingStationInfo.getSs_address());
		HttpSession session=request.getSession();
		UserInfo nowuser=(UserInfo) session.getAttribute("UserInfo");//获取当前用户
		sortingStationInfo.setOpt_id(nowuser.getUser_id());//当前用户的id赋给操作人
		JSONObject jsonOject=new JSONObject();
		int result=sortingStationInfoservice.addSortingStationInfo(sortingStationInfo);
		if (result>0) {
			jsonOject.put("msg", true);
		} else {
			jsonOject.put("msg", false);
		}
		ResponseUtil.write(response, jsonOject);
	}
	/**@方法名: ${enclosing_method}
	 * @方法说明: 删除分拣站
	 * @作者: LiuKaiWen
	 * @邮箱：1519960668@qq.com
	 * @日期: ${date}${time}
	 * ${tags}
	 * @return: ${return_type}
	 */
	@RequestMapping("/deleteSortingStationInfo")
	public void deleteSortingStationInfo(int ss_id, HttpServletResponse response) throws Exception {
		JSONObject jsonobject =new JSONObject();
		int result =sortingStationInfoservice.deleteSortingStationInfo(ss_id);
		if (result>0) {
			jsonobject.put("msg", true);
			jsonobject.put("count", result);
		} else {
			jsonobject.put("msg", false);
		}
		ResponseUtil.write(response, jsonobject);
	}
	/**@方法名: ${enclosing_method}
	 * @方法说明: 修改分拣站
	 * @作者: LiuKaiWen
	 * @邮箱：1519960668@qq.com
	 * @日期: ${date}${time}
	 * ${tags}
	 * @return: ${return_type}
	 */
	@RequestMapping("/updateSortingStationInfo")
	public void updateSortingStationInfo(@RequestBody SortingStationInfo sortingStationInfo,HttpServletRequest request,HttpServletResponse response) throws Exception  {
		int result =sortingStationInfoservice.updateSortingStationInfo(sortingStationInfo);
		JSONObject jsonobject =new JSONObject();
		if (result>0) {
			jsonobject.put("msg", true);
		} else {
			jsonobject.put("msg", false);
		}
		ResponseUtil.write(response, jsonobject);
	}
}
