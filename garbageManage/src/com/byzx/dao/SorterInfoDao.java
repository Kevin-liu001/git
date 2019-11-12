package com.byzx.dao;

import java.util.List;

import com.byzx.model.SorterInfo;


/**@文件名: SorterInfoDao.java
 * @类功能说明: 
 * @作者: LiuKaiWem
 * @Email: 1519960668@qq.com
 * @日期: 2019年10月31日下午2:35:19
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: LiuKaiWem</li> 
 * 	 <li>日期: 2019年10月31日下午2:35:19</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public interface SorterInfoDao {
	
	public List<SorterInfo> findAllSSByAddress(int ss_id);

	public void addSorterInfo(SorterInfo sorterInfo);

	public void deleteSorterInfoBySs_id(Integer s_usid);

	public void updateSorterInfoBySs_id(SorterInfo newSorter);

	
	

	/*public int deleteSorterInfo(int ss_id);*/
	
}
