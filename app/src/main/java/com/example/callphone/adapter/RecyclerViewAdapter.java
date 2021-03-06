package com.example.callphone.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.callphone.BottomSheet;
import com.example.callphone.R;
import com.example.callphone.model.Contact;
import com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>
        implements BottomSheet, FastScrollRecyclerView.SectionedAdapter {

    private List<Contact> mContactList;
    private Context mContext;

    private BottomSheetDialog sheetDialog;

    private ImageView dialog_img;
    private TextView dialog_phone;
    private TextView dialog_name;

    public RecyclerViewAdapter(List<Contact> mContactList, Context context) {
        this.mContactList = mContactList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_contacts, viewGroup, false);
        final ViewHolder viewHolder = new ViewHolder(view);

        sheetDialog = new BottomSheetDialog(mContext);
        sheetDialog.setContentView(R.layout.contact_card);

        clickItem(viewHolder, sheetDialog);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        final Contact contact = mContactList.get(position);

        viewHolder.bindTo(contact);
    }

    @Override
    public int getItemCount() {
        return mContactList.size();
    }

    @Override
    public void clickItem(RecyclerView.ViewHolder view, BottomSheetDialog bottomSheetDialog) {
        final ViewHolder viewHolder = (ViewHolder) view;
        viewHolder.mImageViewPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog_name = sheetDialog.findViewById(R.id.dialog_name);
                dialog_phone = sheetDialog.findViewById(R.id.dialog_phone_number);
                dialog_img = sheetDialog.findViewById(R.id.dialog_image);

                dialog_name.setText(mContactList.get(viewHolder.getAdapterPosition()).getName());
                dialog_phone.setText(mContactList.get(viewHolder.getAdapterPosition()).getPhone());

                if (mContactList.get(viewHolder.getAdapterPosition()).getImage() != 0) {
                    dialog_img.setImageResource(mContactList.get(viewHolder.getAdapterPosition()).getImage());
                } else {
                    dialog_img.setImageResource(R.drawable.ic_account_circle_white);
                }

                Toast.makeText(
                        view.getContext(),
                        "Test click " + String.valueOf(viewHolder.getAdapterPosition()),
                        Toast.LENGTH_SHORT).show();

                sheetDialog.show();
            }
        });
    }

    @SuppressLint("DefaultLocale")
    @NonNull
    @Override
    public String getSectionName(int position) {
        return String.format("%d", position + 1);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout mLinearLayout;
        private TextView mTextViewName;
        private TextView mTextViewPhone;
        private ImageView mImageViewPhoto;

        ViewHolder(@NonNull View itemView) {
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
