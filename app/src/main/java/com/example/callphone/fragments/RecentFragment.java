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
import com.example.callphone.adapter.RecentAdapter;
import com.example.callphone.adapter.Section;
import com.example.callphone.model.Contact;
import com.shuhart.stickyheader.StickyHeaderItemDecorator;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class RecentFragment extends Fragment {

    private ArrayList<Contact> mContacts;

    public RecentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recent, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        RecentAdapter adapter = new RecentAdapter(mContacts);
        recyclerView.setAdapter(adapter);

        StickyHeaderItemDecorator decorator = new StickyHeaderItemDecorator(adapter);
        decorator.attachToRecyclerView(recyclerView);

        adapter.mSections = new ArrayList<Section>() {{
            int section = 0;
            for (int i = 0; i < 15; i++) {
                if (i < 12) {
                    if (i % 4 == 0) {
                        section = i;
                        add(new SectionHeader(section));
                    } else {
                        add(new SectionItem(section));
                    }
                } else {
                    if (i % 8 == 0) {
                        section = i;
                        add(new SectionHeader(section));
                    } else {
                        add(new SectionItem(section));
                    }
                }
            }
        }};
        adapter.notifyDataSetChanged();
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
        mContacts.add(new Contact("Mike"));
    }
}
