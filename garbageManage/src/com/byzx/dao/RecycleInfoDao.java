package com.byzx.dao;

import java.util.List;
import java.util.Map;

import com.byzx.model.RecycleStationInfo;

/**@文件名: RecycleInfoDao.java
 * @类功能说明: 
 * @作者: WangSiYuan
 * @Email: 1512972568@qq.com
 * @日期: 2019年11月1日下午12:04:20
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: WangSiYuan
 * 	 <li>日期: 2019年11月1日下午12:04:20</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public interface RecycleInfoDao {
	
	public List<RecycleStationInfo> findAllRecycle(Map<String,Object> map);
	
	public int findAllRecycleCount(Map<String,Object> map);
	
	public String findSortingstationNameById(int ss_id);
	

}



