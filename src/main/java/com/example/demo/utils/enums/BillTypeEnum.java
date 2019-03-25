package com.example.demo.utils.enums;

public enum BillTypeEnum {

    INCOME("收入", 1),
    OUTCOME("支出", 2);

    private String name;
    private Integer value;

    BillTypeEnum(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public static String parse(Integer value){
        String rst = "";
        if(value==1){
            rst = "收入";
        }
        if(value==2){
            rst = "支出";
        }
        return rst;
    }

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
