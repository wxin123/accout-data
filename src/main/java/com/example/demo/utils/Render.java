package com.example.demo.utils;

import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.io.Serializable;
import java.util.List;

/**
 * @author: wangxin
 * @date:2019/4/1
 * @description:TODO
 */
public class Render<T> implements Serializable {

    private Integer status;
    private String message;
    private T data;
    private Long count;

    public static Render succes(Pair pair) {
        Render r = new Render();
        r.status = 200;
        r.message = "成功";
        r.data = pair.getSecond();
        r.count = Long.parseLong(pair.getFirst().toString());
        return r;
    }

    public static Render success(Object object) {
        Render r = new Render();
        r.status = 200;
        r.message = "成功";
        r.data = object;
        return r;
    }

    public static Render error(Integer status, String message) {
        Render render = new Render();
        render.status = status;
        render.message = message;
        return render;
    }

    public Integer getStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }

    public T getData() {
        return this.data;
    }

    public Long getCount() {
        return this.count;
    }
}
