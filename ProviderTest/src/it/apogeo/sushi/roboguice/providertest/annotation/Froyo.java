package it.apogeo.sushi.roboguice.providertest.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.google.inject.BindingAnnotation;

/**
 * Annotation to identify services to use for Froyo (API Level 8)
 * 
 * @author Massimo Carli - 30/ago/2012
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@BindingAnnotation
public @interface Froyo {
}
