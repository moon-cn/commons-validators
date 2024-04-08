package cn.moon.validation;

import cn.hutool.core.lang.Validator;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 统一社会信用代码
 */
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CreditCode.MyValidator.class)
public @interface CreditCode {

    String message() default "统一社会信用代码错误";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

   class MyValidator implements ConstraintValidator<CreditCode, String> {


        @Override
        public boolean isValid(String str, ConstraintValidatorContext constraintValidatorContext) {
            if (str != null && !str.isEmpty()) {
                return Validator.isCreditCode(str);
            }
            return true;
        }


    }
}
