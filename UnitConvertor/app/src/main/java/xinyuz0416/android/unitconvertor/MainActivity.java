package xinyuz0416.android.unitconvertor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btn, btn2;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        btn = findViewById(R.id.btn);
        btn2 = findViewById(R.id.btn2);
        textView = findViewById(R.id.textView);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String input = editText.getText().toString();
                double kilos = Double.parseDouble(input);
                textView.setText(""+kilosToPounds(kilos));
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String input = editText.getText().toString();
                double pounds = Double.parseDouble(input);
                textView.setText(""+PoundsToKilos(pounds));
            }
        });


    }

    public double kilosToPounds(double kilos){
        return kilos*2.20462;
    }
    public double PoundsToKilos(double pounds){
        return pounds*0.45359;
    }
}