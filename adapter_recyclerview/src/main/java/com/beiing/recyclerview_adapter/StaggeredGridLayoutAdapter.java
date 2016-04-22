//package com.beiing.recyclerview_adapter;
//
//import android.support.v7.widget.RecyclerView;
//import android.support.v7.widget.StaggeredGridLayoutManager;
//import android.view.ViewGroup;
//
//import java.util.List;
//
//public abstract class StaggeredGridLayoutAdapter<T extends RecyclerViewAdapter.Item> extends RecyclerViewAdapter<T> {
//    public StaggeredGridLayoutAdapter(List<T> list) {
//        super(list);
//    }
//
//    public StaggeredGridLayoutAdapter(List<T> list, int headerViewRes) {
//        super(list, headerViewRes);
//    }
//
//    public StaggeredGridLayoutAdapter(List<T> list, int headerViewRes, int footerViewRes) {
//        super(list, headerViewRes, footerViewRes);
//    }
//
//    @Override
//    public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
//        super.onViewAttachedToWindow(holder);
//        if (isStaggeredGridLayout(holder)) {
//            handleLayoutIfStaggeredGridLayout(holder, holder.getLayoutPosition());
//        }
//    }
//
//    private boolean isStaggeredGridLayout(RecyclerView.ViewHolder holder) {
//        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
//        if (layoutParams != null && layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
//            return true;
//        }
//        return false;
//    }
//
//    protected void handleLayoutIfStaggeredGridLayout(RecyclerView.ViewHolder holder, int position) {
//        if (isHeader(position) || isFooter(position)) {
//            StaggeredGridLayoutManager.LayoutParams p = (StaggeredGridLayoutManager.LayoutParams) holder.itemView.getLayoutParams();
//            p.setFullSpan(true);
//        }
//    }
//}
