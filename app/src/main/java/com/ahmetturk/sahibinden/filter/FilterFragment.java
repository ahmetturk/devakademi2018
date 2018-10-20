package com.ahmetturk.sahibinden.filter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.ahmetturk.sahibinden.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FilterFragment extends Fragment {

    @BindView(R.id.filter_edittext)
    EditText editText;

    @BindView(R.id.filter_radiogroup)
    RadioGroup radioGroup;

    public static final String KEY_UIMODEL = "uiModel";

    private View view;

    public static FilterFragment newInstance(FilterUIModel uiModel) {
        final FilterFragment fragment = new FilterFragment();
        final Bundle bundle = new Bundle();
        bundle.putParcelable(KEY_UIMODEL, uiModel);
        fragment.setArguments(bundle);
        return fragment;
    }

    public FilterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_filter, container, false);
        ButterKnife.bind(this, view);

        final FilterUIModel uiModel = getArguments().getParcelable(KEY_UIMODEL);

        if (!TextUtils.isEmpty(uiModel.getEdittextUIModel())) {
            editText.setVisibility(View.VISIBLE);
            editText.setHint(uiModel.getEdittextUIModel());
        }

        if (uiModel.getRadiogroupUIModel() != null && !uiModel.getRadiogroupUIModel().isEmpty()) {
            radioGroup.setVisibility(View.VISIBLE);

            for (int i = 0; i < uiModel.getRadiogroupUIModel().size(); i++) {
                final RadioButton radioButton = new RadioButton(getContext());
                radioButton.setText(uiModel.getRadiogroupUIModel().get(i));
                radioButton.setTag(i);
                radioGroup.addView(radioButton);
            }
        }

        return view;
    }

    @OnClick(R.id.filter_button)
    void onClickFilterButton() {
        String enteredText = null;
        Integer selectedIndex = null;

        if (editText.getVisibility() == View.VISIBLE) {
            enteredText = editText.getText().toString();
        }

        if (radioGroup.getVisibility() == View.VISIBLE) {
            final int selectedId = radioGroup.getCheckedRadioButtonId();
            final RadioButton radioButton = view.findViewById(selectedId);
            selectedIndex = (Integer) radioButton.getTag();
        }

        ((BaseFilterActivity) getActivity()).openFilteredResult(enteredText, selectedIndex);
    }

}
