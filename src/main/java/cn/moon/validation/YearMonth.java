package cn.moon.validation;

import cn.hutool.core.date.DateUtil;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 年月 yyyy-MM
 */
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = YearMonth.MyValidator.class)
public @interface YearMonth {

    String message() default "年月格式错误，正确格式如：2022-03";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

   class MyValidator implements ConstraintValidator<YearMonth, String> {


        @Override
        public boolean isValid(String str, ConstraintValidatorContext constraintValidatorContext) {
            if (str != null && !str.isEmpty()) {
                try {
                    DateUtil.parse(str,"yyyy-MM");
                }catch (Exception e){
                    return false;
                }

            }
            return true;
        }


    }
}
