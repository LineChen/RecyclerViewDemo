package com.beiing.recyclerviewdemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.beiing.recyclerviewdemo.R;
import com.beiing.recyclerviewdemo.bean.Content;
import com.squareup.picasso.Picasso;

import java.util.List;

import recyclerview.adapter.StaggeredGridLayoutAdapter;

public class MyAdapter extends StaggeredGridLayoutAdapter<Content> {


    public MyAdapter(List<Content> list, int headerViewRes) {
        super(list, headerViewRes);
    }


    public MyAdapter(List<Content> list) {
        super(list);
    }

    public MyAdapter(List<Content> list, int headerViewRes, int footerViewRes) {
        super(list, headerViewRes, footerViewRes);
    }

    @Override
    public RecyclerView.ViewHolder onCreateHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_content,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    protected void onBindHeaderView(View headerView) {
        Log.e("TAG","这是HeadView数据绑定的过程");
        ImageView imageView= (ImageView) headerView.findViewById(R.id.icon);
        Picasso.with(headerView.getContext()).load("http://p1.qqyou.com/pic/uploadpic/2013-5/26/2013052611174240620.jpg").into(imageView);
    }

    @Override
    protected void onBindFooterView(View footerView) {
        Log.e("TAG","这是FootView数据绑定的过程");
    }


    @Override
    protected void onBindItemView(RecyclerView.ViewHolder holder, Content item) {
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        Picasso.with(holder.itemView.getContext()).load(item.getIconUrl()).into( itemViewHolder.icon);
        itemViewHolder.title.setText(item.getTitle());
        itemViewHolder.desc.setText(item.getDesc());
    }


    static class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView title;
        TextView desc;
        public ItemViewHolder(View itemView) {
            super(itemView);
            icon = (ImageView) itemView.findViewById(R.id.icon);
            title = (TextView) itemView.findViewById(R.id.title);
            desc = (TextView) itemView.findViewById(R.id.desc);
        }
    }
}
