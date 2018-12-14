package com.checkin.app.checkin.Shop.RecentCheckin.Model;

import android.text.format.Time;

import com.checkin.app.checkin.Misc.BriefModel;
import com.checkin.app.checkin.User.UserModel;
import com.checkin.app.checkin.Utility.Util;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

import javax.annotation.Nullable;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
public class UserCheckinModel {
    @JsonProperty("checkin_date")
    private Date checkinTime;

    @JsonProperty("gender")
    private UserModel.GENDER gender;

    @JsonProperty("is_active")
    private Boolean isActive;

    @JsonProperty("user")
    private BriefModel userInfo;

    public UserCheckinModel() {
    }

    public UserCheckinModel(Date checkinDate, UserModel.GENDER gender, Boolean isActive, BriefModel userInfo) {
        checkinTime = checkinTime;
        this.gender = gender;
        isActive = isActive;
        userInfo = userInfo;
    }

    public Date getCheckinTime() {
        return checkinTime;
    }

    public String formatCheckinTime() {
        return Util.formatDateTo24HoursTime(checkinTime);
    }

    public UserModel.GENDER getGender() {
        return gender;
    }

    @JsonProperty("gender")
    public char getGenderTag() {
        return gender.tag;
    }

    @JsonProperty("gender")
    public void setGender(char tag) {
        this.gender = UserModel.GENDER.getByTag(tag);
    }

    public Boolean isActive() {
        return isActive;
    }

    public BriefModel getUserInfo() {
        return userInfo;
    }

    public boolean isAnonymous() {
        return userInfo == null;
    }
}
