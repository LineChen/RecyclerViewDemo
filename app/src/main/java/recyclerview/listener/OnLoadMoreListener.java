package recyclerview.listener;

import java.util.List;

public interface OnLoadMoreListener<T> {
    /**
     * 加载更多前回调，比如显示Footer的操作
     */
    void onStart();

    /**
     * 加载更多业务处理，如网络请求数据
     */
    void onLoadMore();

    /**
     * 由于onLoadMore可能是异步调用的，所以onFinish需要手动调用，完成数据的刷新，隐藏Footer等
     * @param list onLoadMore中返回的数据
     */
    void onFinish(List<T> list);
}
