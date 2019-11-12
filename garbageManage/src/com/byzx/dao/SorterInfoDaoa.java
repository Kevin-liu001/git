package com.byzx.dao;

import java.util.List;
import java.util.Map;

import com.byzx.model.UserInfo;

public interface SorterInfoDaoa {
	
	public List<UserInfo> findAllSorterInfo(Map<String,Object> map);
	
	public int findAllSorterInfoCount(Map<String,Object> map);
	
	public List<Integer> findAllEnshrineInfo();
	
	public int findUdidByUsername(String user_name);


	public List<UserInfo> findUserInfoByUid(int uid);



}




