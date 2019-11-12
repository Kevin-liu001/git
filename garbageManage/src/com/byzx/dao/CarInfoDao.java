package com.byzx.dao;

import java.util.List;
import java.util.Map;

import com.byzx.model.CarInfo;


/**@文件名: CarInfoDao.java
 * @类功能说明: 
 * @作者: ChongYangYang
 * @Email: 1103222824@qq.com
 * @日期: 2019年11月1日上午10:04:03
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: ChongYangYang</li> 
 * 	 <li>日期: 2019年11月1日上午10:04:03</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public interface CarInfoDao {

	public List<CarInfo> findAllCarInfo();

	public List<CarInfo> findThisCarInfo(String c_location);

	public int deleteCarInfo(int c_carid);

	public int saveCarInfo(CarInfo carInfo);

	public int updateCarInfo(CarInfo carInfo);
	
	public List<CarInfo> findAllCar(Map<String,Object> map);
	
	public int findAllCarCount(Map<String,Object> map);



}
