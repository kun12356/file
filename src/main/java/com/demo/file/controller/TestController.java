package com.demo.file.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author txk
 * @date 2021/6/17
 * dev修改
 */
@RestController
public class TestController {

    public static final String path = "E:\\test";


    public static StringBuilder stringBuilder = new StringBuilder();


    static {
        stringBuilder.append(path);
    }

    /**
     * 移动目录
     *
     * @param str
     * @return
     */
    @RequestMapping("/cd")
    public String cd(String str) {
//        if (null!=str){
//            if ("..".equals(str)){
//                stringBuilder=new StringBuilder();
//                stringBuilder.append(path);
//            }
//            else {
//                if (str.startsWith("/")){
//                    stringBuilder.append(str);
//                }else {
//                    String s = str.split("/")[2];
//                    stringBuilder.append("/home/"+s);
//                }
//            }
//        }

        if (null != str) {
            if (str.startsWith("/")) {
                stringBuilder.append(str);
            } else {
                String substring = stringBuilder.toString().substring(0, stringBuilder.toString().lastIndexOf("/"));
                stringBuilder.delete(0, stringBuilder.length());
                String s = substring + str.replace("..", "");
                stringBuilder.append(s);
            }
        }

        return "";


    }


    /**
     * 获取当前路径下的文件
     *
     * @return
     */
    @RequestMapping("/pwd")
    public String pwd() {
//        File file=new File(stringBuilder.toString());
//        if (file.isDirectory()){
        String s = stringBuilder.toString();
        if (s.equals(path)) {
            return "/";
        }
//            File[] files = file.listFiles();
//            List<String> list = Arrays.stream(files).map(file1 -> file1.getName()).collect(Collectors.toList());
//            StringBuilder builder = new StringBuilder();
//            builder.append();
//            for (String s : list) {
//                builder.append("\\"+s);
//            }
//            System.out.println(s);
        return s.split("t")[2];
    }
//        return "/";
//    }
}
