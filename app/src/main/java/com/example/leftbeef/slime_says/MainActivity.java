package com.example.leftbeef.slime_says;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.leftbeef.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Move to next screen.
    public void nextScreen(View view){
        Intent intent = new Intent(this, TextActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    // Increment text by 5 pixels.
    public void incTextView(View view) {
        setTextSize(5);
    }

    // Decrement text by 5 pixels.
    public void decTextView(View view) {
        setTextSize(-5);
    }

    // Resize text in pixels.
    private void setTextSize(float change) {
        Toast.makeText(MainActivity.this, "Changing by: " + String.valueOf(change), Toast.LENGTH_LONG).show();
        TextView initial = findViewById(R.id.textView);
        float prevSize = initial.getTextSize();
        initial.setTextSize(TypedValue.COMPLEX_UNIT_PX, prevSize + change);
        if(change >= 1){
            initial.setText("Last increased.");
        }
        else {
            initial.setText("Last decreased.");
        }
    }

}
