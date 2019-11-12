package com.byzx.dao;

import java.util.List;
import java.util.Map;

import com.byzx.model.GoodsDetailInfo;


/**@文件名: GoodsDetailInfoDao.java
 * @类功能说明: 
 * @作者: LiuChunHui
 * @Email: 508499598@qq.com
 * @日期: 2019年10月30日下午12:13:54
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: LiuChunHui</li> 
 * 	 <li>日期: 2019年10月30日下午12:13:54</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public interface GoodsDetailInfoDao {

	public List<GoodsDetailInfo> findAllGoodsDetailInfo(Map<String, Object> map);
	
	public int findAllGoodsDetailInfoCount(Map<String, Object> map);
	
	public int saveGoodsDetailInfo(GoodsDetailInfo goodsDetailInfo);
	
	public int updateGoodsDetailInfo(GoodsDetailInfo goodsDetailInfo);
	
	public int deleteGoodsDetailInfo(int gt_id);
}
