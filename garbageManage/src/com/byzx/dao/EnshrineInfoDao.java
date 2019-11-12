package com.byzx.dao;

import java.util.List;
import java.util.Map;

import com.byzx.model.EnshrineInfo;

/**@文件名: EnshrineInfoDao.java
 * @类功能说明: 
 * @作者: SongXinLei
 * @Email: 248382500@qq.com
 * @日期: 2019年10月31日下午3:29:12
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: SongXinLei</li> 
 * 	 <li>日期: 2019年10月31日下午3:29:12</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public interface EnshrineInfoDao {


	public List<EnshrineInfo> findAllEnshrineInfo(Map<String, Object> map);

	public int findAllEnshrineInfoCount(Map<String, Object> map);

	public int saveEnshrineInfo(EnshrineInfo enshrineInfo);

	public int findEnshrineInfoByUName(String warehous_name);

	public void deleteEnshrineInfo(int parseInt);

	public int updateEnshrineInfo(EnshrineInfo enshrineInfo);

	public List<EnshrineInfo> findEnshrineInfo(Map<String, Object> map);




}
