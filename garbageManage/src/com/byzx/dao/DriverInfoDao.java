package com.byzx.dao;
/**@文件名: DriverInfoInfoDao.java
 * @类功能说明: 
 * @作者: WangSiYuan
 * @Email: 1512972568@qq.com
 * @日期: 2019年11月1日下午5:20:14
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: WangSiYuan
 * 	 <li>日期: 2019年11月1日下午5:20:14</li> 
 *	 <li>内容: </li>
 * </pre>
 */

import java.util.List;
import java.util.Map;

import com.byzx.model.UserInfo;

public interface DriverInfoDao {
	
	public List<UserInfo> findAllDriverInfo(Map<String,Object> map);
	
	public int findAllDriverInfoCount(Map<String,Object> map);
	
	public int findUdidByUsername(String user_name);

}




