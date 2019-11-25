package top.wdsama.service.impl;

import lombok.Setter;
import org.hibernate.criterion.DetachedCriteria;
import top.wdsama.dao.ArticleDao;
import top.wdsama.domain.Article;
import top.wdsama.domain.PageBean;
import top.wdsama.service.ArticleService;

import java.util.List;

/**
 * 类名：
 *
 * @Author wdsama
 * @Date 2019/11/23 10:21
 * @Version 1.0
 */
public class ArticleServiceImpl implements ArticleService {
    @Setter
    private ArticleDao articleDao;
    @Override
    public List<Article> list() {
        return articleDao.list();
    }

    @Override
    public PageBean getPageData(DetachedCriteria detachedCriteria, Integer currPage, int pageSize) {
        PageBean<Article> articlePageBean = new PageBean<>();
        /*设置当前页*/
        articlePageBean.setCurrentPage(currPage);
        /*设置一页有多少条数据*/
        articlePageBean.setPageSize(pageSize);
        /*获取总记录数*/
        Integer totalCount = articleDao.getTotalCount(detachedCriteria);
        /*设置总记录数*/
        articlePageBean.setTotalCount(totalCount);
        /*设置总页数*/
        /*调用 PageBean 的总页数计算方法获取总页数*/
        articlePageBean.setTotalPage(articlePageBean.getTotalPage());
        /*获取当前页数据*/
        /*数据库查询*/
        List<Article> list = articleDao.getPageDate(detachedCriteria,articlePageBean.getIndex(),articlePageBean.getPageSize());
        /*计算*/
        articlePageBean.setList(list);
        System.out.println(articlePageBean);
        return articlePageBean;
    }
}
