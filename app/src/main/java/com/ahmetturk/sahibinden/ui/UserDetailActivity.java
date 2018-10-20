package com.ahmetturk.sahibinden.ui;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ahmetturk.sahibinden.R;
import com.ahmetturk.sahibinden.databinding.ActivityUserDetailBinding;
import com.ahmetturk.sahibinden.model.User;

public class UserDetailActivity extends AppCompatActivity {

    private static final String KEY_USER = "user";

    public static Intent newIntent(Context context, User user) {
        final Intent intent = new Intent(context, UserDetailActivity.class);
        intent.putExtra(KEY_USER, user);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityUserDetailBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_user_detail);

        final User user = getIntent().getParcelableExtra(KEY_USER);

        binding.setUser(user);
    }
}
