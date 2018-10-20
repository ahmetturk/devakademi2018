package com.ahmetturk.sahibinden.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.ahmetturk.sahibinden.model.User;

import java.util.List;

public class FilterViewModel extends ViewModel {

    private MutableLiveData<List<User>> users;

    public List<User> getUsers() {
        if (users == null) {
            users = new MutableLiveData<>();
        }
        return users.getValue();
    }

    public void setUsers(List<User> userList) {
        if (users == null) {
            users = new MutableLiveData<>();
        }
        users.setValue(userList);
    }
}
