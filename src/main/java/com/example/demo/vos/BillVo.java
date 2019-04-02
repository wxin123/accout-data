package com.example.demo.vos;

import com.example.demo.dos.BillDo;
import com.example.demo.utils.DateHelper;
import com.example.demo.utils.MoneyHelper;
import com.example.demo.utils.enums.BillTypeEnum;
import lombok.Data;

import java.util.Date;

/**
 * Created by wangxin on 2019/3/22.
 */
@Data
public class BillVo {
    private Long id;
    private String code;
    private String money;
    private String result;
    private String accountCode;
    private String type;
    private String remark;
    private String createTime;
    private String updateTime;
    private String balance;

    public static BillVo parse(BillDo billDo) {
        BillVo vo = new BillVo();
        vo.setId(billDo.getId());
        vo.setCode(billDo.getCode());
        vo.setMoney(MoneyHelper.f2y(billDo.getMoney()));
        vo.setResult(MoneyHelper.f2y(billDo.getResult()));
        vo.setAccountCode(billDo.getAccountCode());
        vo.setType(BillTypeEnum.parse(billDo.getType()));
        vo.setRemark(billDo.getRemark());
        vo.setCreateTime(DateHelper.format(billDo.getCreateTime()));
        return vo;
    }
}
