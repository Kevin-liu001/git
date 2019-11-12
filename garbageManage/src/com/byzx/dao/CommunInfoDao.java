package com.byzx.dao;

import java.util.List;

import com.byzx.model.CommunInfo;
import com.byzx.model.StandbyInfo;

/**@文件名: CommunInfoDao.java
 * @类功能说明: 
 * @作者: LiuChunHui
 * @Email: 508499598@qq.com
 * @日期: 2019年10月31日上午10:04:23
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: LiuChunHui</li> 
 * 	 <li>日期: 2019年10月31日上午10:04:23</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public interface CommunInfoDao {

	public List<CommunInfo> findAllCommunInfo();
	
	public CommunInfo findAllCommunInfoByPoint(String cm_point);
	
	public int saveCommunInfo(CommunInfo communInfo);
	
	public int getCommunInfoMaxId();
	
	public List<StandbyInfo> findRecycleNames() ;
	
	public int deleteCommunInfo(int cm_id);
	
	public int updateCommunInfo(CommunInfo communInfo);
	
	public String findCommunNameById(int rsid);

	public int findCommunIdByName(String plot_name);

	public List<CommunInfo> findAllCommunInfoName();

}
