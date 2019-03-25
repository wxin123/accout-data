package com.example.demo.dao;

import com.example.demo.dos.AccountDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @auth：wangxin
 * @date：2019/3/22
 * @desc：TODO
 */
@Repository
public interface AccountDao extends JpaRepository<AccountDo, Long>, JpaSpecificationExecutor {

    List<AccountDo> findAll();
    AccountDo findByCode(@Param("code") String code);
}