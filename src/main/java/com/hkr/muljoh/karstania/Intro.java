package com.hkr.muljoh.karstania;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Intro extends AppCompatActivity {

    // det här är liksom ramar som vi kan hänga upp på skärmen
    // och visa upp text eller bilder i
    public TextView     ramTitel;
    public TextView     ramText;
    public ImageView    ramBild;
    public Button       ramKnapp;

    // här nedanför kommer våra texter, vi sparar dem i variabler så blir det
    // smidigare att jobba
    private String textTitel        = "Drakbergens Hemlighet";
    private String textSpel         = "Ett äventyrsspel av klass 5 i Grönängsskolan";
    private String knappTextStarta  = "Starta spelet!";


    // här nedanför kommer koden :-)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Här hänger vi upp våra ramar på krokar på skärmen
        ramTitel = (TextView)findViewById(R.id.title);
        ramText  = (TextView)findViewById(R.id.text);
        ramBild  = (ImageView) findViewById(R.id.bild);
        ramKnapp = (Button) findViewById(R.id.starta_spel);

        // Här sätter vi in text och bild i ramarna
        ramTitel.setText(textTitel);
        ramText.setText(textSpel);
        ramBild.setImageResource(R.drawable.drake);
        ramKnapp.setText(knappTextStarta);
    }


    // här har vi en liten metod för att hantera knapptryckningar
    public void klickaKnapp(View view) {
        Button b = (Button) view;
        String value = b.getText().toString();

        Intent myIntent = new Intent(Intro.this, Staden.class);
        myIntent.putExtra("meddelande", value);
        Intro.this.startActivity(myIntent);
    }
}
