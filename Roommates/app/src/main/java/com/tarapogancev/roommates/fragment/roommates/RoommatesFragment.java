package com.tarapogancev.roommates.fragment.roommates;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tarapogancev.roommates.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RoommatesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RoommatesFragment extends Fragment {

    String[] names = {
            "John Doe 1",
            "John Doe 2",
            "John Doe 3",
            "John Doe 4",
            "John Doe 5",
            "John Doe 6",
            "John Doe 7",
    };
    RecyclerView recyclerView;

    public RoommatesFragment() {
        // Required empty public constructor
    }

    public static RoommatesFragment newInstance(String param1, String param2) {
        RoommatesFragment fragment = new RoommatesFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_roommates, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = getView().findViewById(R.id.layout_recyclerView);
        RoommateRecyclerViewAdapter adapter = new RoommateRecyclerViewAdapter(this.getContext(), names);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
    }
}