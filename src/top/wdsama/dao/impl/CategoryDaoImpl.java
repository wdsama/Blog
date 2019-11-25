package top.wdsama.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import top.wdsama.dao.CategoryDao;
import top.wdsama.domain.Category;

import java.util.List;

/**
 * 类名：
 *
 * @Author wdsama
 * @Date 2019/11/17 8:55
 * @Version 1.0
 */
public class CategoryDaoImpl extends HibernateDaoSupport implements CategoryDao {

    @Override
    public void save(Category category) {
        this.getHibernateTemplate().save(category);
    }

    @Override
    public List<Category> getAllCategory() {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Category.class);
        List<Category> categoryList = (List<Category>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
        return categoryList;
    }

    @Override
    public Category getOneCategory(Long id) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Category.class);
        detachedCriteria.add(Restrictions.eq("cid", id));
        List<Category> categoryList = (List<Category>) this.getHibernateTemplate().findByCriteria(detachedCriteria);

        if (categoryList.size() > 0) {
            return categoryList.get(0);
        } else {
            return null;
        }
    }

    @Override
    public void update(Category category) {
        this.getHibernateTemplate().update(category);
    }

    @Override
    public void delete(Category category) {
        this.getHibernateTemplate().delete(category);
    }
}
