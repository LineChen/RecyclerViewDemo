package com.beiing.recyclerviewdemo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;

import com.beiing.recyclerviewdemo.adapter.MyAdapter;
import com.beiing.recyclerviewdemo.bean.Content;

import java.util.ArrayList;
import java.util.List;

import recyclerview.adapter.RecyclerViewAdapter;
import recyclerview.listener.OnRecyclerViewScrollListener;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private List<Content> list = new ArrayList<Content>();
    private RecyclerViewAdapter<Content> myAdapter;
    private  ArrayList<Content> arrayList;
    Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            List<Content> list= (List<Content>) msg.obj;
            myAdapter.getList().addAll(list);
            myAdapter.notifyDataSetChanged();
            myAdapter.setFooterView(0);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        initData();


        //mRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        //mRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        myAdapter = new MyAdapter(list);
        //myAdapter.setHeaderView(R.layout.item_header);
        //myAdapter.setFooterView(R.layout.item_footer);
        mRecyclerView.setAdapter(myAdapter);

        arrayList=new ArrayList<Content>(myAdapter.getList());
        mRecyclerView.addOnScrollListener(new OnRecyclerViewScrollListener<Content>(){
            @Override
            public void onStart() {
                myAdapter.setFooterView(R.layout.item_footer);
                if (myAdapter.hasHeader()){
                    mRecyclerView.smoothScrollToPosition(myAdapter.getItemCount()+1);
                }else{
                    mRecyclerView.smoothScrollToPosition(myAdapter.getItemCount());
                }
            }

            @Override
            public void onLoadMore() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Log.e("TAG","模拟网络请求数据");
                            Thread.sleep(5000);
                            //手动调用onFinish()
                            onFinish(arrayList);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }

            @Override
            public void onFinish(List<Content> contents) {
                Message message=Message.obtain();
                message.obj=contents;
                mHandler.sendMessage(message);
                setLoadingMore(false);
            }
        });

    }

    private void initData() {
        Content c = new Content();
        c.setIconUrl("http://p1.qqyou.com/pic/uploadpic/2013-5/26/2013052611174240620.jpg");
        c.setTitle("摇滚水果");
        c.setDesc("比基尼女郎，掀摇滚热浪。滨江区滨文路577号华润超市4楼。");
        list.add(c);


        c = new Content();
        c.setIconUrl("http://g.hiphotos.baidu.com/zhidao/wh%3D450%2C600/sign=d4d0c467b5de9c82a630f18b59b1ac3c/e850352ac65c103815cbee9cb4119313b07e8932.jpg");
        c.setTitle("坏蛋必须死");
        c.setDesc("说好悬疑片，能否严肃点。余杭区临平南苑街道藕花洲大街303号沃尔玛4楼。");
        list.add(c);


        c = new Content();
        c.setIconUrl("http://att2.citysbs.com/fz/bbs_attachments/2010/month_1002/10020312250ba11460cb93cf95.jpg");
        c.setTitle("诡影迷情");
        c.setDesc("头七夜半时，亡妻回魂日。临安市锦城街道钱王街855号万华广场四楼。");
        list.add(c);

        c = new Content();
        c.setIconUrl("http://cdn.duitang.com/uploads/item/201510/11/20151011195344_aVZRx.jpeg");
        c.setTitle("坏蛋必须死");
        c.setDesc("说好悬疑片，能否严肃点。余杭区临平南苑街道藕花洲大街303号沃尔玛4楼。");
        list.add(c);

        c.setIconUrl("http://p1.qqyou.com/pic/uploadpic/2013-5/26/2013052611174240620.jpg");
        c.setTitle("摇滚水果");
        c.setDesc("比基尼女郎，掀摇滚热浪。滨江区滨文路577号华润超市4楼。");
        list.add(c);


        c = new Content();
        c.setIconUrl("http://g.hiphotos.baidu.com/zhidao/wh%3D450%2C600/sign=d4d0c467b5de9c82a630f18b59b1ac3c/e850352ac65c103815cbee9cb4119313b07e8932.jpg");
        c.setTitle("坏蛋必须死");
        c.setDesc("说好悬疑片，能否严肃点。余杭区临平南苑街道藕花洲大街303号沃尔玛4楼。");
        list.add(c);


        c = new Content();
        c.setIconUrl("http://att2.citysbs.com/fz/bbs_attachments/2010/month_1002/10020312250ba11460cb93cf95.jpg");
        c.setTitle("诡影迷情");
        c.setDesc("头七夜半时，亡妻回魂日。临安市锦城街道钱王街855号万华广场四楼。");
        list.add(c);

        c = new Content();
        c.setIconUrl("http://cdn.duitang.com/uploads/item/201510/11/20151011195344_aVZRx.jpeg");
        c.setTitle("坏蛋必须死");
        c.setDesc("说好悬疑片，能否严肃点。余杭区临平南苑街道藕花洲大街303号沃尔玛4楼。");
        list.add(c);

        c.setIconUrl("http://p1.qqyou.com/pic/uploadpic/2013-5/26/2013052611174240620.jpg");
        c.setTitle("摇滚水果");
        c.setDesc("比基尼女郎，掀摇滚热浪。滨江区滨文路577号华润超市4楼。");
        list.add(c);


        c = new Content();
        c.setIconUrl("http://g.hiphotos.baidu.com/zhidao/wh%3D450%2C600/sign=d4d0c467b5de9c82a630f18b59b1ac3c/e850352ac65c103815cbee9cb4119313b07e8932.jpg");
        c.setTitle("坏蛋必须死");
        c.setDesc("说好悬疑片，能否严肃点。余杭区临平南苑街道藕花洲大街303号沃尔玛4楼。");
        list.add(c);


        c = new Content();
        c.setIconUrl("http://att2.citysbs.com/fz/bbs_attachments/2010/month_1002/10020312250ba11460cb93cf95.jpg");
        c.setTitle("诡影迷情");
        c.setDesc("头七夜半时，亡妻回魂日。临安市锦城街道钱王街855号万华广场四楼。");
        list.add(c);

        c = new Content();
        c.setIconUrl("http://cdn.duitang.com/uploads/item/201510/11/20151011195344_aVZRx.jpeg");
        c.setTitle("坏蛋必须死");
        c.setDesc("说好悬疑片，能否严肃点。余杭区临平南苑街道藕花洲大街303号沃尔玛4楼。");
        list.add(c);
    }
}
