package com.byzx.dao;

import java.util.List;
import java.util.Map;

import com.byzx.model.GoodsInfo;

/**@文件名: GoodsInfoDao.java
 * @类功能说明: 
 * @作者: LiuChunHui
 * @Email: 508499598@qq.com
 * @日期: 2019年10月30日上午10:56:32
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: LiuChunHui</li> 
 * 	 <li>日期: 2019年10月30日上午10:56:32</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public interface GoodsInfoDao {

	
	public List<GoodsInfo> findAllGoodsInfo(Map<String, Object> map);
	
	public int findAllGoodsInfoCount(Map<String, Object> map);
	
	public int saveGoodsInfo(GoodsInfo goodsInfo);
	
	public int updateGoodsInfo(GoodsInfo goodsInfo);
	
	public int deleteGoodsInfo(int g_id);
	
	public int findGoodsInfoByGCode(String g_code);
	
	public List<GoodsInfo> findAllGoodsId();

	public GoodsInfo findGoodsNameById(Integer sg_gid);
	
	
}























