package com.riksasuviana.id.mydagger.detail;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.riksasuviana.id.mydagger.R;
import com.riksasuviana.id.mydagger.util.MyConstant;

public class DetailActivity extends AppCompatActivity implements DetailView{

    private DetailPresenter presenter;

    TextView tvdesc, tvrate, tvdate;
    ImageView iv;

    String date, desc, img, title;
    double rate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_detail);

        presenter = new DetailPresenterImpl(this);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        date = b.getString("date");
        rate = b.getDouble("rate");
        desc = b.getString("desc");
        img = b.getString("img");
        title = b.getString("title");

        iv = (ImageView)findViewById(R.id.iv_detail_cover);
        tvdate = (TextView)findViewById(R.id.tv_detail_date);
        tvrate = (TextView)findViewById(R.id.tv_detail_rate);
        tvdesc = (TextView)findViewById(R.id.tv_detail_desc);

        Toolbar tb = (Toolbar) findViewById(R.id.tb);
        CollapsingToolbarLayout ctl = (CollapsingToolbarLayout)findViewById(R.id.ctl);

        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        getSupportActionBar().setTitle(title);

        ctl.setTitle(title);
        ctl.setExpandedTitleColor(Color.parseColor("#44ffffff"));

        showData();
    }

    @Override
    public void showData() {
        tvdate.setText(date);
        tvrate.setText(rate+"");
        tvdesc.setText(desc);

        Glide.with(this).load(MyConstant.BASE_URL_POSTER+img).into(iv);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
