package com.example.venun2forkjad.jeuxadeux;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int scorePlayer1;
    int scorePlayer2;
    int textinstructionnbr;

    Button buttonplayer1;
    Button buttonplayer2;

    TextView textScore1;
    TextView textScore2;

    Button buttonreset;

    TextView textinstruc;

    boolean jeuxEnCours;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //joueurs
        buttonplayer1 = (Button) findViewById(R.id.joueur1_b);
        buttonplayer2 = (Button) findViewById(R.id.joueur2_b);

        //reset
        buttonreset = (Button) findViewById(R.id.reset_b);
        buttonreset.setText("Commencer");

        //jeux score textview
        textScore1 = (TextView) findViewById(R.id.j1_score);
        textScore2 = (TextView) findViewById(R.id.j2_score);

        //instruction nombre de fois
        textinstruc = (TextView) findViewById(R.id.instruc);

        // onclick joueur 1
        buttonplayer1.setOnClickListener(this);

        // onclick joueur 2
        buttonplayer2.setOnClickListener(this);

        // Reset
        buttonreset.setOnClickListener(this);

        reset();

    }

    public void reset() {

        jeuxEnCours = true;
        //Score initialiser
        scorePlayer1 = 0;
        scorePlayer2 = 0;
        textScore1.setText("Le score est : " + scorePlayer1);
        textScore2.setText("Le score est : " + scorePlayer2);

        //Nombre de deux FOIS a cliquer
        //textinstructionnbr= 5;
        textinstructionnbr = (int) (Math.random() * 50);
        textinstruc.setText("TAPTAPTOP : " + textinstructionnbr + " FOIS");

        //DEBUT DU JEUX
        Toast.makeText(this, "Commencez", Toast.LENGTH_SHORT).show();

        //text reset de depart
        buttonreset.setText("NOMBRE DE TAPTAPTOP");
    }



    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.joueur1_b:
                buttonreset.setText("RECOMMENCER");
                if(jeuxEnCours){
                    scorePlayer1++;
                    textScore1.setText("Le score est : "+ scorePlayer1);
                    if(scorePlayer1 == textinstructionnbr){
                        Toast.makeText(MainActivity.this,"Player 1 a Gagner",Toast.LENGTH_SHORT).show();
                        jeuxEnCours =false;
                    }
                }
                break;

            case R.id.joueur2_b:
               buttonreset.setText("RECOMMENCER");
                if(jeuxEnCours){
                    scorePlayer2++;
                    textScore2.setText("Le score est : "+ scorePlayer2);
                    if(scorePlayer2 == textinstructionnbr){
                        Toast.makeText(MainActivity.this,"Player 2 a Gagner",Toast.LENGTH_SHORT).show();
                        jeuxEnCours =false;

                    }
                }
                break;

            case R.id.reset_b:
                //buttonreset.setText("reset");
                reset();
                break;
        }
    }
}
