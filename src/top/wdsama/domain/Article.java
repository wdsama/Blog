package top.wdsama.domain;

import lombok.Data;


/**
 * @author wdsama
 */
@Data
public class Article {

  /**
   * 文章id
   */
  private Long articleId;
  /**
   * 文章标题
   */
  private String articleTitle;
  /**
   * 文章内容
   */
  private String articleContent;
  /**
   * 发布时间
   */
  private Long articleTime;
  /**
   * 文章图片
   */
  private String articlePic;
  /**
   * 文章描述
   */
  private String articleDesc;
  /**
   * 分类id
   */
  private Category category;

}
