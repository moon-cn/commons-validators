package cn.moon.validation;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.NumberUtil;

import javax.validation.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 季度 yyyy-Qx
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = YearQuarter.MyValidator.class)
public @interface YearQuarter {

    String message() default "季度格式错误，正确格式如：2022-Q2";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class MyValidator implements ConstraintValidator<YearQuarter, String> {


        @Override
        public boolean isValid(String str, ConstraintValidatorContext constraintValidatorContext) {
            if (str != null && !str.isEmpty()) {
                String[] arr = str.split("-");
                if (arr.length == 2 && arr[0].length() == 4 && arr[1].length() == 2) {
                    char q = arr[1].charAt(0);
                    char qNum = arr[1].charAt(1);

                    return NumberUtil.isInteger(arr[0]) && q == 'Q' && (qNum >= '1' && qNum <= '4');
                }
                return false;
            }
            return true;
        }


    }
}
