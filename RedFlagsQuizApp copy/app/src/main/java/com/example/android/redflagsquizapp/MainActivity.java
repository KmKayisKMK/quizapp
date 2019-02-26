package com.example.android.redflagsquizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the submit button is clicked.
     */
    public void submitQuiz(View view) {

        //This method allows a user to enter their name
        EditText nameField = findViewById(R.id.name_field);
        String name = nameField.getText().toString();

        //This method allows the user to denote they have seen recent avalanches
        CheckBox recentAvalanchesQuestion = findViewById(R.id.recent_avalanches_question);
        boolean recentAvalanches = recentAvalanchesQuestion.isChecked();

        //This method allows the user to denote they have seen snow pack failures
        CheckBox snowPackFailuresQuestion = findViewById(R.id.snowpack_failures_question);
        boolean snowPackFailures = snowPackFailuresQuestion.isChecked();

        //This method allows the user to denote that there has been significant snowfall
        CheckBox recentSnowFallQuestion = findViewById(R.id.significant_snowfall_question);
        boolean recentSnowFall = recentSnowFallQuestion.isChecked();

        //This method allows the user to denote there has been significant wind event
        CheckBox recentWindEventQuestion = findViewById(R.id.strong_winds_question);
        boolean recentWindEvent = recentWindEventQuestion.isChecked();

        //This method allows the user to denote there has been a significant temperature change
        CheckBox tempChangeQuestion = findViewById(R.id.temperature_change_question);
        boolean tempChange = tempChangeQuestion.isChecked();

        //This method allows the user to denote if there are human factors present
        CheckBox humanFactorsQuestion = findViewById(R.id.human_factor_question);
        boolean humanFactors = humanFactorsQuestion.isChecked();

        //This method displays Toast when it is safe to ski tour
        if (score <= 1) {
            Toast.makeText(this, name + ", it may be safe to ski tour, proceed with caution", Toast.LENGTH_SHORT).show();
            return;
        }
        if (score == 2) {
            Toast.makeText(this, name + ", it is quetionable whether or not you should ski tour here, proceed with EXTREME caution", Toast.LENGTH_SHORT).show();
            return;
        }
        if (score >= 3) {
            Toast.makeText(this, name + ", avalanche hazard is HIGH, DO NOT PROCEED TO SKI TOUR in area", Toast.LENGTH_SHORT).show();
            return;
        }

        /**
         * This method calculates the score of the quiz
         */
        private int calculateScore ( boolean recentAvalanches, boolean snowPackFailures,
        boolean recentSnowfall,
        boolean windEvent, boolean tempChange, boolean humanFactors){

            if (recentAvalanches) {
                score = score + 1;
            }
            if (snowPackFailures) {
                score = score + 1;
            }
            if (recentSnowfall) {
                score = score + 1;
            }
            if (windEvent) {
                score = score + 1;
            }
            if (tempChange) {
                score = score + 1;
            }
            if (humanFactors) {
                score = score + 1;
            }
            return score;
        }

    }
}