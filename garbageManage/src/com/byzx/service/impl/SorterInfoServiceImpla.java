package com.byzx.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.byzx.dao.SorterInfoDaoa;
import com.byzx.model.UserInfo;
import com.byzx.service.SorterInfoServicea;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
public class SorterInfoServiceImpla implements SorterInfoServicea {
	
	@Autowired
	private SorterInfoDaoa sorterInfoDaoa;
	
	/**@方法名: ${enclosing_method}
	 * @方法说明: 查询分拣站的所有分拣员
	 * @作者: LiuKaiWen
	 * @邮箱：1519960668@qq.com
	 * @日期: ${date}${time}
	 * ${tags}
	 * @return: ${return_type}
	 */
	@Override
	public JSONArray findAllSorterInfo() {
		JSONArray jsonArray=new JSONArray();
		List<Integer> us=sorterInfoDaoa.findAllEnshrineInfo();
		for(Integer u:us) {
		System.out.println(u);
		List<UserInfo> userInfos=sorterInfoDaoa.findUserInfoByUid(u);
			for(UserInfo UserInfo:userInfos) {
				JSONObject jsonOBject=new JSONObject();
				jsonOBject.put("user_id", UserInfo.getUser_id());
				jsonOBject.put("user_name", UserInfo.getUser_name());
				jsonOBject.put("remark", UserInfo.getRemark());
				jsonArray.add(jsonOBject);
			}
		}
			
			return jsonArray;
	}
			
			
			

	
	

	@Override
	public int findAllSorterInfoCount(Map<String, Object> map) {
		
		return sorterInfoDaoa.findAllSorterInfoCount(map);
	}
























	







	
}
