package top.wdsama.service;

import org.hibernate.criterion.DetachedCriteria;
import top.wdsama.domain.Article;
import top.wdsama.domain.PageBean;

import java.util.List;

/**
 * 类名：
 *
 * @Author wdsama
 * @Date 2019/11/23 10:19
 * @Version 1.0
 */
public interface ArticleService {
    /**
     * 查询所有文章
     */
    public   List<Article> list();

    /**
     * 分页查询
     * @param detachedCriteria
     * @param currPage
     * @param pageSize
     * @return
     */
    PageBean getPageData(DetachedCriteria detachedCriteria, Integer currPage, int pageSize);

    /**
     * 删除
     * @param article
     */
    void delete(Article article);
}
