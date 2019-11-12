package com.byzx.dao;

import java.util.List;
import java.util.Map;

import com.byzx.model.TransferInfo;

/**@文件名: TransferInfoDao.java
 * @类功能说明: 
 * @作者: WangSiYuan
 * @Email: 1512972568@qq.com
 * @日期: 2019年10月30日下午3:59:02
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: WangSiYuan
 * 	 <li>日期: 2019年10月30日下午3:59:02</li> 
 *	 <li>内容: </li>
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
