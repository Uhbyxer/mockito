package com.mockito.glotok;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Spy;

import static org.mockito.Mockito.*;


public class AppTest {

	//@Spy
	//@Mock
	private List<String> mockedList;

	@Before
	public void init() {
		//mockedList = new ArrayList<String>();
		mockedList = mock(List.class);
		mockedList.add("one");
		mockedList.clear();
		
		when(mockedList.get(0)).thenReturn("first");
		when(mockedList.get(1)).thenThrow(new RuntimeException());
	}
	
	@Test
	public void testAddWithParam() {
		verify(mockedList).add("one");
		verify(mockedList).clear();

	}
	
	@Test
	public void testStub() {
		System.out.println(mockedList.get(0));

	}

	@Test
	public void testCount() {
		
		System.out.println(mockedList.get(0));

	}
	
	
}
