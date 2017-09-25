package com.challenge.joel.bbva.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.challenge.joel.bbva.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapListFragment extends Fragment {
    private MapListAdapter mAdapter;
    private RecyclerView mRecyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new MapListAdapter(new ArrayList<HashMap<String, String>>());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.map_list, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.map_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }

    public void setDataset(List<HashMap<String, String>> dataset){
        mAdapter.setDataset(dataset);
    }
}
