package com.java.mundo.call.center;

import com.java.mundo.call.center.attention.Dispatcher;
import com.java.mundo.call.center.entity.CountDTO;
import junit.framework.TestCase;

public class CallClientTest extends TestCase{
	
	//mundo perfecto
	public void testMundoPerfecto(){
		CountDTO countDTO = new CountDTO();
		countDTO.setNumberOperator(3);
		countDTO.setNumberSupervisor(2);
		countDTO.setNumberDirector(1);
		
		countDTO.setBusyOperator(0);
		countDTO.setBusySupervisor(0);
		countDTO.setBusyDirector(0);
		
		countDTO.setTotalCall(10);
		countDTO.setMaxAttention(10);
		
		assertEquals(Dispatcher.callCenter(countDTO),true);
	}
	
	//no tenemos empleaods
	public void testNoEmpleados(){
		CountDTO countDTO = new CountDTO();
		countDTO.setNumberOperator(0);
		countDTO.setNumberSupervisor(0);
		countDTO.setNumberDirector(0);
		
		countDTO.setBusyOperator(0);
		countDTO.setBusySupervisor(0);
		countDTO.setBusyDirector(0);
		
		countDTO.setTotalCall(10);
		countDTO.setMaxAttention(10);
		
		assertEquals(Dispatcher.callCenter(countDTO),false);
	}
	
	//mas clientes que empleados
	public void testMaxEmployee(){
		CountDTO countDTO = new CountDTO();
		countDTO.setNumberOperator(3);
		countDTO.setNumberSupervisor(2);
		countDTO.setNumberDirector(1);
		
		countDTO.setBusyOperator(0);
		countDTO.setBusySupervisor(0);
		countDTO.setBusyDirector(0);
		
		countDTO.setTotalCall(12);
		countDTO.setMaxAttention(10);
		
		assertEquals(Dispatcher.callCenter(countDTO),false);
	}
	
	//todos los empleados ocupados
	public void testAllEmployeeBusy(){
		CountDTO countDTO = new CountDTO();
		countDTO.setNumberOperator(3);
		countDTO.setNumberSupervisor(2);
		countDTO.setNumberDirector(1);
		
		countDTO.setBusyOperator(4);
		countDTO.setBusySupervisor(4);
		countDTO.setBusyDirector(4);
		
		countDTO.setTotalCall(10);
		countDTO.setMaxAttention(10);
		
		assertEquals(Dispatcher.callCenter(countDTO),false);
	}
}
