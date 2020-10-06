package com.mayab.calidad.doubles.tareaUnitTest;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class TestTareaUnitPara {
	@Parameters
	public static Iterable<Object[]> data() {
		return Arrays.asList(new Object [][] {
			{"John Smith",500,2},{"Emilia Baker",1000,3},{"Thomas Wayne",999,1}
		});
	}
	
	private String holder;
	private int initialBalance;
	private int zone;
	
	public TestTareaUnitPara(String holder, int initialBalance,int zone) {
		this.holder= holder;
		this.initialBalance= initialBalance;
		this.zone = zone;
	}
	
	
	@Test
	public void test() {
		
		Account account = new Account(holder,initialBalance,zone);
		assertThat(initialBalance,is(account.getBalance()));
		assertThat(zone,is(account.getZone()));
	}

}
