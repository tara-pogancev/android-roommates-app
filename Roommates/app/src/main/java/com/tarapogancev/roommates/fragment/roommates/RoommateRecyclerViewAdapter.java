package com.tarapogancev.roommates.fragment.roommates;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tarapogancev.roommates.R;

public class RoommateRecyclerViewAdapter extends RecyclerView.Adapter<RoommateRecyclerViewAdapter.ViewHolder> {

    String[] names;
    Context context;

    public RoommateRecyclerViewAdapter(Context cotnext, String[] names) {
        this.context = cotnext;
        this.names = names;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.card_roommate, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(names[position] + ", 28");
    }

    @Override
    public int getItemCount() {
        return names.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.text_nameAndAge);
        }
    }

}
