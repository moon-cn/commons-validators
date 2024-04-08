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
 * 中文姓名
 */
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ChineseName.MyValidator.class)
public @interface ChineseName {

    String message() default "中文姓名错误";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

   class MyValidator implements ConstraintValidator<ChineseName, String> {


        @Override
        public boolean isValid(String str, ConstraintValidatorContext constraintValidatorContext) {
            if (str != null && !str.isEmpty()) {
                return Validator.isChineseName(str);
            }
            return true;
        }


    }
}
