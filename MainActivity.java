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

import static com.example.android.chelseaquiz.R.id.pytanie1odp;
import static com.example.android.chelseaquiz.R.id.pytanie1odp1;
import static com.example.android.chelseaquiz.R.id.pytanie1odp2;
import static com.example.android.chelseaquiz.R.id.pytanie1odp3;
import static com.example.android.chelseaquiz.R.id.pytanie1odp4;
import static com.example.android.chelseaquiz.R.id.pytanie4odp;
import static com.example.android.chelseaquiz.R.id.pytanie4odp1;
import static com.example.android.chelseaquiz.R.id.pytanie4odp2;
import static com.example.android.chelseaquiz.R.id.pytanie5odp1;
import static com.example.android.chelseaquiz.R.id.pytanie5odp2;
import static com.example.android.chelseaquiz.R.id.pytanie5odp3;


public class MainActivity extends AppCompatActivity {

    boolean checking = true;
    int result = 0;
    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;
    CheckBox checkBox4;
    RadioGroup radioGroup1;
    RadioButton quest1_answ1;
    RadioButton quest1_answ2;
    RadioButton quest1_answ3;
    RadioButton quest1_answ4;
    RadioButton quest4_answ1;
    RadioButton quest4_answ2;
    RadioButton quest5_answ1;
    RadioButton quest5_answ2;
    RadioButton quest5_answ3;
    RadioGroup radioGroup4;
    RadioGroup radioGroup5;
    EditText quest3;
    String score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        checkBox4 = (CheckBox) findViewById(R.id.checkBox4);
        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        quest1_answ1 = (RadioButton) findViewById(pytanie1odp1);
        quest1_answ2 = (RadioButton) findViewById(pytanie1odp2);
        quest1_answ3 = (RadioButton) findViewById(pytanie1odp3);
        quest1_answ4 = (RadioButton) findViewById(pytanie1odp4);
        quest4_answ1 = (RadioButton) findViewById(pytanie4odp1);
        quest4_answ2 = (RadioButton) findViewById(pytanie4odp2);
        quest5_answ1 = (RadioButton) findViewById(pytanie5odp1);
        quest5_answ2 = (RadioButton) findViewById(pytanie5odp2);
        quest5_answ3 = (RadioButton) findViewById(pytanie5odp3);
        quest3 = (EditText) findViewById(R.id.pytanie3odp);
        radioGroup1 = (RadioGroup) findViewById(pytanie1odp);
        radioGroup4 = (RadioGroup) findViewById(pytanie4odp);
        radioGroup5 = (RadioGroup) findViewById(R.id.pytanie5odp);
        score = getString(R.string.score1);

    }

    //check button
    public void onCheckClick(View view) {


        if (checking) {

            question1Checking();
            question2Checking();
            question3Checking();
            question4Checking();
            question5Checking();
            coloringRightAnswers();

            Toast.makeText(this, getString(R.string.youGot) + " " + result + " " + getString(R.string.pointsoutof),
                    Toast.LENGTH_LONG).show();
            //showing message on screen
            String Test = "\n"+ getString(R.string.youGot)+" " + result + " "+ getString(R.string.pointsoutof);
            displayMessage(Test);
            result = 0;
        }

    }

    //question 1
    private void question1Checking() {
        int checked = radioGroup1.getCheckedRadioButtonId();

        switch (checked) {
            case pytanie1odp1:

                result += 1;
                break;
            case pytanie1odp2:

                break;
            case pytanie1odp3:

                break;
            case pytanie1odp4:

                break;

        }

    }

    //question 2
    private void question2Checking() {

        boolean checkedBox1 = checkBox1.isChecked();
        boolean checkedBox2 = checkBox2.isChecked();
        boolean checkedBox3 = checkBox3.isChecked();
        boolean checkedBox4 = checkBox4.isChecked();


        if (checkedBox3 && checkedBox4 && !checkedBox1 && !checkedBox2)
            result += 1;


    }

    //question 3
    private void question3Checking() {

        String answer = quest3.getText().toString();
        if (answer.equals("5")) {
            result += 1;
            quest3.setTextColor(Color.GREEN);
        } else {
            quest3.setTextColor(Color.RED);
        }


    }

    //question 4
    private void question4Checking() {


        int checked = radioGroup4.getCheckedRadioButtonId();


        switch (checked) {
            case pytanie4odp1:

                break;
            case pytanie4odp2:
                result += 1;
                break;


        }
    }

    //question 5
    private void question5Checking() {

        int checked = radioGroup5.getCheckedRadioButtonId();


        switch (checked) {
            case pytanie5odp1:
                result += 1;
                break;
            case pytanie5odp2:

                break;
            case pytanie5odp3:

                break;


        }
    }

    //reset button
    public void Reset(View view) {

        //quest 1,4,5 reset
        RadioGroup radioGroup = (RadioGroup) findViewById(pytanie1odp);
        RadioGroup radioGroup2 = (RadioGroup) findViewById(pytanie4odp);
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


        quest3.setText("");
        quest3.setTextColor(Color.BLACK);

        //coloring reset
        resetingColors();

        //reseting message
        String test="";
        displayMessage(test);


    }

    //coloring right answers
    public void coloringRightAnswers() {

        //coloring question 1

        quest1_answ1.setTextColor(Color.GREEN);
        quest1_answ2.setTextColor(Color.RED);
        quest1_answ3.setTextColor(Color.RED);
        quest1_answ4.setTextColor(Color.RED);
        //coloring question 2
        checkBox1.setTextColor(Color.RED);
        checkBox2.setTextColor(Color.RED);
        checkBox3.setTextColor(Color.GREEN);
        checkBox4.setTextColor(Color.GREEN);
        //coloring question 3 (in method)
        //coloring question 4
        quest4_answ1.setTextColor(Color.RED);
        quest4_answ2.setTextColor(Color.GREEN);

        //coloring question 5
        quest5_answ1.setTextColor(Color.GREEN);
        quest5_answ2.setTextColor(Color.RED);
        quest5_answ3.setTextColor(Color.RED);


    }

    //reseting colors with reset button
    public void resetingColors() {

        //coloring question 1
        quest1_answ1.setTextColor(Color.BLACK);
        quest1_answ2.setTextColor(Color.BLACK);
        quest1_answ3.setTextColor(Color.BLACK);
        quest1_answ4.setTextColor(Color.BLACK);

        //coloring question 2
        checkBox1.setTextColor(Color.BLACK);
        checkBox2.setTextColor(Color.BLACK);
        checkBox3.setTextColor(Color.BLACK);
        checkBox4.setTextColor(Color.BLACK);
        //coloring questio 3 (in method)
        //coloring questio 4
        quest4_answ1.setTextColor(Color.BLACK);
        quest4_answ2.setTextColor(Color.BLACK);
        //coloring questio 5
        quest5_answ1.setTextColor(Color.BLACK);
        quest5_answ2.setTextColor(Color.BLACK);
        quest5_answ3.setTextColor(Color.BLACK);
    }

    private void displayMessage(String message) {
        TextView summaryScoreView = (TextView) findViewById(R.id.score);
        summaryScoreView.setText(message);
        summaryScoreView.setTextColor(Color.WHITE);

    }
}



