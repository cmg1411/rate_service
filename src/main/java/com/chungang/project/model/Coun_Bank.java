package com.chungang.project.model;

import java.sql.Date;

public class Coun_Bank {

	private String BankNa;
	private String CounNa;
	private double tbRate;
	private Date updateDate;
	
	public String getBankNa() {
		return BankNa;
	}

	public void setBankNa(String BankNa) {
		this.BankNa = BankNa;
	}

	public String getCounNa() {
		return CounNa;
	}

	public void setCounNa(String CounNa) {
		this.CounNa = CounNa;
	}

	public double getTbRate() {
		return tbRate;
	}

	public void setTbRate(double tbRate) {
		this.tbRate = tbRate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
