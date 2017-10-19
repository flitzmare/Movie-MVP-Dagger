package com.riksasuviana.id.mydagger.main;

import com.riksasuviana.id.mydagger.data.Post;
import com.riksasuviana.id.mydagger.data.model.MainDao;
import com.riksasuviana.id.mydagger.data.model.ResultDao;

import java.util.List;

/**
 * Created by riksasuviana on 04/10/17.
 */

public interface MainScreenContract {
    interface View{
//        void showPosts(List<Post> posts);

//        void showList(List<ResultDao> dao);
        void showList(MainDao<List<ResultDao>> dao);

        void showError(String message);

        void showComplete();
    }

    interface Presenter{
//        void loadPost();
        void loadPost(int page);
    }
}
