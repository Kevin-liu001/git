package com.byzx.service;

import com.byzx.model.RecycleStationInfo;

import net.sf.json.JSONArray;

/**@閺傚洣娆㈤崥锟�: RecycleInfoService.java
 * @缁濮涢懗鍊燁嚛閺勶拷: 
 * @娴ｆ粏锟斤拷: BaiHaoJie
 * @Email: 596315150@qq.com
 * @閺冦儲婀�: 2019楠烇拷10閺堬拷31閺冦儰绗呴崡锟�3:02:46
 * @娣囶喗鏁肩拠瀛樻:<br> 
 * <pre>
 * 	 <li>娴ｆ粏锟斤拷: BaiHaoJie</li> 
 * 	 <li>閺冦儲婀�: 2019楠烇拷10閺堬拷31閺冦儰绗呴崡锟�3:02:46</li> 
 *	 <li>閸愬懎顔�: </li>
 * </pre>
 */
public interface RecycleStationInfoService {

	public JSONArray findAllRecycle();

	public JSONArray findRecycleByAddress(String recycle_address);

	public int saveRecycleInfo(RecycleStationInfo recycleStationInfo);

	public int deleteRecycleInfo(int rsid);

	public int updateRecycleInfo(RecycleStationInfo recycleInfo);


}
