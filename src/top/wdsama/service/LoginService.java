package top.wdsama.service;

import top.wdsama.domain.User;

/**
 * 类名：
 *
 * @Author wdsama
 * @Date 2019/11/9 19:12
 * @Version 1.0
 */
public interface LoginService {
    /**
     * 用户登录
     * @param user
     */
    User login(User user);
}
