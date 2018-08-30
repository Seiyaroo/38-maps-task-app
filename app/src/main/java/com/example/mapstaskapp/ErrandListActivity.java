package com.example.mapstaskapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ErrandListActivity
        extends AppCompatActivity implements ValueEventListener {
    @BindView(R.id.errands) RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    ErrandAdapter errandAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_errand_list);

        ButterKnife.bind(this);

        DatabaseReference errands = FirebaseDataBase.getInstance().getReference("errands");
        errands.addValueEventListener(this);

        LinearLayoutManager = new LinearLayoutManager();
        errandAdapter = new ErrandAdapter();

        RecyclerView.setLayoutManager(linearLayoutManager);
        RecyclerView.setAdapter(errandAdapter);
    }

    @Override
    public void onDataChange(DataSnapShot dataSnapShot) {
        List<Errand> errands = new ArrayList<>();
        for (DataSnapshot snapshot : dataSnapShot.getChildren()) {
            errands.add(Errand.fromSnapshot(snapshot));
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
}
