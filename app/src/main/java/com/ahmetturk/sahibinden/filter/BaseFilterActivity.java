package com.ahmetturk.sahibinden.filter;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

import com.ahmetturk.sahibinden.R;
import com.ahmetturk.sahibinden.rest.ApiClient;
import com.ahmetturk.sahibinden.rest.ServiceGenerator;
import com.ahmetturk.sahibinden.viewmodel.FilterViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class BaseFilterActivity extends AppCompatActivity {

    public static final String KEY_UIMODEL = "uiModel";

    @BindView(R.id.progressbar)
    ProgressBar progressBar;

    protected ApiClient apiClient;
    protected FilterViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        ButterKnife.bind(this);

        viewModel = ViewModelProviders.of(this).get(FilterViewModel.class);

        apiClient = ServiceGenerator.createService(ApiClient.class);

        final FilterUIModel uiModel = getIntent().getParcelableExtra(KEY_UIMODEL);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, FilterFragment.newInstance(uiModel))
                .commit();
    }

    public abstract void openFilteredResult(@Nullable String enteredText, @Nullable Integer selectedIndex);
}
