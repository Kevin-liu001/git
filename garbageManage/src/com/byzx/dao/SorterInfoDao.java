package com.byzx.dao;

import java.util.List;

import com.byzx.model.SorterInfo;


/**@�ļ���: SorterInfoDao.java
 * @�๦��˵��: 
 * @����: LiuKaiWem
 * @Email: 1519960668@qq.com
 * @����: 2019��10��31������2:35:19
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: LiuKaiWem</li> 
 * 	 <li>����: 2019��10��31������2:35:19</li> 
 *	 <li>����: </li>
 * </pre>
 */
public interface SorterInfoDao {
	
	public List<SorterInfo> findAllSSByAddress(int ss_id);

	public void addSorterInfo(SorterInfo sorterInfo);

	public void deleteSorterInfoBySs_id(Integer s_usid);

	public void updateSorterInfoBySs_id(SorterInfo newSorter);

	
	

	/*public int deleteSorterInfo(int ss_id);*/
	
}
