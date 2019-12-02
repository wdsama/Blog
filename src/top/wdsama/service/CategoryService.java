package top.wdsama.service;

import top.wdsama.domain.Category;

import java.util.List;

/**
 * 类名：分类管理
 *
 * @Author wdsama
 * @Date 2019/11/17 8:53
 * @Version 1.0
 */
public interface CategoryService {
    /**
     * 新增 分类
     * @param category
     */
    void save(Category category);

    /**
     * 查询所有分类列表
     * @return
     */
    List<Category> getAllCategory();

    /**
     * 获取单条 Category
     * @return
     */
    Category getOneCategory(Long id);

    /**
     * 更新分类
     * @param category
     */
    void update(Category category);

    /**
     * 删除一条分类
     * @param category
     */
    void delete(Category category);

    /**
     * 添加 文章 时 异步查询分类
     * @param pId
     * @return
     */
    List<Category> getCategory(Long pId);

}
