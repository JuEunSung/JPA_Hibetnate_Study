package study.study03;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="ARTICLE")
public class Article3 {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="article_no")
  private int articleNo;

  @ManyToOne
  @JoinColumn(name="member_no")
  private Member3 member;

  private String title;
  private String contents;

  @Enumerated(EnumType.STRING)
  private ArticleStatus status;

  private int hits;
  private int likes;

  @Column(name="register_datetime")
  @Temporal(TemporalType.TIMESTAMP)
  private Date registerDatetime;

  public Article3() { }
  public Article3(String title, String contents, ArticleStatus status) {
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
  public Member3 getMember() {
    return member;
  }
  public void setMember(Member3 member) {
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
  public String toString() {
    return "Article [articleNo=" + articleNo + ", title=" + title
        + ", contents=" + contents + ", status=" + status + ", hits=" + hits + ", likes=" + likes
        + ", registerDatetime=" + registerDatetime + "]";
  }
}
