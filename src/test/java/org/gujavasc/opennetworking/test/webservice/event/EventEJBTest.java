package org.gujavasc.opennetworking.test.webservice.event;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class EventEJBTest {
	
	private static EJBContainer ejbContainer;
	private static Context context;

	@BeforeClass
	public static void setUp(){
		ejbContainer = EJBContainer.createEJBContainer();
		context = ejbContainer.getContext();
	}
	
	@AfterClass
	public static void tearDownClass(){
		ejbContainer.close();
	}
	
	@Test
	public void test() throws NamingException{
		context.lookup("java:global/open-networking-back-java/ProjectService");
	}
	
}
