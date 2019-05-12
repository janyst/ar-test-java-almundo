package com.java.mundo.call.center.attention;

import com.java.mundo.call.center.entity.CountDTO;
import com.java.mundo.call.center.utils.Constant;

public class Dispatcher {
	public static CountDTO countDTO;
	
	public static boolean callCenter(CountDTO countDTOthres) {
		countDTO = countDTOthres;
		boolean flag = false;
		
		if(validateFields()) {
			for(int i = 0; i < countDTO.getTotalCall(); i++) {
				String nameClient = "Cliente nro."+i;
				double ran = (Math.random() * 10) + 5;				
				dispatchCall(new Double(ran).longValue(), nameClient);
			}
			flag = true;
		}
		return flag;
	}
	
	public static synchronized void  dispatchCall(long timeAttention, String nameClient) {
		Thread thread = null;
		synchronized (countDTO) {
			if(countDTO.getBusyOperator() < countDTO.getNumberOperator()) {
				countDTO.setBusyOperator(countDTO.getBusyOperator()+1);
				thread = new Thread(new AttentionClient(timeAttention, Constant.OPERATOR, countDTO, nameClient));
				thread.start();
			}else if(countDTO.getBusySupervisor() < countDTO.getNumberSupervisor()) {
				countDTO.setBusySupervisor(countDTO.getBusySupervisor()+1);
				thread = new Thread(new AttentionClient(timeAttention, Constant.SUPERVISOR, countDTO, nameClient));
				thread.start();
			}else if(countDTO.getBusyDirector() < countDTO.getNumberDirector()) {
				countDTO.setBusyDirector(countDTO.getBusyDirector()+1);
				thread = new Thread(new AttentionClient(timeAttention, Constant.DIRECTOR, countDTO, nameClient));
				thread.start();				
			}else {
				thread = new Thread(new WaitClient(timeAttention, nameClient, countDTO));
				thread.start();
				countDTO.setRetryNumber(countDTO.getRetryNumber()+1);
				if(countDTO.getRetryNumber() > (countDTO.getTotalCall()*3)){
					thread.stop();
				}
			}
		}
	}
	
	private static boolean validateFields(){
		String msg = "Configuracion incorrecta, ";
		boolean validate = true;
		int totalEmployee;
		int totalBusyEmployee;
		
		totalEmployee = countDTO.getNumberOperator() + countDTO.getNumberSupervisor() + countDTO.getNumberDirector();
		totalBusyEmployee = countDTO.getBusyOperator() + countDTO.getBusySupervisor() + countDTO.getBusyDirector();
		
		if(countDTO.getNumberOperator() == 0 && countDTO.getNumberSupervisor() == 0 && countDTO.getNumberDirector() == 0){
			msg = msg.concat("no tenemos empleados en nomina.");
			validate = false;
		}else if(countDTO.getTotalCall() > countDTO.getMaxAttention()){
			msg = msg.concat("total de llamadas no puede ser mayor a cantidad maxima.");
			validate = false;
		}else if(totalEmployee == totalBusyEmployee){
			msg = msg.concat("no hay empleados disponibles.");
			validate = false;
		}else if(totalBusyEmployee > totalEmployee){
			msg = msg.concat("cantidad de empleados ocupados mayor a la cantidad nomina");
			validate = false;
		}
		if(!validate)
			System.out.println(msg);
		return validate;
	}

	public static void main(String[] args) {
		countDTO = new CountDTO();
		countDTO.setNumberOperator(3);
		countDTO.setNumberSupervisor(2);
		countDTO.setNumberDirector(1);
		
		countDTO.setBusyOperator(0);
		countDTO.setBusySupervisor(0);
		countDTO.setBusyDirector(0);
		
		countDTO.setTotalCall(10);
		countDTO.setMaxAttention(10);
		
		callCenter(countDTO);
	}

}
