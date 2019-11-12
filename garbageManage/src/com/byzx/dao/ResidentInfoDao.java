package com.byzx.dao;

import com.byzx.model.ResidentInfo;

/**@文件名: ResidentInfoDao.java
 * @类功能说明: 
 * @作者: HeGuangYao
 * @Email: 105302097@qq.com
 * @日期: 2019年10月30日下午12:19:35
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: HeGuangYao</li> 
 * 	 <li>日期: 2019年10月30日下午12:19:35</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public interface ResidentInfoDao {
	
	public ResidentInfo findResidentInfo(ResidentInfo residentInfo);
	
	public int findResidentInfoByName(String r_name);

	public int insertResidentInfo(ResidentInfo residentInfo);

}
