package com.godnav.a2019matchapparnav;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class MainActivity extends AppCompatActivity {

    private RadioGroup startPosition;
    private RadioGroup startPiece;
    public EditText matchN;
    public EditText nameN;
    public EditText eventN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //change event from here
        String string = "WPI";

        matchN = findViewById(R.id.editMatch);
        nameN = findViewById(R.id.editName);
        eventN = findViewById(R.id.editEvent);
        final Bundle bundleNext = getIntent().getExtras();

        if (bundleNext != null) {
            matchN.setText(String.valueOf(bundleNext.getInt("New Match")));
            nameN.setText(bundleNext.getString("New Name"));
        }
        eventN.setText(string);

        Button startButton = (Button) findViewById(R.id.buttonStart);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final TextView Name = (TextView) findViewById(R.id.editName);
                String name = Name.getText().toString();
                final TextView Event = (TextView) findViewById(R.id.editEvent);
                String event = Event.getText().toString();
                int match = Integer.parseInt(((TextView) findViewById(R.id.editMatch)).getText().toString());
                final TextView Robot = (TextView) findViewById(R.id.editRobot);
                String robot = Robot.getText().toString();

                startPosition = findViewById(R.id.startPositionGroup);
                int selected = startPosition.getCheckedRadioButtonId();
                final RadioButton selectedButton = findViewById(selected);
                String start = selectedButton.getText().toString();

                startPiece = findViewById(R.id.startPieceGroup);
                int selectedPiece = startPiece.getCheckedRadioButtonId();
                final RadioButton selectedPieceButton = findViewById(selectedPiece);
                String piece = selectedPieceButton.getText().toString();

                Bundle bundleMain = new Bundle();
                bundleMain.putString("Robot", robot);
                bundleMain.putInt("Match", match);
                bundleMain.putString("Name", name);
                bundleMain.putString("Event", event);
                bundleMain.putString("Start Position", start);
                bundleMain.putString("Start Piece", piece);

                Intent intentMain = new Intent(MainActivity.this, SandstormActivity.class);
                intentMain.putExtras(bundleMain);
                startActivity(intentMain);
            }
        });

        /*Button save = (Button) findViewById(R.id.noShow);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final TextView Name = (TextView) findViewById(R.id.editName);
                String name = Name.getText().toString();
                final TextView Event = (TextView) findViewById(R.id.editEvent);
                String event = Event.getText().toString();
                int match = Integer.parseInt(((TextView) findViewById(R.id.editMatch)).getText().toString());
                final TextView Robot = (TextView) findViewById(R.id.editRobot);
                String robot = Robot.getText().toString();


                Bundle bundleNO = new Bundle ();
                bundleNO.putString("Robot", robot);
                bundleNO.putInt("Match", match);
                bundleNO.putString("Name", name);
                bundleNO.putString("Event", event);

                String FILENAME = "test_scouting_deepspace.csv";
                String entry =
                        bundleNO.getString("Event") + ","
                                + bundleNO.getString("Name") + ","
                                + bundleNO.getString("Robot") + ","
                                + bundleNO.getInt("Match") + ","
                                + "No Show" + ","
                                + "No Show" + ","
                                + "No Show" + ","
                                + "0" + ","
                                + "0" + ","
                                + "0" + ","
                                + "0" + ","
                                + "0" + ","
                                + "0" + ","
                                + "0" + ","
                                + "0" + ","
                                + "0" + ","
                                + "0" + ","
                                + "0" + ","
                                + "0" + ","
                                + "0" + ","
                                + "0" + ","
                                + "0" + ","
                                + "0" + ","
                                + "0" + ","
                                + "0" + ","
                                + "0" + ","
                                + "0" + ","
                                + "0" + ","
                                + "0" + ","
                                + "0" + ","
                                + "0" + ","
                                + "0" + ","
                                + "0" + ","
                                + "No Show" + ","
                                + "No Show" + ","
                                + "No Show" + ","
                                + "No Show"
                                + System.lineSeparator();

                try {
                    // Get the directory for the match data files.
                    File file = new File(Environment.getExternalStorageDirectory(), "DeepSpace");
                    file.mkdirs();

                    File matchData = new File(file, FILENAME);
                    if (!matchData.exists()) {
                        matchData.createNewFile();
                    }

                    FileOutputStream os = new FileOutputStream(matchData, true);
                    os.write(entry.getBytes());
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                int match1 = (bundleNO.getInt("Match"));

                int nextMatchNumber = match1 + 1;
                String nextScouter = bundleNO.getString("Name");

                Bundle bundleNext1 = new Bundle();
                bundleNext1.putInt("New Match", nextMatchNumber);
                bundleNext1.putString("New Name", nextScouter);
                bundleNext1.putString("entryNext", entry);

                Intent intent = new Intent (MainActivity.this, MainActivity.class);
                intent.putExtras(bundleNext1);
                startActivity(intent);
            }
        });

    }*/

    }
}
