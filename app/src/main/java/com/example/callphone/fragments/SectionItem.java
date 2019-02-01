package com.example.callphone.fragments;

import com.example.callphone.adapter.Section;

class SectionItem implements Section {
    private int section;

    public SectionItem(int section) {
        this.section = section;
    }

    @Override
    public int type() {
        return ITEM;
    }

    @Override
    public int sectionPosition() {
        return section;
    }
}
