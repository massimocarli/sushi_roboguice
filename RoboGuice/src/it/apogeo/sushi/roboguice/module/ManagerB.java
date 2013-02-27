package it.apogeo.sushi.roboguice.module;

/**
 * Another simple implementation of the Manager interface
 * 
 * @author Massimo Carli - 22/ago/2012
 *
 */
public class ManagerB implements Manager {
	
	@Inject
	private Logger logger;
	

	/* (non-Javadoc)
	 * @see it.apogeo.sushi.roboguice.module.Manager#manageSomething(java.lang.String)
	 */
	@Override
	public void manageSomething(String input) {
		logger.log("Manage B managed input:"+input);
	}

}
