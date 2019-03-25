package com.example.demo.service;

import com.example.demo.dao.AccountDao;
import com.example.demo.dao.BillDao;
import com.example.demo.dos.AccountDo;
import com.example.demo.dos.BillDo;
import com.example.demo.param.AccountParam;
import com.example.demo.param.BillParam;
import com.example.demo.utils.DateHelper;
import com.example.demo.utils.MoneyHelper;
import com.example.demo.utils.enums.BillTypeEnum;
import com.example.demo.vos.AccountVo;
import com.example.demo.vos.BillVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


/**
 * @author: WangXin
 * @date:2017/10/27
 * @description:TODO
 */
@Service
public class BillService {

    @Autowired
    BillDao dao;
    @Autowired
    AccountDao accountDao;

    public List<BillVo> findAll() {
        List<BillDo> list = dao.findAll();
        return list.stream().map(b -> BillVo.parse(b)).collect(Collectors.toList());
    }

    public BillVo create(BillParam param) {
        BillDo billDo = new BillDo();
        billDo.setAccountCode("C6D7E890");
        billDo.setCreateTime(DateHelper.parse(param.getCreateTime()));
        billDo.setRemark(param.getRemark());
        billDo.setMoney(MoneyHelper.y2f(param.getMoney()));
        billDo.setType(param.getType());

        AccountDo accountDo = accountDao.findByCode("C6D7E890");
        Long result = 0L;
        if (param.getType() == BillTypeEnum.INCOME.getValue()) {
            result = accountDo.getBalance() + billDo.getMoney();
        }
        if (param.getType() == BillTypeEnum.OUTCOME.getValue()) {
            result = accountDo.getBalance() - billDo.getMoney();
            System.out.println(result);
        }
        billDo.setResult(result);
        accountDo.setBalance(result);
        dao.saveAndFlush(billDo);
        accountDao.saveAndFlush(accountDo);
        return BillVo.parse(dao.saveAndFlush(billDo));
    }
}
