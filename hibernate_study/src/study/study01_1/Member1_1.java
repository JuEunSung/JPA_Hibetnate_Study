package study.study01_1;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MEMBER")
public class Member1_1 implements Serializable {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="member_no")
  private Integer memberNo;

  @Column(unique=true, name="member_id")
  private String memberId;

  @Column(name="member_pw", nullable=false)
  private String memberPw;

  @Column(name="name", nullable=false)
  private String name;

  @Column(name="status", nullable=false)
  private String status;

  @Column(name="register_datetime")
  private String registerDatetime;

  public Member1_1() {}

  public Member1_1(String memberId, String memberPw, String name, String status) {

    this.memberId = memberId;
    this.memberPw = memberPw;
    this.name = name;
    this.status = status;
  }

  public Integer getMemberNo() {
    return memberNo;
  }
  public void setMemberNo(Integer memberNo) {
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
