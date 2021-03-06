package com.seven.common.entity;

import java.util.List;

/**
 * @author ：SevenRyuu
 * date   ：2019/5/20 11:07 PM
 * email  ：sevenryuu77@gmail.com
 */
public class PageResult<T> {

    private Long total;
    private List<T> rows;

    public PageResult() {
    }

    public PageResult(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
