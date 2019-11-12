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

/**@�ļ���: SortingStationInfoController.java
 * @�๦��˵��: 
 * @����: LiuKaiWem
 * @Email: 1519960668@qq.com
 * @����: 2019��10��31������9:38:41
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: LiuKaiWem</li> 
 * 	 <li>����: 2019��10��31������9:38:41</li> 
 *	 <li>����: </li>
 * </pre>
 */

@Controller
@RequestMapping("/sortingStationInfo")
public class SortingStationInfoController {

	@Autowired
	private SortingStationInfoservice sortingStationInfoservice;
	/**@������: ${enclosing_method}
	 * @����˵��: ��ѯ���зּ�վ
	 * @����: LiuKaiWen
	 * @���䣺1519960668@qq.com
	 * @����: ${date}${time}
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
	
	/**@������: ${enclosing_method}
	 * @����˵��: ��ѯ���зּ�վ������
	 * @����: LiuKaiWen
	 * @���䣺1519960668@qq.com
	 * @����: ${date}${time}
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

	/**@������: ${enclosing_method}
	 * @����˵��: ���ݷּ�վ��ַ��ѯ���зּ�վ
	 * @����: LiuKaiWen
	 * @���䣺1519960668@qq.com
	 * @����: ${date}${time}
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
	
	/**@������: ${enclosing_method}
	 * @����˵��: �����ּ�վ
	 * @����: LiuKaiWen
	 * @���䣺1519960668@qq.com
	 * @����: ${date}${time}
	 * ${tags}
	 * @return: ${return_type}
	 */
	@RequestMapping("/addSortingStationInfo")
	public void addSortingStationInfo(@RequestBody SortingStationInfo sortingStationInfo,HttpServletRequest request,HttpServletResponse response) throws Exception  {
		System.out.println("222222222222"+sortingStationInfo.getSs_address());
		HttpSession session=request.getSession();
		UserInfo nowuser=(UserInfo) session.getAttribute("UserInfo");//��ȡ��ǰ�û�
		sortingStationInfo.setOpt_id(nowuser.getUser_id());//��ǰ�û���id����������
		JSONObject jsonOject=new JSONObject();
		int result=sortingStationInfoservice.addSortingStationInfo(sortingStationInfo);
		if (result>0) {
			jsonOject.put("msg", true);
		} else {
			jsonOject.put("msg", false);
		}
		ResponseUtil.write(response, jsonOject);
	}
	/**@������: ${enclosing_method}
	 * @����˵��: ɾ���ּ�վ
	 * @����: LiuKaiWen
	 * @���䣺1519960668@qq.com
	 * @����: ${date}${time}
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
	/**@������: ${enclosing_method}
	 * @����˵��: �޸ķּ�վ
	 * @����: LiuKaiWen
	 * @���䣺1519960668@qq.com
	 * @����: ${date}${time}
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
