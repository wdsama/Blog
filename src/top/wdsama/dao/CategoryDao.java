package top.wdsama.dao;

import top.wdsama.domain.Category;

import java.util.List;

/**
 * 类名：分类管理
 *
 * @Author wdsama
 * @Date 2019/11/17 8:54
 * @Version 1.0
 */
public interface CategoryDao {
    /**
     * 新增 分类
     */
    void save(Category category);

    /**
     * 查询所有分类
     * @return
     */
    List<Category> getAllCategory();

    /**
     * 查询单条 category（分类）
     * @param id
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
     * 添加文章时 异步查询 分类
     * @param pId
     * @return
     */
    List<Category> getCategory(Long pId);
}
