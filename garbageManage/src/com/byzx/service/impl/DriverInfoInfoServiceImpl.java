package com.byzx.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.byzx.dao.DriverInfoDao;
import com.byzx.model.UserInfo;
import com.byzx.service.DriverInfoInfoService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**@�ļ���: DriverInfoInfoServiceImpl.java
 * @�๦��˵��: ˾���ӿ�ʵ����
 * @����: WangSiYuan
 * @Email: 1512972568@qq.com
 * @����: 2019��11��1������5:14:08
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: WangSiYuan
 * 	 <li>����: 2019��11��1������5:14:08</li> 
 *	 <li>����: </li>
 * </pre>
 */
@Service
public class DriverInfoInfoServiceImpl implements DriverInfoInfoService {
	
	@Autowired
	private DriverInfoDao driverInfoDao;

	@Override
	public JSONArray findAllDriverInfo(Map<String, Object> map) {
		List<UserInfo> driverInfoList=driverInfoDao.findAllDriverInfo(map);
		JSONArray jsonArray=new JSONArray();
		for(int i=0;i<driverInfoList.size();i++) {
			JSONObject jsonOBject=new JSONObject();
			UserInfo driverInfo=driverInfoList.get(i);
			jsonOBject.put("user_id", driverInfo.getUser_id());
			jsonOBject.put("user_name", driverInfo.getUser_name());
			jsonOBject.put("user_pwd", driverInfo.getUser_pwd());
			jsonOBject.put("user_phone", driverInfo.getUser_phone());
			jsonOBject.put("user_idCard", driverInfo.getUser_idCard());
			jsonOBject.put("role_id", driverInfo.getRole_id());
			jsonOBject.put("state", driverInfo.getState());
			jsonOBject.put("delflag", driverInfo.getDelflag());
			jsonOBject.put("createtime", driverInfo.getCreatetime());
			jsonOBject.put("remark", driverInfo.getRemark());
			jsonOBject.put("opt_id", driverInfo.getOpt_id());
			jsonArray.add(jsonOBject);
		}
		return jsonArray;
	}

	@Override
	public int findAllDriverInfoCount(Map<String, Object> map) {
		
		return driverInfoDao.findAllDriverInfoCount(map);
	}
}
