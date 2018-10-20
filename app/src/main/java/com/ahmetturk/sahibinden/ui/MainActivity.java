package com.ahmetturk.sahibinden.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ahmetturk.sahibinden.R;
import com.ahmetturk.sahibinden.filter.BirthdateFilterActivity;
import com.ahmetturk.sahibinden.filter.CityFilterActivity;
import com.ahmetturk.sahibinden.filter.EducationFilterActivity;
import com.ahmetturk.sahibinden.filter.FilterUIModel;
import com.ahmetturk.sahibinden.filter.GenderFilterActivity;
import com.ahmetturk.sahibinden.filter.MartialFilterActivity;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickBirthdate(View view) {
        final FilterUIModel uiModel = new FilterUIModel(getString(R.string.birthdate),
                Arrays.asList(getResources().getStringArray(R.array.birthdateRadioGroup)));
        startActivity(BirthdateFilterActivity.newIntent(this, uiModel));
    }

    public void onClickCity(View view) {
        final FilterUIModel uiModel = new FilterUIModel(getString(R.string.city), null);
        startActivity(CityFilterActivity.newIntent(this, uiModel));
    }

    public void onClickEducation(View view) {
        final FilterUIModel uiModel = new FilterUIModel(null,
                Arrays.asList(getResources().getStringArray(R.array.educationRadioGroup)));
        startActivity(EducationFilterActivity.newIntent(this, uiModel));
    }

    public void onClickMartialStatus(View view) {
        final FilterUIModel uiModel = new FilterUIModel(null,
                Arrays.asList(getResources().getStringArray(R.array.martialRadioGroup)));
        startActivity(MartialFilterActivity.newIntent(this, uiModel));
    }

    public void onClickGender(View view) {
        final FilterUIModel uiModel = new FilterUIModel(null,
                Arrays.asList(getResources().getStringArray(R.array.genderRadioGroup)));
        startActivity(GenderFilterActivity.newIntent(this, uiModel));
    }
}
