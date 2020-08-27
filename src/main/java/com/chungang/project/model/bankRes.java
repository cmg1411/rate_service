package com.chungang.project.model;

public class bankRes {
	private String CounNa;
	private double buy;
	private double sell;
	private double tbRate;
	private double fees;

	public double getBuy() {
		return buy;
	}

	public void setBuy(double buy) {
		this.buy = buy;
	}

	public double getSell() {
		return sell;
	}

	public void setSell(double sell) {
		this.sell = sell;
	}

	public String getCounNa() {
		return CounNa;
	}

	public void setCounNa(String counNa) {
		CounNa = counNa;
	}

	public double getTbRate() {
		return tbRate;
	}

	public void setTbRate(double tbRate) {
		this.tbRate = tbRate;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

}
