package com.example.search;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<data> list1;
    adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setList1();
        recyclerView = findViewById(R.id.rv);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new adapter(list1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
    private void setList1(){
        list1 = new ArrayList<>();
        list1.add(new data("item0","0"));
        list1.add(new data("item1","1"));
        list1.add(new data("item2","2"));
        list1.add(new data("item3","3"));
        list1.add(new data("item4","4"));
        list1.add(new data("item5","5"));
        list1.add(new data("item5","6"));
        list1.add(new data("item6","7"));
        list1.add(new data("item7","8"));
        list1.add(new data("item8","9"));
        list1.add(new data("xitem1","10"));
        list1.add(new data("citem1","11"));
        list1.add(new data("vitem1","12"));
        list1.add(new data("bitem1","13"));
        list1.add(new data("bitem12","14"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater =getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        MenuItem search_item = menu.findItem(R.id.search_icon);
        SearchView searchView = (SearchView) search_item.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setQueryHint("search");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
              adapter.getFilter().filter(s);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
