package com.mockito.glotok;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CountTest {

	private List<String> mockedList;

	@Before
	public void init() {
		//mockedList = new ArrayList<String>();
		mockedList = mock(List.class);
		mockedList.add("once");//mockedList.add("once");
		 
		mockedList.add("twice");
		mockedList.add("twice");
		 
		mockedList.add("three times");
		mockedList.add("three times");
		mockedList.add("three times");
		
		mockedList.add("five times");
		mockedList.add("five times");
		
	}
	
	@Test
	public void testCount() {
		
		//по умолчанию проверка, что вызывался 1 раз ~ times(1)
		verify(mockedList).add("once");
		verify(mockedList, times(1)).add("once");
		
		verify(mockedList, times(2)).add("twice");
		verify(mockedList, times(3)).add("three times");
		
		verify(mockedList, never()).add("never happened");

	}
	
	@Test
	public void testCountMinMax() {
		
		verify(mockedList, atLeastOnce()).add("three times");
		verify(mockedList, atLeast(2)).add("five times");
		verify(mockedList, atMost(5)).add("three times");

	}
	
}
