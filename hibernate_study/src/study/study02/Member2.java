package study.study02;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="MEMBER")
public class Member2 {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="member_no")
  private int memberNo;

  @Column(unique=true, name="member_id")
  private String memberId;

  @Column(name="member_pw")
  private String memberPw;

  @Column(name="name")
  private String name;

  @Column(name="status")
  @Enumerated(EnumType.STRING)
  private Status status;

  @Column(name="register_datetime")
  @Temporal(TemporalType.TIMESTAMP)
  private Date registerDatetime;

  public Member2() {}

  public Member2(String memberId, String memberPw, String name, Status status) {

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
  public Status getStatus() {
    return status;
  }
  public void setStatus(Status status) {
    this.status = status;
  }
  public Date getRegisterDatetime() {
    return registerDatetime;
  }
  public void setRegisterDatetime(Date registerDatetime) {
    this.registerDatetime = registerDatetime;
  }

  @Override
  public String toString() {
    return "Member [memberNo=" + memberNo + ", memberId=" + memberId + ", memberPw=" + memberPw
        + ", name=" + name + ", status=" + status.name() + ", registerDatetime="
        + registerDatetime + "]";
  }
}
