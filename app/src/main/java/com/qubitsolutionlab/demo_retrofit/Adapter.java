package com.qubitsolutionlab.demo_retrofit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.Viewholder> {

    List<ResponseObject> objects;

    public Adapter(List<ResponseObject> alluser) {
        this.objects = alluser;
    }

    @NonNull
    @Override
    public Adapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.iteam_main, parent,false);
        Viewholder viewholder = new Viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.Viewholder holder, int position) {

        holder.view.setText(objects.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        TextView view;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            view = itemView.findViewById(R.id.iteam_txt);
        }

    }
}
