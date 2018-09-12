package com.ikats.scheduler.entity.common;

import java.io.Serializable;

public class Page implements Serializable
{
    private static final long serialVersionUID = -1L;

    /** 当前页码，默认为1 */
    private Integer pageNum    = 1;

    /** 每页显示数据数量，默认10 */
    private Integer pageSize   = 10;

    /** 总记录数 */
    private Long  totalCount = 0L;

    /** 总页数 */
    private Integer totalPage  = 0;

    private Long offset  = 0L;

    /** 页码: 上一页 */
  //  private Integer prevPage   = 0;

    /** 页码: 下一页 */
  //  private Integer nextPage   = 0;


    /** 开始行数 */
 //   private Integer startRow   = 0;

    /** 结束行数 */
 //   private Integer endRow     = 0;

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

    public Long getTotalCount()
    {
        return totalCount;
    }

    public void setTotalCount(Long totalCount)
    {
        this.totalCount = totalCount;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Long getOffset() {
        return offset;
    }

    public void setOffset(Long offset)
    {
        this.offset = offset;
    }

    /*
    public Integer getPrevPage() {
        return prevPage;
    }

    public void setPrevPage(Integer prevPage) {
        this.prevPage = prevPage;
    }

    public Integer getNextPage() {
        return nextPage;
    }

    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }


    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getStartRow() {
        return startRow;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }

    public Integer getEndRow() {
        return endRow;
    }

    public void setEndRow(Integer endRow) {
        this.endRow = endRow;
    }*/
}
