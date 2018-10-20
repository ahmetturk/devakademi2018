package com.ahmetturk.sahibinden.filter;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class FilterUIModel implements Parcelable {

    private String edittextUIModel;

    private List<String> radiogroupUIModel;

    public FilterUIModel(String edittextUIModel, List<String> radiogroupUIModel) {
        this.edittextUIModel = edittextUIModel;
        this.radiogroupUIModel = radiogroupUIModel;
    }

    public String getEdittextUIModel() {
        return edittextUIModel;
    }

    public List<String> getRadiogroupUIModel() {
        return radiogroupUIModel;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.edittextUIModel);
        dest.writeStringList(this.radiogroupUIModel);
    }

    protected FilterUIModel(Parcel in) {
        this.edittextUIModel = in.readString();
        this.radiogroupUIModel = in.createStringArrayList();
    }

    public static final Creator<FilterUIModel> CREATOR = new Creator<FilterUIModel>() {
        @Override
        public FilterUIModel createFromParcel(Parcel source) {
            return new FilterUIModel(source);
        }

        @Override
        public FilterUIModel[] newArray(int size) {
            return new FilterUIModel[size];
        }
    };
}
