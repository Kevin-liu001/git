package com.byzx.dao;

import java.util.List;

import com.byzx.model.RecycleGoodsInfo;

/**@鏂囦欢鍚�: RecycleGoodsInfoDao.java
 * @绫诲姛鑳借鏄�: 
 * @浣滆��: BaiHaoJie
 * @Email: 596315150@qq.com
 * @鏃ユ湡: 2019骞�10鏈�31鏃ヤ笅鍗�3:42:26
 * @淇敼璇存槑:<br> 
 * <pre>
 * 	 <li>浣滆��: BaiHaoJie</li> 
 * 	 <li>鏃ユ湡: 2019骞�10鏈�31鏃ヤ笅鍗�3:42:26</li> 
 *	 <li>鍐呭: </li>
 * </pre>
 */
public interface RecycleGoodsInfoDao {
	
	public List<RecycleGoodsInfo> findAllRecycleGoodsInfo(Integer rsid);

	public int addRecycleGoodsInfo(RecycleGoodsInfo recycleGoodsInfo);

	public int deleteRecycleGoodsInfo(Integer rsid);

	public int updateRecycleGoods(RecycleGoodsInfo newrecycleGoods);

	public List<RecycleGoodsInfo> findAllRecycleGoodsId();
	

}
