package examples.aaronhoskins.com.unittesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvOutput;
    EditText etInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvOutput = findViewById(R.id.tvOutput);
        etInput = findViewById(R.id.etInput);
    }

    public void onClick(View view) {
        if(!etInput.getText().toString().isEmpty()) {
            tvOutput.setText(etInput.getText().toString());
        }
    }
}
