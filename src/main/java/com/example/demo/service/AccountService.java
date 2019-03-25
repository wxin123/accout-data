package com.example.demo.service;

import com.alibaba.fastjson.support.odps.CodecCheck;
import com.example.demo.dao.AccountDao;
import com.example.demo.dos.AccountDo;
import com.example.demo.param.AccountParam;
import com.example.demo.vos.AccountVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


/**
 * @author: WangXin
 * @date:2017/10/27
 * @description:TODO
 */
@Service
public class AccountService {

    @Autowired
    AccountDao dao;

    public List<AccountDo> findAll() {
        return dao.findAll();
    }

    public AccountVo findByCode(String code){
        AccountDo accountDo =  dao.findByCode(code);
        return AccountVo.parse(accountDo);
    }

    public AccountVo create (AccountParam param){
        AccountDo accountDo = new AccountDo();
        accountDo.setMobile(param.getMobile());
        accountDo.setUsername(param.getMobile());
        accountDo.setPassword(param.getPassword());
        accountDo.setBalance(0L);
        return AccountVo.parse(dao.saveAndFlush(accountDo));
    }

    public AccountVo update(AccountParam param) {
        AccountDo accountDo = dao.findByCode(param.getCode());
        if (Optional.ofNullable(accountDo).isPresent()) {
            accountDo.setPassword(param.getPassword());
            if (Optional.ofNullable(param.getUsername()).isPresent()) {
                accountDo.setUsername(param.getUsername());
            }
            accountDo.setUpdateTime(new Date());
            accountDo.setCode(param.getCode());
        }
        return AccountVo.parse(dao.saveAndFlush(accountDo));
    }

    public AccountVo delete(String code) {
        AccountDo accountDo = dao.findByCode(code);
        if (Optional.ofNullable(accountDo).isPresent()) {
            dao.deleteById(accountDo.getId());
        }
        return AccountVo.parse(accountDo);
    }
}
