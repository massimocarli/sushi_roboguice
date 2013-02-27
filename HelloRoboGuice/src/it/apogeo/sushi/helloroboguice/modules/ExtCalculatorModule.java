package it.apogeo.sushi.helloroboguice.modules;

import it.apogeo.sushi.helloroboguice.log.Logger;
import it.apogeo.sushi.helloroboguice.log.SysLog;
import it.apogeo.sushi.helloroboguice.service.Calculator;
import it.apogeo.sushi.helloroboguice.service.KeyMapper;
import it.apogeo.sushi.helloroboguice.service.LoggedCalculator;
import it.apogeo.sushi.helloroboguice.service.SimpleKeyMapper;

import com.google.inject.AbstractModule;

/**
 * This is a Module implementation for the Calculator project
 * @author Massimo Carli - 29/ago/2012
 *
 */
public class ExtCalculatorModule extends AbstractModule {

	/* (non-Javadoc)
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override
	protected void configure() {
		// We add a new implementation of Calculator that uses Logger
		bind(Calculator.class).to(LoggedCalculator.class);
		bind(KeyMapper.class).to(SimpleKeyMapper.class);
		bind(Logger.class).to(SysLog.class);
	}

}
