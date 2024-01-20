package xinyuz0416.android.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.*;
import android.view.*;
import android.widget.*;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btn;
    TextView result;
    ImageView chat, share;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        btn = findViewById(R.id.btn);
        result = findViewById(R.id.result);
        chat = findViewById(R.id.chat);
        share = findViewById(R.id.share);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String userName = editText.getText().toString();
                int randomInt = generateRandomInt();
                result.setText(""+randomInt);
                chat.setVisibility(View.VISIBLE);
                share.setVisibility(View.VISIBLE);

                share.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        shareData(userName, randomInt);
                    }
                });
            }
        });



    }

    private int generateRandomInt(){
        Random random = new Random();
        return random.nextInt(101);
    }

    private void shareData(String userName, int randomInt){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, userName + "got lucky today!");
        intent.putExtra(Intent.EXTRA_TEXT, "His/ Her lucky number is " + randomInt);

        startActivity(Intent.createChooser(intent,"Choose a platform"));
    }


}