package com.byzx.dao;

import java.util.List;
import java.util.Map;

import com.byzx.model.BiddDocumentInfo;

/**@鏂囦欢鍚�: BiddDocumentInfoDao.java
 * @绫诲姛鑳借鏄�: 
 * @浣滆��: LiuChunHui
 * @Email: 508499598@qq.com
 * @鏃ユ湡: 2019骞�10鏈�30鏃ヤ笅鍗�5:19:11
 * @淇敼璇存槑:<br> 
 * <pre>
 * 	 <li>浣滆��: LiuChunHui</li> 
 * 	 <li>鏃ユ湡: 2019骞�10鏈�30鏃ヤ笅鍗�5:19:11</li> 
 *	 <li>鍐呭: </li>
 * </pre>
 */
public interface BiddDocumentInfoDao {

	public List<BiddDocumentInfo> findAllBiddDocumentInfo(Map<String, Object> map);
	
	public int findAllBiddDocumentInfoCount(Map<String, Object> map); 
	
	public int saveBiddDocumentInfo(BiddDocumentInfo biddDocumentInfo);
	
	public int updateBiddDocumentInfo(BiddDocumentInfo biddDocumentInfo);
	
	public int deleteBiddDocumentInfo(int bd_id);
}
