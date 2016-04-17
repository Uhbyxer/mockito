package com.mockito.power.create;

public class InternalCreateService {
	private final ExternalServiceFactory externalServiceFactory;
	
    public InternalCreateService(final ExternalServiceFactory externalServiceFactory) {
        this.externalServiceFactory = externalServiceFactory;
    }

    public void doWork() {
    	externalServiceFactory.createExternalService().doMegaWork();
    }
}	
