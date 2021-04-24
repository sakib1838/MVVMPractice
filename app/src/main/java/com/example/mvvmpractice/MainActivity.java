package com.example.mvvmpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mvvmpractice.Adapter.RecyclerViewFAQAdapter;
import com.example.mvvmpractice.ModelView.FAQModelView;
import com.example.mvvmpractice.PojoClass.FAQEntity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<FAQEntity>faqModelList;
    RecyclerView recyclerView;
    RecyclerViewFAQAdapter faqAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerViewFAQ);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        faqAdapter=new RecyclerViewFAQAdapter(this,faqModelList);
        recyclerView.setAdapter(faqAdapter);
        //listView=(ListView)findViewById(R.id.recyclerViewFAQ);

        final FAQModelView faqModelView= ViewModelProviders.of(MainActivity.this).get(FAQModelView.class);
        faqModelView.getFAQLiveData().observe(this, new Observer<List<FAQEntity>>() {
            @Override
            public void onChanged(List<FAQEntity> faqEntities) {
                faqModelList=faqEntities;
                //recyclerViewFAQAdapter=new RecyclerViewFAQAdapter(FaqListActivity.this,faqEntities);
                //recyclerView.setAdapter(recyclerViewFAQAdapter);
                //listViewAdapterFAQ= new ListViewAdapterFAQ(FaqListActivity.this,faqEntities);
                //listView.setAdapter(listViewAdapterFAQ);
                faqAdapter.setFAQ(faqModelList);
                System.out.println(faqEntities.size());
            }
        });




    }
}