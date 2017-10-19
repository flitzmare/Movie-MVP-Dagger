package com.riksasuviana.id.mydagger.main;

import com.riksasuviana.id.mydagger.data.Post;
import com.riksasuviana.id.mydagger.data.model.MainDao;
import com.riksasuviana.id.mydagger.data.model.ResultDao;
import com.riksasuviana.id.mydagger.network.NetworkService;
import com.riksasuviana.id.mydagger.util.MyConstant;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;
import retrofit2.http.GET;
import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by riksasuviana on 04/10/17.
 */

public class MainScreenPresenter implements MainScreenContract.Presenter {
    public Retrofit retrofit;
    MainScreenContract.View mView;

    @Inject
    public MainScreenPresenter(Retrofit retrofit, MainScreenContract.View mView){
        this.retrofit = retrofit;
        this.mView = mView;
    }

//    @Override
//    public void loadPost() {
//        retrofit.create(NetworkService.class).getResultDaoList().subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .unsubscribeOn(Schedulers.io())
//                .subscribe(new Observer<MainDao<List<ResultDao>>>() {
//                    @Override
//                    public void onCompleted() {
//                        mView.showComplete();
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        mView.showError(e.getMessage());
//                    }
//
//                    @Override
//                    public void onNext(MainDao<List<ResultDao>> dao) {
////                        mView.showPosts(posts);
//                        mView.showList(dao);
//                    }
//                });
//    }

    @Override
    public void loadPost(int page) {
        retrofit.create(NetworkService.class).getPage(MyConstant.API_KEY, page).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<MainDao<List<ResultDao>>>() {
                    @Override
                    public void onCompleted() {
                        mView.showComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(MainDao<List<ResultDao>> dao) {
//                        mView.showPosts(posts);
                        mView.showList(dao);
                    }
                });
    }
}
