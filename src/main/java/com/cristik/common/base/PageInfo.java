package com.cristik.common.base;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * Created by zhenghua on 2016/4/20.
 */
public class PageInfo {

    private Integer start;

    private Integer length;

    private Integer draw;

    private Integer recordsTotal;

    private Integer recordsFiltered;

    private Integer pageNum;

    private Integer pageSize;

    private List<Object> data;

    private Object param;

    private Long total;

    private Integer totalPage;



    public PageInfo(){
        if(pageNum==null){
            pageNum = 1;
        }
        if(pageSize==null){
            pageSize= 10;
        }
    }

    public PageInfo(Integer start, Integer length,Integer draw) {
        this.pageNum = (int)Math.floor(start/length+1);
        this.pageSize = length;
        this.draw = draw;
    }

    public Object getParam() {
        return param;
    }

    public void setParam(Object param) {
        this.param = param;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getRecordsFiltered() {
        return this.recordsFiltered;
    }

    public void setRecordsFiltered(Integer recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public Integer getRecordsTotal() {
        return this.recordsTotal;
    }

    public void setRecordsTotal(Integer recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "data=" + data +
                ", start=" + start +
                ", length=" + length +
                ", draw=" + draw +
                ", recordsTotal=" + recordsTotal +
                ", recordsFiltered=" + recordsFiltered +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", param=" + param +
                ", total=" + total +
                ", totalPage=" + totalPage +
                '}';
    }

    public String toJSONString(){
        return JSONObject.toJSONString(this);
    }
}
