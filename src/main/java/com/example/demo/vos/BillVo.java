package com.example.demo.vos;

import com.example.demo.dos.BillDo;
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
    private Long money;
    private Long result;
    private String accountCode;
    private String type;
    private String remark;
    private Date createTime;
    private Date updateTime;

    public static BillVo parse(BillDo billDo) {
        BillVo vo = new BillVo();
        vo.setId(billDo.getId());
        vo.setCode(billDo.getCode());
        vo.setMoney(billDo.getMoney());
        vo.setResult(billDo.getResult());
        vo.setAccountCode(billDo.getAccountCode());
        vo.setType(BillTypeEnum.parse(billDo.getType()));
        vo.setRemark(billDo.getRemark());
        vo.setCreateTime(billDo.getCreateTime());
        vo.setUpdateTime(billDo.getUpdateTime());
        return vo;
    }
}
