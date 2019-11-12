package com.byzx.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.byzx.dao.RecycleInfoDao;
import com.byzx.model.RecycleStationInfo;
import com.byzx.service.RecycleInfoService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**@�ļ���: RecycleInfoServiceImpl.java
 * @�๦��˵��: 
 * @����: WangSiYuan
 * @Email: 1512972568@qq.com
 * @����: 2019��11��1������11:58:37
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: WangSiYuan
 * 	 <li>����: 2019��11��1������11:58:37</li> 
 *	 <li>����: </li>
 * </pre>
 */
@Service
public class RecycleInfoServiceImpl implements RecycleInfoService {
	
	@Autowired
	private RecycleInfoDao recycleInfoDao;

	@Override
	public JSONArray findAllRecycle(Map<String, Object> map) {
		List<RecycleStationInfo> recycleInfoList=recycleInfoDao.findAllRecycle(map);
		JSONArray jsonArray=new JSONArray();
		for(int i=0;i<recycleInfoList.size();i++) {
			JSONObject jsonOBject=new JSONObject();
			RecycleStationInfo recycleInfo=recycleInfoList.get(i);
			jsonOBject.put("rsid", recycleInfo.getRsid());
			jsonOBject.put("ss_id", recycleInfo.getSs_id());
			jsonOBject.put("c_ucid", recycleInfo.getC_ucid());
			jsonOBject.put("rsname", recycleInfo.getRsname());
			jsonOBject.put("address", recycleInfo.getAddress());
			jsonOBject.put("scope", recycleInfo.getScope());
			jsonOBject.put("state", recycleInfo.getState());
			jsonOBject.put("date", recycleInfo.getDate());
			jsonOBject.put("volume", recycleInfo.getVolume());
			jsonOBject.put("optid", recycleInfo.getOptid());
			jsonOBject.put("delflag", recycleInfo.getDelflag());
			jsonOBject.put("optime", recycleInfo.getOptime());
			jsonOBject.put("remark", recycleInfo.getRemark());
			jsonOBject.put("ss_name", recycleInfoDao.findSortingstationNameById(recycleInfo.getSs_id()));
			jsonArray.add(jsonOBject);
		}
		return jsonArray;
	}

	@Override
	public int findAllRecycleCount(Map<String, Object> map) {
		
		return recycleInfoDao.findAllRecycleCount(map);
	}
	

}
