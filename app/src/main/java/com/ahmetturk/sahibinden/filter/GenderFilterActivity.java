package com.ahmetturk.sahibinden.filter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.View;

import com.ahmetturk.sahibinden.R;
import com.ahmetturk.sahibinden.model.User;
import com.ahmetturk.sahibinden.ui.UserListFragment;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GenderFilterActivity extends BaseFilterActivity {

    public static Intent newIntent(Context context, FilterUIModel uiModel) {
        final Intent intent = new Intent(context, GenderFilterActivity.class);
        intent.putExtra(KEY_UIMODEL, uiModel);
        return intent;
    }

    @Override
    public void openFilteredResult(@Nullable String enteredText, @Nullable Integer selectedIndex) {
        if (selectedIndex != null) {
            progressBar.setVisibility(View.VISIBLE);

            String gender;

            switch (selectedIndex) {
                case 0:
                    gender = "E";
                    break;
                case 1:
                default:
                    gender = "K";
                    break;
            }

            final Call<ArrayList<User>> call = apiClient.getUsersByGender(gender);

            call.enqueue(new Callback<ArrayList<User>>() {
                @Override
                public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {
                    progressBar.setVisibility(View.GONE);

                    viewModel.setUsers(response.body());
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, new UserListFragment())
                            .commit();
                }

                @Override
                public void onFailure(Call<ArrayList<User>> call, Throwable t) {

                }
            });
        }
    }
}
