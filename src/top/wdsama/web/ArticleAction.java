package top.wdsama.web;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import lombok.Setter;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import top.wdsama.domain.Article;
import top.wdsama.domain.PageBean;
import top.wdsama.service.ArticleService;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

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

    /**
     * 删除
     */
    @Setter
    private Long id;
    public String delete(){
        Article article = new Article();
        article.setArticleId(id);
        articleService.delete(article);
        return "delete";
    }

    /**
     * 添加文章
     * @return
     */
    @Setter
    private String uploadFileName;
    @Setter
    private File upload;
    @Setter
    private String uploadContentType;
    public String add() throws IOException {

        if (upload!=null){
            /*文件上传*/
            /*设置文件上传路径*/
            String realPath = ServletActionContext.getServletContext().getRealPath("/upload");

            /*获取文件拓展名*/
            int index = uploadFileName.lastIndexOf(".");
            String etx = uploadFileName.substring(index);
            /*随机生成文件名 防止重复*/
            String uuidFileName = UUID.randomUUID().toString().replace("-","")+etx;
            System.out.println(uuidFileName);
            File file = new File(realPath);
            if (!file.exists()){
                file.mkdirs();
            }

            File newFile = new File(realPath + "/" + uuidFileName);
            FileUtils.copyFile(upload,newFile);
        }

        return null;
    }
}
