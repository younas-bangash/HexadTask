package com.hexad.movietask.view.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hexad.movietask.AppApplication;
import com.hexad.movietask.R;
import com.hexad.movietask.databinding.FragmentBookListBinding;
import com.hexad.movietask.view.base.BaseFragment;
import com.hexad.movietask.viewmodel.BookListViewModel;

/**
 * A fragment which show the list of moves which is read from the jsonFile
 * <p>
 * Created by Muhammad Younas
 * Created Date : 1/3/2019.
 * Email Address : engr.younasbangash@gmail.com
 */
public class BookListFragment extends BaseFragment<BookListViewModel, FragmentBookListBinding> {


    public static BookListFragment newInstance() {
        return new BookListFragment();
    }


    @Override
    protected Class<BookListViewModel> getViewModel() {
        return BookListViewModel.class;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        setToolBar();
        return dataBinding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (viewModel.items.size() == 0) {
            viewModel.readBookList();
            viewModel.createObservable();
            viewModel.createObserver();
        }

    }

    private void setToolBar() {
        if (null != getActivity() &&
                null != ((AppCompatActivity) getActivity()).getSupportActionBar()) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().show();
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(
                    AppApplication.getAppContext().getString(R.string.app_name));
        }
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_book_list;
    }

    @Override
    protected void observeLiveData() {
        // No Live Data to observe
    }
}
