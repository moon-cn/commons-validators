package cn.moon.validation;

import com.sun.istack.internal.NotNull;
import lombok.Data;

@Data
public class User {

    @NotNull
    private String name;
    
    // 其他属性和方法...
}