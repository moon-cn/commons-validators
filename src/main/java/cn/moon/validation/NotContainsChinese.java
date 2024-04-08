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
 * 不包含汉字
 */
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotContainsChinese.NotContainsChineseValidator.class)
public @interface NotContainsChinese {

    String message() default "不能包含中文字符";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class NotContainsChineseValidator implements ConstraintValidator<NotContainsChinese, String> {


        @Override
        public boolean isValid(String str, ConstraintValidatorContext constraintValidatorContext) {
            if (str != null && !str.isEmpty()) {
                for (char c : str.toCharArray()) {
                    if (isHan(c)) {
                        return false;
                    }
                }
            }
            return true;
        }

        private boolean isHan(char c) {
            Character.UnicodeScript sc = Character.UnicodeScript.of(c);
            return sc == Character.UnicodeScript.HAN;
        }
    }
}
