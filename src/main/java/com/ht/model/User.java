package com.ht.model;
;
import java.util.Date;
import javax.persistence.*;

@Entity(name = "SYSTEM_USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID", nullable = false, length = 12)
    private int userId;
    @Column(name = "USER_NAME", nullable = false, length = 128)
    private String userName;
    @Column(name = "USER_TELEPHONE", length = 15)
    private Long telePhone;
    @Column(name = "USER_EMAIL", length = 128)
    private String email;

    @Column(name = "ADDRESS", length = 128)
    private String fAddress;

    @Column(name = "USER_TYPE", length = 2)
    private String userType;

    @Column(name = "TEAM_ID", length = 2)
    private String teamId;

    @Column(name = "SEX", length = 1)
    private String sex;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getTelePhone() {
        return telePhone;
    }

    public void setTelePhone(Long telePhone) {
        this.telePhone = telePhone;
    }

    public String getfAddress() {
        return fAddress;
    }

    public void setfAddress(String fAddress) {
        this.fAddress = fAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
