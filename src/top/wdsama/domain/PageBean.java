package top.wdsama.domain;

import lombok.Data;

import java.util.List;

/**
 * 类名：分页包装类
 *
 * @Author wdsama
 * @Date 2019/11/24 13:18
 * @Version 1.0
 */
@Data
public class PageBean<T> {
    /**
     * 当前页
     */
    private Integer currentPage;
    /**
     * 一条有多少数据
     */
    private Integer pageSize;
    /**
     * 当前角标
     */
    private Integer index;
    /**
     * 总记录数
     */
    private Integer totalCount;
    /**
     * 总页数
     */
    private Integer totalPage;
    /**
     * 当前页的数据
     */
    private List<T> list;
    /**
     * 如果当前页没有设置，默认设置为第一页
     */
    public void  setCurrentPage(Integer currentPage){
        if (currentPage==null){
            currentPage = 1;
        }
        this.currentPage = currentPage;
    }
    /**
     * 如果没有设置当前页总记录数据，设置默认记录为一页5条
     */
    public void setPageSize(Integer pageSize){
        if (pageSize==null){
            pageSize = 5;
        }
        this.pageSize = pageSize;
    }
    /**
     * 计算当前页从数据库当中查询的位置
     */
    public Integer getIndex(){
        return (currentPage-1)*pageSize;
    }
    /**
     * 计算总页数
     */
    public Integer getTotalPage(){
        double ceil = Math.ceil(totalCount * 1.0 / pageSize);
        return (int)ceil;
    }
}
