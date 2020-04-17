package com.example.myapplication_udemy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;


/**
 *  Make sure you are using the correct package name.
 * This example uses the package name:

 **/

import android.os.Bundle;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity {
    public int numberSatisfaction=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * This method is called when the order button is clicked.
     */
    public void submitResponse(View view) {
        EditText name=(EditText) findViewById(R.id.namefield);
        String value=name.getText().toString();
        CheckBox froshCheckBox = (CheckBox) findViewById(R.id.frosh_checkbox);
        CheckBox secondCheckBox = (CheckBox) findViewById(R.id.secon_year_checkbox);
        CheckBox juniorCheckBox = (CheckBox) findViewById(R.id.junior_checkbox);
        CheckBox seniorCheckBox = (CheckBox) findViewById(R.id.senior_checkbox);
        boolean isSenior=seniorCheckBox.isChecked();
        boolean isFrosh=froshCheckBox.isChecked();
        boolean isJunior=juniorCheckBox.isChecked();
        boolean isSecond=secondCheckBox.isChecked();
        EditText comment=(EditText) findViewById(R.id.comment);
        String comm=comment.getText().toString();
        displayQuantity(numberSatisfaction);
        displayMessage(createMessage(value, isFrosh, isSenior, isSecond, isJunior,comm));

    }

    private String createMessage(String name, boolean frosh, boolean second, boolean junior, boolean senior, String comment){
        String year="student unspecified";
        if(frosh==true){
            year="Frosh";}
        if(second==true){year="Second";}
        if(junior==true){year="Junior";}
        if(senior==true){year="Senior";}
        String message=
                "\n"+"Name"+name +
                "\n"+"Year "+ year+
//                "\n"+getString(R.string.order_summary_chocolate, choc)+
                "\n"+"Total: "+Integer.toString(numberSatisfaction) +
                        "\n"+"Comm: "+comment +
                "\n"+getString(R.string.thank_you);
        return message;
    }

    public void increment(View view) {
        numberSatisfaction++;
        displayQuantity(numberSatisfaction);

    }

    public void decrement(View view) {
        if (numberSatisfaction>0){numberSatisfaction--;}
        displayQuantity(numberSatisfaction);

    }


    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }


    private void displayMessage(String message) {
        TextView SummaryTextView = (TextView) findViewById(R.id.summary_text_view);
        SummaryTextView.setText(message);
    }




}
