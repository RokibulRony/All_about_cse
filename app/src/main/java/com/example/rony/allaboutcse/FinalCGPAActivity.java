package com.example.rony.allaboutcse;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DecimalFormat;

public class FinalCGPAActivity extends AppCompatActivity {


    EditText editText2,editText3,editText4,editText5,editText6,editText7,editText8,editText9;
    private Button btnSubmit;
    private double vgrade1=0.0,vgrade2=0.0,vgrade3=0.0,vgrade4=0.0,vgrade5=0.0,vgrade6=0.0,vgrade7=0.0,vgrade8=0.0;
    private double gpoint1=0.0,gpoint2=0.0,gpoint3=0.0,gpoint4=0.0,gpoint5=0.0,gpoint6=0.0,gpoint7=0.0,gpoint8=0.0;
    private double finalCGPA = 0.0;
    private double currentpoint =0.0;
    private int c=0,b=0;
    private String cgpa;
    private static final int DIALOG_ALERT = 10;
    private String info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_cgpa);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btnSubmit = (Button)findViewById(R.id.calculate);
        editText2= (EditText) findViewById(R.id.editText2);
        editText3= (EditText) findViewById(R.id.editText3);
        editText4= (EditText) findViewById(R.id.editText4);
        editText5= (EditText) findViewById(R.id.editText5);
        editText6= (EditText) findViewById(R.id.editText6);
        editText7= (EditText) findViewById(R.id.editText7);
        editText8= (EditText) findViewById(R.id.editText8);
        editText9= (EditText) findViewById(R.id.editText9);
        addListenerOnButton();
    }

    public void addListenerOnButton() {


        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                addListenerOnButton();

                retrieve();

                Calculate();


                AlertDialog.Builder builder = new AlertDialog.Builder(FinalCGPAActivity.this);
                DecimalFormat df = new DecimalFormat("0.00");


                if(b==1){

                    reset();
                    info = "Please Fill All Semester GPA";
                    Toast.makeText(getApplicationContext(), "Please Fill All Semester GPA",
                            Toast.LENGTH_LONG).show();
                    addListenerOnButton();

                }

               else if(b==2){

                    reset();
                    Toast.makeText(getApplicationContext(), "Please Enter A Valid GPA",
                            Toast.LENGTH_LONG).show();
                    addListenerOnButton();

                }
                else{
                    info = "Your Final CGPA  : " + df.format(finalCGPA) + "("+cgpa+")";
                    builder.setMessage(info);
                    builder.setCancelable(true);
                    builder.setNegativeButton("Go Back", new FinalCGPAActivity.backListener());
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }


            }

        });

    }
    public void retrieve(){

        //retrieve Grades
        vgrade1 = Double.parseDouble(editText2.getText().toString());
        vgrade2 = Double.parseDouble(editText3.getText().toString());
        vgrade3 = Double.parseDouble(editText4.getText().toString());
        vgrade4 = Double.parseDouble(editText5.getText().toString());
        vgrade5 = Double.parseDouble(editText6.getText().toString());
        vgrade6 = Double.parseDouble(editText7.getText().toString());
        vgrade7 = Double.parseDouble(editText8.getText().toString());
        vgrade8 = Double.parseDouble(editText9.getText().toString());

        if(vgrade1==6.0 || vgrade2 ==6.0 || vgrade3==6.0 || vgrade4==6.0 || vgrade5==6.0 || vgrade6==6.0 || vgrade7==6.0 || vgrade8==6.0){
            b=1;

            if (vgrade1 >4.0 || vgrade2 >4.0 || vgrade3 >4.0 || vgrade4>4.0 || vgrade5>4.0 || vgrade6>4.0 || vgrade7>4.0 || vgrade8>4.0){
                b=2;

            }
        }


    }

    public void Calculate(){


        gpoint1 = vgrade1*16.5;
        gpoint2 = vgrade2*18;
        gpoint3 = vgrade3*22.5;
        gpoint4 = vgrade4*18;
        gpoint5 = vgrade5*16.5;
        gpoint6 = vgrade6*19.5;
        gpoint7 = vgrade7*17.5;
        gpoint8 = vgrade8*16.5;


        double currentpoint =  gpoint1 + gpoint2 + gpoint3 + gpoint4 + gpoint5 + gpoint6+ gpoint7;

        finalCGPA= currentpoint/145;


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


    private final class backListener implements
            DialogInterface.OnClickListener {
        public void onClick(DialogInterface dialog, int which) {
            reset();
            Toast.makeText(getApplicationContext(), "Calculate Another CGPA",
                    Toast.LENGTH_LONG).show();
        }
    }

    private void reset(){
        vgrade1=0.0;vgrade2=0.0;vgrade3=0.0;vgrade4=0.0;vgrade5=0.0; vgrade6=0.0;vgrade7=0.0;vgrade8=0.0;
        gpoint1=0.0;gpoint2=0.0;gpoint3=0.0;gpoint4=0.0;gpoint5=0.0;gpoint6=0.0;gpoint7=0.0;gpoint8=0.0;
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

        return super.onOptionsItemSelected(item);
    }

}

