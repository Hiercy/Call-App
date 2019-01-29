package com.example.callphone;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.callphone.dao.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactFragment extends Fragment {

    private List<Contact> mContacts;

    public ContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        RecyclerView mRecyclerView = view.findViewById(R.id.rv_contact);

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(mContacts, getContext());

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(recyclerViewAdapter);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
