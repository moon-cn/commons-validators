package cn.moon.validation;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotContainsChineseValidator implements ConstraintValidator<NotContainsChinese, String> {


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