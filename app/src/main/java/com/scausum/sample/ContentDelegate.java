package com.scausum.sample;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.scausum.adapterdelegate.AdapterDelegate;
import com.scausum.adapterdelegate.OnDelegateClickListener;
import com.scausum.sample.model.ContentItem;
import com.scausum.sample.model.Item;

import java.util.List;

/**
 * Created by sum on 5/10/16.
 */
public class ContentDelegate extends AdapterDelegate<Item> {

    private OnDelegateClickListener onDelegateClickListener;

    public ContentDelegate(Activity activity) {
        super(activity);
    }

    public void setOnDelegateClickListener(OnDelegateClickListener listener) {
        this.onDelegateClickListener = listener;
    }

    @Override
    public boolean isForViewType(@NonNull Item item) {
        return item instanceof ContentItem;
    }

    @Override
    protected RecyclerView.ViewHolder onCreateViewHolder(LayoutInflater layoutInflater, ViewGroup parent) {
        View itemView = layoutInflater.inflate(R.layout.layout_content, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    protected void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @NonNull Item item, @NonNull List<Object> payloads) {
        final ViewHolder viewHolder = (ViewHolder) holder;
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onDelegateClickListener != null) {
                    int position = viewHolder.getAdapterPosition();
                    onDelegateClickListener.onClick(v, position);
                }
            }
        };
        ContentItem contentItem = (ContentItem) item;
        viewHolder.tvContent.setOnClickListener(onClickListener);
        viewHolder.tvContent.setText(contentItem.content != null ? contentItem.content : "Hello World!!!");

    }

    private static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvContent;

        public ViewHolder(View itemView) {
            super(itemView);

            tvContent = (TextView) itemView.findViewById(R.id.tv_main_item_content);
        }
    }

}
