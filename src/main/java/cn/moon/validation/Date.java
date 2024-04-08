package cn.moon.validation;

import cn.hutool.core.date.DateUtil;
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
 * 日期 yyyy-MM-dd
 */
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = Date.MyValidator.class)
public @interface Date {

    String message() default "日期格式错误，正确格式如：2022-03-15";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

   class MyValidator implements ConstraintValidator<Date, String> {


        @Override
        public boolean isValid(String str, ConstraintValidatorContext constraintValidatorContext) {
            if (str != null && !str.isEmpty()) {
                try {
                    DateUtil.parse(str,"yyyy-MM-dd");
                }catch (Exception e){
                    return false;
                }

            }
            return true;
        }


    }
}
