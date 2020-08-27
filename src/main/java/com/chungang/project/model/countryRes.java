package com.chungang.project.model;

import java.sql.Date;

public class countryRes {

	private String bankNa;
	private double money;
	private Date updateDate;

	public String getBankNa() {
		return bankNa;
	}

	public void setBankNa(String bankNa) {
		this.bankNa = bankNa;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
