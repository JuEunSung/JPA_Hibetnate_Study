package study.study01;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MEMBER")
public class Member1 {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="member_no")
  private int memberNo;

  @Column(unique=true, name="member_id", nullable=false)
  private String memberId;

  @Column(name="member_pw", nullable=false)
  private String memberPw;

  @Column(name="name", nullable=false)
  private String name;

  @Column(name="status", nullable=false)
  private String status;

  @Column(name="register_datetime")
  private String registerDatetime;

  public Member1() {}

  public Member1(String memberId, String memberPw, String name, String status) {

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
  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }
  public String getRegisterDatetime() {
    return registerDatetime;
  }
  public void setRegisterDatetime(String registerDatetime) {
    this.registerDatetime = registerDatetime;
  }

  @Override
  public String toString() {
    return "Member [memberNo=" + memberNo + ", memberId=" + memberId + ", memberPw=" + memberPw
        + ", name=" + name + ", status=" + status + ", registerDatetime="
        + registerDatetime + "]";
  }
}
