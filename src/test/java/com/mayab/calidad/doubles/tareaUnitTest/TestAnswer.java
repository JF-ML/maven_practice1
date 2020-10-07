package com.mayab.calidad.doubles.tareaUnitTest;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.*;
import java.util.HashMap;
import java.util.Map;
public class TestAnswer {

	
	Account account;
	int key = 1;
	@Before
	public void setupMock() {
		account = mock(Account.class);
		
		when(account.getCommision()).thenReturn(new HashMap<Integer,Integer>());
	}
	
	@Test
	public void Answer() {
		when(account.abono(anyInt())).thenAnswer(new Answer<Integer>() {
			public Integer answer(InvocationOnMock invocation) throws Throwable{
				Integer balance = (Integer)invocation.getArguments()[0]; 
				account.getCommision().put(eq(1), balance);
				
				return balance;
			}
		});
		when(account.calcularComm()).thenAnswer(new Answer<Float>() {
			public Float answer(InvocationOnMock invocation) throws Throwable{
				float totalComm=0;
				
				for(int i =0; i<account.map.size();i++) {
					totalComm += account.getCommision().get(key) * 0.01f;
					
					System.out.println(account.map.get(i));
				}
				for (Map.Entry me : account.map.entrySet()) {
			          System.out.println("Key: "+me.getKey() + " & Value: " + me.getValue());
			        }
				return totalComm;
			}
		});
		account.abono(100);
		account.abono(200);
		account.abono(200);
		
		assertThat(5.0f,is(account.calcularComm()));
	}

}
