package com.byzx.dao;

import java.util.List;
import java.util.Map;

import com.byzx.model.RoleInfo;

/**@文件名: RoleInfoDao.java
 * @类功能说明: 
 * @作者: LiuChunHui
 * @Email: 508499598@qq.com
 * @日期: 2019年10月19日上午9:29:08
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: LiuChunHui</li> 
 * 	 <li>日期: 2019年10月19日上午9:29:08</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public interface RoleInfoDao {

	public String getMenuIdsByRoleId(int roleId);
	
	public List<RoleInfo> findAllUserInfo(Map<String,Object> map);
	
	public int findAllUserInfoCount (Map<String,Object> map);
	
	public int saveRoleInfo(RoleInfo roseInfo);
	
	public int findRoleInfoByRName(String role_name);
	
	public int updateRoleInfo(RoleInfo roseInfo);
	
	public int deleteRoleInfo(int role_id);
	
	public int roleInfoEmpower(Map<String, Object> map);
	
	public List<RoleInfo> findAllRoles(Map<String,Object> map);
	
	public int findAllRolesCount(Map<String,Object> map);

	public int updateroleInfoEmpower(Map<String, Object> map);

}
