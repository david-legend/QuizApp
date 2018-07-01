package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

//  Initial score
    int score = 0;

//  Answers for questions with Radio Button
    String[] answers = {
            "1880s", "Operating System", "Field", "1900s", "Animation/movie file"
    };

//  ID's for questions with Radio Buttons
    int[] questions = {
            R.id.question_1, R.id.question_2, R.id.question_3, R.id.question_4, R.id.question_5
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//      Find ID and put an onclick Listener on the markquiz button
        Button markQuiz = findViewById(R.id.mark_quiz);
        markQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//              Call methods to mark radio buttons, checkboxes and editTexts
                markRadioButtons(answers);
                markCheckboxes();
                markEditText();

//              Toast message to present total score
                Toast.makeText(MainActivity.this, "Your total score is " + score, Toast.LENGTH_LONG).show();

//              Reset score after marking
                score=0;
            }
        });

    }


    public void markRadioButtons(String[] answers) {

        for(int i = 0; i < answers.length; i++){

            RadioGroup currentQuestion =(RadioGroup) findViewById(questions[i]);
            RadioButton selectedOption = (RadioButton) findViewById(currentQuestion.getCheckedRadioButtonId());

//          comparing selected option to answers in the answers Array and in
            if(selectedOption != null && selectedOption.getText().toString().equals(answers[i])){
                score++;
            }

        }
    }

    public void markCheckboxes() {
//      Storing answers for checkBox questions
        CheckBox checkbox_1 = findViewById(R.id.question_8b);
        CheckBox checkBox_2 = findViewById(R.id.question_8c);
        CheckBox checkbox_3 = findViewById(R.id.question_9a);
        CheckBox checkBox_4 = findViewById(R.id.question_9c);

//       checking if answers are checked and incrementing the score
        if(checkbox_1.isChecked() && checkBox_2.isChecked()) {
            score++;
        }

        if(checkbox_3.isChecked() && checkBox_4.isChecked()) {
            score++;
        }
    }

    public void markEditText() {
//      Storing answers for EditText questions
        EditText textBox_1 = findViewById(R.id.question_6);
        EditText textBox_2 = findViewById(R.id.question_7);

//      checking if answers provides match the answers and incrementing the score
        if(textBox_1.getText().toString().equals("1981")) {
            score++;
        }

        if(textBox_2.getText().toString().toLowerCase().equals("charles babbage")) {
            score++;
        }
    }

}
