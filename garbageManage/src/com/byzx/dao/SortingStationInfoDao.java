package com.byzx.dao;

import java.util.List;

import com.byzx.model.SortingStationInfo;

/**@�ļ���: SortingStationInfoDao.java
 * @�๦��˵��: �ּ�վdao��
 * @����: LiuKaiWem
 * @Email: 1519960668@qq.com
 * @����: 2019��10��31������11:12:25
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: LiuKaiWem</li> 
 * 	 <li>����: 2019��10��31������11:12:25</li> 
 *	 <li>����: </li>
 * </pre>
 */
public interface SortingStationInfoDao {

	
	public List<SortingStationInfo> findAllSortingStation();

	public SortingStationInfo findAllSSByAddress(String ss_address);//ͨ���ּ�վ��ַ��ѯ�ּ�վ��Ϣ

	public int addSortingStationInfo(SortingStationInfo sortingStationInfo);

	public int getSortingStationInfoMaxId();//�ҵ������е����ID

	public int deleteSortingStationInfo(int ss_id);//ɾ���ּ�վ

	public int updateSortingStationInfo(SortingStationInfo sortingStationInfo);
	
	public List<SortingStationInfo> findSortStationNames();

	public Integer findSortStationIdByName(String ss_name);//�������ֲ��ҷּ�վ

	public String findSortStationNameById(Integer rsid);//���ݷּ�վ��ID��ѯ�ּ�վ������


}
