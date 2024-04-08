package cn.moon.validation;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Validators {

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @Constraint(validatedBy = StartWithLetterValidator.class)
    public @interface StartWithLetter {

        String message() default "{cn.moon.validation.Validators.StartWithLetter.message}";

        Class<?>[] groups() default {};

        Class<? extends Payload>[] payload() default {};
    }


    public static class StartWithLetterValidator implements ConstraintValidator<StartWithLetter, String> {


            @Override
            public void initialize(StartWithLetter constraintAnnotation) {
            }

            @Override
            public boolean isValid(String idNum, ConstraintValidatorContext constraintValidatorContext) {
                if (idNum != null && idNum.length() > 0) {
                    char c = idNum.charAt(0);
                    return Character.isLetter(c);
                }

                return true;
            }
        }
}
