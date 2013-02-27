package it.apogeo.sushi.roboguice.module;

/**
 * Simple implementation of the Manager interface
 * 
 * @author Massimo Carli - 22/ago/2012
 *
 */
public class ManagerA implements Manager {
	

	/* (non-Javadoc)
	 * @see it.apogeo.sushi.roboguice.module.Manager#manageSomething(java.lang.String)
	 */
	@Override
	public void manageSomething(String input) {
		System.out.println("ManagerA is not using Logger and has input:"+input);
	}

}
