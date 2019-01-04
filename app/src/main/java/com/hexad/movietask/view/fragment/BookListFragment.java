package com.hexad.movietask.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (viewModel.items.size() == 0) {
            viewModel.readBookList();
        }
    }

    private void setToolBar() {
        ((AppCompatActivity) getActivity()).setSupportActionBar(dataBinding.toolbar.toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(
                AppApplication.getAppContext().getString(R.string.app_name));
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_book_list;
    }

    @Override
    protected void observeLiveData() {

    }
}
