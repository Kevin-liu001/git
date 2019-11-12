package com.byzx.dao;

import java.util.List;
import java.util.Map;

import com.byzx.model.TransferInfo;

/**@�ļ���: TransferInfoDao.java
 * @�๦��˵��: 
 * @����: WangSiYuan
 * @Email: 1512972568@qq.com
 * @����: 2019��10��30������3:59:02
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: WangSiYuan
 * 	 <li>����: 2019��10��30������3:59:02</li> 
 *	 <li>����: </li>
 * </pre>
 */
public interface TransferInfoDao {
	
	public List<TransferInfo> findAllTransferInfo(Map<String,Object> map);
	
	public int findAllTransferInfoCount(Map<String,Object> map);
	
	public int saveTransferInfo(TransferInfo transferInfo);
	
	public int updateTransferInfo(TransferInfo transferInfo);
	
	public int deleteTransferInfo(int tid);
	
	public int findIdByName(String rsname);
	
	public int findSsidByRsid(int rsid);
	
	public String findUserNameByTudid(int t_udid);
	

}
