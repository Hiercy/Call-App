package com.example.callphone.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.callphone.BottomSheet;
import com.example.callphone.R;
import com.example.callphone.dao.Contact;

import java.util.ArrayList;
import java.util.Objects;

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.ViewHolder> implements BottomSheet {

    private ArrayList<Contact> mContactList;
    private Context mContext;


    public FavoritesAdapter(ArrayList<Contact> contactList, Context context) {
        this.mContactList = contactList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public FavoritesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_favorites, viewGroup, false);
        final ViewHolder viewHolder = new ViewHolder(view);

        BottomSheetDialog sheetDialog = new BottomSheetDialog(mContext);
        sheetDialog.setContentView(R.layout.contact_card);

        clickItem(viewHolder, sheetDialog);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Contact contact = mContactList.get(i);

        viewHolder.bindTo(contact);
    }

    @Override
    public int getItemCount() {
        return mContactList.size();
    }

    @Override
    public void clickItem(RecyclerView.ViewHolder view, final BottomSheetDialog bottomSheetDialog) {
        final ViewHolder viewHolder = (ViewHolder) view;
        viewHolder.mViewPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView dialog_name = bottomSheetDialog.findViewById(R.id.dialog_name);
                ImageView dialog_img = bottomSheetDialog.findViewById(R.id.dialog_image);

                Objects.requireNonNull(dialog_name).setText(mContactList.get(viewHolder.getAdapterPosition()).getName());

                if (mContactList.get(viewHolder.getAdapterPosition()).getImage() != 0) {
                    Objects.requireNonNull(dialog_img).setImageResource(mContactList.get(viewHolder.getAdapterPosition()).getImage());
                } else {
                    Objects.requireNonNull(dialog_img).setImageResource(R.drawable.ic_account_circle_white);
                }

                Toast.makeText(
                        view.getContext(),
                        "Test click " + String.valueOf(viewHolder.getAdapterPosition()),
                        Toast.LENGTH_SHORT).show();

                bottomSheetDialog.show();
            }
        });
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView mViewPhoto;
        private TextView mViewName;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            mViewPhoto = itemView.findViewById(R.id.fv_photo);
            mViewName = itemView.findViewById(R.id.fv_name);
        }

        void bindTo(Contact contact) {
            mViewName.setText(contact.getName());
            if (contact.getImage() != 0) {
                mViewPhoto.setImageResource(contact.getImage());
            } else {
                mViewPhoto.setImageResource(R.drawable.ic_account_box);
            }
        }

    }
}
