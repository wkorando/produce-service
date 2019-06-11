package com.ibm.developer.produce;

import org.junit.Test;

public class TestProduceService {

	@Test(expected = ClientException.class)
	public void testFindByNameInvalidCharacter() {
		ProduceService service = new ProduceService(null);
		service.findProduceByName("+");
	}
}
