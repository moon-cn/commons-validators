package cn.moon.validation;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.io.file.FileNameUtil;
import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ReadmeGen {

    public static void main(String[] args) {
        File readme = new File("README.md");

        File java = new File("src/main/java/cn/moon/validation");

        File[] validators = java.listFiles(file -> file.isFile() && !file.getName().endsWith("Validator.java"));


        List<String> apis = new ArrayList<>();

        for (File validator : validators) {
            String name = validator.getName();
            name = FileNameUtil.mainName(name);
            apis.add("- " +name + ": " + getRemark(validator));
        }

        FileUtil.appendUtf8Lines(apis, readme);
    }

    // 获得注释
    private static String getRemark(File  file){
        List<String> javaLines = FileUtil.readUtf8Lines(file);

        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < javaLines.size(); i++) {
            String javaLine = javaLines.get(i);
            if (javaLine.contains("/*")) {
                buf.append(javaLine);

                for (int j = i; j < javaLines.size(); j++) {
                    String line = javaLines.get(j);

                    if(Validator.hasChinese(line)){
                        buf.append(line);
                        break;
                    }
                }

                break;
            }
        }

        String str = buf.toString();
        str = str.replace("*", "").replace("/", "");

        return StrUtil.cleanBlank(str);
    }
}
