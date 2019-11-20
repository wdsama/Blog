package top.wdsama.service.impl;

import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;
import top.wdsama.dao.UserDao;
import top.wdsama.domain.User;
import top.wdsama.service.LoginService;

/**
 * 类名：
 *
 * @Author wdsama
 * @Date 2019/11/9 19:13
 * @Version 1.0
 */
@Transactional
public class LoginServiceImpl implements LoginService {
    @Setter
    private UserDao userDao;
    @Override
    public User login(User user) {

        User resUser = userDao.getUser(user.getUsername(), user.getPassword());
        return resUser;
    }
}
