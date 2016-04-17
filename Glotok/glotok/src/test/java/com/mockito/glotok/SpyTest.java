package com.mockito.glotok;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SpyTest {
	
	private List list;
	private List spy;
	
	@Before
	public void setUp() {
		list = new LinkedList();
		spy = spy(list);
		
		//опционально, определяем лишь метод size()
		when(spy.size()).thenReturn(100);
		
		//используем реальные методы
		spy.add("one");
		spy.add("two");
	}
	
	@Test
	public void testSpy() {
		System.out.println(spy.get(0));
		System.out.println(spy.size());
		
		verify(spy).add("one");
		verify(spy).add("two");
	}
	
	
}
