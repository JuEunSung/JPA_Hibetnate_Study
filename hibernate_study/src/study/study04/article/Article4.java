package study.study04.article;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import study.study04.comments.Comments4;
import study.study04.member.Member4;

@Entity
@Table(name="ARTICLE")
public class Article4 {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="article_no")
  private int articleNo;

  private String title;
  private String contents;

  @Enumerated(EnumType.STRING)
  private ArticleStatus status;

  private int hits;
  private int likes;

  @Column(name="register_datetime")
  @Temporal(TemporalType.TIMESTAMP)
  private Date registerDatetime;

  /**
   * Entity Mapping
   */
  @ManyToOne
  @JoinColumn(name="member_no")
  private Member4 member;

  @OneToMany(targetEntity=Comments4.class, mappedBy="article")
  @OrderBy("register_datetime DESC")
  private List<Comments4> commentsList;

  public Article4() { }

  public Article4(String title, String contents, ArticleStatus status) {
    this.title = title;
    this.contents = contents;
    this.status = status;
  }

  public int getArticleNo() {
    return articleNo;
  }
  public void setArticleNo(int articleNo) {
    this.articleNo = articleNo;
  }
  public Member4 getMember() {
    return member;
  }
  public void setMember(Member4 member) {
    this.member = member;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getContents() {
    return contents;
  }
  public void setContents(String contents) {
    this.contents = contents;
  }
  public ArticleStatus getStatus() {
    return status;
  }
  public void setStatus(ArticleStatus status) {
    this.status = status;
  }
  public int getHits() {
    return hits;
  }
  public void setHits(int hits) {
    this.hits = hits;
  }
  public int getLikes() {
    return likes;
  }
  public void setLikes(int likes) {
    this.likes = likes;
  }
  public Date getRegisterDatetime() {
    return registerDatetime;
  }
  public void setRegisterDatetime(Date registerDatetime) {
    this.registerDatetime = registerDatetime;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Article4 other = (Article4) obj;
    if (articleNo != other.articleNo)
      return false;
    if (contents == null) {
      if (other.contents != null)
        return false;
    } else if (!contents.equals(other.contents))
      return false;
    if (hits != other.hits)
      return false;
    if (likes != other.likes)
      return false;
    if (member == null) {
      if (other.member != null)
        return false;
    } else if (!member.equals(other.member))
      return false;
    if (registerDatetime == null) {
      if (other.registerDatetime != null)
        return false;
    } else if (!registerDatetime.equals(other.registerDatetime))
      return false;
    if (status != other.status)
      return false;
    if (title == null) {
      if (other.title != null)
        return false;
    } else if (!title.equals(other.title))
      return false;
    return true;
  }
}
