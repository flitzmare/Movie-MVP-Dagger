package com.riksasuviana.id.mydagger.main.RecyclerView;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.riksasuviana.id.mydagger.R;
import com.riksasuviana.id.mydagger.data.model.ResultDao;
import com.riksasuviana.id.mydagger.detail.DetailActivity;
import com.riksasuviana.id.mydagger.main.MainActivity;
import com.riksasuviana.id.mydagger.util.MyConstant;

import java.util.List;

/**
 * Created by riksasuviana on 04/10/17.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder>{

    private boolean isLoadingAdded = false;

    private static final int ITEM = 0;
    private static final int LOADING = 1;

    List<ResultDao> list;

    public MainAdapter(List<ResultDao> list){
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item, parent, false);
        return new ViewHolder(view  );
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final ResultDao d = list.get(position);
        holder.title.setText(d.getTitle());
        holder.date.setText(d.getRelease_date());
        holder.desc = d.getOverview();
        holder.rate = d.getVote_average();

        Glide.with(holder.itemView.getContext()).load(MyConstant.BASE_URL_POSTER+d.getPoster_path()).into(holder.iv);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(holder.itemView.getContext(), DetailActivity.class);
                i.putExtra("date", d.getRelease_date());
                i.putExtra("rate", d.getVote_average());
                i.putExtra("desc", d.getOverview());
                i.putExtra("img", d.getPoster_path());
                i.putExtra("title", d.getTitle());
                holder.itemView.getContext().startActivity(i);
//                String date = b.getString("date");
//                String rate = b.getString("rate");
//                String desc = b.getString("desc");
//                String img = b.getString("img");
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        return (position == list.size() - 1 && isLoadingAdded) ? LOADING : ITEM;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public String desc;
        public double rate;

        public TextView title, date;
        public ImageView iv;

        public ViewHolder(View itemView) {
            super(itemView);

            title = (TextView)itemView.findViewById(R.id.tv_main_item_title);
            date = (TextView)itemView.findViewById(R.id.tv_main_item_date);
            iv = (ImageView)itemView.findViewById(R.id.iv_main_item);
        }
    }
}