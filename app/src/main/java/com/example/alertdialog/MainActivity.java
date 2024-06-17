package com.example.alertdialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    EditText edit1,edit2,edit3;
    Button btn;


    private void changeEditTextToTextView(EditText edit) {
        ViewGroup parentLayout = (ViewGroup) edit.getParent();
        TextView textView = new TextView(this);
        textView.setText(edit.getText().toString());
        textView.setTextSize(edit.getTextSize());
        textView.setTextColor(edit.getCurrentTextColor());
        textView.setLayoutParams(edit.getLayoutParams());

        parentLayout.removeView(edit);
        parentLayout.addView(textView);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("להרשם ? ")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        changeEditTextToTextView(edit1);
                        changeEditTextToTextView(edit2);
                        changeEditTextToTextView(edit3);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });

        builder.create();



        EdgeToEdge.enable(this);
        btn = (Button) this.findViewById(R.id.button);
        edit1 =(EditText) this.findViewById(R.id.editTextText);
        edit2 =(EditText) this.findViewById(R.id.editTextText1);
        edit3 =(EditText) this.findViewById(R.id.editTextText2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.show();
            }
        });
    }
}