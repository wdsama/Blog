package top.wdsama.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import top.wdsama.dao.UserDao;
import top.wdsama.domain.User;

import java.util.List;

/**
 * 类名：用户Dao
 *
 * 想要使用spring 支持的 hibernate 模板
 * 需要继承 HibernateDaoSupport
 * 并且 在spring 配置文件中 对当前 bean对象 注入 SessionFactory 属性
 *
 * 而 这个属性 在配置 hibernate 的时候交给了 spring 管理
 *
 * @Author wdsama
 * @Date 2019/11/9 19:22
 * @Version 1.0
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
    /**
     * 获取指定用户 如果有该用户 则通过登录 没有则返回空
     * @param username
     * @param password
     * @return
     */
    @Override
    public User getUser(String username, String password) {
        /**
         * 设置查询的表
         */
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(User.class);
        /**
         * 设置条件
         */
        detachedCriteria.add(Restrictions.eq("username",username));
        detachedCriteria.add(Restrictions.eq("password",password));
        /**
         * 进行查询 需要强制转换
         */
        List<User> userList = (List<User>)this.getHibernateTemplate().findByCriteria(detachedCriteria);
        if (userList.size()>0){
            return userList.get(0);
        }
        return null;

    }
}
