package com.example.callphone.adapter;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.callphone.R;
import com.example.callphone.model.Contact;
import com.shuhart.stickyheader.StickyAdapter;

import java.util.ArrayList;
import java.util.List;

public class RecentAdapter extends StickyAdapter<RecyclerView.ViewHolder, RecyclerView.ViewHolder> {

    public List<Section> mSections = new ArrayList<>();
    List<Contact> mContacts = new ArrayList<>();

    public RecentAdapter(List<Contact> contacts) {
        this.mContacts = contacts;
    }

    @Override
    public RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
        return createViewHolder(parent, Section.HEADER);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());

        if (viewType == Section.HEADER || viewType == Section.CUSTOM_HEADER) {
            return new HeaderViewholder(layoutInflater.inflate(R.layout.header_item, viewGroup, false));
        }
        return new ItemViewHolder(layoutInflater.inflate(R.layout.item_contacts, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int headerPosition) {
        final Contact contact = mContacts.get(headerPosition);
        int type = mSections.get(headerPosition).type();
        int section = mSections.get(headerPosition).sectionPosition();
        if (type == Section.HEADER) {
            ((HeaderViewholder) holder).textView.setText("Header " + section);
        } else if (type == Section.ITEM) {
            ((ItemViewHolder) holder).bindTo(contact);
        } else {
            ((HeaderViewholder) holder).textView.setText("Custom header");
        }
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder, int headerPosition) {
        ((HeaderViewholder) holder).textView.setText("Header " + headerPosition);
    }

    @Override
    public int getItemCount() {
        return mSections.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mSections.get(position).type();
    }

    @Override
    public int getHeaderPositionForItem(int itemPosition) {
        return mSections.get(itemPosition).sectionPosition();
    }

    public static class HeaderViewholder extends RecyclerView.ViewHolder {

        TextView textView;

        HeaderViewholder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_header);
        }
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout mLinearLayout;
        private TextView mTextViewName;
        private TextView mTextViewPhone;
        private ImageView mImageViewPhoto;

        ItemViewHolder(View itemView) {
            super(itemView);

            mLinearLayout = itemView.findViewById(R.id.item_contact);
            mTextViewName = itemView.findViewById(R.id.contact_name);
            mTextViewPhone = itemView.findViewById(R.id.contact_phone);
            mImageViewPhoto = itemView.findViewById(R.id.img_contact);
        }

        void bindTo(Contact contact) {
            mTextViewName.setText(contact.getName());
            mTextViewPhone.setText(contact.getPhone());
            if (contact.getImage() != 0) {
                mImageViewPhoto.setImageResource(contact.getImage());
            } else {
                mImageViewPhoto.setImageResource(R.drawable.ic_account);
            }
        }
    }
}
