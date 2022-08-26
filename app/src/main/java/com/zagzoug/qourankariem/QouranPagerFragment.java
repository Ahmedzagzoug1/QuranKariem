package com.zagzoug.qourankariem;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ZoomControls;

/**
 * A placeholder fragment containing a simple view.
 */
public class QouranPagerFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    ImageView imageView;
    public QouranPagerFragment() {
    }

    public static QouranPagerFragment newInstance(int sectionNumber) {
        QouranPagerFragment fragment = new QouranPagerFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_qouran_pager, container, false);
        imageView = (ImageView) rootView.findViewById(R.id.imege_pager);
        imageView.setImageResource(getArguments().getInt(ARG_SECTION_NUMBER));
        return rootView;
    }

}

