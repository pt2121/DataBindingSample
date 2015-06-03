package com.prt2121.rx.viewmodel;

import com.prt2121.rx.BR;
import com.prt2121.rx.data.api.model.Item;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by pt2121 on 6/2/15.
 */
public class RepositoryViewModel extends BaseObservable {

    private Item item;

    @Bindable
    public Item getItem() {
        return item;
    }

    public void setRepository(Item item) {
        this.item = item;
        notifyPropertyChanged(BR.item);
    }

}
