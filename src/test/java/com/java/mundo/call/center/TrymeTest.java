package com.java.mundo.call.center;

import com.java.mundo.call.center.attention.Dispatcher;
import com.java.mundo.call.center.entity.CountDTO;
import junit.framework.TestCase;

public class TrymeTest extends TestCase{

	//mundo perfecto
	public void testMundoPerfecto(){
		Thread test = null;
		CountDTO countDTO = null;
		Boolean flag = null; 
		
		try {
			test = new Thread();
			test.start();
			//cantidad empleados nomina
			countDTO = new CountDTO();
			countDTO.setNumberOperator(3);
			countDTO.setNumberSupervisor(2);
			countDTO.setNumberDirector(1);
			//cantidad empleados ocupados
			countDTO.setBusyOperator(0);
			countDTO.setBusySupervisor(0);
			countDTO.setBusyDirector(0);
			//llamadas a atender
			countDTO.setTotalCall(10);
			//cantidad maxima de llamadas
			countDTO.setMaxAttention(10);
			
			flag = Dispatcher.callCenter(countDTO);
			test.sleep(60000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		junit.framework.Assert.assertEquals(flag.booleanValue(),true);
	}

}
