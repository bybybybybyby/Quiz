package com.example.android.quiz;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private RadioButton radioButton;
    private EditText editText2;
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private CheckBox checkBox4;
    private EditText editText4;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextName = findViewById(R.id.name_field);
        radioButton = findViewById(R.id.radio_button_2);
        editText2 = findViewById(R.id.editText_two);
        checkBox1 = findViewById(R.id.masters_checkbox_1);
        checkBox2 = findViewById(R.id.masters_checkbox_2);
        checkBox3 = findViewById(R.id.masters_checkbox_3);
        checkBox4 = findViewById(R.id.masters_checkbox_4);
        editText4 = findViewById(R.id.editText_four);
    }

    /**
     * Shows score message in a toast when Submit button is pressed.
     */
    public void submitOrder(View view) {
        calculateScore();
        Context context = getApplicationContext();
        String stringName = editTextName.getText().toString();
        CharSequence text = getString(R.string.score_message, stringName, score);
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
        score = 0;
    }

    /**
     * Checks answers and returns the total number correct.
     */
    public void calculateScore() {

        /**
         * Question 1 grading
         */
        boolean checked = radioButton.isChecked();
        if (checked) {
            score += 1;
        }

        /**
         * Question 2 grading
         */
        String q2 = editText2.getText().toString();
        if (q2.equalsIgnoreCase("Eldrick")) {
            score += 1;
        }

        /**
         * Question 3 grading
         */
        boolean checkBox1_checked = checkBox1.isChecked();
        boolean checkBox2_checked = checkBox2.isChecked();
        boolean checkBox3_checked = checkBox3.isChecked();
        boolean checkBox4_checked = checkBox4.isChecked();
        if (!checkBox1_checked && checkBox2_checked && !checkBox3_checked && checkBox4_checked) {
            score += 1;
        }

        /**
         * Question 4 grading
         */
        String q4 = editText4.getText().toString();
        if (TextUtils.isEmpty(q4)) {

        } else {
            int q4Num = Integer.parseInt(q4);
            if (q4Num >= 34 && q4Num <= 38) {
                score += 1;
            }
        }
    }
}
