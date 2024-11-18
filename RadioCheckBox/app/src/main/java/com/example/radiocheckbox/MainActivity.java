//package com.example.radiocheckbox;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.CheckBox;
//import android.widget.LinearLayout;
//import android.widget.RadioButton;
//import android.widget.RadioGroup;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//public class MainActivity extends AppCompatActivity {
//
//    RadioGroup department;
//    LinearLayout events;
//    Button register;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        setContentView(R.layout.activity_main);
//
//
//        department = (RadioGroup) findViewById(R.id.department);
//        events = (LinearLayout) findViewById(R.id.events);
//        register = (Button) findViewById(R.id.register);
//
//        register.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Get the selected department from the radio group
//                int dept_id = department.getCheckedRadioButtonId();
//                RadioButton dept = (RadioButton) findViewById(dept_id);
//
//                // Get the selected events from the check boxes
//                StringBuilder events_selected = new StringBuilder();
//                for (int i = 0; i < events.getChildCount(); i++) {
//                    CheckBox c = (CheckBox) events.getChildAt(i);
//                    if (c.isChecked())
//                        events_selected.append(c.getText().toString()).append(", ");
//                }
//
//                // Display a toast message with the selected department and events
//                Toast t = Toast.makeText(
//                        getApplicationContext(),
//                        "Department: " + dept.getText() + "\nEvents: " + events_selected.toString(),
//                        Toast.LENGTH_SHORT
//                );
//                t.show();
//            }
//        });
//    }
//}

package com.example.radiocheckbox;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RadioGroup department;
    Button register;
    CheckBox event1, event2, event3, event4; // Assuming you have four events.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        department = findViewById(R.id.department);
        register = findViewById(R.id.register);

        // Initialize the CheckBoxes
        event1 = findViewById(R.id.football);
        event2 = findViewById(R.id.cricket);
        event3 = findViewById(R.id.basketball);
        event4 = findViewById(R.id.badminton);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the selected department from the radio group
                int dept_id = department.getCheckedRadioButtonId();
                RadioButton dept = findViewById(dept_id);

                // Check which events are selected
                StringBuilder events_selected = new StringBuilder();
                if (event1.isChecked()) {
                    events_selected.append(event1.getText().toString()).append(", ");
                }
                if (event2.isChecked()) {
                    events_selected.append(event2.getText().toString()).append(", ");
                }
                if (event3.isChecked()) {
                    events_selected.append(event3.getText().toString()).append(", ");
                }
                if (event4.isChecked()) {
                    events_selected.append(event4.getText().toString()).append(", ");
                }

                // Remove trailing comma and space if any events are selected
                if (events_selected.length() > 0) {
                    events_selected.setLength(events_selected.length() - 2);
                }

                // Display a toast message with the selected department and events
                Toast t = Toast.makeText(
                        getApplicationContext(),
                        "Department: " + dept.getText() + "\nEvents: " + events_selected,
                        Toast.LENGTH_SHORT
                );
                t.show();
            }
        });
    }
}
