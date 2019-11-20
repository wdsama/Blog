package top.wdsama.dao;

import top.wdsama.domain.User;

/**
 * 类名：
 *
 * @Author wdsama
 * @Date 2019/11/9 19:22
 * @Version 1.0
 */
public interface UserDao {
    /**
     * 查询是否有该用户
     * @param username
     * @param password
     * @return
     */
    User getUser(String username,String password);
}
