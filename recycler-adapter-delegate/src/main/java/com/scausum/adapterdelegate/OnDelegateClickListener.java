package com.scausum.adapterdelegate;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 *
 */
public abstract class OnDelegateClickListener
        implements View.OnClickListener {

    private RecyclerView.ViewHolder viewHolder;

    public void setViewHolder(RecyclerView.ViewHolder viewHolder) {
        this.viewHolder = viewHolder;
    }

    @Override
    public final void onClick(View v) {
        if (viewHolder == null) {
            throw new NullPointerException("Must invoke OnDelegateClickListener.setViewHolder() method in " +
                    "before View.onClick() event.");
        }
        int position = viewHolder.getAdapterPosition();
        onClick(v, position);
    }

    /**
     * Callback when click the itemView's child view
     *
     * @param child    the itemView's child view
     * @param position the itemView's position in RecyclerView
     */
    protected abstract void onClick(View child, int position);
}