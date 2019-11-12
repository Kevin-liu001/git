package com.byzx.dao;

import java.util.List;
import com.byzx.model.RecycleStationInfo;


/**@鏂囦欢鍚�: RecycleStationInfoDao.java
 * @绫诲姛鑳借鏄�: 
 * @浣滆��: BaiHaoJie
 * @Email: 596315150@qq.com
 * @鏃ユ湡: 2019骞�10鏈�31鏃ヤ笅鍗�3:09:56
 * @淇敼璇存槑:<br> 
 * <pre>
 * 	 <li>浣滆��: BaiHaoJie</li> 
 * 	 <li>鏃ユ湡: 2019骞�10鏈�31鏃ヤ笅鍗�3:09:56</li> 
 *	 <li>鍐呭: </li>
 * </pre>
 */
public interface RecycleStationInfoDao {

	public List<RecycleStationInfo> findAllRecycle();

	public List<RecycleStationInfo> findRecycleByAddress(String recycle_address);

	public int saveRecycleInfo(RecycleStationInfo recycleStationInfo);

	public int getrecycleStationInfoMaxId();

	public int deleteRecycleInfo(Integer rsid);
	
	public int updateRecycleInfo(RecycleStationInfo recycleInfo);

}
