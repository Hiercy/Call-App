package com.example.callphone;

import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public interface BottomSheet {
    void clickItem(RecyclerView.ViewHolder view, BottomSheetDialog bottomSheetDialog);
}
