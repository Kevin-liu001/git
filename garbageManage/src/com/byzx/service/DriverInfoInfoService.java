package com.byzx.service;

import java.util.Map;

import net.sf.json.JSONArray;

/**@�ļ���: DriverInfoInfoService.java
 * @�๦��˵��: 
 * @����: WangSiYuan
 * @Email: 1512972568@qq.com
 * @����: 2019��11��1������5:12:38
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: WangSiYuan
 * 	 <li>����: 2019��11��1������5:12:38</li> 
 *	 <li>����: </li>
 * </pre>
 */
public interface DriverInfoInfoService {
	
	public JSONArray findAllDriverInfo(Map<String,Object> map);
	
	public int findAllDriverInfoCount(Map<String,Object> map);

}



