package com.byzx.dao;
/**@�ļ���: DriverInfoInfoDao.java
 * @�๦��˵��: 
 * @����: WangSiYuan
 * @Email: 1512972568@qq.com
 * @����: 2019��11��1������5:20:14
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: WangSiYuan
 * 	 <li>����: 2019��11��1������5:20:14</li> 
 *	 <li>����: </li>
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




