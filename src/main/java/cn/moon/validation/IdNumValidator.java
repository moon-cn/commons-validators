package cn.moon.validation;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.IdcardUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IdNumValidator implements ConstraintValidator<IdNum, String> {


    @Override
    public boolean isValid(String str, ConstraintValidatorContext constraintValidatorContext) {
        if (str != null && !str.isEmpty()) {
            return IdcardUtil.isValidCard(str);
        }
        return true;
    }


}