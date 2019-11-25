package top.wdsama.web;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import lombok.Setter;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.apache.struts2.ServletActionContext;
import top.wdsama.domain.Category;
import top.wdsama.service.CategoryService;

import java.io.IOException;
import java.util.List;

/**
 * 类名：
 *
 * @Author wdsama
 * @Date 2019/11/15 0:28
 * @Version 1.0
 */
public class CategoryAction extends ActionSupport implements ModelDriven<Category> {
    @Setter
    private CategoryService categoryService;

    private Category category = new Category();
    @Override
    public Category getModel() {
        return category;
    }

    public String add(){
        categoryService.save(category);
        return "listAction";
    }

    public String list(){
        List<Category> list = categoryService.getAllCategory();
        System.out.println(list);
        ActionContext.getContext().getValueStack().set("CategoryList",list);
        return "list";
    }

    /**
     * Ajax 获取单条 category（分类）
     * @return
     */
    public String updateUI(){
        Long cid = category.getCid();
        Category category = categoryService.getOneCategory(cid);
        System.out.println(category);
        /**
         * 以json(数据格式)响应给前端页面
         */
        JSONArray jsonArray = JSONArray.fromObject(category, new JsonConfig());
        System.out.println(jsonArray);
        ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
        try {
            ServletActionContext.getResponse().getWriter().println(jsonArray.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String update(){
        categoryService.update(category);
        return "listAction";
    }

    public String delete(){
        categoryService.delete(category);
        return "listAction";
    }
}
