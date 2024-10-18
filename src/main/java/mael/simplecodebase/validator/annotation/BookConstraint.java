package mael.simplecodebase.validator.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import mael.simplecodebase.validator.BookValidator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = BookValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface BookConstraint {
    String message() default "Writing date must be before publication date";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
