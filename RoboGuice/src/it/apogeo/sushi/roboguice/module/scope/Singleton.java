package it.apogeo.sushi.roboguice.module.scope;

import it.apogeo.sushi.roboguice.dependency.annotation.CustomInjection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation is useful to tag Singleton classes. 
 * 
 * @author Massimo Carli - 22/ago/2012
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@CustomInjection
public @interface Singleton {
}
