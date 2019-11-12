package com.byzx.dao;

import java.util.List;
import java.util.Map;

import com.byzx.model.AllotInfo;

/**@文件名: AllotInfoDao.java
 * @类功能说明: 
 * @作者: ChongYangYang
 * @Email: 1103222824@qq.com
 * @日期: 2019年10月31日上午11:48:13
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: ChongYangYang</li> 
 * 	 <li>日期: 2019年10月31日上午11:48:13</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public interface AllotInfoDao {

	public List<AllotInfo> findAllotInfo(Map<String, Object> map);

	public int findAllotInfoCount(Map<String, Object> map);

	public int saveallotInfo(AllotInfo allotInfo);

	public int findallotInfoByUNumber(int c_carid);

	public int updateallotInfo(AllotInfo allotInfo);

	public int deleteallotInfo(int a_aid);

}
