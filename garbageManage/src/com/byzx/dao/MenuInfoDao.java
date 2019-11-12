package com.byzx.dao;

import java.util.List;
import java.util.Map;

import com.byzx.model.MenuInfo;



/**@文件名: MenuInfoDao.java
 * @类功能说明: 
 * @作者: LiuChunHui
 * @Email: 508499598@qq.com
 * @日期: 2019年10月19日上午10:03:20
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: LiuChunHui</li> 
 * 	 <li>日期: 2019年10月19日上午10:03:20</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public interface MenuInfoDao {

	public List<MenuInfo> getMenunInfoByParentIdAndMenuIds(Map<String,Object> map);
	
	public List<MenuInfo> getMenuInfoEmpowerByParentId(Map<String,Object> map);
	
	public int updateParentMenu(int parentId);
	
	public int saveMenuInfo(MenuInfo menuInfo);
	
	public int updateMenuInfo(MenuInfo menuInfo);
	
	public int findMenuInfoCognateByMId(int parentId);
	
	public int findMenuInfoParentIdByMId(int menu_id);
	
	public int updateParentMenuInfo(int parentId);
	
	public int deleteMenuInfo(int menu_id);
	
	public List<MenuInfo> getMenuInfoByParentIdAndMenuIds(Map<String,Object> map);
	
	public List<MenuInfo> getMenuInfoByParentIdForEmpower(Map<String,Object> map);
	
	public int deleteMenuInfos(int menu_id);
}





















