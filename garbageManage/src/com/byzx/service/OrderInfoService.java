package com.byzx.service;

import java.util.Map;

import com.byzx.model.OrderInfo;

import net.sf.json.JSONArray;

/**@�ļ���: OrderInfoService.java
 * @�๦��˵��: 
 * @����: WangSiYuan
 * @Email: 1512972568@qq.com
 * @����: 2019��11��2������11:48:12
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: WangSiYuan
 * 	 <li>����: 2019��11��2������11:48:12</li> 
 *	 <li>����: </li>
 * </pre>
 */
public interface OrderInfoService {

	public JSONArray findAllOrderInfo(Map<String,Object> map);
	
	public int findAllOrderInfoCount(Map<String,Object> map);
	
	public int saveOrderInfo(OrderInfo orderInfo);
	
	public int updateOrderInfo(OrderInfo orderInfo);
	
	public int deleteOrderInfo(String orderIds);
	
	
}



