package com.example.rony.allaboutcse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class EightSyllabusActivity extends AppCompatActivity {

    ListView subjectList;
    ArrayList<String> subject;
    ArrayList<String> details;
    ListViewCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eight_syllabus);
        getSupportActionBar().setTitle("Eighth Semester Syllabus");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        subjectList =(ListView) findViewById(R.id.lvAlbumList);
        fillData();
        adapter = new ListViewCustomAdapter(getApplicationContext(), subject, details);

        subjectList.setAdapter(adapter);

        subjectList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position,
                                    long id) {


                switch(position){

                    case 0:
                    {
                        Intent i= new Intent(EightSyllabusActivity.this,CSE421Activity.class);
                        startActivity(i);
                        break;
                    }
                    case 1:
                    {


                        Intent i= new Intent(EightSyllabusActivity.this,CSE422Activity.class);
                        startActivity(i);
                        break;
                    }
                    case 2:
                    {
                        Intent i= new Intent(EightSyllabusActivity.this,CSE423Activity.class);
                        startActivity(i);
                        break;
                    }
                    case 3:
                    {
                        Intent i= new Intent(EightSyllabusActivity.this,CSE427Activity.class);
                        startActivity(i);
                        break;
                    }
                    case 4:
                    {
                        Intent i= new Intent(EightSyllabusActivity.this,CSE499Activity.class);
                        startActivity(i);
                        break;
                    }

                    default:
                        break;

                }

            }
        });

    }

    private void fillData() {

        subject = new ArrayList<String>();
        details = new ArrayList<String>();

        subject.add("Web Engineering");
        subject.add("Web Engineering Practical");
        subject.add("Computer and Network Security");
        subject.add("Elective Course*");
        subject.add("Project **");



        details.add("3 hours in a week      3 Cr.");
        details.add("3 hours in a week      1.5 Cr.");
        details.add("3 hours in a week      3 Cr.");
        details.add("3 hours in a week      3 Cr.");
        details.add("3 hours in a week      6 Cr.");


    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }

        else if (id == R.id.action_settings) {
            Intent i=new Intent(EightSyllabusActivity.this, AboutUsActivity.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
