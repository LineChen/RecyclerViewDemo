package com.beiing.recyclerview_adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.List;

public abstract class CommonAdapter<T> extends RecyclerView.Adapter<ViewHolder> {

    public interface Item {
        int TYPE_HEADER = 0;
        int TYPE_FOOTER = 1;
        /**
         * 返回item类型，其值不能为0或者1；
         *
         * @return
         */
        int getType();
    }


    protected Context mContext;
    protected int mLayoutId;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;

    private OnItemClickListener mOnItemClickListener;


    //-------添加header、footer处理
    protected int headerViewRes;
    protected int footerViewRes;
    protected boolean hasHeader = false;
    protected boolean hasFooter = false;


    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public CommonAdapter(Context context, int layoutId, List<T> datas) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mLayoutId = layoutId;
        mDatas = datas;
    }

    public CommonAdapter(Context context, int layoutId, List<T> datas, int headerViewRes) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mLayoutId = layoutId;
        mDatas = datas;
        setHeaderView(headerViewRes);
    }

    public CommonAdapter(Context context, int layoutId, List<T> datas, int headerViewRes, int footerViewRes) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mLayoutId = layoutId;
        mDatas = datas;
        setHeaderView(headerViewRes);
        setFooterView(footerViewRes);
    }

    public boolean isHeader(int position) {
        return hasHeader() && position == 0;
    }

    public boolean isFooter(int position) {
        if(hasHeader()){
            return hasFooter() && position == mDatas.size() + 1;
        }else {
            return hasFooter() && position == mDatas.size();
        }
    }

    public int getHeaderViewRes() {
        return headerViewRes;
    }

    public int getFooterViewRes() {
        return footerViewRes;
    }

    public void setHeaderView(int headerViewRes) {

        if (headerViewRes != 0) {
            if (!hasHeader()){
                this.headerViewRes = headerViewRes;
                this.hasHeader = true;
                notifyItemInserted(0);
            }else{
                this.headerViewRes = headerViewRes;
                notifyDataSetChanged();
            }

        } else {
            if (hasHeader()){
                this.hasHeader = false;
                notifyItemRemoved(0);
            }

        }

    }

    public void setFooterView(int footerViewRes) {
        if (footerViewRes != 0) {
            if (!hasFooter()){
                this.footerViewRes = footerViewRes;
                this.hasFooter = true;
                if (hasHeader()){
                    notifyItemInserted(mDatas.size()+1);
                }else{
                    notifyItemInserted(mDatas.size());
                }
            }else{
                this.footerViewRes = footerViewRes;
                notifyDataSetChanged();
            }
        } else {
            if(hasFooter()){
                this.hasFooter = false;
                if (hasHeader()){
                    notifyItemRemoved(mDatas.size()+1);
                }else{
                    notifyItemRemoved(mDatas.size());
                }
            }
        }

    }

    public boolean hasHeader() {
        return hasHeader;
    }

    public boolean hasFooter() {
        return hasFooter;
    }

    /**只能添加一个headerview**/
    public int getHeaderCount(){
        return hasHeader ? 1 : 0;
    }


    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        ViewHolder viewHolder = null;//ViewHolder.get(mContext, null, parent, mLayoutId, -1);
        if (hasHeader() && viewType == Item.TYPE_HEADER) {
            viewHolder = ViewHolder.get(mContext, null, parent, headerViewRes, -1);
            Log.e("===", "create header holder");
        } else if (hasFooter() && viewType == Item.TYPE_FOOTER) {
            viewHolder = ViewHolder.get(mContext, null, parent, footerViewRes, -1);
            Log.e("===", "create footer holder");
        } else {
            viewHolder = ViewHolder.get(mContext, null, parent, mLayoutId, -1);
            setListener(parent, viewHolder, viewType);
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.updatePosition(position);
        if (getItemViewType(position) == Item.TYPE_HEADER) {
            bindHeaderView(holder);
        } else if (getItemViewType(position) == Item.TYPE_FOOTER) {
            bindFooterView(holder);
        } else {
            bindItemView(holder, mDatas.get(position - getHeaderCount()));
        }
    }

    /**
     * 考虑header 和 footer
     * @return
     */
    @Override
    public int getItemCount() {
        int count = 0;
        count += (hasHeader() ? 1 : 0);
        count += (hasFooter() ? 1 : 0);
        count += mDatas.size();
        return count;
    }

    //这里只考虑是否是头部或底部
    @Override
    public int getItemViewType(int position) {
        int size = mDatas.size();
        int type = -1;
        if (hasHeader()) {
            if (position == 0) {
                type =  Item.TYPE_HEADER;
            } else {
                if (position == size + 1) {
                    type =  Item.TYPE_FOOTER;
                }
            }
        } else {
            if (position == size) {
                type =  Item.TYPE_FOOTER;
            }
        }
        return type;
    }

    protected int getPosition(RecyclerView.ViewHolder viewHolder) {
        return viewHolder.getAdapterPosition();
    }

    protected T getItemByPosition(int position) {
        int size = mDatas.size();
        if (hasHeader()) {
            return mDatas.get(position - 1);
        } else {
            return mDatas.get(position);
        }
    }

    protected boolean isEnabled(int viewType) {
        return true;
    }

    /**
     * 设置点击事件
     * @param parent
     * @param viewHolder
     * @param viewType
     */
    protected void setListener(final ViewGroup parent, final ViewHolder viewHolder, int viewType) {
        if (!isEnabled(viewType)) return;
        viewHolder.getConvertView().setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (mOnItemClickListener != null) {
                    int position = getPosition(viewHolder);
                    mOnItemClickListener.onItemClick(parent, v, mDatas.get(position - getHeaderCount()), position);
                }
            }
        });


        viewHolder.getConvertView().setOnLongClickListener(new View.OnLongClickListener()
        {
            @Override
            public boolean onLongClick(View v)
            {
                if (mOnItemClickListener != null) {
                    int position = getPosition(viewHolder);
                    return mOnItemClickListener.onItemLongClick(parent, v, mDatas.get(position - getHeaderCount()), position);
                }
                return false;
            }
        });
    }

    //绑定数据
    public abstract void bindItemView(ViewHolder holder, T t);

    //------这两个方法不是必须的，所以父类写个空方法
    protected  void bindFooterView(ViewHolder holder){

    }
    protected  void bindHeaderView(ViewHolder holder){

    }


}
