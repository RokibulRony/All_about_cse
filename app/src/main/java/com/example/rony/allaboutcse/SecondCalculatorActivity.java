package com.example.rony.allaboutcse;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.text.DecimalFormat;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class SecondCalculatorActivity extends AppCompatActivity {

    private Button btnSubmit;

    // grades
    private Spinner grade1,grade2,grade3,grade4,grade5,grade6,grade7;
    private double vgrade1=0.0,vgrade2=0.0,vgrade3=0.0,vgrade4=0.0,vgrade5=0.0,vgrade6=0.0,vgrade7=0.0;
    private double gpoint1=0.0,gpoint2=0.0,gpoint3=0.0,gpoint4=0.0,gpoint5=0.0,gpoint6=0.0,gpoint7=0.0;
    View rootView;
    private double finalCGPA = 0.0;
    private int c=0,b=0;
    private String cgpa;
    private static final int DIALOG_ALERT = 10;
    private String info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_calculator);
        getSupportActionBar().setTitle("Calculation Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btnSubmit = (Button)findViewById(R.id.calculate);
        grade1 = (Spinner)findViewById(R.id.spinner1);
        grade2 = (Spinner)findViewById(R.id.spinner2);
        grade3 = (Spinner)findViewById(R.id.spinner3);
        grade4 = (Spinner)findViewById(R.id.spinner4);
        grade5 = (Spinner)findViewById(R.id.spinner5);
        grade6 = (Spinner)findViewById(R.id.spinner6);
        grade7 = (Spinner)findViewById(R.id.spinner7);
        addListenerOnButton();
    }

    public void addListenerOnButton() {


        btnSubmit.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                addListenerOnButton();

                retrieve();

                Calculate();


                Builder builder = new AlertDialog.Builder(SecondCalculatorActivity.this);
                DecimalFormat df = new DecimalFormat("0.00");


                if(b==1){

                    reset();
                    info = "Please Fill The Subject Grade";
                    Toast.makeText(getApplicationContext(), "Please Fill The Subject Grade",
                            Toast.LENGTH_LONG).show();
                    addListenerOnButton();

                }

                else if(c>0){
                    info = "Total Credit : 18"+ "\nTotal Subject :  7"+"\nFail In  :" +"  "+ c + "  Subject "
                            + "\nYour CGPA  : " + df.format(finalCGPA) + "("+cgpa+")";
                    builder.setMessage(info);
                    builder.setCancelable(true);
                    builder.setNegativeButton("Go Back", new backListener());
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }

                else{
                    info = "Total Credit : 18" +" "+ "\nTotal Subject: 7"
                            + "\nYour CGPA  : " + df.format(finalCGPA)+ "("+cgpa+")";
                    builder.setMessage(info);
                    builder.setCancelable(true);
                    builder.setNegativeButton("Go Back", new backListener());
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }

            }

        });

    }
    public void retrieve(){

        //retrieve Grades

        vgrade1 = convertGrade(String.valueOf(grade1.getSelectedItem()));
        vgrade2 = convertGrade(String.valueOf(grade2.getSelectedItem()));
        vgrade3 = convertGrade(String.valueOf(grade3.getSelectedItem()));
        vgrade4 = convertGrade(String.valueOf(grade4.getSelectedItem()));
        vgrade5 = convertGrade(String.valueOf(grade5.getSelectedItem()));
        vgrade6 = convertGrade(String.valueOf(grade6.getSelectedItem()));
        vgrade7 = convertGrade(String.valueOf(grade7.getSelectedItem()));

        if(vgrade1==6.0 || vgrade2 ==6.0 || vgrade3==6.0 || vgrade4==6.0 || vgrade5==6.0 || vgrade6==6.0 || vgrade7==6.0){
            b=1;
        }


    }

    public void Calculate(){


        gpoint1 = vgrade1*3;
        gpoint2 = vgrade2*1.5;
        gpoint3 = vgrade3*3;
        gpoint4 = vgrade4*1.5;
        gpoint5 = vgrade5*3;
        gpoint6 = vgrade6*3;
        gpoint7 = vgrade7*3;

        if (gpoint1==0)
            c=c+1;
        if (gpoint2==0)
            c=c+1;
        if (gpoint3==0)
            c=c+1;
        if (gpoint4==0)
            c=c+1;
        if (gpoint5==0)
            c=c+1;
        if (gpoint6==0)
            c=c+1;

        double currentpoint =  gpoint1 + gpoint2 + gpoint3 + gpoint4 + gpoint5 + gpoint6+ gpoint7;

        finalCGPA= currentpoint/18;


        if(finalCGPA<2.00)
            cgpa="F";
        if(finalCGPA >= 2.00 && finalCGPA<2.25)
            cgpa="D";
        if(finalCGPA >= 2.25 && finalCGPA<2.50)
            cgpa="C";
        if(finalCGPA >= 2.50 && finalCGPA<2.75)
            cgpa="C+";
        if(finalCGPA >= 2.75 && finalCGPA<3.00)
            cgpa="B-";
        if(finalCGPA >= 3.00 && finalCGPA<3.25)
            cgpa="B";
        if(finalCGPA >= 3.25 && finalCGPA<3.50)
            cgpa="B+";
        if(finalCGPA >= 3.50 && finalCGPA<3.75)
            cgpa="A-";
        if(finalCGPA >= 3.75 && finalCGPA<4.00)
            cgpa="A";
        if(finalCGPA==4.00)
            cgpa="A+";
    }



    public double convertGrade(String grade){
        double cgrade = 0.0;

        if(grade.equals("A+")){
            cgrade = 4.0;
        } else if(grade.equals("A")){
            cgrade = 3.75;
        } else if(grade.equals("A-")){
            cgrade = 3.50;
        } else if(grade.equals("B+")) {
            cgrade = 3.25;
        } else if(grade.equals("B")){
            cgrade = 3.00;
        } else if(grade.equals("B-")){
            cgrade = 2.75;
        } else if(grade.equals("C+")){
            cgrade = 2.50;
        } else if(grade.equals("C")) {
            cgrade = 2.25;
        } else if(grade.equals("D")) {
            cgrade = 2.0;
        }
        else if(grade.equals("F")) {
            cgrade = 0.0;
        } else {
            cgrade = 6.0;
        }

        return cgrade;
    }

    private final class backListener implements
            DialogInterface.OnClickListener {
        public void onClick(DialogInterface dialog, int which) {
            reset();
            Toast.makeText(getApplicationContext(), "Calculate Another CGPA",
                    Toast.LENGTH_LONG).show();
        }
    }

    private void reset(){
        vgrade1=0.0;vgrade2=0.0;vgrade3=0.0;vgrade4=0.0;vgrade5=0.0; vgrade6=0.0;vgrade7=0.0;
        gpoint1=0.0;gpoint2=0.0;gpoint3=0.0;gpoint4=0.0;gpoint5=0.0;gpoint6=0.0;gpoint7=0.0;
        finalCGPA = 0.0;
        c=0;b=0;
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
            Intent i=new Intent(SecondCalculatorActivity.this, AboutUsActivity.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
