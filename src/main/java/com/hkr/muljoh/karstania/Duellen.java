package com.hkr.muljoh.karstania;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Duellen extends AppCompatActivity {
    // det här är liksom ramar som vi kan hänga upp på skärmen
    // och visa upp text eller bilder i
    public TextView     ramTitel;
    public TextView     ramText;
    public ImageView    ramBild;
    public Button       ramKnappA;
    public Button       ramKnappB;

    private String textTitel =  "Duellen";
    private String textSpel =   "här klipper ni in berättelsetexten för det "+
                                "första rummet";

    private String knappTextA =  "Knapp A";
    private String knappTextB =  "Knapp B";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exempel);

        // här tar vi emot meddelanden från andra kapitel som kan
        // starta oss
        Intent intent = getIntent();
        String value = intent.getStringExtra("meddelande");

        // Här hänger vi upp våra ramar på krokar på skärmen
        ramTitel = (TextView) findViewById(R.id.title);
        ramBild = (ImageView) findViewById(R.id.bild);
        ramText = (TextView) findViewById(R.id.text);
        ramText.setMovementMethod(new ScrollingMovementMethod());
        ramKnappA = (Button) findViewById(R.id.knapp_a);
        ramKnappB = (Button) findViewById(R.id.knapp_b);

        // Här sätter vi in text och bild i ramarna
        ramTitel.setText(textTitel);
        ramText.setText(textSpel);
        ramBild.setImageResource(R.drawable.drake);
        ramKnappA.setText(knappTextA);
        ramKnappB.setText(knappTextB);

        // eftersom vi kan komma hit på olika sätt måste vi ha en
        // if-sats så att vi skriver ut rätt saker på skärmen ( i ramarna )
        if (value.equalsIgnoreCase("Knapp B")) {
            ramText.setText("Du tryckte på Knapp B");
        }
        if (value.equalsIgnoreCase("Knapp A")) {
            ramText.setText("Du tryckte på Knapp A");
        }
    }


    public void klickaKnapp(View view) {
        Button b = (Button) view;
        String value = b.getText().toString();

        Intent myIntent = new Intent(Duellen.this, Duellen.class);
        myIntent.putExtra("meddelande", value);
        Duellen.this.startActivity(myIntent);
    }
}
