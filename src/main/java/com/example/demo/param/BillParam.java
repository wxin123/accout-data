package com.example.demo.param;

import lombok.Data;

/**
 * Created by wangxin on 2019/3/22.
 */
@Data
public class BillParam {
    private Integer page;
    private Integer Limit;
    private Double money;
    private Integer type;
    private String createTime;
    private String remark;
    private String accountCode;
}
