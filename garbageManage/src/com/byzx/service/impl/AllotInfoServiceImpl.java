package com.byzx.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.byzx.dao.AllotInfoDao;
import com.byzx.model.AllotInfo;
import com.byzx.service.AllotInfoService;
import com.byzx.util.DateUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**@鏂囦欢鍚�: AllotInfoServiceImpl.java
 * @绫诲姛鑳借鏄�: 
 * @浣滆��: ChongYangYang
 * @Email: 1103222824@qq.com
 * @鏃ユ湡: 2019骞�10鏈�31鏃ヤ笂鍗�11:38:44
 * @淇敼璇存槑:<br> 
 * <pre>
 * 	 <li>浣滆��: ChongYangYang</li> 
 * 	 <li>鏃ユ湡: 2019骞�10鏈�31鏃ヤ笂鍗�11:38:44</li> 
 *	 <li>鍐呭: </li>
 * </pre>
 */
@Service
public class AllotInfoServiceImpl implements AllotInfoService {
	
	@Autowired
	private AllotInfoDao allotInfoDao;

	@Override
	public JSONArray findAllotInfo(Map<String, Object> map) {
		List<AllotInfo> allotInfoList=allotInfoDao.findAllotInfo(map);
		JSONArray jsonArray=new JSONArray();
		for(int i=0;i<allotInfoList.size();i++) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("a_aid", allotInfoList.get(i).getA_aid());
			jsonObject.put("c_carid", allotInfoList.get(i).getC_carid());
			jsonObject.put("a_depart", allotInfoList.get(i).getA_depart());
			jsonObject.put("a_destination", allotInfoList.get(i).getA_destination());
			jsonObject.put("a_time", allotInfoList.get(i).getA_time());
			jsonObject.put("remark", allotInfoList.get(i).getRemark());
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}

	@Override
	public int findAllotInfoCount(Map<String, Object> map) {
		return allotInfoDao.findAllotInfoCount(map);
	}

	@Override
	public int saveallotInfo(AllotInfo allotInfo) {
		allotInfo.setA_time(DateUtil.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
		allotInfo.setDelflag(0);
		return allotInfoDao.saveallotInfo(allotInfo);
	}

	@Override
	public int findallotInfoByUNumber(int c_carid) {
		return allotInfoDao.findallotInfoByUNumber(c_carid);
	}

	@Override
	public int updateallotInfo(AllotInfo allotInfo) {
		return allotInfoDao.updateallotInfo(allotInfo);
	}

	@Override
	public int deleteallotInfo(String allotIds) {
		String aid[]=allotIds.split(",");
		int count=0;
			for(int i=0;i<aid.length;i++) {
				allotInfoDao.deleteallotInfo(Integer.parseInt(aid[i]));
				count++;
		}
		return count;
	}



}
