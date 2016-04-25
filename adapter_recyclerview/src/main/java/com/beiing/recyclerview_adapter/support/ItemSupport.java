package com.beiing.recyclerview_adapter.support;

import com.beiing.recyclerview_adapter.adapter.CommonAdapter;

/**
 * Created by chenliu on 2016/4/22.<br/>
 * 描述：提供布局Id 或 布局类型
 */
public abstract class ItemSupport<T> {
	public abstract int getLayoutId(int itemType);

	/**
	 * 当只有一种布局时，不用重写该方法，默认返回2
	 * @param position
	 * @param t
     * @return
     */
	public int getItemViewType(int position, T t){
		return  ItemType.TYPE_ONLY_ONE;
	}
}