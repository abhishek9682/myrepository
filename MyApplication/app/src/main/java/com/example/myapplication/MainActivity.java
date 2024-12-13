package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9;
    int flag = 0; // 0 for 'X', 1 for 'O'
    int count = 0;
    String b1, b2, b3, b4, b5, b6, b7, b8, b9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        bt4 = findViewById(R.id.bt4);
        bt5 = findViewById(R.id.bt5);
        bt6 = findViewById(R.id.bt6);
        bt7 = findViewById(R.id.bt7);
        bt8 = findViewById(R.id.bt8);
        bt9 = findViewById(R.id.bt9);
    }

    public void Check(View view) {
        Button btCurrent = (Button) view;

        // Prevent overwriting existing moves
        if (!btCurrent.getText().toString().equals("")) {
            Toast.makeText(this, "This spot is already taken!", Toast.LENGTH_SHORT).show();
            return;
        }

        count++;
        if (flag == 0) {
            btCurrent.setText("X");
            flag = 1;
        } else {
            btCurrent.setText("O");
            flag = 0;
        }

        // Capture the current text for all buttons
        b1 = bt1.getText().toString();
        b2 = bt2.getText().toString();
        b3 = bt3.getText().toString();
        b4 = bt4.getText().toString();
        b5 = bt5.getText().toString();
        b6 = bt6.getText().toString();
        b7 = bt7.getText().toString();
        b8 = bt8.getText().toString();
        b9 = bt9.getText().toString();

        // Check for winning conditions
        if ((b1.equals(b2) && b2.equals(b3) && !b1.equals("")) ||
                (b4.equals(b5) && b5.equals(b6) && !b4.equals("")) ||
                (b7.equals(b8) && b8.equals(b9) && !b7.equals("")) ||
                (b1.equals(b4) && b4.equals(b7) && !b1.equals("")) ||
                (b2.equals(b5) && b5.equals(b8) && !b2.equals("")) ||
                (b3.equals(b6) && b6.equals(b9) && !b3.equals("")) ||
                (b1.equals(b5) && b5.equals(b9) && !b1.equals("")) ||
                (b3.equals(b5) && b5.equals(b7) && !b3.equals(""))) {

            Toast.makeText(this, "Winner is " + btCurrent.getText().toString(), Toast.LENGTH_SHORT).show();
            resetGame();
        } else if (count == 9) {
            Toast.makeText(this, "It's a draw!", Toast.LENGTH_SHORT).show();
            resetGame();
        }
    }

    private void resetGame() {
        bt1.setText("");
        bt2.setText("");
        bt3.setText("");
        bt4.setText("");
        bt5.setText("");
        bt6.setText("");
        bt7.setText("");
        bt8.setText("");
        bt9.setText("");
        flag = 0;
        count = 0;
    }
}
