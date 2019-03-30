package com.godnav.a2019matchapparnav;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by arnavmishra on 3/2/19.
 */

public class SandstormActivity extends AppCompatActivity {
    private RadioGroup cross;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sandstorm);

        final Counter sHatchCS = findViewById(R.id.CSHatch);
        final Counter sCargoCS = findViewById(R.id.CSCargo);
        final Counter sHatchC = findViewById(R.id.CHatch);
        final Counter sCargoC = findViewById(R.id.CCargo);
        final Counter sHatchRLow = findViewById(R.id.RLowHatch);
        final Counter sCargoRLow = findViewById(R.id.RLowCargo);
        final Counter sHatchRMid = findViewById(R.id.RMidHatch);
        final Counter sCargoRMid = findViewById(R.id.RMidCargo);
        final Counter sHatchRHigh = findViewById(R.id.RHighHatch);
        final Counter sCargoRHigh = findViewById(R.id.RHighCargo);
        final Counter sHatchD = findViewById(R.id.DHatch);
        final Counter sCargoD = findViewById(R.id.DCargo);

        Button startButton = (Button) findViewById(R.id.nextButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cross = findViewById(R.id.crossBaselineGroup);
                int selected = cross.getCheckedRadioButtonId();
                final RadioButton selectedCrossButton = findViewById(selected);
                String crossed = selectedCrossButton.getText().toString();

                Bundle bundleAuto = new Bundle();
                bundleAuto.putInt("sandstormHatchesScoredR1", sHatchRLow.getValue());
                bundleAuto.putInt("sandstormHatchesScoredR2", sHatchRMid.getValue());
                bundleAuto.putInt("sandstormHatchesScoredR3", sHatchRHigh.getValue());
                bundleAuto.putInt("sandstormHatchesScoredCS", sHatchCS.getValue());
                bundleAuto.putInt("sandstormCargoScoredR1", sCargoRLow.getValue());
                bundleAuto.putInt("sandstormCargoScoredR2", sCargoRMid.getValue());
                bundleAuto.putInt("sandstormCargoScoredR3", sCargoRHigh.getValue());
                bundleAuto.putInt("sandstormCargoScoredCS", sCargoCS.getValue());
                bundleAuto.putInt("sandstormHatchDropped", sHatchD.getValue());
                bundleAuto.putInt("sandstormCargoDropped", sCargoD.getValue());
                bundleAuto.putInt("sandstormHatchCollected", sHatchC.getValue());
                bundleAuto.putInt("sandstormCargoCollected", sCargoC.getValue());
                bundleAuto.putString("HABcrossed", crossed);

                Bundle bundleMain = getIntent().getExtras();

                Intent intentAuto = new Intent(SandstormActivity.this, TeleopActivity.class);
                intentAuto.putExtras(bundleAuto);
                intentAuto.putExtras(bundleMain);
                startActivity(intentAuto);
            }
        });
    }
}