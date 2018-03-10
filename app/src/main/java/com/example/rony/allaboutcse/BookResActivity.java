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

public class BookResActivity extends AppCompatActivity {

    ListView subjectList;
    ArrayList<String> subject;
    ArrayList<String> details;
    ListViewCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_res);
        getSupportActionBar().setTitle("Books PDF");
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
                        Intent i= new Intent(BookResActivity.this,Book1Activity.class);
                        startActivity(i);
                        break;
                    }
                    case 1:
                    {


                        Intent i= new Intent(BookResActivity.this,Book1Activity.class);
                        startActivity(i);
                        break;
                    }
                    case 2:
                    {
                        Intent i= new Intent(BookResActivity.this,Book2Activity.class);
                        startActivity(i);
                        break;
                    }
                    case 3:
                    {
                        Intent i= new Intent(BookResActivity.this,Book3Activity.class);
                        startActivity(i);
                        break;
                    }
                    case 4:
                    {
                        Intent i= new Intent(BookResActivity.this,Book4Activity.class);
                        startActivity(i);
                        break;
                    }
                    case 5:
                    {
                        Intent i= new Intent(BookResActivity.this,Book1Activity.class);
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

        subject.add("Computer Fundamentals");
        subject.add("Computers and Information System");
        subject.add("Programming in ANSI C");
        subject.add("Physics Part-II");
        subject.add("Differential calculus");
        subject.add("Computer Networking");

        details.add("(4th Edition).-Pradeep K. Sinha");
        details.add("(5th Edition).- Sarah B. Hutchinsonb and Stacey C. Sawyer");
        details.add("E. Balagurusamy, 6th edition");
        details.add("David Halliday and Robert Resin,  6th edition");
        details.add("B.C Das & B. N. Mukherjee");
        details.add("(4th Edition).- Ray Bradly");


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
            Intent i=new Intent(BookResActivity.this, AboutUsActivity.class);
            startActivity(i);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }
}
