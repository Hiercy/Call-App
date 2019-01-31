package com.example.callphone.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.callphone.R;
import com.example.callphone.adapter.RecyclerViewAdapter;
import com.example.callphone.model.Contact;
import com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ContactFragment extends Fragment {

    private List<Contact> mContacts;

    public ContactFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        FastScrollRecyclerView fastScrollRecyclerView = view.findViewById(R.id.rv_contact);

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(mContacts, getContext());

        fastScrollRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        fastScrollRecyclerView.setAdapter(recyclerViewAdapter);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        populateData();
    }

    private void populateData() {
        mContacts = new ArrayList<>();
        mContacts.add(new Contact("Mike", "+123456789"));
        mContacts.add(new Contact("Mike", "+123456789"));
        mContacts.add(new Contact("Mike", "+123456789"));
        mContacts.add(new Contact("Mike", "+123456789"));
        mContacts.add(new Contact("Mike", "+123456789"));
        mContacts.add(new Contact("Mike", "+123456789"));
        mContacts.add(new Contact("Mike", "+123456789"));
        mContacts.add(new Contact("Mike", "+123456789"));
        mContacts.add(new Contact("Mike", "+123456789"));
        mContacts.add(new Contact("Mike", "+123456789"));
        mContacts.add(new Contact("Mike", "+123456789"));
        mContacts.add(new Contact("Mike", "+123456789"));
        mContacts.add(new Contact("Mike", "+123456789"));
        mContacts.add(new Contact("Mike", "+123456789"));
    }
}
