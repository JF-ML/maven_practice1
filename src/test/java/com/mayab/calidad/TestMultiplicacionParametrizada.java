package com.mayab.calidad;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestMultiplicacionParametrizada {

	@Parameters
	public static Collection<Object> data() {
		return Arrays.asList(new Object [][] {
			{4,2,2},{6,3,2},{5,5,1},{10,5,2}
		});
	}
	
	private float multiplierOne;
	private float expected;
	private float multiplierTwo;
	
	public TestMultiplicacionParametrizada(float expected, float multiplierOne, float multiplierTwo) {
		this.multiplierOne= multiplierOne;
		this.expected= expected;
		this.multiplierOne= multiplierTwo;
	}
	@Test
	public void test() {
		float result;
		result = multiplierOne*multiplierTwo;
		assertThat(result,is(expected));
	}

}
