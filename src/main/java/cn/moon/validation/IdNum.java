package cn.moon.validation;

import cn.hutool.core.util.IdcardUtil;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 身份证
 */
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IdNum.IdNumValidator.class)
public @interface IdNum {

    String message() default "身份证号码错误";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

   class IdNumValidator implements ConstraintValidator<IdNum, String> {


        @Override
        public boolean isValid(String str, ConstraintValidatorContext constraintValidatorContext) {
            if (str != null && !str.isEmpty()) {
                return IdcardUtil.isValidCard(str);
            }
            return true;
        }


    }
}
