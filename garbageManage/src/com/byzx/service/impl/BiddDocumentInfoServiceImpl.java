package com.byzx.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.byzx.dao.BiddDocumentInfoDao;
import com.byzx.model.BiddDocumentInfo;
import com.byzx.service.BiddDocumentInfoService;
import com.byzx.util.DateUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**@鏂囦欢鍚�: BiddDocumentInfoServiceImpl.java
 * @绫诲姛鑳借鏄�: 
 * @浣滆��: LiuChunHui
 * @Email: 508499598@qq.com
 * @鏃ユ湡: 2019骞�10鏈�30鏃ヤ笅鍗�5:20:31
 * @淇敼璇存槑:<br> 
 * <pre>
 * 	 <li>浣滆��: LiuChunHui</li> 
 * 	 <li>鏃ユ湡: 2019骞�10鏈�30鏃ヤ笅鍗�5:20:31</li> 
 *	 <li>鍐呭: </li>
 * </pre>
 */
@Service
public class BiddDocumentInfoServiceImpl implements BiddDocumentInfoService {

	@Autowired
	private BiddDocumentInfoDao biddDocumentInfoDao;
	
	@Override
	public JSONArray findAllBiddDocumentInfo(Map<String, Object> map) {
		List<BiddDocumentInfo> biddDocumentInfos=biddDocumentInfoDao.findAllBiddDocumentInfo(map);
		JSONArray jsonArray=new JSONArray();
		for(int i=0;i<biddDocumentInfos.size();i++) {
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("bd_id", biddDocumentInfos.get(i).getBd_id());
			jsonObject.put("projectTitle", biddDocumentInfos.get(i).getProjectTitle());
			jsonObject.put("serialNumber", biddDocumentInfos.get(i).getSerialNumber());
			jsonObject.put("title", biddDocumentInfos.get(i).getTitle());
			jsonObject.put("sort", biddDocumentInfos.get(i).getSort());
			jsonObject.put("bidingTime", biddDocumentInfos.get(i).getBidingTime());
			jsonObject.put("bidingType", biddDocumentInfos.get(i).getBidingType());
			jsonObject.put("creatime", biddDocumentInfos.get(i).getCreatime());
			jsonObject.put("state", biddDocumentInfos.get(i).getState());
			jsonObject.put("bidding", biddDocumentInfos.get(i).getBidding());
			jsonObject.put("Remark", biddDocumentInfos.get(i).getRemark());
			jsonObject.put("delflag", biddDocumentInfos.get(i).getDelflag());
			jsonObject.put("opt_id", biddDocumentInfos.get(i).getOpt_id());
			jsonObject.put("optime", biddDocumentInfos.get(i).getOptime());
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}

	@Override
	public int findAllBiddDocumentInfoCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return biddDocumentInfoDao.findAllBiddDocumentInfoCount(map);
	}

	@Override
	public int saveBiddDocumentInfo(BiddDocumentInfo biddDocumentInfo) {
		biddDocumentInfo.setOptime(DateUtil.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
		biddDocumentInfo.setDelflag(0);
		biddDocumentInfo.setState(0);
		return biddDocumentInfoDao.saveBiddDocumentInfo(biddDocumentInfo);
	}

	@Override
	public int updateBiddDocumentInfo(BiddDocumentInfo biddDocumentInfo) {
		// TODO Auto-generated method stub
		return biddDocumentInfoDao.updateBiddDocumentInfo(biddDocumentInfo);
	}

	@Override
	public int deleteBiddDocumentInfo(String roleIds) {
		String bd_id[]=roleIds.split(",");
		int count=0;
		for(int i=0;i<bd_id.length;i++) {
			biddDocumentInfoDao.deleteBiddDocumentInfo(Integer.parseInt(bd_id[i]));
			count++;
		}
		return count;
	}

}
