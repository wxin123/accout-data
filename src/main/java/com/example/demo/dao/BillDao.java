package com.example.demo.dao;

import com.example.demo.dos.BillDo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @auth：wangxin
 * @date：2019/3/22
 * @desc：TODO
 */
@Repository
public interface BillDao extends JpaRepository<BillDo, Long>, JpaSpecificationExecutor {

    Page<BillDo> findAllByCreateTimeBetweenAndAccountCodeOrderByCreateTimeDesc (Date startTime, Date endTime, String accountCode, Pageable pageable);
    Page<BillDo> findAllByAccountCodeOrderByCreateTimeDesc  (String accountCode, Pageable pageable);
}