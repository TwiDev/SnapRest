package ch.twidev.snaprest.api.bind.annotation;

import ch.twidev.snaprest.api.bind.RequestType;
import ch.twidev.snaprest.http.ResponseType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Route {

    String name() default "";

    RequestType[] requestType() default {};

    String[] path();

    String responseType() default ResponseType.TEXT_PLAIN;

    String[] requiredPermission() default {};

    String[] requiredParams() default {};

    String[] requiredHeaders() default {};
}
