package xinyuz0416.android.volumecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class Cube extends AppCompatActivity {

    EditText cubeSideLength;
    TextView title, result;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cube);

        cubeSideLength = findViewById(R.id.editText_cube);
        title = findViewById(R.id.textView2);
        result = findViewById(R.id.textView3);
        btn = findViewById(R.id.btn1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sideLength = cubeSideLength.getText().toString();

                try{
                    int s = Integer.parseInt(sideLength);

                    double volume = s*s*s;
                    result.setText("V = "+volume+" m^3");
                }catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(), "Please put in a number", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
}
