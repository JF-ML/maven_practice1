package com.mayab.calidad.doubles.tareaUnitTest;



import org.junit.Before;
import org.junit.Test;



import static org.mockito.Mockito.*;
public class TestAlerts {

	
	
	Account account;
	Alert alert;
	
	
	@Before
	public void setupMock() {
		alert = mock(Alert.class);
	}
	
	@Test
	public void Alerts() {
		account = new Account("John Smith",100,1,alert);
		account.debit(90);
		
		
		verify(alert).sendAlert("John Smith, your account balance is below 100");;
	}

}
