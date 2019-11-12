package com.byzx.dao;

import java.util.List;
import java.util.Map;

import com.byzx.model.DataInfo;

/**@文件名: DataInfoDao.java
 * @类功能说明: 
 * @作者: LiuChunHui
 * @Email: 508499598@qq.com
 * @日期: 2019年10月25日上午11:38:12
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: LiuChunHui</li> 
 * 	 <li>日期: 2019年10月25日上午11:38:12</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public interface DataInfoDao {

	public List<DataInfo> findAllDataInfo(Map<String, Object> map);
	
	public int findAllDataInfoCount(Map<String, Object> map);
	
	public int addDataInfo(DataInfo dataInfo); 
	
	public int getDataInfoMaxId();
	
	public int updateDataInfo(DataInfo dataInfo);
	
	public int deleteDataInfo(int data_id);
	
	
}
