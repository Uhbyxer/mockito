package org.eclipsecon.coctail.bar;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class BartenderTest {
	
	private Bartender bartender;
	
	@Mock
	private Drink drink;
	@Mock
	private Incrediants incrediants;
	
	@Mock
	private Cashbox cashbox;
	
//	@Spy @InjectMocks
//	private Waitress waitress;

	@Before
	public void setUp() {
		bartender = new Bartender();
		
//		
//		drink = mock(Drink.class);
//		incrediants = mock(Incrediants.class);
	}
	
	@Test
	public void testUsesIncredients() {

		
		bartender.mixDrink(drink, incrediants);
			
		verify(incrediants).getIncredians();
		
	}
	
	@Test
	public void testShakeIncredients() {
		
		bartender.mixDrink(drink, incrediants);
			
		verify(drink).shake();
		
	}
	

	@Test
	public void testOrder() {
		
		bartender.mixDrink(drink, incrediants);
			
		InOrder order = inOrder(incrediants, drink);
		order.verify(incrediants).getIncredians();
		order.verify(drink).shake();
		
	}
//	
//	@Test
//	public void testWaitress() {
//		
//		bartender.mixDrink(drink, incrediants);
//		
//		verify(cashbox).payDrink(drink, 5.00);
//
//	}	
	

	
}
