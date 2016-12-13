package com.hkr.muljoh.karstania;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Slottet_ext extends AppCompatActivity {
    // det här är liksom ramar som vi kan hänga upp på skärmen
    // och visa upp text eller bilder i
    public TextView     ramTitel;
    public TextView     ramText;
    public ImageView    ramBild;
    public Button       ramKnappA;
    public Button       ramKnappB;

    // här nedanför kommer våra texter, vi sparar dem i variabler så blir det
    // smidigare att jobba
    private String textTitel =  "Slottet_ext";
    private String textUtanforSlottet = "Du kommer in i en stor inhägnad med  gröna granar bakom ett stort grått slott." +
            "Slottet_ext har skruttiga fönster med spindlarna som kravlar sig upp för den" +
            "blodiga väggen. Du ser änglar med ilskna röda ögon och blod som rinner ur" +
            "deras munnar och ner i vallgraven. Två av änglarna vaktar den stora antika" +
            "porten gjord av gammalt trä." +
            "\n" +
            "Fråga: Väljer du att döda vakten? Eller smyga förbi?\n" +
            "1: Döda vakten\n" +
            "2: Smyga\n";

    private String textSmyga = "Du kommer in genom slottets port och blir inte upptäckt.";
    private String textDoda = "Du blir upptäckt och vakten dödar dig och du får börja om från porten.";
    private String textInneISlottet = "Det är helt tomt i slottet. Du känner en  unken doft." +
            "Efter en stund ser du några fångar som är fastbundna i ett stort rum med gråa" +
            "sängkläder. De är svårt skadade och du tvivlar på att hjälpa dem.\n" +
            "Ska du hjälpa dem? eller Ska du bara gå förbi?\n" +
            "\n" +
            "1: Hjälpa\n" +
            "2: Gå förbi";

    private String textGaForbi = "Du kommer bli svårt sjuk och dör.\n"+
            "Du valde fel du får börja om från början av banan.\n";

    private String textHjalpa = "Du väljer att hjälpa fångarna: De hjälper dig att hitta guldägget.\n" +
            "Du har vunnit\n";

    private String knappTextDoda    =  "Döda vakten";
    private String knappTextSmyga   =  "Smyga förbi";
    private String knappTextHjalpa  =  "Hjälpa";
    private String knappTextGoForbi =  "Gå förbi";
    private String knappTextBorjaOm =  "Börja om";

    // här nedanför kommer koden :-)

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slottet);

        // här tar vi emot meddelanden från andra kapitel som kan
        // starta oss
        Intent intent = getIntent();
        String value = intent.getStringExtra("meddelande");

        // Här hänger vi upp våra ramar på krokar på skärmen
        ramTitel = (TextView)findViewById(R.id.title);
        ramBild  = (ImageView) findViewById(R.id.bild);
        ramText  = (TextView)findViewById(R.id.text);
        ramText.setMovementMethod(new ScrollingMovementMethod());
        ramKnappA = (Button) findViewById(R.id.knapp_a);
        ramKnappB = (Button) findViewById(R.id.knapp_b);

        // eftersom vi kan komma hit på olika sätt måste vi ha en
        // if-sats så att vi skriver ut rätt saker på skärmen ( i ramarna )
        if (value.equalsIgnoreCase("Starta spelet!")) {
            ramTitel.setText(textTitel);
            ramBild.setImageResource(R.drawable.drake); // Byt ut drake mot er bild
            ramText.setText(textUtanforSlottet);
            ramKnappA.setText(knappTextDoda);
            ramKnappB.setText(knappTextSmyga);
        }
        if (value.equalsIgnoreCase("Döda vakten")) {
            ramTitel.setText(textTitel);
            ramBild.setImageResource(R.drawable.drake); // Byt ut drake mot er bild
            ramText.setText(textDoda);
            ramKnappA.setText(knappTextBorjaOm);
            ramKnappB.setText(knappTextBorjaOm);
        }
        if (value.equalsIgnoreCase("Börja om")) {
            ramTitel.setText(textTitel);
            ramBild.setImageResource(R.drawable.drake); // Byt ut drake mot er bild
            ramText.setText(textUtanforSlottet);
            ramKnappA.setText(knappTextDoda);
            ramKnappB.setText(knappTextSmyga);
        }
        if (value.equalsIgnoreCase("Smyga förbi")) {
            ramTitel.setText(textTitel);
            ramBild.setImageResource(R.drawable.drake); // Byt ut drake mot er bild
            ramText.setText(textSmyga + textInneISlottet);
            ramKnappB.setText(knappTextHjalpa);
            ramKnappA.setText(knappTextGoForbi);
        }
        if (value.equalsIgnoreCase("Hjälpa")) {
            ramTitel.setText(textTitel);
            ramBild.setImageResource(R.drawable.drake); // Byt ut drake mot er bild
            ramText.setText(textHjalpa);
            ramKnappB.setText("Sluta");
            ramKnappA.setText("Spela igen");
        }
        if (value.equalsIgnoreCase("Sluta")) {
            this.finishAffinity(); // sluta hela spelet
        }
        if (value.equalsIgnoreCase("Spela igen")) {
            Intent myIntent = new Intent(Slottet_ext.this, Intro.class);
            myIntent.putExtra("meddelande", "Starta");
            Slottet_ext.this.startActivity(myIntent);
        }
    }

    public void klickaKnapp(View view) {
        Button b = (Button) view;
        String value = b.getText().toString();

        Intent myIntent = new Intent(Slottet_ext.this, Slottet_ext.class);
        myIntent.putExtra("meddelande", value);
        Slottet_ext.this.startActivity(myIntent);
    }
}
