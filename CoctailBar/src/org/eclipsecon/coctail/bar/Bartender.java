package org.eclipsecon.coctail.bar;

public class Bartender {

	public void mixDrink(Drink drink, Incrediants incrediants) {

		incrediants.getIncredians();	
		notifyWaitress(drink);
		drink.shake();

		
		//throw new IllegalStateException();
		
	}

	private void notifyWaitress(Drink drink) {
		// TODO Auto-generated method stub
		
	}
	
}
