package cn.moon.validation;


import javax.validation.constraints.NotNull;

public class User {

    @StartWithLetter(message = "必须以字母开头")
    @NotNull(message = "名称不能为空")
     String name;

    @IdNum
     String idNum;



}