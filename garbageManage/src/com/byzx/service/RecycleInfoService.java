package com.byzx.service;

import java.util.Map;

import net.sf.json.JSONArray;

/**@�ļ���: RecycleInfoService.java
 * @�๦��˵��: 
 * @����: WangSiYuan
 * @Email: 1512972568@qq.com
 * @����: 2019��11��1������11:56:02
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: WangSiYuan
 * 	 <li>����: 2019��11��1������11:56:02</li> 
 *	 <li>����: </li>
 * </pre>
 */
public interface RecycleInfoService {
	
	public JSONArray findAllRecycle(Map<String,Object> map);
	
	public int findAllRecycleCount (Map<String,Object> map);
	
	
	
	

}





