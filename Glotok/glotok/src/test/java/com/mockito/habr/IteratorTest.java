package com.mockito.habr;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.argThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.Test;

public class IteratorTest {
	@Test
	public void iteratorTest() {
		Iterator i = mock(Iterator.class);
		when(i.next()).thenReturn("Hello").thenReturn("World");
		
		String res = "" + i.next() + i.next();
		System.out.println(res);
		assertEquals("HelloWorld", res);
		
	}
	
	@Test
	public void witgArgsTest() {
		Comparable<String> comparable = mock(Comparable.class);
		when(comparable.compareTo("Test")).thenReturn(1);
		assertEquals(1, comparable.compareTo("Test"));
		
	
	}
	
	@Test
	public void withAnyArgs() {
		Comparable<String> comparable = mock(Comparable.class);
		when(comparable.compareTo(anyString())).thenReturn(1);
		assertEquals(1, comparable.compareTo("TTTest"));
	}
	
	@Test(expected = IOException.class)
	public void throwOnCloseTest() throws IOException {
		OutputStream mock = mock(OutputStream.class);
		OutputStreamWriter osw = new OutputStreamWriter(mock);
		doThrow(new IOException()).when(mock).close();
		
		osw.close();
		
	}
	
	public void buffersTest() throws IOException {
		OutputStream mock = mock(OutputStream.class);
		OutputStreamWriter osw = new OutputStreamWriter(mock);
		osw.write('a');
		osw.flush();
		
		BaseMatcher<byte[]> arrayStartingWithA = new BaseMatcher<byte[]>() {

			public boolean matches(Object arg0) {
				byte[] buf = (byte[]) arg0;
				
				return buf[0] == 'a';
			}

			public void describeTo(Description arg0) {
				
				
				
			}
		
			
		};
		
		verify(mock).write(argThat(arrayStartingWithA));
	}
	
}
