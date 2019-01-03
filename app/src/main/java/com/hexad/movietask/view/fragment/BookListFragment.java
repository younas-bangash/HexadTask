package com.hexad.movietask.view.fragment;


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
    protected int getLayoutRes() {
        return R.layout.fragment_book_list;
    }

    @Override
    protected void observeLiveData() {

    }
}
