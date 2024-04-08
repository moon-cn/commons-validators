package cn.moon.validation;


import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 字母开头
 */
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StartWithLetter.MyValidator.class)
public @interface StartWithLetter {

    String message() default "必须以字母开头";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


    class MyValidator implements ConstraintValidator<StartWithLetter, String> {


            @Override
            public boolean isValid(String str, ConstraintValidatorContext constraintValidatorContext) {
                if (str != null && !str.isEmpty()) {
                    char c = str.charAt(0);
                    return Character.isLetter(c);
                }
                return true;
            }
        }
}
