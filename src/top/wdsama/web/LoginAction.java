package top.wdsama.web;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import lombok.Setter;
import top.wdsama.domain.User;
import top.wdsama.service.LoginService;

/**
 * 类名：
 *
 * @Author wdsama
 * @Date 2019/11/9 18:44
 * @Version 1.0
 */
public class LoginAction extends ActionSupport implements ModelDriven<User> {
    /**
     * 为 ModelDriven 提供接收参数的对象
     */
    public User user = new User();

    @Override
    public User getModel() {
        return user;
    }

    /**
     * 用于Spring属性注入
     */
    @Setter
    private LoginService loginService;

    /**
     * 登录
     * @return
     */
    public String login() {
        User resUser = loginService.login(user);
        if (resUser==null){
            this.addActionError("账号或密码错误");
            return LOGIN;
        }else {
            ActionContext.getContext().getSession().put("curUser",resUser);
            return SUCCESS;
        }
    }

    /**
     * 退出
     * @return
     */
    public String loginOut(){
        ActionContext.getContext().getSession().remove("curUser");
        return "loginOut";
    }

}
