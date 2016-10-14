package study.study04.comments;

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

import study.study04.article.Article4;
import study.study04.member.Member4;

@Entity
@Table(name="COMMENTS")
public class Comments4 {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="comments_no")
  private int commentsNo;

  private String contents;

  @Enumerated(EnumType.STRING)
  private CommentsStatus status;
  private int likes;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="register_date")
  private Date registerDate;

  /**
   * Entity Mapping
   */
  @ManyToOne
  @JoinColumn(name="article_no")
  private Article4 article;

  @ManyToOne
  @JoinColumn(name="member_no")
  private Member4 member;

  public Comments4() { }

  public Comments4(String contents, CommentsStatus status) {
    this.contents = contents;
    this.status = status;
  }

  public int getCommentsNo() {
    return commentsNo;
  }
  public void setCommentsNo(int commentsNo) {
    this.commentsNo = commentsNo;
  }
  public String getContents() {
    return contents;
  }
  public void setContents(String contents) {
    this.contents = contents;
  }
  public CommentsStatus getStatus() {
    return status;
  }
  public void setStatus(CommentsStatus status) {
    this.status = status;
  }
  public int getLikes() {
    return likes;
  }
  public void setLikes(int likes) {
    this.likes = likes;
  }
  public Date getRegisterDate() {
    return registerDate;
  }
  public void setRegisterDate(Date registerDate) {
    this.registerDate = registerDate;
  }
  public Article4 getArticle() {
    return article;
  }
  public void setArticle(Article4 article) {
    this.article = article;
  }
  public Member4 getMember() {
    return member;
  }
  public void setMember(Member4 member) {
    this.member = member;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Comments4 other = (Comments4) obj;
    if (article == null) {
      if (other.article != null)
        return false;
    } else if (!article.equals(other.article))
      return false;
    if (commentsNo != other.commentsNo)
      return false;
    if (contents == null) {
      if (other.contents != null)
        return false;
    } else if (!contents.equals(other.contents))
      return false;
    if (likes != other.likes)
      return false;
    if (member == null) {
      if (other.member != null)
        return false;
    } else if (!member.equals(other.member))
      return false;
    if (registerDate == null) {
      if (other.registerDate != null)
        return false;
    } else if (!registerDate.equals(other.registerDate))
      return false;
    if (status != other.status)
      return false;
    return true;
  }
}
