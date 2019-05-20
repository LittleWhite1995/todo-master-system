package com.todo.system.util.utils;

import java.io.Serializable;
import java.util.List;

/**
 * @program: com-todo-sysytem-parent
 * @description: PageVo
 * @author: littleWhite
 * @create: 2019/5/20 15:42
 **/
public class PageVo<T> implements Serializable {
    private static final long serialVersionUID = 7736687003205131064L;
    protected int total;
    protected int recordsTotal;
    protected int recordsFiltered;
    protected List<T> rows = null;

    public PageVo(int total, List<T> rows) {
        super();
        this.total = total;
        this.rows = rows;
    }

    public PageVo() {
        super();
    }

    public int getRecordsTotal() {
        return total;
    }

    public void setRecordsTotal(int recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public int getRecordsFiltered() {
        return total;
    }

    public void setRecordsFiltered(int recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
