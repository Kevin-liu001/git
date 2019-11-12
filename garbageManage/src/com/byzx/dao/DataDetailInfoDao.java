package com.byzx.dao;

import java.util.List;

import com.byzx.model.DataDetailInfo;

/**@文件名: DatadetilInfoDao.java
 * @类功能说明: 
 * @作者: LiuChunHui
 * @Email: 508499598@qq.com
 * @日期: 2019年10月26日上午10:02:08
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: LiuChunHui</li> 
 * 	 <li>日期: 2019年10月26日上午10:02:08</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public interface DataDetailInfoDao {

	public List<DataDetailInfo> findAllDatadetilInfo(int data_id);
	
	public void addDatadetilInfo(DataDetailInfo dataDetailInfo);
	
	public void updateDetailInfo(DataDetailInfo dataDetailInfo);
	
	public void deleteDataDetailInfoById(int DataDet_id);
	
	public int deleteDataInfo(int data_id);
	
	//白浩杰
	public int addDataDetailInfo(DataDetailInfo dataDetailInfo);
	
	public int deleteDataDetailInfo(int data_id);
	
	public int deleteDataDetailInfoByDdId(int dataDet_id); 
	
	public int updateDetailInfoByDdId(DataDetailInfo dataDetailInfo);
	//查找数据字典子表
	public List<DataDetailInfo> findAllDataInfoDetail(int data_id);
	
}
