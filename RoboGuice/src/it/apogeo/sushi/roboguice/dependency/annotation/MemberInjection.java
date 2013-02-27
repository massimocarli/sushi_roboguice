package it.apogeo.sushi.roboguice.dependency.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation describe the possibility to make a member injection into
 * a class
 * 
 * @author Massimo Carli - 21/ago/2012
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@CustomInjection
public @interface MemberInjection  {
	// Optional description for the annotation
	String description() default "no-description";
	// Mandatory value for the implementation
	Class<?> value();
}
