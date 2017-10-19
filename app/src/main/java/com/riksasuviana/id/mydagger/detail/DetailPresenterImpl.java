package com.riksasuviana.id.mydagger.detail;

/**
 * Created by riksasuviana on 04/10/17.
 */

public class DetailPresenterImpl implements DetailPresenter{
    private DetailView detailView;

    public DetailPresenterImpl(DetailView detailView){
        this.detailView = detailView;
    }

    @Override
    public void onDestroy() {
        detailView = null;
    }
}
