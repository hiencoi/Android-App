package com.learnenglishforkids.kidbox.learnenglishforkids.control;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.learnenglishforkids.kidbox.learnenglishforkids.R;
import com.learnenglishforkids.kidbox.learnenglishforkids.model.Item;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by trand on 10/13/2017.
 */

public class CustomGridAdapter extends ArrayAdapter<Item> {
    Context context;
    int resource;
    ArrayList<Item> modelItem;
    public CustomGridAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<Item> modelItem) {
        super(context, resource, modelItem);
        this.context = context;
        this.resource = resource;
        this.modelItem = modelItem;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        RecordHolder recordHolder = null;
        if(row == null) {
            LayoutInflater layoutInflater = ((Activity) context).getLayoutInflater();
            row = layoutInflater.inflate(resource, parent, false);

            recordHolder = new RecordHolder();
            recordHolder.txtTitle = (TextView) row.findViewById(R.id.itemTitle);
            recordHolder.imageView = (ImageView) row.findViewById(R.id.itemImage);
            row.setTag(recordHolder);
        }else{
            recordHolder = (RecordHolder) row.getTag();
        }

        Item item = modelItem.get(position);
        recordHolder.txtTitle.setText(item.getTitle());
        recordHolder.imageView.setImageBitmap(item.getImage());
        return row;
    }

    static class RecordHolder {
        TextView txtTitle;
        ImageView imageView;
    }
}

