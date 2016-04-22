package com.beiing.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.beiing.recyclerview_adapter.DividerItemDecoration;
import com.beiing.recyclerview_adapter.OnItemClickListener;
import com.beiing.recyclerviewdemo.adapter.FirstAdapter;
import com.beiing.recyclerviewdemo.bean.Content;

import java.util.ArrayList;
import java.util.List;

import recyclerview.adapter.RecyclerViewAdapter;

public class FirstActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private List<Content> list = new ArrayList<Content>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        initData();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FirstAdapter adapter = new FirstAdapter(this, R.layout.item_content, list);
        adapter.setHeaderView(R.layout.item_header);
        adapter.setFooterView(R.layout.item_footer);

        recyclerView.setAdapter(adapter);

        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        adapter.setOnItemClickListener(new OnItemClickListener<Content>() {
            @Override
            public void onItemClick(ViewGroup parent, View view, Content content, int position) {
                Toast.makeText(FirstActivity.this, position + content.getTitle(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public boolean onItemLongClick(ViewGroup parent, View view, Content content, int position) {
                Toast.makeText(FirstActivity.this, position + content.getTitle(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        Log.e("====", "item_count:" + adapter.getItemCount());
        Log.e("====", "hasFooter:" + adapter.hasFooter());
    }


    //5个数据
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


//        c = new Content();
//        c.setIconUrl("http://g.hiphotos.baidu.com/zhidao/wh%3D450%2C600/sign=d4d0c467b5de9c82a630f18b59b1ac3c/e850352ac65c103815cbee9cb4119313b07e8932.jpg");
//        c.setTitle("坏蛋必须死");
//        c.setDesc("说好悬疑片，能否严肃点。余杭区临平南苑街道藕花洲大街303号沃尔玛4楼。");
//        list.add(c);
//
//
//        c = new Content();
//        c.setIconUrl("http://att2.citysbs.com/fz/bbs_attachments/2010/month_1002/10020312250ba11460cb93cf95.jpg");
//        c.setTitle("诡影迷情");
//        c.setDesc("头七夜半时，亡妻回魂日。临安市锦城街道钱王街855号万华广场四楼。");
//        list.add(c);

//        c = new Content();
//        c.setIconUrl("http://cdn.duitang.com/uploads/item/201510/11/20151011195344_aVZRx.jpeg");
//        c.setTitle("坏蛋必须死");
//        c.setDesc("说好悬疑片，能否严肃点。余杭区临平南苑街道藕花洲大街303号沃尔玛4楼。");
//        list.add(c);
//
//        c.setIconUrl("http://p1.qqyou.com/pic/uploadpic/2013-5/26/2013052611174240620.jpg");
//        c.setTitle("摇滚水果");
//        c.setDesc("比基尼女郎，掀摇滚热浪。滨江区滨文路577号华润超市4楼。");
//        list.add(c);
//
//
//        c = new Content();
//        c.setIconUrl("http://g.hiphotos.baidu.com/zhidao/wh%3D450%2C600/sign=d4d0c467b5de9c82a630f18b59b1ac3c/e850352ac65c103815cbee9cb4119313b07e8932.jpg");
//        c.setTitle("坏蛋必须死");
//        c.setDesc("说好悬疑片，能否严肃点。余杭区临平南苑街道藕花洲大街303号沃尔玛4楼。");
//        list.add(c);
//
//
//        c = new Content();
//        c.setIconUrl("http://att2.citysbs.com/fz/bbs_attachments/2010/month_1002/10020312250ba11460cb93cf95.jpg");
//        c.setTitle("诡影迷情");
//        c.setDesc("头七夜半时，亡妻回魂日。临安市锦城街道钱王街855号万华广场四楼。");
//        list.add(c);
//
//        c = new Content();
//        c.setIconUrl("http://cdn.duitang.com/uploads/item/201510/11/20151011195344_aVZRx.jpeg");
//        c.setTitle("坏蛋必须死");
//        c.setDesc("说好悬疑片，能否严肃点。余杭区临平南苑街道藕花洲大街303号沃尔玛4楼。");
//        list.add(c);
    }
}
