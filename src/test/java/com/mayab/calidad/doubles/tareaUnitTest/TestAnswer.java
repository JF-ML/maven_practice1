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

	HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	Account account;
	int key = 0;
	@Before
	public void setupMock() {
		account = mock(Account.class);
		map = mock(HashMap.class);
		when(account.getCommision()).thenReturn(0.01f);
	}
	
	@Test
	public void Answer() {
		when(account.abono(anyInt())).thenAnswer(new Answer<Float>() {
			public Float answer(InvocationOnMock invocation) throws Throwable{
				map.put(eq(1), anyInt());
				
				return 0f;
			}
		});
		when(account.calcularComm()).thenAnswer(new Answer<Float>() {
			public Float answer(InvocationOnMock invocation) throws Throwable{
				float totalComm=0;
				
				for(int i =0; i<map.size();i++) {
					totalComm += account.getCommision() * map.get(i);
					System.out.println(map.get(i));
				}
				for (Map.Entry me : map.entrySet()) {
			          System.out.println("Key: "+me.getKey() + " & Value: " + me.getValue());
			        }
				return totalComm;
			}
		});
		account.abono(100);
		account.abono(200);
		account.abono(200);
		
		System.out.println(account.calcularComm());
		assertThat(5.0f,is(account.calcularComm()));
	}

}
