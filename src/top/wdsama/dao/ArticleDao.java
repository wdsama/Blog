package top.wdsama.dao;

import org.hibernate.criterion.DetachedCriteria;
import top.wdsama.domain.Article;

import java.util.List;

/**
 * 类名：
 *
 * @Author wdsama
 * @Date 2019/11/23 10:21
 * @Version 1.0
 */
public interface ArticleDao {
    /**
     * 查询所有文章
     * @return
     */
    List<Article> list();

    /**
     * 获取总记录数
     * @param detachedCriteria
     * @return
     */
    Integer getTotalCount(DetachedCriteria detachedCriteria);

    /**
     * 分页查询数据
     * @param detachedCriteria
     * @param index
     * @param pageSize
     * @return
     */
    List<Article> getPageDate(DetachedCriteria detachedCriteria, Integer index, Integer pageSize);
}
