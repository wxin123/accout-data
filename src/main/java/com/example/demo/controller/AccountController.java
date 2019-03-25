package com.example.demo.controller;

import com.example.demo.dos.AccountDo;
import com.example.demo.param.AccountParam;
import com.example.demo.service.AccountService;
import com.example.demo.vos.AccountVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by wangxin on 2019/3/22.
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService service;

    /**
     * 列表
     * @param param
     * @return
     */
    @GetMapping("/list")
    @ResponseBody
    public List<AccountDo> list(AccountParam param) {
        return  service.findAll();
    }

    /**
     * 详情
     * @param code
     * @return
     */
    @GetMapping("/{code}")
    @ResponseBody
    public AccountVo findByCode(@PathVariable("code") String code) {
        return service.findByCode(code);
    }

    /**
     * 新建
     * @param param
     */
    @PostMapping("")
    @ResponseBody
    public AccountVo create(AccountParam param) {
        return service.create(param);
    }

    /**
     * 编辑
     * @param param
     */
    @PutMapping("")
    @ResponseBody
    public AccountVo update(AccountParam param) {
        return service.update(param);
    }

    /**
     * 删除
     * @param code
     * @return
     */
    @DeleteMapping("/{code}")
    @ResponseBody
    public AccountVo deleteByCode(@PathVariable("code") String code){
        return service.delete(code);
    }
}
