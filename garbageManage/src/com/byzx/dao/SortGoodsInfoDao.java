package com.byzx.dao;

import java.util.List;

import com.byzx.model.SortGoodsInfo;


/**@�ļ���: SortGoodsInfoDao.java
 * @�๦��˵��: 
 * @����: LiuKaiWem
 * @Email: 1519960668@qq.com
 * @����: 2019��10��31������2:35:49
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: LiuKaiWem</li> 
 * 	 <li>����: 2019��10��31������2:35:49</li> 
 *	 <li>����: </li>
 * </pre>
 */
public interface SortGoodsInfoDao {
	
	public List<SortGoodsInfo> findAllSSByAddress(int ss_id);

	public void addSortGoodsInfo(SortGoodsInfo sortGoodsInfo);

	public void deleteSortGoodsInfoBySs_id(Integer sg_id);

	public void updateSortGoodsInfoBySs_id(SortGoodsInfo newSortGoodsInfo);

	
}
