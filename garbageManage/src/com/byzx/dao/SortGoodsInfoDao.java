package com.byzx.dao;

import java.util.List;

import com.byzx.model.SortGoodsInfo;


/**@文件名: SortGoodsInfoDao.java
 * @类功能说明: 
 * @作者: LiuKaiWem
 * @Email: 1519960668@qq.com
 * @日期: 2019年10月31日下午2:35:49
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: LiuKaiWem</li> 
 * 	 <li>日期: 2019年10月31日下午2:35:49</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public interface SortGoodsInfoDao {
	
	public List<SortGoodsInfo> findAllSSByAddress(int ss_id);

	public void addSortGoodsInfo(SortGoodsInfo sortGoodsInfo);

	public void deleteSortGoodsInfoBySs_id(Integer sg_id);

	public void updateSortGoodsInfoBySs_id(SortGoodsInfo newSortGoodsInfo);

	
}
