package xinyuz0416.android.volumecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class Prism extends AppCompatActivity {

    EditText prism_length, prism_width, prism_height;
    TextView title, result;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prism);

        prism_length = findViewById(R.id.editText_prism_length);
        prism_width = findViewById(R.id.editText_prism_width);
        prism_height = findViewById(R.id.editText_prism_height);
        title = findViewById(R.id.textView2);
        result = findViewById(R.id.textView3);
        btn = findViewById(R.id.btn1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String length = prism_length.getText().toString();
                String width = prism_width.getText().toString();
                String height = prism_height.getText().toString();

                try{
                    int l = Integer.parseInt(length);
                    int w = Integer.parseInt(width);
                    int h = Integer.parseInt(height);

                    double volume = l*w*h;
                    result.setText("V = "+volume+" m^3");
                }catch (Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(), "Please put in a number", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
}
