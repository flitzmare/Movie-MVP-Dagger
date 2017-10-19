package com.riksasuviana.id.mydagger.network;

import com.riksasuviana.id.mydagger.data.model.MainDao;
import com.riksasuviana.id.mydagger.data.model.ResultDao;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by flitzmare21 on 07/10/17.
 */

public interface NetworkService {
    @GET("3/discover/movie?api_key=d8fcb077e3b62f7d851f8c7833508966")
    Observable<MainDao<List<ResultDao>>> getResultDaoList();

    @POST("3/discover/movie")
    Observable<MainDao<List<ResultDao>>> getPage(@Query("api_key") String api_key, @Query("page") int page);
}
