package com.example.manhl_000.bkrypto.Adapter;

import android.content.Context;
import android.support.v4.app.ActivityCompat;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ActionMenuView;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.manhl_000.bkrypto.Data.MenuItemData;
import com.example.manhl_000.bkrypto.R;

import java.util.List;

import github.hellocsl.cursorwheel.CursorWheelLayout;

/**
 * Created by manhl_000 on 4/8/2018.
 */

public class WheelTextAdapter extends CursorWheelLayout.CycleWheelAdapter {

    private Context mContext;
    private List<MenuItemData> menuItem;
    private LayoutInflater inflater;
    private int gravity;

    public WheelTextAdapter(Context mContext, List<MenuItemData> menuItem) {
        this.mContext = mContext;
        this.menuItem = menuItem;
        gravity = Gravity.CENTER;
        inflater = LayoutInflater.from(mContext);
    }

    public WheelTextAdapter(Context mContext, List<MenuItemData> menuItem, int gravity) {
        this.mContext = mContext;
        this.menuItem = menuItem;
        this.gravity = gravity;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return menuItem.size();
    }

    @Override
    public View getView(View parent, int position) {
        MenuItemData itemData = getItem(position);
        View root = inflater.inflate(R.layout.wheel_text_layout,null,false);
        TextView textView = (TextView)root.findViewById(R.id.wheel_menu_item_tv);
        textView.setVisibility(View.VISIBLE);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
        textView.setText(itemData.mTitle);
        if(textView.getLayoutParams() instanceof FrameLayout.LayoutParams)
            ((FrameLayout.LayoutParams) textView.getLayoutParams()).gravity = gravity;
        if(position == 4)
            textView.setTextColor(ActivityCompat.getColor(mContext,R.color.red));
        return root;
    }

    @Override
    public MenuItemData getItem(int position) {
        return menuItem.get(position);
    }
}
