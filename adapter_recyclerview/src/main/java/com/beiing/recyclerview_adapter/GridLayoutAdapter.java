//package com.beiing.recyclerview_adapter;
//
//import android.support.v7.widget.GridLayoutManager;
//import android.support.v7.widget.RecyclerView;
//
//import java.util.List;
//
//public abstract class GridLayoutAdapter<T extends RecyclerViewAdapter.ItemType> extends RecyclerViewAdapter<T> {
//
//    public GridLayoutAdapter(List list) {
//        super(list);
//    }
//    public GridLayoutAdapter(List list, int headerViewRes) {
//        super(list, headerViewRes);
//    }
//
//    public GridLayoutAdapter(List list, int headerViewRes, int footerViewRes) {
//        super(list, headerViewRes, footerViewRes);
//    }
//
//    private GridSpanSizeLookup mGridSpanSizeLookup;
//    private GridLayoutManager gridManager;
//    @Override
//    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
//        super.onAttachedToRecyclerView(recyclerView);
//        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
//        if (manager instanceof GridLayoutManager) {
//            gridManager = ((GridLayoutManager) manager);
//            if (mGridSpanSizeLookup == null) {
//                mGridSpanSizeLookup = new GridSpanSizeLookup();
//            }
//            gridManager.setSpanSizeLookup(mGridSpanSizeLookup);
//        }
//    }
//
//    class GridSpanSizeLookup extends GridLayoutManager.SpanSizeLookup {
//
//        //如果是header 或 footer就需要占满整个屏幕
//        @Override
//        public int getSpanSize(int position) {
//            if (isHeader(position) || isFooter(position)) {
//                return gridManager.getSpanCount();
//            }
//            return 1;
//        }
//    }
//
//
//}
