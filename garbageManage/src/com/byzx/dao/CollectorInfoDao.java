package com.byzx.dao;

import java.util.List;
import com.byzx.model.CollectorInfo;

/**@文件名: CollectorInfoDao.java
 * @类功能说明: 
 * @作者: LiuChunHui
 * @Email: 508499598@qq.com
 * @日期: 2019年11月1日下午5:26:23
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: LiuChunHui</li> 
 * 	 <li>日期: 2019年11月1日下午5:26:23</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public interface CollectorInfoDao {

	public List<CollectorInfo> findAllCollectorInfo(Integer rsid);
	
	public List<CollectorInfo> findAllCollectorInfo1(Integer rsid);

	public int addCollectorInfo(CollectorInfo collectorInfo);

	public int updataCollectorInfo(CollectorInfo newCollector);

	public int deleteCollectorInfo(Integer rsid);
}
