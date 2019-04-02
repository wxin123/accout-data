package com.example.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.dao.AccountDao;
import com.example.demo.dao.BillDao;
import com.example.demo.dos.AccountDo;
import com.example.demo.dos.BillDo;
import com.example.demo.param.BillParam;
import com.example.demo.utils.DateHelper;
import com.example.demo.utils.MoneyHelper;
import com.example.demo.utils.Pair;
import com.example.demo.utils.Render;
import com.example.demo.utils.enums.BillTypeEnum;
import com.example.demo.vos.BillVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.xml.crypto.Data;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
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

    public Pair<Long, List<BillVo>> findPage(BillParam param) {
        Calendar calendarInstance = Calendar.getInstance();
        Page<BillDo> page = null;
        if(StringUtils.hasText(param.getCreateTime())){
            if (param.getDateType() == 3) {
                param.setCreateTime(param.getCreateTime() + " 00:00:00");
                calendarInstance.setTime(DateHelper.parse(param.getCreateTime()));
                calendarInstance.add(Calendar.DATE, 1);
            }
            if (param.getDateType() == 2) {
                param.setCreateTime(param.getCreateTime() + "-01 00:00:00");
                calendarInstance.setTime(DateHelper.parse(param.getCreateTime()));
                calendarInstance.add(Calendar.MONTH, 1);
            }
            if (param.getDateType() == 1) {
                param.setCreateTime(param.getCreateTime() + "-01-01 00:00:00");
                calendarInstance.setTime(DateHelper.parse(param.getCreateTime()));
                calendarInstance.add(Calendar.YEAR, 1);
            }
            Date startTime = DateHelper.parse(param.getCreateTime());
            Date endTime = calendarInstance.getTime();
            page = dao.findAllByCreateTimeBetweenAndAccountCodeOrderByCreateTimeDesc (startTime, endTime, "C6D7E890", new PageRequest(param.getPage(), param.getLimit()));
        }else {
            page = dao.findAllByAccountCodeOrderByCreateTimeDesc ("C6D7E890", new PageRequest(param.getPage(), param.getLimit()));
        }
        List<BillVo> list = page.getContent().stream().map(b -> BillVo.parse(b)).collect(Collectors.toList());
        return Pair.of(page.getTotalElements(), list);
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
        }
        billDo.setResult(result);
        accountDo.setBalance(result);
        dao.saveAndFlush(billDo);
        accountDao.saveAndFlush(accountDo);
        return BillVo.parse(dao.saveAndFlush(billDo));
    }
}
