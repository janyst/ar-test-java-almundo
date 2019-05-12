package com.java.mundo.call.center.attention;

import com.java.mundo.call.center.entity.CountDTO;

public class WaitClient implements Runnable {
	private String nameClient;
	private long timeAttention;
	private CountDTO countDTO;
	
	public WaitClient (long timeAttention, String nameClient, CountDTO countDTO) {
		this.timeAttention = timeAttention;
		this.nameClient = nameClient;
		this.countDTO = countDTO;		
	}
	
	
	public void run() {
		System.out.println("Cliente en espera "+ nameClient);
		if(this.countDTO.getNumberOperator() == this.countDTO.getBusyOperator() 
				|| this.countDTO.getNumberSupervisor() == this.countDTO.getBusySupervisor()
				|| this.countDTO.getNumberDirector() == this.countDTO.getBusyDirector()) {		
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}
		Dispatcher.dispatchCall(timeAttention, nameClient);
	}

}
