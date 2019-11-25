package top.wdsama.web;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import lombok.Setter;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import top.wdsama.domain.Article;
import top.wdsama.domain.PageBean;
import top.wdsama.service.ArticleService;

import java.util.List;
import java.util.Objects;

/**
 * 类名：
 *
 * @Author wdsama
 * @Date 2019/11/23 10:13
 * @Version 1.0
 */
public class ArticleAction extends ActionSupport implements ModelDriven<Article> {

    private Article article = new Article();

    @Override
    public Article getModel() {
        return article;
    }

    @Setter
    private ArticleService articleService;

    public String list() {
        List<Article> list = articleService.list();
        ActionContext.getContext().getValueStack().set("Article", list);
        return "list";
    }

    /**
     * 分页查询
     */
    @Setter
    private Integer currPage;
    @Setter
    private String keyWord;
    public String pageList() {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Article.class);
        if (!Objects.isNull(keyWord)){
            detachedCriteria.add(Restrictions.like("articleTitle","%"+keyWord+"%"));
        }
        PageBean pageBean = articleService.getPageData(detachedCriteria, currPage, 5);
        ActionContext.getContext().getValueStack().push(pageBean);
        return "list";
    }
}
