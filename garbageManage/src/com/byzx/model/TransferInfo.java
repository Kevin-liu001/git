package com.byzx.model;
/**@�ļ���: t_transfer.java
 * @�๦��˵��: 
 * @����: WangSiYuan
 * @Email: 1512972568@qq.com
 * @����: 2019��10��30������10:57:58
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: WangSiYuan
 * 	 <li>����: 2019��10��30������10:57:58</li> 
 *	 <li>����: </li>
 * </pre>
 */
public class TransferInfo {
	
	private Integer tid;	//ת�˵�����
	private int t_carid;	//����ID  ���
	private int t_udid;		//˾��ID
	private String createtime;		//ת�˵�����ʱ��
	private Integer t_rsid;		//����վid
	private String rsname;		//����վ����
	private int t_ssid;		//�ּ�վid
	private String ss_name;		//�ּ�վ����
	private String depart_time;		//��������ʱ��
	private int t_ueid;		//��վ���Ա
	private double load;	//����/kg
	private int state;		//ת��״̬
	private int delflag;	//ɾ�����
	private int optid;		//���ݲ���Աid
	private String optime;		//��������ʱ��
	private String remark;		//��ע
	private String user_name;	//˾������
	
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public int getT_carid() {
		return t_carid;
	}
	public void setT_carid(int t_carid) {
		this.t_carid = t_carid;
	}
	public int getT_udid() {
		return t_udid;
	}
	public void setT_udid(int t_udid) {
		this.t_udid = t_udid;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public Integer getT_rsid() {
		return t_rsid;
	}
	public void setT_rsid(Integer t_rsid) {
		this.t_rsid = t_rsid;
	}
	public int getT_ssid() {
		return t_ssid;
	}
	public void setT_ssid(int t_ssid) {
		this.t_ssid = t_ssid;
	}
	public String getDepart_time() {
		return depart_time;
	}
	public void setDepart_time(String depart_time) {
		this.depart_time = depart_time;
	}
	public int getT_ueid() {
		return t_ueid;
	}
	public void setT_ueid(int t_ueid) {
		this.t_ueid = t_ueid;
	}
	public double getLoad() {
		return load;
	}
	public void setLoad(double load) {
		this.load = load;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getDelflag() {
		return delflag;
	}
	public void setDelflag(int delflag) {
		this.delflag = delflag;
	}
	public int getOptid() {
		return optid;
	}
	public void setOptid(int optid) {
		this.optid = optid;
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
	public String getRsname() {
		return rsname;
	}
	public void setRsname(String rsname) {
		this.rsname = rsname;
	}
	public String getSs_name() {
		return ss_name;
	}
	public void setSs_name(String ss_name) {
		this.ss_name = ss_name;
	}

	
	
}




