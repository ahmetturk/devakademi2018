package com.ahmetturk.sahibinden.filter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;

import com.ahmetturk.sahibinden.R;
import com.ahmetturk.sahibinden.model.User;
import com.ahmetturk.sahibinden.ui.UserListFragment;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CityFilterActivity extends BaseFilterActivity {

    public static Intent newIntent(Context context, FilterUIModel uiModel) {
        final Intent intent = new Intent(context, CityFilterActivity.class);
        intent.putExtra(KEY_UIMODEL, uiModel);
        return intent;
    }

    @Override
    public void openFilteredResult(@Nullable String enteredText, @Nullable Integer selectedIndex) {
        if (!TextUtils.isEmpty(enteredText)) {
            progressBar.setVisibility(View.VISIBLE);

            apiClient.getUsersByCityName(enteredText).enqueue(new Callback<ArrayList<User>>() {
                @Override
                public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {
                    progressBar.setVisibility(View.GONE);

                    viewModel.setUsers(response.body());
                    getSupportFragmentManager().beginTransaction().
                            replace(R.id.container, new UserListFragment()).
                            commit();
                }

                @Override
                public void onFailure(Call<ArrayList<User>> call, Throwable t) {

                }
            });
        }
    }
}
