package it.apogeo.sushi.helloroboguice.modules;

import it.apogeo.sushi.helloroboguice.service.Calculator;
import it.apogeo.sushi.helloroboguice.service.KeyMapper;
import it.apogeo.sushi.helloroboguice.service.SimpleCalculator;
import it.apogeo.sushi.helloroboguice.service.SimpleKeyMapper;

import com.google.inject.AbstractModule;

/**
 * This is a Module implementation for the Calculator project
 * @author Massimo Carli - 29/ago/2012
 *
 */
public class CalculatorModule extends AbstractModule {

	/* (non-Javadoc)
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override
	protected void configure() {
		// Here we have to make the bind of the service interface with
		// its related implementation
		bind(Calculator.class).to(SimpleCalculator.class);
		bind(KeyMapper.class).to(SimpleKeyMapper.class);
	}

}
