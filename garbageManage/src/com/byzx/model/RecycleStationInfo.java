package com.byzx.model;

import java.util.List;

/**@�ļ���: RecycleStationInfo.java
 * @�๦��˵��: 
 * @����: WangSiYuan
 * @Email: 1512972568@qq.com
 * @����: 2019��11��1������11:43:55
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: WangSiYuan
 * 	 <li>����: 2019��11��1������11:43:55</li> 
 *	 <li>����: </li>
 * </pre>
 */
public class RecycleStationInfo {
	
	private Integer rsid;  //����վID 
	private Integer ss_id; //�����ּ�վid
	private String c_ucid;  //������Աid����
	private String rsname;  //����
	private String address;
	private String scope;
	private String cm_name;//С������
	private int state;		//����վ״̬ 1.open 0.closed
	private String date;
	private int volume;
	private int optid;
	private int delflag;
	private String optime;
	private String remark;
	private String plot_name;		//С����
	private	String ss_name;		//�����ּ�վ����
	private List<CollectorInfo> collectorInfo;
	private List<RecycleGoodsInfo> recycleGoodsInfo;
	
	public String getSs_name() {
		return ss_name;
	}
	public void setSs_name(String ss_name) {
		this.ss_name = ss_name;
	}
	public Integer getRsid() {
		return rsid;
	}
	public void setRsid(Integer rsid) {
		this.rsid = rsid;
	}
	public Integer getSs_id() {
		return ss_id;
	}
	public void setSs_id(Integer ss_id) {
		this.ss_id = ss_id;
	}
	public String getC_ucid() {
		return c_ucid;
	}
	public void setC_ucid(String c_ucid) {
		this.c_ucid = c_ucid;
	}
	public String getRsname() {
		return rsname;
	}
	public void setRsname(String rsname) {
		this.rsname = rsname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public int getOptid() {
		return optid;
	}
	public void setOptid(int optid) {
		this.optid = optid;
	}
	public int getDelflag() {
		return delflag;
	}
	public void setDelflag(int delflag) {
		this.delflag = delflag;
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
	public String getCm_name() {
		return cm_name;
	}
	public void setCm_name(String cm_name) {
		this.cm_name = cm_name;
	}
	public String getPlot_name() {
		return plot_name;
	}
	public void setPlot_name(String plot_name) {
		this.plot_name = plot_name;
	}
	public List<CollectorInfo> getCollectorInfo() {
		return collectorInfo;
	}
	public void setCollectorInfo(List<CollectorInfo> collectorInfo) {
		this.collectorInfo = collectorInfo;
	}
	public List<RecycleGoodsInfo> getRecycleGoodsInfo() {
		return recycleGoodsInfo;
	}
	public void setRecycleGoodsInfo(List<RecycleGoodsInfo> recycleGoodsInfo) {
		this.recycleGoodsInfo = recycleGoodsInfo;
	}
	
	

}



