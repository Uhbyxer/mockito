package com.mockito.power.create;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.mockito.power.ExternalService;


@RunWith(PowerMockRunner.class)
@PrepareForTest({ ExternalServiceFactory.class, ExternalService.class })
public class InternalCreateServiceTest {
	private final ExternalService externalService = PowerMockito.mock(ExternalService.class);

	private final ExternalServiceFactory externalServiceFactory;
	private final InternalCreateService internalService;

	public InternalCreateServiceTest() throws Exception {
		PowerMockito.whenNew(ExternalService.class).withNoArguments().thenReturn(externalService);

		externalServiceFactory = new ExternalServiceFactory();
		internalService = new InternalCreateService(externalServiceFactory);
	}

	@Before
	public void before() {
		Mockito.reset(externalService);
	}

	@Test
	public void doWorkTest() {
		internalService.doWork();

		Mockito.verify(externalService).doMegaWork();
	}

}
