package it.apogeo.sushi.roboguice.dependency.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This is a custom annotation we're using to annotate our injection annotation
 * It's a "kind of way" to implement tagging interface. A custom annotation is that
 * if annotated with this annotation 
 * 
 * @author Massimo Carli - 21/ago/2012
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface CustomInjection {
}
