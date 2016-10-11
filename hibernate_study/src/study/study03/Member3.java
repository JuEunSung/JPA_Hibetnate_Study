package study.study03;

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
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="MEMBER")
public class Member3 {

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
   * 연관 관계 매핑
   */
  @OneToMany(targetEntity=Article3.class, mappedBy="member")
  @OrderBy("article_no DESC")
  private List<Article3> articleList;

  public Member3() {}
  

  public Member3(String memberId, String memberPw, String name, MemberStatus status) {

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
  public List<Article3> getArticleList() {
    return articleList;
  }
  public void setArticleList(List<Article3> articleList) {
    this.articleList = articleList;
  }

  @Override
  public String toString() {
    return "Member [memberNo=" + memberNo + ", memberId=" + memberId + ", memberPw=" + memberPw
        + ", name=" + name + ", status=" + status.name() + ", registerDatetime="
        + registerDatetime + "]";
  }
}
