package com.tuantran.recycleview_bai2_buoi4.bai3;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tuantran.recycleview_bai2_buoi4.R;

import java.util.ArrayList;

public class FolderManager extends AppCompatActivity {
            ArrayList<DataFolder> dataFolders = new ArrayList<>();
            FolderAdapter folderAdapter ;
            private int i = 1;
            RecyclerView recyclerView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.foldermanager);
        InitView();
        initToolbar();


    }
    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_ios_new_24);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        toolbar.inflateMenu(R.menu.menu_folder);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menufolder:
                        i++;
                       dataFolders.add(new DataFolder("New Folder: "+ i));
                       folderAdapter.notifyDataSetChanged();
                        break;

                }
                return false;
            }
        });

    }
    private void InitView(){
        recyclerView = (RecyclerView) findViewById(R.id.recycle2);

        dataFolders.add(new DataFolder("Video"));
        dataFolders.add(new DataFolder("Android"));
        dataFolders.add(new DataFolder("Applock"));
        dataFolders.add(new DataFolder("Books"));
        dataFolders.add(new DataFolder("map"));
        dataFolders.add(new DataFolder("Authenticate Using Google"));
        dataFolders.add(new DataFolder("New Folder"));
        dataFolders.add(new DataFolder("New folder 1"));


        folderAdapter = new FolderAdapter(dataFolders,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setAdapter(folderAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);


    }
}
