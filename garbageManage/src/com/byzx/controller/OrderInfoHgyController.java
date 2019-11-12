package com.byzx.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.byzx.model.OrderInfoHgy;
import com.byzx.model.ResidentInfo;
import com.byzx.service.OrderInfoHgyService;
import com.byzx.util.ResponseUtil;
import com.byzx.util.UUIDUtils;

import net.sf.json.JSONObject;




/**@文件名: OrderInfoController.java
 * @类功能说明: 
 * @作者: HeGuangYao
 * @Email: 105302097@qq.com
 * @日期: 2019年11月1日下午2:35:39
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: HeGuangYao</li> 
 * 	 <li>日期: 2019年11月1日下午2:35:39</li> 
 *	 <li>内容: </li>
 * </pre>
 */
@Controller
@RequestMapping("/orderInfo")
public class OrderInfoHgyController {
	@Autowired
	private OrderInfoHgyService orderInfoService;
	
	@RequestMapping("/addOrderInfo")
	public void addOrderInfo(OrderInfoHgy orderInfo,HttpServletRequest request,HttpServletResponse response)throws Exception {
       HttpSession session = request.getSession();
       ResidentInfo residentInfo= (ResidentInfo) session.getAttribute("ResidentInfo");
       orderInfo.setR_id(residentInfo.getR_id());
       orderInfo.setOdid(UUIDUtils.getUUID());
       JSONObject jsonObject=new JSONObject();
       int result = orderInfoService.addOrderInfo(orderInfo);
       if(result>0) {
    	   jsonObject.put("msg", true);
       }else {
    	   jsonObject.put("msg", false);
       }
       ResponseUtil.write(response, jsonObject);
	}

}
















