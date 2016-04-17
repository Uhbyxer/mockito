package com.mockito.power;

public class UseStaticService {
	  public String useStatic(final Object obj) {
	        StaticService.doStatic();
	        //
	        return StaticService.doStaticWithParams(obj);
	   }
}
