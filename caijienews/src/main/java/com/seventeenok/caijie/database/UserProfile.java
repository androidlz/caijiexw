package com.seventeenok.caijie.database;

import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.query.QueryBuilder;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ShiQing on 2018/3/7 0007 09:05
 * Desc:
 */

@Entity(nameInDb = "user_db")
public class UserProfile implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @SerializedName("userId")
    private long userId = 0;
    @SerializedName("token")
    private String token = null;
    @SerializedName("name")
    private String name = null;
    @SerializedName("head")
    private String head = null;
    @SerializedName("phone")
    private String phone = null;
    @Generated(hash = 1212845646)
    public UserProfile(long userId, String token, String name, String head,
            String phone) {
        this.userId = userId;
        this.token = token;
        this.name = name;
        this.head = head;
        this.phone = phone;
    }
    @Generated(hash = 968487393)
    public UserProfile() {
    }
    public long getUserId() {
        return this.userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }
    public String getToken() {
        return this.token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getHead() {
        return this.head;
    }
    public void setHead(String head) {
        this.head = head;
    }
    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public static UserProfile getUserProfile() {
        QueryBuilder<UserProfile> userProfileQueryBuilder = DatabaseManager.getInstance().getDao().queryBuilder();
        List<UserProfile> list = userProfileQueryBuilder.list();
        UserProfile userProfile = null;
        if (list.size() > 0) {
            userProfile = list.get(0);
        }
        return userProfile;
    }
}
