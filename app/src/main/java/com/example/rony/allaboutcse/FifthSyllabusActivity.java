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

public class FifthSyllabusActivity extends AppCompatActivity {

    ListView subjectList;
    ArrayList<String> subject;
    ArrayList<String> details;
    ListViewCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth_syllabus);
        getSupportActionBar().setTitle("Fifth Semester Syllabus");
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
                        Intent i= new Intent(FifthSyllabusActivity.this,CSE311Activity.class);
                        startActivity(i);
                        break;
                    }
                    case 1:
                    {


                        Intent i= new Intent(FifthSyllabusActivity.this,CSE312Activity.class);
                        startActivity(i);
                        break;
                    }
                    case 2:
                    {
                        Intent i= new Intent(FifthSyllabusActivity.this,CSE313Activity.class);
                        startActivity(i);
                        break;
                    }
                    case 3:
                    {
                        Intent i= new Intent(FifthSyllabusActivity.this,CSE314Activity.class);
                        startActivity(i);
                        break;
                    }
                    case 4:
                    {
                        Intent i= new Intent(FifthSyllabusActivity.this,CSE315Activity.class);
                        startActivity(i);
                        break;
                    }
                    case 5:
                    {
                        Intent i= new Intent(FifthSyllabusActivity.this,CSE316Activity.class);
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

        subject.add("Theory of Computation");
        subject.add("Microprocessor and Assembly Language");
        subject.add("Assembly Language Practical");
        subject.add("Engineering Mathematics");
        subject.add("Sociology");
        subject.add("Technical Writing & Communications");


        details.add("3 hours in a week      3 Cr.");
        details.add("3 hours in a week      3 Cr.");
        details.add("3 hours in a week      1.5 Cr.");
        details.add("3 hours in a week      3 Cr.");
        details.add("3 hours in a week      3 Cr.");
        details.add("3 hours in a week      3 Cr.");

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
            Intent i=new Intent(FifthSyllabusActivity.this, AboutUsActivity.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
