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
 * 包含中文字符
 */
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ContainsChinese.MyChineseValidator.class)
public @interface ContainsChinese {

    String message() default "必须包含中文字符";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class MyChineseValidator implements ConstraintValidator<ContainsChinese, String> {


        @Override
        public boolean isValid(String str, ConstraintValidatorContext constraintValidatorContext) {
            if (str != null && !str.isEmpty()) {
                for (char c : str.toCharArray()) {
                    if (isHan(c)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }

        private boolean isHan(char c) {
            Character.UnicodeScript sc = Character.UnicodeScript.of(c);
            return sc == Character.UnicodeScript.HAN;
        }
    }
}
