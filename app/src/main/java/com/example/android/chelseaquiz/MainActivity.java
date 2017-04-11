package com.example.android.chelseaquiz;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AbsSpinner;

import static com.example.android.chelseaquiz.R.id.pytanie1;
import static com.example.android.chelseaquiz.R.id.pytanie1odp;

import static com.example.android.chelseaquiz.R.id.pytanie1odp1;
import static com.example.android.chelseaquiz.R.id.pytanie1odp2;
import static com.example.android.chelseaquiz.R.id.radio;
import static com.example.android.chelseaquiz.R.string.question1;


public class MainActivity extends AppCompatActivity {

    boolean checking = true;
    int result=0;
    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;
    CheckBox checkBox4;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        checkBox4 = (CheckBox) findViewById(R.id.checkBox4);


    }
    public void onCheckClick(View view){

        if (checking){

            question1Checking();
            question2Checking();
            question3Checking();
            question4Checking();
            question5Checking();
            coloringRightAnswers();
            RadioGroup radioGroup = (RadioGroup) findViewById(R.id.pytanie1odp);


            Toast.makeText(this, getString(R.string.youGot)+" " + result +" " +getString(R.string.pointsoutof),
                    Toast.LENGTH_LONG).show();
            result=0;

        }

    }

    private void question1Checking(){
        RadioGroup radioGroup = (RadioGroup) findViewById(pytanie1odp);
        int checked = radioGroup.getCheckedRadioButtonId();



        switch (checked) {
            case pytanie1odp1:

                result+=1;
                break;
            case pytanie1odp2:

                break;
            case R.id.pytanie1odp3:

                break;
            case R.id.pytanie1odp4:

                break;






        }

    }

    private void question2Checking() {
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        boolean checkedBox1 = checkBox1.isChecked();
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        boolean checkedBox2 = checkBox2.isChecked();
        CheckBox checkBox3= (CheckBox) findViewById(R.id.checkBox3);
        boolean checkedBox3 = checkBox3.isChecked();
        CheckBox checkBox4 = (CheckBox) findViewById(R.id.checkBox4);
        boolean checkedBox4 = checkBox4.isChecked();


        if (checkedBox3 && checkedBox4 && !checkedBox1 && !checkedBox2)
            result+= 1;


    }

    private void question3Checking(){
        EditText quest3 = (EditText) findViewById(R.id.pytanie3odp);
        String answer = quest3.getText().toString();
        if (answer.equals("5"))
            result+=1;




    }

    private void question4Checking() {

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.pytanie4odp);
        int checked = radioGroup.getCheckedRadioButtonId();


        switch (checked) {
            case R.id.pytanie4odp1:

                break;
            case R.id.pytanie4odp2:
                result += 1;
                break;


        }
    }

    private void question5Checking(){

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.pytanie5odp);
        int checked = radioGroup.getCheckedRadioButtonId();


        switch (checked) {
            case R.id.pytanie5odp1:
                result += 1;
                break;
            case R.id.pytanie5odp2:

                break;
            case R.id.pytanie5odp3:

                break;


        }
    }

    public void Reset(View view){

        //quest 1,4,5 reset
        RadioGroup radioGroup = (RadioGroup) findViewById(pytanie1odp);
        RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.pytanie4odp);
        RadioGroup radioGroup3 = (RadioGroup) findViewById(R.id.pytanie5odp);
        radioGroup.clearCheck();
        radioGroup2.clearCheck();
        radioGroup3.clearCheck();



        //quest 2 reset
        checkBox1.setChecked(false);
        checkBox2.setChecked(false);
        checkBox3.setChecked(false);
        checkBox4.setChecked(false);
        //question 3 reset

        EditText quest3 = (EditText) findViewById(R.id.pytanie3odp);
        quest3.setText(" ");

        //coloring reset
        resetingColors();

    }

    public void coloringRightAnswers(){

        //coloring question 1


        //coloring question 2
        checkBox1.setTextColor(Color.RED);
        checkBox2.setTextColor(Color.RED);
        checkBox3.setTextColor(Color.GREEN);
        checkBox4.setTextColor(Color.GREEN);
        //coloring questio 3




        //coloring questio 4

        //coloring questio 5


    }
    public void resetingColors(){

        //coloring question 1



        //coloring question 2
        checkBox1.setTextColor(Color.BLACK);
        checkBox2.setTextColor(Color.BLACK);
        checkBox3.setTextColor(Color.BLACK);
        checkBox4.setTextColor(Color.BLACK);
        //coloring questio 3




        //coloring questio 4

        //coloring questio 5
    }


}


