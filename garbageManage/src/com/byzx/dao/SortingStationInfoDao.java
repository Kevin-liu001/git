package com.byzx.dao;

import java.util.List;

import com.byzx.model.SortingStationInfo;

/**@ï¿½Ä¼ï¿½ï¿½ï¿½: SortingStationInfoDao.java
 * @ï¿½à¹¦ï¿½ï¿½Ëµï¿½ï¿½: ·Ö¼ðÕ¾dao²ã
 * @ï¿½ï¿½ï¿½ï¿½: LiuKaiWem
 * @Email: 1519960668@qq.com
 * @ï¿½ï¿½ï¿½ï¿½: 2019ï¿½ï¿½10ï¿½ï¿½31ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½11:12:25
 * @ï¿½Þ¸ï¿½Ëµï¿½ï¿½:<br> 
 * <pre>
 * 	 <li>ï¿½ï¿½ï¿½ï¿½: LiuKaiWem</li> 
 * 	 <li>ï¿½ï¿½ï¿½ï¿½: 2019ï¿½ï¿½10ï¿½ï¿½31ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½11:12:25</li> 
 *	 <li>ï¿½ï¿½ï¿½ï¿½: </li>
 * </pre>
 */
public interface SortingStationInfoDao {

	
	public List<SortingStationInfo> findAllSortingStation();

	public SortingStationInfo findAllSSByAddress(String ss_address);//Í¨¹ý·Ö¼ðÕ¾µØÖ·²éÑ¯·Ö¼ðÕ¾ÐÅÏ¢

	public int addSortingStationInfo(SortingStationInfo sortingStationInfo);

	public int getSortingStationInfoMaxId();//ÕÒµ½Ö÷±íÖÐµÄ×î´óID

	public int deleteSortingStationInfo(int ss_id);//É¾³ý·Ö¼ðÕ¾

	public int updateSortingStationInfo(SortingStationInfo sortingStationInfo);
	
	public List<SortingStationInfo> findSortStationNames();

	public Integer findSortStationIdByName(String ss_name);//¸ù¾ÝÃû×Ö²éÕÒ·Ö¼ðÕ¾

	public String findSortStationNameById(Integer rsid);//¸ù¾Ý·Ö¼ðÕ¾µÄID²éÑ¯·Ö¼ðÕ¾µÄÃû×Ö


}
