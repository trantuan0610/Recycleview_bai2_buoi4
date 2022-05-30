package com.tuantran.recycleview_bai2_buoi4.PDF;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tuantran.recycleview_bai2_buoi4.R;
import com.tuantran.recycleview_bai2_buoi4.bai3.FolderManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
        Button add;
        RecyclerView recyclerView;
        PdfAdapter PdfAdapter;
        private int i =0;
        ArrayList<DataPdf> arrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add = findViewById(R.id.btnAdd);
        InitView();
       initToolbar();


    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.menu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu:
                        Intent intent = new Intent(MainActivity.this, FolderManager.class);
                        startActivity(intent);
                        break;
                    case R.id.search:
                        Toast.makeText(MainActivity.this, "search", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });

    }


    private void InitView(){
         recyclerView = (RecyclerView)findViewById(R.id.ryclerview);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        arrayList.add(new DataPdf("To Kill a Mockingbird "));
        arrayList.add(new DataPdf("To Kill a Mockingbird "));
        arrayList.add(new DataPdf("To Kill a Mockingbird "));
        arrayList.add(new DataPdf("To Kill a Mockingbird "));
        arrayList.add(new DataPdf("To Kill a Mockingbird "));
        arrayList.add(new DataPdf("To Kill a Mockingbird "));
        arrayList.add(new DataPdf("To Kill a Mockingbird "));
        arrayList.add(new DataPdf("To Kill a Mockingbird "));
        arrayList.add(new DataPdf("To Kill a Mockingbird "));

         PdfAdapter = new PdfAdapter(arrayList);
        recyclerView.setAdapter(PdfAdapter);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
               arrayList.add(new DataPdf("File bất kì thứ "+ i));
               PdfAdapter.notifyDataSetChanged();
            }
        });
    }
}