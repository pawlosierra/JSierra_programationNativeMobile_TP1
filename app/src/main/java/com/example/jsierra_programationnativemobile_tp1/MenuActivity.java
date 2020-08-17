package com.example.jsierra_programationnativemobile_tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //chaque bouton est atribué a une variable via findViewById

        Button button2 = (Button) findViewById(R.id.b2);
        Button button3 = (Button) findViewById(R.id.b3);
        Button button4 = (Button) findViewById(R.id.b4);
        Button button5 = (Button) findViewById(R.id.b5);

        //chaque bouton se voit attribuer le listener via setOnClickListener

        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
    }

    // On declare le méthode onClick() qui sera lancée à chaque clic de bouton. On fait le trai à
    // l'aide d'une structure Switch Case.

    public void onClick(View donnee){

        //Declaration d'une variable que va contenir le nom de l'activite en lancer.
        //les activites que nous utiliserons sont: Temperature, distance et masse.
        Class paramametre;

        //Lorsque la methode onClick est apellée, le bouton cliqué est passé par le paramètre donnée.
        //On peut donc savoir quel bouton en filtrant le parametre via une structure Switch/Case

        switch (donnee.getId()){
            //Premier bouton
            case R.id.b2:
                paramametre = Temperature.class;
                Toast.makeText(this,"Convertisseur de temperatura",Toast.LENGTH_LONG).show();
                break;

                //Deuxieme bouton
            case R.id.b3:
                paramametre = Distance.class;
                Toast.makeText(this,"Convertisseur de distance",Toast.LENGTH_LONG).show();
                break;

                //Troisiene bouton
            case R.id.b4:
                paramametre = Masse.class;
                Toast.makeText(this,"Convertisseur de massa",Toast.LENGTH_LONG).show();
                break;

                //si aucun choix ne convient, le cas par defaut est utilise
            default:
                paramametre = null;
        }
        //on lance l'activite definie dans la variable parametre
        startActivity(new Intent(MenuActivity.this,paramametre));
    }






}
