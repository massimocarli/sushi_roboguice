package it.apogeo.sushi.roboguice.module;

import it.apogeo.sushi.roboguice.dependency.annotation.CustomInjection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation describe the possibility to make a generic injection into
 * a class
 * 
 * @author Massimo Carli - 21/ago/2012
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.CONSTRUCTOR,ElementType.METHOD})
@CustomInjection
public @interface Inject  {
	// Optional description for the annotation
	String description() default "no-description";
}
