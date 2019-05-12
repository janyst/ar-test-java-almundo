package com.java.mundo.call.center.entity;

import java.io.Serializable;

public class CountDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1301141688119188581L;
	
	private int numberOperator;
	private int numberSupervisor;
	private int numberDirector;
	
	private int busyOperator;
	private int busySupervisor;
	private int busyDirector;
	
	private int totalCall;
	private int maxAttention;
	
	private int retryNumber;
	
	public int getNumberOperator() {
		return numberOperator;
	}
	public void setNumberOperator(int numberOperator) {
		this.numberOperator = numberOperator;
	}
	public int getNumberSupervisor() {
		return numberSupervisor;
	}
	public void setNumberSupervisor(int numberSupervisor) {
		this.numberSupervisor = numberSupervisor;
	}
	public int getNumberDirector() {
		return numberDirector;
	}
	public void setNumberDirector(int numberDirector) {
		this.numberDirector = numberDirector;
	}
	
	public int getBusyOperator() {
		return busyOperator;
	}
	public void setBusyOperator(int busyOperator) {
		this.busyOperator = busyOperator;
	}
	public int getBusySupervisor() {
		return busySupervisor;
	}
	public void setBusySupervisor(int busySupervisor) {
		this.busySupervisor = busySupervisor;
	}
	public int getBusyDirector() {
		return busyDirector;
	}
	public void setBusyDirector(int busyDirector) {
		this.busyDirector = busyDirector;
	}
	public int getTotalCall() {
		return totalCall;
	}
	public void setTotalCall(int totalCall) {
		this.totalCall = totalCall;
	}
	public int getMaxAttention() {
		return maxAttention;
	}
	public void setMaxAttention(int maxAttention) {
		this.maxAttention = maxAttention;
	}
	public int getRetryNumber() {
		return retryNumber;
	}
	public void setRetryNumber(int retryNumber) {
		this.retryNumber = retryNumber;
	}
}
