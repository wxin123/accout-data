package com.example.demo.vos;

import com.example.demo.dos.AccountDo;
import lombok.Data;

import java.util.Date;

/**
 * Created by wangxin on 2019/3/22.
 */
@Data
public class AccountVo {
    private String id;
    private String code;
    private String mobile;
    private String password;
    private String username;
    private Long balance;
    private Date createTime;
    private Date updateTime;

    public static AccountVo parse(AccountDo accountDo) {
        AccountVo vo = new AccountVo();
        vo.setId(accountDo.getId().toString());
        vo.setCode(accountDo.getCode());
        vo.setMobile(accountDo.getMobile());
        vo.setPassword(accountDo.getPassword());
        vo.setUsername(accountDo.getUsername());
        vo.setBalance(accountDo.getBalance());
        vo.setCreateTime(accountDo.getCreateTime());
        vo.setUpdateTime(accountDo.getUpdateTime());
        return vo;
    }
}
