package com.tuantran.recycleview_bai2_buoi4.bai3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tuantran.recycleview_bai2_buoi4.R;

import java.util.ArrayList;

public class FolderAdapter extends RecyclerView.Adapter<FolderAdapter.MyViewHolder>{
    private ArrayList<DataFolder> dataFolders;
    private Context context;


    public FolderAdapter(ArrayList<DataFolder> dataFolders, Context context) {
        this.dataFolders = dataFolders;
        this.context = context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context  = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View folderView = inflater.inflate(R.layout.item_folder,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(folderView);
        return viewHolder.LinkAdapter(this);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            DataFolder dataFolder = dataFolders.get(position);
            holder.ten.setText(dataFolder.getTen());


    }

    @Override
    public int getItemCount() {
        return dataFolders.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        private FolderAdapter adapter;
        public TextView ten;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            ten = itemView.findViewById(R.id.txtTen);
            itemView.findViewById(R.id.imgbtnXoa).setOnClickListener(v -> {
                adapter.dataFolders.remove(getAdapterPosition());
                adapter.notifyItemRemoved(getAdapterPosition());
            });
            itemView.findViewById(R.id.imgbtnSua).setOnClickListener(v -> {
                adapter.dataFolders.get(getAdapterPosition()).setTen("");
                adapter.notifyDataSetChanged();
            });

        }
        public MyViewHolder LinkAdapter(FolderAdapter adapter){
            this.adapter = adapter;
            return this;
        }
    }
}
