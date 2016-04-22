package com.beiing.recyclerview_adapter;

public interface MultiItemTypeSupport<T> {
	int getLayoutId(int itemType);

	int getItemViewType(int position, T t);
}