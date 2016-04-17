package com.mockito.power;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ StaticService.class })
public class UseStaticServiceTest {
    private static final Object OBJECT_PARAM = new Object();
    private static final String RETURN_STRING = "result";
    
    private final UseStaticService useStaticService = new UseStaticService();
    
    
    @Before
    public void setUp() {
    	PowerMockito.mockStatic(StaticService.class);
    	PowerMockito.when(StaticService.doStaticWithParams(OBJECT_PARAM))
    		.thenReturn(RETURN_STRING);
    }
    
    
    @Test
    public void useStaticTest() {
    	String res = useStaticService.useStatic(OBJECT_PARAM);
    	
    	//PowerMockito.verifyStatic() — вызывается перед проверкой каждого статического вызова метода.
    	PowerMockito.verifyStatic();
    	StaticService.doStatic();
    	
    	PowerMockito.verifyStatic();
    	StaticService.doStaticWithParams(OBJECT_PARAM);
    	
    	assertEquals(RETURN_STRING, res);
    	
    }
    
    
}
