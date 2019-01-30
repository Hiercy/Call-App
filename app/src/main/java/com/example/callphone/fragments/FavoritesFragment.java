package com.example.callphone.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.callphone.R;
import com.example.callphone.adapter.FavoritesAdapter;
import com.example.callphone.dao.Contact;

import java.util.ArrayList;

public class FavoritesFragment extends Fragment {

    private ArrayList<Contact> mContacts;

    public FavoritesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorites, container, false);

        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);

        RecyclerView mRecyclerView = view.findViewById(R.id.fv_recyclerView);

        FavoritesAdapter recyclerViewAdapter = new FavoritesAdapter(mContacts, getContext());

        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), gridColumnCount));
        mRecyclerView.setAdapter(recyclerViewAdapter);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        populateData();
    }

    private void populateData() {
        mContacts = new ArrayList<>();
        mContacts.add(new Contact(R.drawable.ic_account,"Mike"));
        mContacts.add(new Contact("Mike"));
        mContacts.add(new Contact("Mike"));
        mContacts.add(new Contact("Mike"));
        mContacts.add(new Contact("Mike"));
        mContacts.add(new Contact("Mike"));
        mContacts.add(new Contact("Mike"));
        mContacts.add(new Contact("Mike"));
        mContacts.add(new Contact("Mike"));
        mContacts.add(new Contact("Mike"));
        mContacts.add(new Contact("Mike"));
        mContacts.add(new Contact("Mike"));
        mContacts.add(new Contact("Mike"));
        mContacts.add(new Contact("Mike"));
    }
}
