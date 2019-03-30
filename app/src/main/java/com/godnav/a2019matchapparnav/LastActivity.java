package com.godnav.a2019matchapparnav;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by arnavmishra on 3/2/19.
 */

public class LastActivity extends AppCompatActivity {

    private RadioGroup climb;
    private RadioGroup defense;
    private CheckBox brokenHC;
    private CheckBox brokenCC;
    private CheckBox brokenD;
    private CheckBox brokenC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);

        final Bundle bundleTeleop = getIntent().getExtras();

        final Bundle bundleAuto = getIntent().getExtras();

        final Bundle bundleMain = getIntent().getExtras();

        Button save = (Button) findViewById(R.id.saveButton);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundleLast = new Bundle();

                climb = findViewById(R.id.climbGroup);
                int selectedClimb = climb.getCheckedRadioButtonId();
                final RadioButton selectedButtonClimb = findViewById(selectedClimb);
                String climbLevel = selectedButtonClimb.getText().toString();


                brokenHC = findViewById(R.id.checkBrokenHatch);
                boolean selectedHC = brokenHC.isChecked();

                brokenCC = findViewById(R.id.checkBrokenCargo);
                boolean selectedCC = brokenCC.isChecked();

                brokenD = findViewById(R.id.checkBrokenDrivetrain);
                boolean selectedD = brokenD.isChecked();

                brokenC = findViewById(R.id.checkBrokenClimber);
                boolean selectedC = brokenC.isChecked();


                defense = findViewById(R.id.defenseGroup);
                int selectedDefense = defense.getCheckedRadioButtonId();
                final RadioButton selectedButtonDefense = findViewById(selectedDefense);
                String defenseLevel = selectedButtonDefense.getText().toString();


                bundleLast.putString("Climb Level", climbLevel);
                bundleLast.putString("Defense", defenseLevel);
                bundleLast.putBoolean("Broken Hatch", selectedHC);
                bundleLast.putBoolean("Broken Cargo", selectedCC);
                bundleLast.putBoolean("Broken Climber", selectedC);
                bundleLast.putBoolean("Broken Drivetrain", selectedD);

                String FILENAME = "WPI_scouting_deepspace.csv";
                String entry =

                                  bundleMain.getInt("Match") + ","
                                + bundleMain.getString("Robot") + ","
                                + bundleMain.getString("Event") + ","
                                + bundleMain.getString("Name") + ","
                                + bundleMain.getString("Start Position") + ","
                                + bundleMain.getString("Start Piece") + ","

                                + bundleAuto.getString("HABcrossed") + ","
                                + bundleAuto.getInt("sandstormCargoScoredCS") + ","
                                + bundleAuto.getInt("sandstormCargoScoredR1") + ","
                                + bundleAuto.getInt("sandstormCargoScoredR2") + ","
                                + bundleAuto.getInt("sandstormCargoScoredR3") + ","
                                + bundleAuto.getInt("sandstormHatchesScoredCS") + ","
                                + bundleAuto.getInt("sandstormHatchesScoredR1") + ","
                                + bundleAuto.getInt("sandstormHatchesScoredR2") + ","
                                + bundleAuto.getInt("sandstormHatchesScoredR3") + ","
                                + bundleAuto.getInt("sandstormCargoCollected") + ","
                                + bundleAuto.getInt("sandstormCargoDropped") + ","
                                + bundleAuto.getInt("sandstormHatchCollected") + ","
                                + bundleAuto.getInt("sandstormHatchDropped") + ","

                                + bundleTeleop.getInt("teleopCargoScoredCS") + ","
                                + bundleTeleop.getInt("teleopCargoScoredR1") + ","
                                + bundleTeleop.getInt("teleopCargoScoredR2") + ","
                                + bundleTeleop.getInt("teleopCargoScoredR3") + ","
                                + bundleTeleop.getInt("teleopHatchesScoredCS") + ","
                                + bundleTeleop.getInt("teleopHatchesScoredR1") + ","
                                + bundleTeleop.getInt("teleopHatchesScoredR2") + ","
                                + bundleTeleop.getInt("teleopHatchesScoredR3") + ","
                                + bundleTeleop.getInt("teleopCargoCollected") + ","
                                + bundleTeleop.getInt("teleopCargoDropped") + ","
                                + bundleTeleop.getInt("teleopHatchCollected") + ","
                                + bundleTeleop.getInt("teleopHatchDropped") + ","

                                + bundleLast.getString("Climb Level") + ","
                                + bundleLast.getString("Defense") + ","
                                + bundleLast.getBoolean("Broken Hatch") + ","
                                + bundleLast.getBoolean("Broken Cargo") + ","
                                + bundleLast.getBoolean("Broken Drivetrain") + ","
                                + bundleLast.getBoolean("Broken Climber")

                        + System.lineSeparator();

                try {
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

                int match = (bundleMain.getInt("Match"));
                int nextMatchNumber = match + 1;

                String nextScouter = bundleMain.getString("Name");

                Bundle bundleNext = new Bundle();
                bundleNext.putInt("New Match", nextMatchNumber);
                bundleNext.putString("New Name", nextScouter);
                bundleNext.putString("entryNext", entry);

                Intent intent = new Intent (LastActivity.this, MainActivity.class);
                intent.putExtras(bundleNext);
                startActivity(intent);
            }
        });
    }
}
