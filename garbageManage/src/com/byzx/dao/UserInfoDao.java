package com.byzx.dao;

import java.util.List;
import java.util.Map;

import com.byzx.model.UserInfo;



/**@文件名: UserInfoDao.java
 * @类功能说明: 
 * @作者: LiuChunHui
 * @Email: 508499598@qq.com
 * @日期: 2019年10月17日下午6:00:57
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: LiuChunHui</li> 
 * 	 <li>日期: 2019年10月17日下午6:00:57</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public interface UserInfoDao {

	/**
	 * @方法名: findUserInfo
	 * @方法说明: 
	 * @作者: LiuChunHui
	 * @邮箱：508499598@qq.com
	 * @日期: 2019年10月17日下午7:01:38
	 * @param userInfo
	 * @return
	 * @return: UserInfo
	 */
	public UserInfo findUserInfo(UserInfo userInfo);
	
	public List<UserInfo> findAllUserInfo(Map<String,Object> map);
	
	public int findAllUserInfoCount(Map<String,Object> map);

	public int saveUserInfo(UserInfo userInfo);
	
	public int findUserInfoByUName(String user_name);
	
	public String findUserPasswordByUId(int user_id);
	
	public int updateUserInfo(UserInfo userInfo);
	
	public int deleteUserInfo(int user_id);

	public String findNameById(Integer user_id);
	
	public UserInfo login(UserInfo userInfo);
	
	public List<UserInfo> findAllUserId();

}
