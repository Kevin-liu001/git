package com.byzx.model;
/**@�ļ���: SorterInfo.java
 * @�๦��˵��: �ּ�Ա
 * @����: LiuKaiWem
 * @Email: 1519960668@qq.com
 * @����: 2019��10��30������3:45:28
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: LiuKaiWem</li> 
 * 	 <li>����: 2019��10��30������3:45:28</li> 
 *	 <li>����: </li>
 * </pre>
 */
public class SorterInfo {

	private Integer sorter_jobNum;//�ּ�Ա����
	private Integer ss_id; //�ּ�վid
	private Integer s_usid; //�ּ�ԱID
	private Integer sorter_busy; //�ּ�Ա״̬0-���У�1-������
	private Integer sorter_work;//�ּ�Ա�Ƿ�����0-û�ϰ� 1-�ϰ�
	private Integer state;//״̬
	private Integer delflag;//ɾ�����
	private Integer opt_id;//������Աid
	private String sorter_workTop;//�ּ�Ա����
	private String remark;//��ע
	private String optime;//����ʱ��
	
	public Integer getOpt_id() {
		return opt_id;
	}
	public void setOpt_id(Integer opt_id) {
		this.opt_id = opt_id;
	}
	public Integer getSorter_jobNum() {
		return sorter_jobNum;
	}
	public void setSorter_jobNum(Integer sorter_jobNum) {
		this.sorter_jobNum = sorter_jobNum;
	}
	public Integer getSs_id() {
		return ss_id;
	}
	public void setSs_id(Integer ss_id) {
		this.ss_id = ss_id;
	}
	public Integer getS_usid() {
		return s_usid;
	}
	public void setS_usid(Integer s_usid) {
		this.s_usid = s_usid;
	}
	public Integer getSorter_busy() {
		return sorter_busy;
	}
	public void setSorter_busy(Integer sorter_busy) {
		this.sorter_busy = sorter_busy;
	}
	public Integer getSorter_work() {
		return sorter_work;
	}
	public void setSorter_work(Integer sorter_work) {
		this.sorter_work = sorter_work;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getDelflag() {
		return delflag;
	}
	public void setDelflag(Integer delflag) {
		this.delflag = delflag;
	}
	
	public String getSorter_workTop() {
		return sorter_workTop;
	}
	public void setSorter_workTop(String sorter_workTop) {
		this.sorter_workTop = sorter_workTop;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getOptime() {
		return optime;
	}
	public void setOptime(String optime) {
		this.optime = optime;
	}

	
	
	
}
