package edu.dtcc.sean.porttoland;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button createString = (Button) findViewById(R.id.btnCreateString);
        createString.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        TextView textView = (TextView) findViewById(R.id.tvDisplayString);
        TextView textView2 = (TextView) findViewById(R.id.editText);
        textView.setText(textView2.getText());

    }
}
