package com.example.quizmanagementsystem;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class quiz extends AppCompatActivity implements View.OnClickListener {


        private Button falseButton;
        private Button trueButton;
        private Button nextButton;
        private Button submit;
        private ImageView Image;
        private TextView questionTextView;
        private int correct = 0;
        private int currentQuestionIndex = 0;
        ProgressBar pb;
        int progress=0;
        ProgressDialog progressDialog;
        private Question[] questionBank = new Question[]{
                new Question(R.string.a, true),
                new Question(R.string.b, false),
                new Question(R.string.c, true),
                new Question(R.string.d, true),
                new Question(R.string.e, true),
                new Question(R.string.f, false),

        };

        @Override
        protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        falseButton = findViewById(R.id.false_button);
        trueButton = findViewById(R.id.true_button);
        nextButton = findViewById(R.id.next_button);
        questionTextView = findViewById(R.id.answer_text_view);
        submit=findViewById(R.id.submit_button);
        Image = findViewById(R.id.myimage);
        falseButton.setOnClickListener(this);
        trueButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);

    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {


            switch (v.getId()) {


            case R.id.false_button:
                checkAnswer(false);
                break;

            case R.id.true_button:
                checkAnswer(true);
                break;
                case R.id.next_button:
                    final ProgressDialog progressDialog=new ProgressDialog(quiz.this);
                    progressDialog.setMessage("Loading..");
                    progressDialog.setTitle("ProgressDialog");
                    progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                    progressDialog.show();
                    progressDialog.setCancelable(false);
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try{
                                Thread.sleep(1000);
                            }catch(Exception e){
                                e.printStackTrace();
                            }
                            progressDialog.dismiss();
                        }
                    }).start();

                        if (currentQuestionIndex < 7) {
                            currentQuestionIndex
                                    = currentQuestionIndex + 1;


                            if (currentQuestionIndex == 6) {
                                questionTextView.setText(getString(
                                        R.string.correct, correct));
                                nextButton.setVisibility(
                                        View.INVISIBLE);
                                trueButton.setVisibility(
                                        View.INVISIBLE);
                                falseButton.setVisibility(
                                        View.INVISIBLE);
                              // if (correct > 3){

                           //    }
                                //    questionTextView.setText(
                                 //           "CORRECTNESS IS " + correct
                                   //                + " "
                                      //          + "OUT OF 6");

                            } else {
                                updateQuestion();
                            }
                            if(currentQuestionIndex == 5) {
                                submit.setVisibility(View.VISIBLE);


                            }
                        }


                        break;
            }
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        private void updateQuestion ()
        {
            Log.d("Current",
                    "onClick: " + currentQuestionIndex);

            questionTextView.setText(
                    questionBank[currentQuestionIndex]
                            .getAnswerResId());
            switch (currentQuestionIndex) {
                case 1:
                    Image.setImageResource(R.drawable.a);
                    break;
                case 2:
                    Image.setImageResource(R.drawable.a);
                    break;
                case 3:
                    Image.setImageResource(R.drawable.a);
                    break;
                case 4:
                    Image.setImageResource(R.drawable.a);
                    break;
                case 5:
                    Image.setImageResource(R.drawable.a);
                    break;
                case 6:
                    Image.setImageResource(R.drawable.a);
                    break;
            }
        }
        private void checkAnswer ( boolean userChooseCorrect)
        {
            boolean answerIsTrue
                    = questionBank[currentQuestionIndex]
                    .isAnswerTrue();
            int toastMessageId;

            if (userChooseCorrect == answerIsTrue) {
                toastMessageId = R.string.correct_answer;
                correct++;
            } else {
                toastMessageId = R.string.wrong_answer;
            }

            Toast.makeText(quiz.this, toastMessageId,Toast.LENGTH_SHORT).show();
        }
   public void next(View v){
       Intent intent = new Intent(this, quiz2.class);
       intent.putExtra("message",correct );
       startActivity(intent);
         //   Intent intent = new Intent(this, quiz2.class);
     //  startActivity(intent);
        }

        }


