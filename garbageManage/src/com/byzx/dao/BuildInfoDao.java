package com.byzx.dao;

import java.util.List;

import com.byzx.model.BuildInfo;


/**@文件名: BuildInfoDao.java
 * @类功能说明: 
 * @作者: LiuChunHui
 * @Email: 508499598@qq.com
 * @日期: 2019年11月1日上午8:40:01
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: LiuChunHui</li> 
 * 	 <li>日期: 2019年11月1日上午8:40:01</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public interface BuildInfoDao {

	public List<BuildInfo> findAllBuildInfo(int cm_id);
	
	public void addBuildInfo(BuildInfo buildInfo);
	
	public int deleteBuildInfo(int cm_id);
	
	public int updateBuildInfo(BuildInfo buildInfo);
	
	public int deleteBuildInfoById(int b_id);
	
}
