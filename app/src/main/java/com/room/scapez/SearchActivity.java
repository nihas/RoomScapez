package com.room.scapez;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Nihas on 12-Jul-15.
 */
public class SearchActivity extends AppCompatActivity {

    Toolbar toolbar;
    List<Person> persons;

    @Override
    public void onBackPressed() {
//        Intent bakView = new Intent(SearchActivity.this, HomeActivity.class);
//        startActivity(bakView);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_city);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });



        initializeData();
        ListView lv = (ListView)findViewById(R.id.lv);
//        rv.setHasFixedSize(true);
//        LinearLayoutManager llm = new LinearLayoutManager(this);
//        rv.setLayoutManager(llm);

        final RVAdapter adapter = new RVAdapter(this,persons);
        lv.setAdapter(adapter);



        // Locate the EditText in listview_main.xml
        final EditText editsearch = (EditText) findViewById(R.id.search_city);
        editsearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
                String text = editsearch.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,
                                          int arg2, int arg3) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {
                // TODO Auto-generated method stub
            }
        });


    }

    private void initializeData(){
        persons = new ArrayList<>();
        persons.add(new Person("Bangalore", "23 years old", ""));
        persons.add(new Person("Delhi", "25 years old", ""));
        persons.add(new Person("Ludhiana", "35 years old", ""));
        persons.add(new Person("Ernakulam", "23 years old", ""));
        persons.add(new Person("Alappuzha", "25 years old", ""));
        persons.add(new Person("Trivandrum", "35 years old", ""));
        persons.add(new Person("Kottayam", "23 years old", ""));
        persons.add(new Person("Idukki", "25 years old", ""));
        persons.add(new Person("Moonnar", "35 years old", ""));
        persons.add(new Person("Kumily", "23 years old", ""));
        persons.add(new Person("Thrissur", "25 years old", ""));
        persons.add(new Person("Hyderabad", "35 years old", ""));
        persons.add(new Person("Kollam", "23 years old", ""));
        persons.add(new Person("Goa", "25 years old", ""));
        persons.add(new Person("Kasargod", "35 years old", ""));
        persons.add(new Person("Kanyakumari", "23 years old", ""));
        persons.add(new Person("Rajasthan", "25 years old", ""));
        persons.add(new Person("Wayanad", "35 years old", ""));
        persons.add(new Person("Palakad", "23 years old", ""));
        persons.add(new Person("Salem", "25 years old", ""));
        persons.add(new Person("Chennai", "35 years old", ""));
        persons.add(new Person("Madhurai", "23 years old", ""));
        persons.add(new Person("Andhra Pradesh", "25 years old", ""));
        persons.add(new Person("Kochi", "35 years old", ""));



    }
}
