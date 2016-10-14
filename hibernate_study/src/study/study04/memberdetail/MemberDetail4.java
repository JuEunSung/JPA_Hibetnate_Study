package study.study04.memberdetail;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import study.study04.member.Member4;

@Entity
@Table(name="MEMBER_DETAIL")
public class MemberDetail4 {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="member_detail_no")
  private int memberDetailNo;

  @Column(name="phone_number")
  private String phoneNumber;

  @Column(name="email_address")
  private String emailAddress;

  @OneToOne
  @JoinColumn(name="memberNo")
  private Member4 member;

  public MemberDetail4() {}

  public MemberDetail4(String phoneNumber, String emailAddress) {
    this.phoneNumber = phoneNumber;
    this.emailAddress = emailAddress;
  }

  public int getMemberDetailNo() {
    return memberDetailNo;
  }
  public void setMemberDetailNo(int memberDetailNo) {
    this.memberDetailNo = memberDetailNo;
  }
  public String getPhoneNumber() {
    return phoneNumber;
  }
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
  public String getEmailAddress() {
    return emailAddress;
  }
  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
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
    MemberDetail4 other = (MemberDetail4) obj;
    if (emailAddress == null) {
      if (other.emailAddress != null)
        return false;
    } else if (!emailAddress.equals(other.emailAddress))
      return false;
    if (member == null) {
      if (other.member != null)
        return false;
    } else if (!member.equals(other.member))
      return false;
    if (memberDetailNo != other.memberDetailNo)
      return false;
    if (phoneNumber == null) {
      if (other.phoneNumber != null)
        return false;
    } else if (!phoneNumber.equals(other.phoneNumber))
      return false;
    return true;
  }
}
