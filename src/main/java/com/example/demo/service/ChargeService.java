package com.example.demo.service;

import com.example.demo.dao.ChargeDao;
import com.example.demo.dos.ChargeDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author: WangXin
 * @date:2017/10/27
 * @description:TODO
 */
@Service
public class ChargeService {

    @Autowired
    ChargeDao dao;

    public List<ChargeDo> findAll() {
        return dao.findAll();
    }

}
