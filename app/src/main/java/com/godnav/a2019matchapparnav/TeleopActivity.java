package com.godnav.a2019matchapparnav;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by arnavmishra on 3/2/19.
 */

public class TeleopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teleop);

        final Counter tHatchCS2 = findViewById(R.id.CSHatch2);
        final Counter tCargoCS2 = findViewById(R.id.CSCargo2);
        final Counter tHatchC2 = findViewById(R.id.CHatch2);
        final Counter tCargoC2 = findViewById(R.id.CCargo2);
        final Counter tHatchRLow2 = findViewById(R.id.RLowHatch2);
        final Counter tCargoRLow2 = findViewById(R.id.RLowCargo2);
        final Counter tHatchRMid2 = findViewById(R.id.RMidHatch2);
        final Counter tCargoRMid2 = findViewById(R.id.RMidCargo2);
        final Counter tHatchRHigh2 = findViewById(R.id.RHighHatch2);
        final Counter tCargoRHigh2 = findViewById(R.id.RHighCargo2);
        final Counter tHatchD2 = findViewById(R.id.DHatch2);
        final Counter tCargoD2 = findViewById(R.id.DCargo2);

        Button startButton = (Button) findViewById(R.id.nextButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundleTeleop = new Bundle();
                bundleTeleop.putInt("teleopHatchesScoredR1", tHatchRLow2.getValue());
                bundleTeleop.putInt("teleopHatchesScoredR2", tHatchRMid2.getValue());
                bundleTeleop.putInt("teleopHatchesScoredR3", tHatchRHigh2.getValue());
                bundleTeleop.putInt("teleopHatchesScoredCS", tHatchCS2.getValue());
                bundleTeleop.putInt("teleopCargoScoredR1", tCargoRLow2.getValue());
                bundleTeleop.putInt("teleopCargoScoredR2", tCargoRMid2.getValue());
                bundleTeleop.putInt("teleopCargoScoredR3", tCargoRHigh2.getValue());
                bundleTeleop.putInt("teleopCargoScoredCS", tCargoCS2.getValue());
                bundleTeleop.putInt("teleopHatchDropped", tHatchD2.getValue());
                bundleTeleop.putInt("teleopCargoDropped", tCargoD2.getValue());
                bundleTeleop.putInt("teleopHatchCollected", tHatchC2.getValue());
                bundleTeleop.putInt("teleopCargoCollected", tCargoC2.getValue());

                Bundle bundleMain = getIntent().getExtras();
                Bundle bundleAuto = getIntent().getExtras();

                Intent intentAuto = new Intent(TeleopActivity.this, LastActivity.class);
                intentAuto.putExtras(bundleAuto);
                intentAuto.putExtras(bundleMain);
                intentAuto.putExtras(bundleTeleop);
                startActivity(intentAuto);
            }
        });
    }
}