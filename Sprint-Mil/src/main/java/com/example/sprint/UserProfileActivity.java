package com.example.sprint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class UserProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private Button logoutBtn, sendBtn;
    private EditText inputText;
    private FirebaseListAdapter<ChatMessage> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        logoutBtn = (Button) findViewById(R.id.logoutBtn);
        sendBtn = (Button) findViewById(R.id.sendChatMsg);

        inputText = (EditText)findViewById(R.id.chatMessage);

        logoutBtn.setOnClickListener(this);
        sendBtn.setOnClickListener(this);

        displayChatMessages();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.logoutBtn:
                startActivity(new Intent(UserProfileActivity.this, MainActivity.class));
                break;
            case R.id.sendChatMsg:
                FirebaseDatabase.getInstance()
                        .getReference()
                        .push()
                        .setValue(new ChatMessage(inputText.getText().toString(),
                                FirebaseAuth.getInstance()
                                        .getCurrentUser()
                                        .getEmail())
                        );
                inputText.setText("");
                displayChatMessages();
                break;

        }
    }

    private void displayChatMessages() {
        ListView listOfMessages = (ListView) findViewById(R.id.messagesList);

        adapter = new FirebaseListAdapter<ChatMessage>(this, ChatMessage.class,
                R.layout.message, FirebaseDatabase.getInstance().getReference()) {
            @Override
            protected void populateView(View v, ChatMessage model, int position) {
                // Get references to the views of message.xml
                TextView messageText = (TextView) v.findViewById(R.id.message_text);
                TextView messageUser = (TextView) v.findViewById(R.id.message_user);
                TextView messageTime = (TextView) v.findViewById(R.id.message_time);

                // Set their text
                messageText.setText(model.getMessageText());
                messageUser.setText(model.getMessageUser());

                // Format the date before showing it
                messageTime.setText(DateFormat.format("dd-MM-yyyy (HH:mm:ss)",
                        model.getMessageTime()));
            }
        };

        listOfMessages.setAdapter(adapter);
    }
}