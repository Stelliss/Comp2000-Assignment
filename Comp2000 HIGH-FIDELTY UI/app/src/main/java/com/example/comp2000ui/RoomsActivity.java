package com.example.comp2000ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class RoomsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_rooms);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button backButton = findViewById(R.id.backButton2);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RoomsActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        //list of all
        int[] bookingButtonIDs = {R.id.bookButton1, R.id.bookButton2,R.id.bookButton3,R.id.bookButton4,R.id.bookButton5,R.id.bookButton6,R.id.bookButton7,R.id.bookButton8};
        for (int counter : bookingButtonIDs){
            findViewById(counter).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    show();
                }
            });
        }

    }
    public void show(){ //send request message
        CharSequence bookSendingMessage = "Sending Booking Request...";
        int sendDuration = Toast.LENGTH_SHORT;
        Toast sendMessage = Toast.makeText(this, bookSendingMessage, sendDuration);
        sendMessage.show();
    }
}