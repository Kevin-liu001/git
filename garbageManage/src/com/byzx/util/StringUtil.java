package com.byzx.util;

import java.util.ArrayList;
import java.util.List;

/**@文件名: StringUtil.java
 * @类功能说明: 
 * @作者: LiuChunHui
 * @Email: 508499598@qq.com
 * @日期: 2019年10月19日上午9:37:44
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: LiuChunHui</li> 
 * 	 <li>日期: 2019年10月19日上午9:37:44</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public class StringUtil {

	public static boolean isEmpty(String str){
		if("".equals(str)|| str==null){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean isNotEmpty(String str){
		if(!"".equals(str)&&str!=null){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean existStrArr(String str,String []strArr){
		for(int i=0;i<strArr.length;i++){
			if(strArr[i].equals(str)){
				return true;
			}
		}
		return false;
	}
	
	public static List<Integer> stringToArry(String str){
		String[] str1=str.split(",");
		List<Integer> array=new ArrayList<Integer>(); 
		for(int i=0;i<str1.length;i++){
			array.add(Integer.parseInt(str1[i]));
		}
		return array;
	}
}
