package com.bd.soai.mule;

import junit.framework.Assert;

import org.junit.Test;
import org.mule.module.client.MuleClient;
import org.mule.tck.functional.FunctionalTestComponent;
import org.mule.tck.junit4.FunctionalTestCase;

public class VMEndpointTest extends FunctionalTestCase {
	
	

	@Override
	protected String getConfigResources() {
		return "src/main/app/soa-integration.xml";
//		return "soa-integration.xml";
	}

	// mule application with related func test config should be running to run this test
	@Test
	public void innerIsCalled() throws Exception {
		final FunctionalTestComponent ftc = getFunctionalTestComponent("innerFtc");
		final Object object = new Object();
		final MuleClient client = new MuleClient(muleContext);

		client.dispatch("outer-endpoint", object, null);
		client.request("inner.completed", RECEIVE_TIMEOUT);

		Assert.assertEquals(object, ftc.getLastReceivedMessage());
	}

}