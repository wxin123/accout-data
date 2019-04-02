package com.example.demo.param;

import lombok.Data;

/**
 * Created by wangxin on 2019/3/22.
 */
@Data
public class BillParam extends PageParam{
    private Double money;
    private Integer type;
    private String createTime;
    private Integer dateType;
    private String year;
    private String month;
    private String day;
    private String remark;
    private String accountCode;
}
