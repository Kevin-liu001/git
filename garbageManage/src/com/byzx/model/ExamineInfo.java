package com.byzx.model;
/**@�ļ���: ExamineInfo.java
 * @�๦��˵��: �������˱�ʵ����
 * @����: LiuKaiWem
 * @Email: 1519960668@qq.com
 * @����: 2019��10��30������3:59:14
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: LiuKaiWem</li> 
 * 	 <li>����: 2019��10��30������3:59:14</li> 
 *	 <li>����: </li>
 * </pre>
 */
public class ExamineInfo {
	private int	examine_id;      //����id            
	private int	s_usid;          //�ּ�Աid         
	private int	allot;           //���������     
	private int	accomplish;      //��ɵ�����     
	private int	massDeviation;   //����ƫ��        
	private int	budgetTime;      //Ԥ�����ʱ��  
	private int	realityTime;     //ʵ�����ʱ��  
	private int	timeDeviation;   //ʱ��ƫ��        
	private int	state;           //״̬              
	private int	opt_id;           //������Ա        
	private int	delflag;         //ɾ�����        
	private String optime;       //�Ǽ�ʱ��        
	private String remark;       //��ע  
	public int getExamine_id() {
		return examine_id;
	}
	public void setExamine_id(int examine_id) {
		this.examine_id = examine_id;
	}
	public int getS_usid() {
		return s_usid;
	}
	public void setS_usid(int s_usid) {
		this.s_usid = s_usid;
	}
	public int getAllot() {
		return allot;
	}
	public void setAllot(int allot) {
		this.allot = allot;
	}
	public int getAccomplish() {
		return accomplish;
	}
	public void setAccomplish(int accomplish) {
		this.accomplish = accomplish;
	}
	public int getMassDeviation() {
		return massDeviation;
	}
	public void setMassDeviation(int massDeviation) {
		this.massDeviation = massDeviation;
	}
	public int getBudgetTime() {
		return budgetTime;
	}
	public void setBudgetTime(int budgetTime) {
		this.budgetTime = budgetTime;
	}
	public int getRealityTime() {
		return realityTime;
	}
	public void setRealityTime(int realityTime) {
		this.realityTime = realityTime;
	}
	public int getTimeDeviation() {
		return timeDeviation;
	}
	public void setTimeDeviation(int timeDeviation) {
		this.timeDeviation = timeDeviation;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getOpt_id() {
		return opt_id;
	}
	public void setOpt_id(int opt_id) {
		this.opt_id = opt_id;
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
}
