package com.mockito.power;

public class InternalService {
	private final ExternalService externalService;

	public InternalService(ExternalService externalService) {
		this.externalService = externalService;
	}

	public void doWork() {
		externalService.doMegaWork();
	}
}
