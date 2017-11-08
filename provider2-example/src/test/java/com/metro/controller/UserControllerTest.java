package com.metro.controller;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.metro.AppConfiguration;

import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.VerificationReports;
import au.com.dius.pact.provider.junit.loader.PactBroker;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;

/**
 * Test class to verify consumer contract from pact broker.
 *
 */
@RunWith(PactRunner.class)
@Provider("platform_cdc_javaProvider1")
@PactBroker(host = "54.232.203.146", port = "8085")
// @PactFolder("/home/ubuntu/PactServices/Consumer/Consumer/target/pacts")
@VerificationReports({ "console", "markdown" })
public class UserControllerTest {

	@TestTarget
	public final Target target = new HttpTarget(8080);

	private static ConfigurableApplicationContext context;

	@BeforeClass
	public static void startService() {
		context = SpringApplication.run(AppConfiguration.class);
	}

	@State("test state")
	public void testState() {
		System.out.println("in test state.....");
	}

	@AfterClass
	public static void stopService() {
		context.stop();
	}
}
