# validators
Java校验注解，项目中常用规则校验

#### Where can I get the latest release?
You can pull it from the central Maven repositories:
```
 <dependency>
    <groupId>io.github.moon-cn</groupId>
    <artifactId>commons-validators</artifactId>
    <version>1.x.x</version>
</dependency>
```
latest version: https://mvnrepository.com/artifact/io.github.moon-cn/commons-validators


#### 使用方式


```
    @StartWithLetter
    String name;
```

#### 所有注解

- IdNum: 身份证
- NotContainsChinese: 不包含汉字
- StartWithLetter: 字母开头