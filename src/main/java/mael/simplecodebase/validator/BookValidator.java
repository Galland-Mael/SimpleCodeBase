package mael.simplecodebase.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import mael.simplecodebase.validator.annotation.BookConstraint;
import org.springframework.beans.BeanWrapperImpl;

import java.time.LocalDate;
import java.util.Objects;


public class BookValidator implements ConstraintValidator<BookConstraint, Object> {
    private static final String PUBLICATION_DATE_FIELD = "publicationDate";
    private static final String WRITTING_DATE_FIELD = "writtingDate";

    @Override
    public void initialize(BookConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        BeanWrapperImpl bean = new BeanWrapperImpl(o);

        LocalDate writtingDate = (LocalDate) Objects.requireNonNull(bean.getPropertyValue(WRITTING_DATE_FIELD));
        LocalDate publicationDate = (LocalDate) Objects.requireNonNull(bean.getPropertyValue(PUBLICATION_DATE_FIELD));

        return writtingDate.isBefore(publicationDate);
    }
}
