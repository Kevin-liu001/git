package com.byzx.service;

import java.util.Map;

import com.byzx.model.TransferInfo;

import net.sf.json.JSONArray;

/**@�ļ���: TransferInfoService.java
 * @�๦��˵��: 
 * @����: WangSiYuan
 * @Email: 1512972568@qq.com
 * @����: 2019��10��30������3:44:29
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: WangSiYuan
 * 	 <li>����: 2019��10��30������3:44:29</li> 
 *	 <li>����: </li>
 * </pre>
 */
public interface TransferInfoService {
	
	public JSONArray findAllTransferInfo(Map<String,Object> map);
	
	public int findAllTransferInfoCount(Map<String,Object> map);
	
	public int saveTransferInfo(TransferInfo transferInfo);
	
	public int updateTransferInfo(TransferInfo transferInfo);
	
	public int deleteTransferInfo(String transIds);
	
	public int findIdByName(String rsname);
	

}
