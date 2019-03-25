package com.example.demo.dos;

import com.example.demo.utils.CodeHelper;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * @auth：wangxin
 * @date：2019/3/22
 * @desc：TODO
 */
@Entity
@Table(name = "account")
@Data
public class AccountDo implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private Long id;
    private String code;
    private String mobile;
    private String password;
    private String username;
    private Long balance;
    private Date createTime;
    private Date updateTime;

    public AccountDo() {
        this.createTime = new Date();
        this.code = CodeHelper.MD5("account");
    }
}
