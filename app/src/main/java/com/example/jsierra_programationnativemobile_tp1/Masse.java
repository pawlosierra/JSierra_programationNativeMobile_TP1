package com.example.jsierra_programationnativemobile_tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


public class Masse extends AppCompatActivity implements TextWatcher, CompoundButton.OnCheckedChangeListener {

    // les deux variables de type String contient la reference de unite de mesure avec laquelle
    // le programe commencera par defaut.
    // la variable UniteConverti est la variable à laquelle le programme attribuera la unite de
    // mesure finale.

    String UniteDepart = "kg";          //Kilograme
    String UniteConvertie = "lb";       //Libre

    //Il faut que on fait l'initialisation des variables. Le début des variables est null.

    Float MassDepart = null;
    Float MassConvertie = null;

    //Cette ligne permet donnner le nombre de décimales.
    DecimalFormat numberFormat = new DecimalFormat("0.00");

    //l'ensemble du code Java de l'application est généralement écrit dans la méthode onCreate

    //Pour charger l'interface d'une activite, on redéfinie la méthode OnCreate à la l'aide
    //du mot clé @Override.

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        //Lorsque la méthode (onCreate(Bundle savedInstanceState)) est appelée, Android tente de
        //récupérer l'état précédent de l'activité dans un Bundle (Si elle existe).

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masse);

        //On assigne chaque bouton à une variable.
        //Pour faire la conversion, on a travaillé avec un switch. il a 2 position.
        //On va asigner la position ON à kg, cette est la unite de depart. La position OFF a
        //la unite de messure lb.

        //L'objet swOn est le switch. Il va enregistrer le changement (ON ou OFF)
        CompoundButton swOn = (CompoundButton) findViewById(R.id.switchMasse);

        //Avec l'object masFrom, on va enregistrer les valeurs (nombres) qui serai convertir.
        EditText massFrom = (EditText) findViewById(R.id.txtMasse);

        //Ce listener écoute les 2 position qui se trouvent dans le switch et declenche un
        //méthode lorsqu'un des 2 position est appuyé.
        swOn.setOnCheckedChangeListener(this);

        massFrom.addTextChangedListener(this);
    }

    //Cette ligne s'exécute juste après la modification du texte ai eu lieu.
    public void afterTextChanged(Editable s) {
        //Recherche l'instance du edittext
        EditText massFrom = (EditText) findViewById(R.id.txtMasse);

        //On vas faire la verification si le edittext est vide.
        if (massFrom.getText().toString().isEmpty()) {
            //On recherche l'instance de textview pour le résultat
            TextView masstTo = (TextView) findViewById(R.id.txtResultatMasse);
            //On lui assigne un chaine vide
            masstTo.setText("");
            //La température de départ est nulle.
            MassDepart = null;

            //Sinon. s'il n'y a qu'un + ou un - la tempDepart est null.
        } else if (massFrom.getText().toString().equals("-") || (massFrom.getText().toString().equals("+"))) {
            //On ne fait rien puisqu'il n'y a pas de valeur numérique dans le edittext
            massFrom = null;
        } else {
            //Sinon, c'est qu'il y a des nombres dans le edittext.
            //On converti le contenu du edittext en float et on assigne la valeur à la variable
            //tempdepart.
            MassDepart = Float.valueOf(massFrom.getText().toString());
            //On apelle la méthode  quelCalulMass qui permet savoir quel calcul effectuer.
            //La méthode quelCalculMass fonctionnera en utilisant la unite de depart (UnietDepart),
            //la unite à convertie (UniteConvertie) et la température de départ. Ces informations
            //est donnée par l'utilisateur.

            quelcalculMass(UniteDepart, UniteConvertie, MassDepart);
        }
    }

    //Cette méthode s'exécute juste avant que la modification du text ai lieu.
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        //Rien à faire
    }

    //Cette méthode s'exécute pendant que la modification du texte a lieu.
    public void onTextChanged(CharSequence argO, int start, int before, int count) {

        //Rien à faire
    }

    //Méthode appellée lorsque le switch est cliqué. 
    // La méthode reçoit en parametre le switch et la position sélectionné.

    @Override

    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


        Switch position1 = (Switch) findViewById(R.id.switchMasse);
        TextView affichez = (TextView) findViewById(R.id.convFinalUnite);

        if (position1.isChecked()) {
            //True
            UniteDepart = "kg";
            //Nous montrerons dans un message de texte, qui est l'unité de départ.
            affichez.setText("Conversion des kg à lb");
            //Cette ligne permet d'afficher dans un message de text l'unite que
            //el usager a sélectionné.
            Toast.makeText(this, "kilograme", Toast.LENGTH_SHORT).show();

        } else {
            //False
            //Nous montrerons dans un message de texte, qui est l'unité de départ.
            affichez.setText("Conversion des lb à kg");
            //Cette ligne permet d'afficher dans un message de text l'unite que
            //el usager a sélectionné.
            Toast.makeText(this, "lb", Toast.LENGTH_SHORT).show();
            UniteDepart = "lb";
        }

        if (MassDepart != null) {
            //On appelle la méthode quelcalculMass qui permet de savoir quel calcul effectuers 
            quelcalculMass(UniteDepart, UniteConvertie, MassDepart);
        }
    }


    //Méthode qui permet de determiner quel calcul effectuer. Elle recoit en parametre l'unité 
    //de depart, l'unité  de conversion et la masse de depart

    public void quelcalculMass(String uDe, String uCon, Float MasseDepart) {
        //On assigne ces valeurs aux variables  
        UniteDepart = uDe;
        UniteConvertie = uCon;
        MassDepart = MasseDepart;


        //Rechercher l'instance du textview
        TextView massTo = (TextView) findViewById(R.id.txtResultatMasse);

        if (UniteDepart.equals("kg")) {
            UniteConvertie.equals("lb");
            //On appelle la methode ConversionKGaLB.
            MassConvertie = ConversionKGaLB(MassDepart);
        } else if (UniteDepart.equals("lb")){
            UniteConvertie.equals("kg");
            //On appelle la methode ConversionLBaKG.
            MassConvertie = ConversionLBaKG(MassDepart);
        }

        massTo.setText(numberFormat.format(MassConvertie).toString());
    }

    //Methode conversion de Conversion de kg à lb 
    public float ConversionKGaLB(Float massekg){ return massekg*2.205f; }
    //Methode conversion de conversion de lb à kg 
    public float ConversionLBaKG(Float masselb) { return (masselb/2.205f);}

}
