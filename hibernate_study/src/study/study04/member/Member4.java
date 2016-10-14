package study.study04.member;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import study.study03_3.article.Article3_3;
import study.study04.comments.Comments4;
import study.study04.memberdetail.MemberDetail4;

@Entity
@Table(name="MEMBER")
public class Member4 {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="member_no")
  private int memberNo;

  @Column(unique=true, name="member_id")
  private String memberId;

  @Column(name="member_pw")
  private String memberPw;

  private String name;

  @Enumerated(EnumType.STRING)
  private MemberStatus status;

  @Column(name="register_datetime")
  @Temporal(TemporalType.TIMESTAMP)
  private Date registerDatetime;

  /**
   * Entity Mapping
   */
  @OneToMany(targetEntity=Article3_3.class, mappedBy="member")
  @OrderBy("article_no DESC")
  private List<Article3_3> articleList;

  @OneToOne(mappedBy="member")
  private MemberDetail4 memberDetail;

  @OneToMany(targetEntity=Comments4.class, mappedBy="member")
  @OrderBy("register_datetime DESC")
  private List<Comments4> contentsList;

  public Member4() {}

  public Member4(String memberId, String memberPw, String name, MemberStatus status) {

    this.memberId = memberId;
    this.memberPw = memberPw;
    this.name = name;
    this.status = status;
  }

  public int getMemberNo() {
    return memberNo;
  }
  public void setMemberNo(int memberNo) {
    this.memberNo = memberNo;
  }
  public String getMemberId() {
    return memberId;
  }
  public void setMemberId(String memberId) {
    this.memberId = memberId;
  }
  public String getMemberPw() {
    return memberPw;
  }
  public void setMemberPw(String memberPw) {
    this.memberPw = memberPw;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public MemberStatus getStatus() {
    return status;
  }
  public void setStatus(MemberStatus status) {
    this.status = status;
  }
  public Date getRegisterDatetime() {
    return registerDatetime;
  }
  public void setRegisterDatetime(Date registerDatetime) {
    this.registerDatetime = registerDatetime;
  }
  public List<Article3_3> getArticleList() {
    return articleList;
  }
  public void setArticleList(List<Article3_3> articleList) {
    this.articleList = articleList;
  }
  public MemberDetail4 getMemberDetail() {
    return memberDetail;
  }
  public void setMemberDetail(MemberDetail4 memberDetail) {
    this.memberDetail = memberDetail;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Member4 other = (Member4) obj;
    if (articleList == null) {
      if (other.articleList != null)
        return false;
    } else if (!articleList.equals(other.articleList))
      return false;
    if (memberDetail == null) {
      if (other.memberDetail != null)
        return false;
    } else if (!memberDetail.equals(other.memberDetail))
      return false;
    if (memberId == null) {
      if (other.memberId != null)
        return false;
    } else if (!memberId.equals(other.memberId))
      return false;
    if (memberNo != other.memberNo)
      return false;
    if (memberPw == null) {
      if (other.memberPw != null)
        return false;
    } else if (!memberPw.equals(other.memberPw))
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (registerDatetime == null) {
      if (other.registerDatetime != null)
        return false;
    } else if (!registerDatetime.equals(other.registerDatetime))
      return false;
    if (status != other.status)
      return false;
    return true;
  }
}
