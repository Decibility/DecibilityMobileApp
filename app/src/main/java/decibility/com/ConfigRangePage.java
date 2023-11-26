package decibility.com;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class ConfigRangePage extends AppCompatActivity {

    EditText min_volume_input;
    EditText max_volume_input;
    EditText min_frequency_input;
    EditText max_frequency_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_range_page);

        System.out.println("ON CREATED");

        min_volume_input = (EditText) findViewById(R.id.min_volume_input);
        if (getIntent().hasExtra("min_volume_input")) {
            min_volume_input.setText(getIntent().getStringExtra("min_volume_input"));
        }
        max_volume_input = (EditText) findViewById(R.id.max_volume_input);
        if (getIntent().hasExtra("max_volume_input")) {
            max_volume_input.setText(getIntent().getStringExtra("max_volume_input"));
        }
        min_frequency_input = (EditText) findViewById(R.id.min_frequency_input);
        if (getIntent().hasExtra("max_volume_input")) {
            min_frequency_input.setText(getIntent().getStringExtra("min_frequency_input"));
        }
        max_frequency_input = (EditText) findViewById(R.id.max_frequency_input);
        if (getIntent().hasExtra("max_volume_input")) {
            max_frequency_input.setText(getIntent().getStringExtra("max_frequency_input"));
        }

        Button config_range_back_btn = findViewById(R.id.config_range_back_btn);
        config_range_back_btn.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("min_volume_input", min_volume_input.getText().toString());
            intent.putExtra("max_volume_input", max_volume_input.getText().toString());
            intent.putExtra("min_frequency_input", min_frequency_input.getText().toString());
            intent.putExtra("max_frequency_input", max_frequency_input.getText().toString());
            startActivity(intent);
        });
    }

    // This callback is called only when there is a saved instance previously saved using onSaveInstanceState().
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        min_volume_input.setText(savedInstanceState.getString("MIN_VOL_KEY"));
        System.out.println("ON RESTORE INSTANCE STATE");
    }

    // Invoked when the activity might be temporarily destroyed; save the instance state here.
    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("MIN_VOL_KEY", min_volume_input.getText().toString());

        System.out.println("SAVED INSTANCE STATE");
        // Call superclass to save any view hierarchy.
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onStop() {
        super.onStop();

        System.out.println("ON STOPPED");
    }
}