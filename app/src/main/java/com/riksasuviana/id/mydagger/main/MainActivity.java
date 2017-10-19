package com.riksasuviana.id.mydagger.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.riksasuviana.id.mydagger.App;
import com.riksasuviana.id.mydagger.R;
import com.riksasuviana.id.mydagger.data.Post;
import com.riksasuviana.id.mydagger.data.model.MainDao;
import com.riksasuviana.id.mydagger.data.model.ResultDao;
import com.riksasuviana.id.mydagger.main.RecyclerView.MainAdapter;
import com.riksasuviana.id.mydagger.main.RecyclerView.PaginationScrollListener;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainScreenContract.View{

    RecyclerView rv;
    List<ResultDao> list = new ArrayList<>();
    MainAdapter adp;

    private boolean isLoading = false;
    private boolean isLastPage = false;
    private int currentPage = 1;

    @Inject
    MainScreenPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = (RecyclerView) findViewById(R.id.rv);

        adp = new MainAdapter(list);

        GridLayoutManager lm = new GridLayoutManager(this, 2);
//        LinearLayoutManager lm = new LinearLayoutManager(this);
        rv.setAdapter(adp);
        rv.setLayoutManager(lm);
        rv.addOnScrollListener(new PaginationScrollListener(lm) {
            @Override
            protected void loadMoreItems() {
                isLoading = true;
                currentPage += 1;
                loadItem();
            }

            @Override
            public int getTotalPageCount() {
                return 0;
            }

            @Override
            public boolean isLastPage() {
                return false;
            }

            @Override
            public boolean isLoading() {
                return false;
            }
        });

        DaggerMainScreenComponent.builder()
                .netComponent(((App) getApplicationContext()).getNetComponent())
                .mainScreenModule(new MainScreenModule(this))
                .build().inject(this);

        loadItem();
    }

    private void loadItem(){
        mainPresenter.loadPost(currentPage);
    }

//    @Override
//    public void showPosts(List<Post> posts) {
//        //Loop through the posts and get the title of the post and add it to our list object
//        for (int i = 0; i < posts.size(); i++) {
//            list.add(posts.get(i).getTitle());
//        }
//        //Create the array adapter and set it to list view
//        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
//        listView.setAdapter(adapter);
//    }

//    @Override
//    public void showList(List<ResultDao> dao) {
//        for(int i = 0;i<dao.size();i++){
//            Log.wtf("showList: ", dao.get(i).getTitle());
//        }
//    }

    @Override
    public void showList(MainDao<List<ResultDao>> dao) {
        for(int i = 0;i<dao.getResults().size();i++){
//            Log.wtf("showList: ", dao.getResults().get(i).getTitle());
//            Log.wtf("showList: ", dao.getResults().get(i).getVote_count()+"");
//            Log.wtf("showList: ", dao.getResults().get(i).getId()+"");
//            Log.wtf("showList: ", dao.getResults().get(i).getPoster_path());
                    ResultDao d = new ResultDao();
                    d.setTitle(dao.getResults().get(i).getTitle());
                    d.setPoster_path(dao.getResults().get(i).getPoster_path());
                    d.setRelease_date(dao.getResults().get(i).getRelease_date());
                    d.setVote_average(dao.getResults().get(i).getVote_average());
                    d.setOverview(dao.getResults().get(i).getOverview());
                    list.add(d);
                    adp.notifyDataSetChanged();
        }
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getApplicationContext(), "Error" + message, Toast.LENGTH_SHORT).show();
        Log.wtf("showError: ", message);
    }

    @Override
    public void showComplete() {
//        Toast.makeText(getApplicationContext(), "Complete", Toast.LENGTH_SHORT).show();
    }
}
