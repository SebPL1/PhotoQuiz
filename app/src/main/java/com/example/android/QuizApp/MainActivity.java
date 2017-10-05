
package com.example.android.QuizApp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Toast;

import static com.example.android.QuizApp.R.id.baq4;

public class MainActivity extends AppCompatActivity {

    int result;
    RadioButton ansQ1;
    RadioButton ansQ2;
    CheckBox ansQ31;
    CheckBox ansQ33;
    EditText ansQ4;
    ScrollView scrollView;
    EditText nameInput;
    String corrAnswer;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ansQ1 = (RadioButton) findViewById(R.id.bq1a3);
        ansQ2 = (RadioButton) findViewById(R.id.bq1a3);
        ansQ31 = (CheckBox) findViewById(R.id.bq3a1);
        ansQ33 = (CheckBox) findViewById(R.id.bq3a3);
        ansQ4 = (EditText) findViewById(baq4);


        scrollView = (ScrollView) findViewById(R.id.activity_main);
        nameInput = (EditText) findViewById(R.id.name_input);
    }


    private int setGameScore() {
        result = 0;
        corrAnswer = getString(R.string.q4a2);

        boolean checkQ1 = ansQ1.isChecked();
        if (checkQ1) {
            result += 1;
        } else {
            result += 0;
        }

        boolean checkQ2 = ansQ2.isChecked();
        if (checkQ2) {
            result += 1;
        } else {
            result += 0;
        }

        boolean checkQ3 = ansQ31.isChecked() && ansQ33.isChecked();
        if (checkQ3) {
            result += 1;
        } else {
            result += 0;
        }


        EditText checkQ4 = (EditText) findViewById(R.id.baq4);
        String answer = checkQ4.getText().toString().toLowerCase();
        if (answer.equals(corrAnswer)) {
            result += 1;
        } else {
            result += 0;
        }
        return result;
    }


    public void finalMessage(int result) {

        String name = nameInput.getText().toString();
        Toast.makeText(this, getString(R.string.congrat) + name + getString(R.string.congrat2) + result + getString(R.string.outof), Toast.LENGTH_LONG).show();

    }

    public void displayFinalResult(View view) {
        setGameScore();
        finalMessage(result);
    }

    public void resetResults(View view) {
        RadioGroup question1RadioGroup = (RadioGroup) findViewById(R.id.rg1);
        question1RadioGroup.clearCheck();

        result = 0;
        ansQ4.setText(getString(R.string.blank));
        nameInput.setText(getString(R.string.blank));
        nameInput.requestFocus();

    }
}

