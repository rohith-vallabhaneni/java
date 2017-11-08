package com.metro.rest.client;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Rule;

import com.metro.rest.dto.Data;

import au.com.dius.pact.consumer.ConsumerPactTestMk2;
import au.com.dius.pact.consumer.MockServer;
import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;

public class ConsumerAnotherTest extends ConsumerPactTestMk2 {

	@Rule
	public PactProviderRuleMk2 mockProvider = new PactProviderRuleMk2("platform_cdc_javaProvider1", "localhost", 8080,
			this);

	@Override
	protected String consumerName() {
		return "platform_cdc_javaConsumer";
	}

	@Override
	@Pact(provider = "platform_cdc_javaProvider1", consumer = "platform_cdc_javaConsumer")
	protected RequestResponsePact createPact(PactDslWithProvider builder) {
		return builder.given("test state").uponReceiving("ExampleJavaConsumerPactTest test interaction").path("/data")
				.method("GET").willRespondWith().status(200)
				.body(new PactDslJsonBody().integerType("username", "michel").stringValue("password", "michel"))
				.toPact();
	}

	@Override
	protected String providerName() {
		return "platform_cdc_javaProvider1";
	}

	@Override
	protected void runTest(MockServer server) throws IOException {
		RestClient restClient = new RestClient(server.getUrl());
		Data data = restClient.getData();
		Assert.assertNotNull(data);
	}
}