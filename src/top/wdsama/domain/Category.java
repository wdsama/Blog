package top.wdsama.domain;

import lombok.Data;

/**
 * 类名：
 *
 * @Author wdsama
 * @Date 2019/11/11 19:41
 * @Version 1.0
 */
@Data
public class Category {

    private Long cid;

    private String cname;

    private Long parentId;


}
