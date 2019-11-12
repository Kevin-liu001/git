package com.byzx.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.byzx.dao.GoodsDetailInfoDao;
import com.byzx.model.GoodsDetailInfo;
import com.byzx.service.GoodsDetailInfoService;
import com.byzx.util.DateUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**@鏂囦欢鍚�: GoodsDetailInfoServiceImpl.java
 * @绫诲姛鑳借鏄�: 
 * @浣滆��: LiuChunHui
 * @Email: 508499598@qq.com
 * @鏃ユ湡: 2019骞�10鏈�30鏃ヤ笅鍗�12:15:38
 * @淇敼璇存槑:<br> 
 * <pre>
 * 	 <li>浣滆��: LiuChunHui</li> 
 * 	 <li>鏃ユ湡: 2019骞�10鏈�30鏃ヤ笅鍗�12:15:38</li> 
 *	 <li>鍐呭: </li>
 * </pre>
 */
@Service
public class GoodsDetailInfoServiceImpl implements GoodsDetailInfoService {

	@Autowired
	private GoodsDetailInfoDao goodsDetailInfoDao;
	
	@Override
	public JSONArray findAllGoodsDetailInfo(Map<String, Object> map) {
		List<GoodsDetailInfo> goodsDetailInfos=goodsDetailInfoDao.findAllGoodsDetailInfo(map);
		JSONArray jsonArray=new JSONArray();
		for(int i=0;i<goodsDetailInfos.size();i++) {
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("gt_id", goodsDetailInfos.get(i).getGt_id());
			jsonObject.put("gt_code", goodsDetailInfos.get(i).getGt_code());
			jsonObject.put("gt_name", goodsDetailInfos.get(i).getGt_name());
			jsonObject.put("gt_creattime", goodsDetailInfos.get(i).getGt_creattime());
			jsonObject.put("gt_remark", goodsDetailInfos.get(i).getGt_remark());
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}

	@Override
	public int findAllGoodsDetailInfoCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return goodsDetailInfoDao.findAllGoodsDetailInfoCount(map);
	}

	@Override
	public int saveGoodsDetailInfo(GoodsDetailInfo goodsDetailInfo) {
		goodsDetailInfo.setGt_creattime(DateUtil.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
		goodsDetailInfo.setGt_delflag(0);
		goodsDetailInfo.setGt_state(0);
		return goodsDetailInfoDao.saveGoodsDetailInfo(goodsDetailInfo);
	}

	@Override
	public int updateGoodsDetailInfo(GoodsDetailInfo goodsDetailInfo) {
		// TODO Auto-generated method stub
		return goodsDetailInfoDao.updateGoodsDetailInfo(goodsDetailInfo);
	}

	@Override
	public int deleteGoodsDetailInfo(String roleIds) {
		String gt_id[]=roleIds.split(",");
		int count=0;
		for(int i=0;i<gt_id.length;i++) {
			goodsDetailInfoDao.deleteGoodsDetailInfo(Integer.parseInt(gt_id[i]));
			count++;
		}
		return count;
	}

}
