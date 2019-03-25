package com.example.demo.param;

import lombok.Data;

/**
 * Created by wangxin on 2019/3/22.
 */
@Data
public class AccountParam {
    private String code;
    private String mobile;
    private String password;
    private String username;
    private Long balance;
    private String createTime;
    private String updateTime;
}
