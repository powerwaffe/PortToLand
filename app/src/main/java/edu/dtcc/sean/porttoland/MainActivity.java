package edu.dtcc.sean.porttoland;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    // Define key for the bundle
    private final String CELSIUS_KEY = "celsius value";

    // Define variable for Celsius
    private double celsius;

    // Define input field
    private EditText editText;

    // Define the output field
    private TextView tvDisplayCelsius;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get references to the output fields
        tvDisplayCelsius = (TextView) findViewById(R.id.tvDisplayCelsius);

        // Get references to the input fields
        editText = (EditText) findViewById(R.id.editText);

        // Create onClick listener
        Button createString = (Button) findViewById(R.id.btnCalculateFahrenheit);
        createString.setOnClickListener(this);

        if (savedInstanceState != null)
        {
            // Restore the save data
            celsius = savedInstanceState.getDouble(CELSIUS_KEY);

            tvDisplayCelsius.setText(String.format("%.2f", celsius));
            Log.d("SEAN", "bundle restored");
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);

        outState.putDouble(CELSIUS_KEY, celsius);

        Log.d("SEAN", "bundle saved");
    }

    @Override
    public void onClick(View v)
    {
       try
       {
           // Read input
           double fahrenheit = Double.parseDouble(editText.getText().toString());

           // Calculate
           celsius = (fahrenheit - 32) * 5 / 9;

           // Add results to textView
           tvDisplayCelsius.setText(String.format("%.2f", celsius));
       }
       catch (Exception e)
       {
           // Display warning toast
           Toast.makeText(MainActivity.this, "Invalid Input", Toast.LENGTH_LONG).show();

           // Clear fields
           tvDisplayCelsius.setText("0.0");
       }
    }
}
