package com.example.demo.controller;

import com.example.demo.dos.AccountDo;
import com.example.demo.dos.BillDo;
import com.example.demo.param.AccountParam;
import com.example.demo.param.BillParam;
import com.example.demo.service.AccountService;
import com.example.demo.service.BillService;
import com.example.demo.vos.AccountVo;
import com.example.demo.vos.BillVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by wangxin on 2019/3/22.
 */
@Controller
@RequestMapping("/bill")
public class BillController {

    @Autowired
    BillService service;

    /**
     * 列表
     * @param param
     * @return
     */
    @GetMapping("/list")
    @ResponseBody
    public List<BillVo> list(AccountParam param) {
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
        return null;
    }

    /**
     * 新建
     * @param param
     */
    @PostMapping("")
    @ResponseBody
    public BillVo create(BillParam param) {
        return service.create(param);
    }

    /**
     * 编辑
     * @param param
     */
    @PutMapping("")
    @ResponseBody
    public AccountVo update(AccountParam param) {
        return null;
    }

    /**
     * 删除
     * @param code
     * @return
     */
    @DeleteMapping("/{code}")
    @ResponseBody
    public AccountVo deleteByCode(@PathVariable("code") String code){
        return null;
    }
}
