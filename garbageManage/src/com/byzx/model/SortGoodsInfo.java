package com.byzx.model;
/**@文件�?: UserInfo.java
 * @类功能说�?: 分拣站物资实体类
 * @作�??: LiuKaiWem
 * @Email: 1519960668@qq.com
 * @日期: 2019�?10�?17日下�?6:13:24
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作�??: LiuKaiWem</li> 
 * 	 <li>日期: 2019�?10�?17日下�?6:13:24</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public class SortGoodsInfo {
	private Integer	sg_id;             //分拣物资id     
	private Integer	sg_gid;            //物资id           
	private Integer	ss_id;             //分拣站id         
	private int	allocation_num;    //台账分配数量  
	private int	inventory_num;     //库存数量        
	private int	use_num;           //已使用数�?     
	private int	scrap_num;         //报废数量        
	private int	delflag;           //删除标记        
	private int	opt_id;             //操作人员        
	private String optime;         //操作时间      
	private String remark;         //备注             


	public Integer getSg_id() {
		return sg_id;
	}
	public void setSg_id(Integer sg_id) {
		this.sg_id = sg_id;
	}
	public Integer getSg_gid() {
		return sg_gid;
	}
	public void setSg_gid(Integer sg_gid) {
		this.sg_gid = sg_gid;
	}
	public Integer getSs_id() {
		return ss_id;
	}
	public void setSs_id(Integer ss_id) {
		this.ss_id = ss_id;
	}
	public int getAllocation_num() {
		return allocation_num;
	}
	public void setAllocation_num(int allocation_num) {
		this.allocation_num = allocation_num;
	}
	public int getInventory_num() {
		return inventory_num;
	}
	public void setInventory_num(int inventory_num) {
		this.inventory_num = inventory_num;
	}
	public int getUse_num() {
		return use_num;
	}
	public void setUse_num(int use_num) {
		this.use_num = use_num;
	}
	public int getScrap_num() {
		return scrap_num;
	}
	public void setScrap_num(int scrap_num) {
		this.scrap_num = scrap_num;
	}
	public int getDelflag() {
		return delflag;
	}
	public void setDelflag(int delflag) {
		this.delflag = delflag;
	}
	
	public int getOpt_id() {
		return opt_id;
	}
	public void setOpt_id(int opt_id) {
		this.opt_id = opt_id;
	}
	public String getOptime() {
		return optime;
	}
	public void setOptime(String optime) {
		this.optime = optime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}


}
