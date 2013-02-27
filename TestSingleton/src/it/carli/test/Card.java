package it.carli.test;

/**
 * @author Massimo Carli - 06/set/2012
 *
 */
public class Card {
	
	private int value;
	
	private int suite;
	
	public Card(int value, int suite){
		this.value=value;
		this.suite = suite;
	}
	
	public int getSuite() {
		return suite;
	}

	public int getValue() {
		return value;
	}
}
