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


- CarDrivingLicence: 驾驶证
- IdNum: 身份证
- NotContainsChinese: 不包含汉字
- StartWithLetter: 字母开头
- ChineseName: 中文姓名
- CreditCode: 统一社会信用代码
- General: 英文字母、数字和下划线
- Hex: 16进制字符串
- Ipv4: IP地址(v4)
- Mobile: 手机号码
- PlateNumber: 中国车牌号
- ZipCode: 邮政编码（中国）
- ContainsChinese: 包含中文字符
- Password: 密码
- Date: 日期yyyy-MM-dd
- YearMonth: 年月yyyy-MM
- YearQuarter: 季度yyyy-Qx