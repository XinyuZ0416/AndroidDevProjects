package xinyuz0416.android.volumecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class Cylinder extends AppCompatActivity {

    EditText cylinder_radius, cylinder_height;
    TextView title, result;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cylinder);

        cylinder_radius = findViewById(R.id.editText_cylinder_radius);
        cylinder_height = findViewById(R.id.editText_cylinder_height);
        title = findViewById(R.id.textView2);
        result = findViewById(R.id.textView3);
        btn = findViewById(R.id.btn1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String radius = cylinder_radius.getText().toString();
                String height = cylinder_height.getText().toString();

                try {
                    int r = Integer.parseInt(radius);
                    int h = Integer.parseInt(height);

                    double volume = 3.14159 * r * r * h;
                    result.setText("V = "+volume+" m^3");
                }catch (Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(), "Please put in a number", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
}
