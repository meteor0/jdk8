package com.example.jdk.demo5stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 操作集合的弊端,
 * 每个需求都要循环一次,还要搞一个新集合来装数据,麻烦
 */
public class Demo1 {
    public static void main(String[] args) {
        List<String> listName  = new ArrayList();
        Collections.addAll(listName,"张无忌","周芷若","赵敏","张强","张三丰","金轮法王");

        List<String> zhangList  = new ArrayList();
        for (String name :listName){
            if(name.contains("张")){
                zhangList.add(name);
            }
        }
        listName.stream().filter((e)->{
           return e.startsWith("张");
        }).filter((e)->{
            return e.length()<3;
        }).forEach((e)->{
            System.out.println("e"+e);
        });
        System.out.println(zhangList);
        List<String> threeList  = new ArrayList();
        for (String name :zhangList){
            if(name.length()<3){
                threeList.add(name);
            }
        }
        System.out.println(threeList);

    }
}
