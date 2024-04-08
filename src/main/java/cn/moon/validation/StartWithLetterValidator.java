package cn.moon.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StartWithLetterValidator implements ConstraintValidator<StartWithLetter, String> {


        @Override
        public boolean isValid(String str, ConstraintValidatorContext constraintValidatorContext) {
            if (str != null && !str.isEmpty()) {
                char c = str.charAt(0);
                return Character.isLetter(c);
            }
            return true;
        }
    }