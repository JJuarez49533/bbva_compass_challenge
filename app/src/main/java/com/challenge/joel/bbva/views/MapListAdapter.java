package com.challenge.joel.bbva.views;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.challenge.joel.bbva.R;


import java.util.HashMap;
import java.util.List;

public class MapListAdapter extends RecyclerView.Adapter<MapListAdapter.Viewholder> {
    List<HashMap<String, String>> nearbyPlaceList;

    public MapListAdapter(List<HashMap<String, String>> nearbyPlaceList) {
        this.nearbyPlaceList = nearbyPlaceList;
    }
    @Override
    public MapListAdapter.Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new Viewholder(childView);
    }

    @Override
    public void onBindViewHolder(MapListAdapter.Viewholder holder, int position) {
        // Change texts
        HashMap<String, String> googlePlace = nearbyPlaceList.get(position);

        String placeName = googlePlace.get("place_name");
        String vicinity = googlePlace.get("vicinity");
        double lat = Double.parseDouble( googlePlace.get("lat"));
        double lng = Double.parseDouble( googlePlace.get("lng"));

        holder.textName.setText(placeName);
        holder.textReference.setText(vicinity);
    }

    @Override
    public int getItemCount() {
        return nearbyPlaceList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView textReference;
        TextView textName;

        public Viewholder(View itemView) {
            super(itemView);
            textReference = itemView.findViewById(R.id.reference);
            textName= itemView.findViewById(R.id.name);
        }
    }

    public void setDataset(List<HashMap<String, String>> dataset) {
        this.nearbyPlaceList = dataset;
        notifyDataSetChanged();
    }
}


