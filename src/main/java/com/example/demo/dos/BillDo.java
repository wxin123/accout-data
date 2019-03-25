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
@Table(name = "bill")
@Data
public class BillDo implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private Long id;
    private String code;
    private Long money;
    private Long result;
    private String accountCode;
    private Integer type;
    private String remark;
    private Date createTime;
    private Date updateTime;

    public BillDo() {
        this.code = CodeHelper.MD5("bill");
    }
}
