package top.wdsama.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import top.wdsama.dao.ArticleDao;
import top.wdsama.domain.Article;

import java.util.List;

/**
 * 类名：
 *
 * @Author wdsama
 * @Date 2019/11/23 10:22
 * @Version 1.0
 */
public class ArticleDaoImpl extends HibernateDaoSupport implements ArticleDao {

    @Override
    public List<Article> list() {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Article.class);
        List<Article> list = (List<Article>)this.getHibernateTemplate().findByCriteria(detachedCriteria);
        return list;
    }

    @Override
    public Integer getTotalCount(DetachedCriteria detachedCriteria) {
        /*获取 Count*/
        DetachedCriteria detachedCriteria1 = detachedCriteria.setProjection(Projections.rowCount());
        /*查询的结果会放在集合里面*/
        List<Long> list = (List<Long>)this.getHibernateTemplate().findByCriteria(detachedCriteria);
        if (list.size()>0){
            /*进行类型转换*/
            return list.get(0).intValue();
        }
        return 0;
    }

    @Override
    public List<Article> getPageDate(DetachedCriteria detachedCriteria, Integer index, Integer pageSize) {
        /**
         * 因为用的查询条件是同一个 DetachedCriteria
         *  在查询总记录时  设置了  Projections.rowCount()
         *  所以在新的查询时  需要将 前面方法中设置的查询条件清空
         */
        detachedCriteria.setProjection(null);
        /*清空查询条件*/
        List<Article> list = (List<Article>)this.getHibernateTemplate().findByCriteria(detachedCriteria, index, pageSize);
        return list;
    }

    @Override
    public void delete(Article article) {
        this.getHibernateTemplate().delete(article);
    }
}
