package com.java.mundo.call.center.attention;

import com.java.mundo.call.center.entity.CountDTO;
import com.java.mundo.call.center.utils.Constant;

public class AttentionClient implements Runnable {
	
	
	private long timeAttention;
	private String typeEmployee;
	private CountDTO countDTO;
	private String nameClient;
	
	public AttentionClient(Long timeAttention, String typeEmployee, CountDTO countDTO, String nameClient) {
		this.timeAttention = timeAttention*1000;
		this.typeEmployee = typeEmployee;		
		this.countDTO = countDTO;
		this.nameClient = nameClient;
	}

	
	public void run() {
		this.attentionCliente();
	}
	
	private void attentionCliente(){
		if(countDTO != null && typeEmployee != null) {
			System.out.println("Se atiende el cliente: " + this.nameClient + ", recibe llamada: "+typeEmployee);
			try {
				Thread.sleep(this.timeAttention);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally {
				this.enableEmployee();
				System.out.println("Cliente Atendido : " + this.nameClient + ", se libera: "+typeEmployee 
						+ " ocupados Operador:"+this.countDTO.getBusyOperator()+", Supervisor: "+this.countDTO.getBusySupervisor()+", Director: "+this.countDTO.getBusyDirector());
			}
		}
	}
	
	private void enableEmployee() {
		if(this.typeEmployee.equalsIgnoreCase(Constant.OPERATOR)){
			this.countDTO.setBusyOperator(this.countDTO.getBusyOperator()-1);
		}else if(this.typeEmployee.equalsIgnoreCase(Constant.SUPERVISOR)){
			this.countDTO.setBusySupervisor(this.countDTO.getBusySupervisor()-1);
		}else if(this.typeEmployee.equalsIgnoreCase(Constant.DIRECTOR)){
			this.countDTO.setBusyDirector(this.countDTO.getBusyDirector()-1);
		}
	}

	public long getTimeAttention() {
		return timeAttention;
	}

	public void setTimeAttention(long timeAttention) {
		this.timeAttention = timeAttention;
	}

	public String getTypeEmployee() {
		return typeEmployee;
	}

	public void setTypeEmployee(String typeEmployee) {
		this.typeEmployee = typeEmployee;
	}

	public CountDTO getCountDTO() {
		return countDTO;
	}

	public void setCountDTO(CountDTO countDTO) {
		this.countDTO = countDTO;
	}

}
