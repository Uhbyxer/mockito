package com.mockito.power;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ExternalService.class})
public class InternalServiceTest {
	
	private final ExternalService externalService = 
			PowerMockito.mock(ExternalService.class);
	
	private final InternalService internalService = 
			new InternalService(externalService);
	
	
	@Before
	public void setUp() {
		Mockito.reset(externalService);
	}
	
	@Test
	public void doWorkTest() {
		internalService.doWork();
		
		Mockito.verify(externalService).doMegaWork();
	}
	
}
