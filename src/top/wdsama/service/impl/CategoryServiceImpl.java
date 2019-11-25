package top.wdsama.service.impl;

import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;
import top.wdsama.dao.CategoryDao;
import top.wdsama.domain.Category;
import top.wdsama.service.CategoryService;

import java.util.List;

/**
 * 类名：
 *
 * @Author wdsama
 * @Date 2019/11/17 8:54
 * @Version 1.0
 */
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Setter
    private CategoryDao  categoryDao;

    @Override
    public void save(Category category) {
        categoryDao.save(category);
    }

    @Override
    public List<Category> getAllCategory() {
        List<Category> list = categoryDao.getAllCategory();
        return list;
    }

    @Override
    public Category getOneCategory(Long id) {
        Category category = categoryDao.getOneCategory(id);
        return category;
    }

    @Override
    public void update(Category category) {
        categoryDao.update(category);
    }

    @Override
    public void delete(Category category) {

        categoryDao.delete(category);
    }
}
