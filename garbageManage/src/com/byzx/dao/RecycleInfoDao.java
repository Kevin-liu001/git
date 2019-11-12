package com.byzx.dao;

import java.util.List;
import java.util.Map;

import com.byzx.model.RecycleStationInfo;

/**@�ļ���: RecycleInfoDao.java
 * @�๦��˵��: 
 * @����: WangSiYuan
 * @Email: 1512972568@qq.com
 * @����: 2019��11��1������12:04:20
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: WangSiYuan
 * 	 <li>����: 2019��11��1������12:04:20</li> 
 *	 <li>����: </li>
 * </pre>
 */
public interface RecycleInfoDao {
	
	public List<RecycleStationInfo> findAllRecycle(Map<String,Object> map);
	
	public int findAllRecycleCount(Map<String,Object> map);
	
	public String findSortingstationNameById(int ss_id);
	

}



