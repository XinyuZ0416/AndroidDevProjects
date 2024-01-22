package xinyuz0416.android.volumecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class Sphere extends AppCompatActivity {

    EditText sphere_radius;
    TextView title, result;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sphere);

        sphere_radius = findViewById(R.id.editText_sphere);
        title = findViewById(R.id.textView2);
        result = findViewById(R.id.textView3);
        btn = findViewById(R.id.btn1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String radius = sphere_radius.getText().toString();

                try{
                    int r = Integer.parseInt(radius);

                    double volume = 1.33333 * 3.14159 * r*r*r;
                    result.setText("V = "+volume+" m^3");
                }catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(), "Please put in a number", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
}
