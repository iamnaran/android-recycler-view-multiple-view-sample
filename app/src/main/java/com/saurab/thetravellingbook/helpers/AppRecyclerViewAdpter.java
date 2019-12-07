package com.saurab.thetravellingbook.helpers;

import androidx.recyclerview.widget.RecyclerView;

public abstract class AppRecyclerViewAdpter extends RecyclerView.Adapter {

    protected abstract void add(Object object);

    protected abstract void clear();

}
