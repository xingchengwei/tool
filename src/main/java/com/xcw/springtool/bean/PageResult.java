package com.xcw.springtool.bean;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页结果对象
 *
 * @author Bo.Qian
 * @date 2021/05/15
 */
public class PageResult<T> implements Serializable {
    /**
     * 默认页码
     */
    protected long pageNo = 1L;
    /**
     * 总页数
     */
    protected long totalPages = -1L;
    /**
     * 每页数量
     */
    protected long pageSize = 10L;
    /**
     * 查询偏移量
     */
    @JsonIgnore
    private long offset = 0L;
    /**
     * 总数量
     */
    @JsonProperty(value = "total")
    protected long totalCount = -1L;
    /**
     * 结果集
     */
    @JsonProperty(value = "rows")
    protected List<T> result = null;

    /**
     * Create a new {@code PageResult}.
     */
    public PageResult() {
    }

    /**
     * Create a new {@code PageResult}.
     *
     * @param thePageNo
     * @param pageSize
     */
    public PageResult(long thePageNo, long pageSize) {
        setPageNo(thePageNo);
        this.pageSize = pageSize;
    }

    /**
     * 获取页码
     *
     * @return
     */
    public long getPageNo() {
        return this.pageNo;
    }

    /**
     * 设置页码
     *
     * @param pageNo
     */
    public void setPageNo(long pageNo) {
        this.pageNo = pageNo;

        if (pageNo < 1L) {
            this.pageNo = 1L;
        }
        getOffset();
    }

    /**
     * 获取每页数量
     *
     * @return
     */
    public long getPageSize() {
        return pageSize;
    }

    /**
     * 设置每页数量
     *
     * @param size
     */
    public void setPageSize(long size) {
        pageSize = size;
    }

    /**
     * 获取偏移量
     *
     * @return
     */
    public long getOffset() {
        this.offset = ((this.pageNo - 1L) * pageSize);
        return this.offset;
    }

    /**
     * 设置偏移量
     *
     * @param offset
     */
    public void setOffset(long offset) {
        this.offset = offset;
    }

    /**
     * 得到总数
     *
     * @return
     */
    public long getTotalCount() {
        return this.totalCount;
    }

    /**
     * 设置总数
     *
     * @param totalCount
     */
    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * 设置总页数
     *
     * @param totalPages
     */
    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
    }

    /**
     * 获取总页数
     *
     * @return
     */
    public long getTotalPages() {
        if (this.totalCount < 0L) {
            return -1L;
        }

        this.totalPages = (this.totalCount / pageSize);
        if (this.totalCount % pageSize > 0L) {
            this.totalPages += 1L;
        }
        return this.totalPages;
    }

    /**
     * 获取结果集
     *
     * @return
     */
    public List<T> getResult() {
        if (this.result == null) {
            return new ArrayList<T>();
        }
        return this.result;
    }

    /**
     * 设置结果集
     *
     * @param result
     */
    public void setResult(List<T> result) {
        this.result = result;
    }
}