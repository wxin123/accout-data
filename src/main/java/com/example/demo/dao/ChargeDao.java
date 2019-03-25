package com.example.demo.dao;

import com.example.demo.dos.ChargeDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @auth：wangxin
 * @date：2019/3/22
 * @desc：TODO
 */
@Repository
public interface ChargeDao extends JpaRepository<ChargeDo, Long>, JpaSpecificationExecutor {

}