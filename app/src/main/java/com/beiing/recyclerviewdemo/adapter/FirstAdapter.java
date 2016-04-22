package com.beiing.recyclerviewdemo.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.beiing.recyclerview_adapter.CommonAdapter;
import com.beiing.recyclerview_adapter.ViewHolder;
import com.beiing.recyclerviewdemo.R;
import com.beiing.recyclerviewdemo.bean.Content;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by chenliu on 2016/4/22.
 * 描述：
 */
public class FirstAdapter extends CommonAdapter<Content> {
    public FirstAdapter(Context context, int layoutId, List<Content> datas) {
        super(context, layoutId, datas);
    }

    @Override
    public void bindItemView(ViewHolder holder, Content content) {
        holder.setText(R.id.title, content.getTitle());
        holder.setText(R.id.desc, content.getDesc());
        ImageView image = holder.getView(R.id.icon);
        Picasso.with(mContext).load(content.getIconUrl()).into(image);
    }

    @Override
    protected void bindHeaderView(ViewHolder holder) {
        ImageView image = holder.getView(R.id.icon);
        Picasso.with(mContext).load("http://sd.china.com.cn/uploadfile/2015/1110/20151110124254756.jpg").into(image);
        holder.setText(R.id.tv_header, "这是头部噢");
    }

    @Override
    protected void bindFooterView(ViewHolder holder) {
        holder.setText(R.id.title, "上拉加载更多美女哦");
    }


}













