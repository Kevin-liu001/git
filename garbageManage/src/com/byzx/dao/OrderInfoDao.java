package com.byzx.dao;

import java.util.List;
import java.util.Map;

import com.byzx.model.OrderInfo;

/**@�ļ���: OrderInfoDao.java
 * @�๦��˵��: 
 * @����: WangSiYuan
 * @Email: 1512972568@qq.com
 * @����: 2019��11��2������12:02:21
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: WangSiYuan
 * 	 <li>����: 2019��11��2������12:02:21</li> 
 *	 <li>����: </li>
 * </pre>
 */
public interface OrderInfoDao {
	
	public List<OrderInfo> findAllUserInfo(Map<String,Object> map);
	
	public int findAllOrderInfoCount(Map<String,Object> map);
	
	public int findRidByNickname(String r_nickname);

	public int saveOrderInfo(OrderInfo orderInfo);

	public int updateOrderInfo(OrderInfo orderInfo);

	public int deleteOrderInfo(int oid);

	
}













