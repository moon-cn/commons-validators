package cn.moon.validation;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MainTest {

    @Test
    public void idNum() {
        User user = new User();

        // 正确
        user.idNum = "350321195803085628";


        Assertions.assertTrue(!validate(user).contains(IdNum.class));

        // 正确
        user.idNum = "123";
        Assertions.assertTrue(validate(user).contains(IdNum.class));
    }

    @Test
    public void notNull() {
        User user = new User();
        user.name = null;


        Assertions.assertTrue(validate(user).contains(NotNull.class));
    }

    @Test
    public void startWithLetter() {
        User user = new User();

        user.name = "abc";
        Assertions.assertTrue(!validate(user).contains(StartWithLetter.class));


        user.name = "12abc";
        Assertions.assertTrue(validate(user).contains(StartWithLetter.class));

    }


    /**
     * @param user
     * @return
     */
    private static List<?> validate(User user) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<User>> validate = validator.validate(user);

        List<?> collect = validate.stream().map(v -> v.getConstraintDescriptor().getAnnotation().annotationType()).collect(Collectors.toList());
        return collect;
    }


}
