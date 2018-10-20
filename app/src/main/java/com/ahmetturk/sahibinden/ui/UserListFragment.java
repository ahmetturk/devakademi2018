package com.ahmetturk.sahibinden.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ahmetturk.sahibinden.R;
import com.ahmetturk.sahibinden.model.User;
import com.ahmetturk.sahibinden.viewmodel.FilterViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserListFragment extends Fragment implements UserListAdapterListener {

    @BindView(R.id.user_list_recycler_view)
    RecyclerView recyclerView;

    private FilterViewModel viewModel;

    public UserListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(getActivity()).get(FilterViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user_list, container, false);
        ButterKnife.bind(this, view);

        final UserListAdapter adapter = new UserListAdapter(getContext(), this);
        adapter.setList(viewModel.getUsers());

        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onUserClicked(User user) {
        getActivity().startActivity(UserDetailActivity.newIntent(getContext(), user));
    }
}
