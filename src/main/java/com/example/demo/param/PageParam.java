package com.example.demo.param;

import lombok.Data;

/**
 * Created by wangxin on 2019/4/1.
 */
public class PageParam {
    private Integer page = 0;
    private Integer Limit = 10;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page - 1;
    }

    public Integer getLimit() {
        return Limit;
    }

    public void setLimit(Integer limit) {
        Limit = limit;
    }
}
