package com.tuantran.recycleview_bai2_buoi4.PDF;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tuantran.recycleview_bai2_buoi4.R;

import java.util.ArrayList;

public class PdfAdapter extends RecyclerView.Adapter<PdfAdapter.ViewHolder> {

    ArrayList<DataPdf> dataPdfs = new ArrayList<>();

    public PdfAdapter(ArrayList<DataPdf> dataPdfs) {
        this.dataPdfs = dataPdfs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pdf,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.title.setText(dataPdfs.get(position).getMota());
    }

    @Override
    public int getItemCount() {
        return dataPdfs.size();
    }

    public class  ViewHolder extends RecyclerView.ViewHolder{
      private TextView title ;


      public ViewHolder(@NonNull View itemView) {
          super(itemView);
          title = itemView.findViewById(R.id.tv_name_pdf);

      }
  }

}
