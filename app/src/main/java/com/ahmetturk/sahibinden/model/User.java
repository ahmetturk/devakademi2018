package com.ahmetturk.sahibinden.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class User implements Parcelable {

    @SerializedName("id")
    public Integer id;
    @SerializedName("cityName")
    public String cityName;
    @SerializedName("education")
    public String education;
    @SerializedName("job")
    public String job;
    @SerializedName("martialStatus")
    public String martialStatus;
    @SerializedName("age")
    public Integer age;
    @SerializedName("gender")
    public String gender;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.cityName);
        dest.writeString(this.education);
        dest.writeString(this.job);
        dest.writeString(this.martialStatus);
        dest.writeValue(this.age);
        dest.writeString(this.gender);
    }

    protected User(Parcel in) {
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.cityName = in.readString();
        this.education = in.readString();
        this.job = in.readString();
        this.martialStatus = in.readString();
        this.age = (Integer) in.readValue(Integer.class.getClassLoader());
        this.gender = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}