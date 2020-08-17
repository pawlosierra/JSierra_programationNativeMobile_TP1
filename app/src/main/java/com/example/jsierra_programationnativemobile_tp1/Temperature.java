package com.example.jsierra_programationnativemobile_tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Temperature extends AppCompatActivity implements TextWatcher, RadioGroup.OnCheckedChangeListener {

    // les deux variables de type String contient la reference de unite de mesure avec laquelle
    // le programe commencera par defaut.
    // la variable UnitConverti est la variable à laquelle le programme attribuera la unite de
    // mesure finale.
    String UnitDepart = "C";            //Celcius
    String UnitConvertie = "F";          //Fahrenheit

    //Il faut que on fait l'initialisation des variables. Le début des variables est null.

    Float TempDepart = null;
    Float TempConvertie = null;

    //Cette ligne permet donnner le nombre de décimales.
    DecimalFormat numberFormat = new DecimalFormat("0.00");

    //l'ensemble du code Java de l'application est généralement écrit dans la méthode onCreate

    //Pour charger l'interface d'une activite, on redéfinie la méthode OnCreate à la l'aide
    //du mot clé @Override

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        //Lorsque la méthode (onCreate(Bundle savedInstanceState)) est appelée, Android tente de
        //récupérer l'état précédent de l'activité dans un Bundle (Si elle existe).

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

       //On assigne chaque bouton à une variable.
        //Pour faire la conversion, on a travaillé avec 2 groups de radio boutons.
        //Un RadioGroup qui contient les unites de depart et un RadioGroup qui contient
        //les unites avec lesquelles l'utilisateur souhaite voir le résultat de la conversion.

        RadioGroup rgFrom = (RadioGroup) findViewById(R.id.radioGroupDepart);
        RadioGroup rgTo = (RadioGroup) findViewById(R.id.RadioGroupFin);

        // On vas attribuer la valeur de la températeur de depart à cette object. C'est-à-dire
        // que temFrom=txtTemp.
        EditText tempFrom = (EditText) findViewById(R.id.txtTemp);

        //Assignation du listeners sur les radiogroups.
        rgFrom.setOnCheckedChangeListener(this);
        rgTo.setOnCheckedChangeListener(this);

        //Assignation du listeners sur le edittext
        tempFrom.addTextChangedListener(this);
    }

    //L'implémentation de l'interface TextWactcher nous oblige à déclarer les trois méthodes qui
    //lui sont associées.
    //Méthodes requises par l'interface textwatcher. Elles doivent etre déclarées mémes si elle
    //ne sont pas utilisées

    //Cette ligne s'exécute juste après la modification du texte ai eu lieu.
    public void afterTextChanged(Editable s){
        //Recherche l'instance du edittext.
        EditText tempFrom = (EditText) findViewById(R.id.txtTemp);

        //On vas faire la verification si le edittext est vide.
        if(tempFrom.getText().toString().isEmpty()){
            //On recherche l'instance de textview pour le résultat
            TextView tempTo = (TextView) findViewById(R.id.txtResultatTemp);
            //On lui assigne un chaine vide
            tempTo.setText("");
            //La température de départ est nulle.
            TempDepart = null;
        }
        //Sinon. s'il n'y a qu'un + ou un - la tempDepart est null.
        else if(tempFrom.getText().toString().equals("-") || (tempFrom.getText().toString().equals("+"))){
            //On ne fait rien puisqu'il n'y a pas de valeur numérique dans le edittext
            TempDepart = null;
        }
        //Sinon, c'est qu'il y a des nombres dans le edittext.
        else{
            //On converti le contenu du edittext en float et on assigne la valeur à la variable
            //tempdepart.
            TempDepart = Float.valueOf(tempFrom.getText().toString());
            //On apelle la méthode  quelCalul qui permet savoir quel calcul effectuer.
            //La méthode quelCalcul fonctionnera en utilisant la unite de depart (UnitDepart),
            //la unite à convertie (UnitConvertie) et la température de départ. Ces informations
            //est donnée par l'utilisateur.
            quelCalcul(UnitDepart,UnitConvertie,TempDepart);
        }
    }

    //Cette méthode s'exécute juste avant que la modification du text ai lieu.
    public void beforeTextChanged(CharSequence s, int start, int count, int after){
        //Rien à faire
    }
    //Cette méthode s'exécute pendant que la modification du texte a lieu.
    public void onTextChanged(CharSequence argO, int start, int before, int count){
        //Rien à faire
    }

    //Méthode appeléee lorsqu'un radio bouton est cliqué
    //La méthode rocoit en parametre le groupe de bouton et le bouton sélectionné

    @Override

    public void onCheckedChanged(RadioGroup group, int chechedId){

        RadioButton rEnCours = (RadioButton) findViewById(chechedId);

        //En utilisant l'option que l'utilisateur a choisi, le switch utilisara el id de chaque
        //élément d'entrée.
        switch (rEnCours.getId()){
            //Ce groupe de boutons sert à définir l'unité de départ du calcule que on veut
            //faire.
            case R.id.rbDeCelcius:
                //si l'utilisateur a choisi le radio bouton de celsius la unite de depart est
                // celcius.
                //Cette ligne permet d'afficher dans un message de text le radio bouton que
                //el usager a sélectionné.
                Toast.makeText(this,"celcius",Toast.LENGTH_SHORT).show();
                UnitDepart = "C";
                break;
            case R.id.rbDeFahreinheit:
                //si l'utilisateur a choisi le radio bouton de fahreinheit la unite de depart est
                // fahreinheit.
                //Cette ligne permet d'afficher dans un message de text le radio bouton que
                //el usager a sélectionné.
                Toast.makeText(this,"fahreinheit",Toast.LENGTH_SHORT).show();
                UnitDepart = "F";
                break;
            case R.id.rbDeKelvin:
                //si l'utilisateur a choisi le radio bouton de kelvin la unite de depart est
                // kelvin.
                //Cette ligne permet d'afficher dans un message de text le radio bouton que
                //el usager a sélectionné.
                Toast.makeText(this,"kelvin",Toast.LENGTH_SHORT).show();
                UnitDepart = "K";
                break;

            //Ce groupe de boutons sert à définir l'unité que on souhaitons obtenir.

            case R.id.rbFinCelcius:
                //si l'utilisateur a choisi le radio bouton de celsius, la unite à convertir est
                // celcius. C'est-à-dire que UnitConvertie= "C".
                //Cette ligne permet d'afficher dans un message de text le radio bouton que
                //el usager a sélectionné.
                Toast.makeText(this,"cenlcius",Toast.LENGTH_SHORT).show();
                UnitConvertie = "C";
                break;
            case R.id.rbFinFahrenheit:
                //si l'utilisateur a choisi le radio bouton de fahrenheit, la unite à convertir est
                // fahrenheit. C'est-à-dire que UnitConvertie= "F".
                //Cette ligne permet d'afficher dans un message de text le radio bouton que
                //el usager a sélectionné.
                Toast.makeText(this,"fahrenheit",Toast.LENGTH_SHORT).show();
                UnitConvertie = "F";
                break;
            case R.id.rbFinKelvin:
                //si l'utilisateur a choisi le radio bouton de kelvin, la unite à convertir est
                // kelvin. C'est-à-dire que UnitConvertie= "k".
                //Cette ligne permet d'afficher dans un message de text le radio bouton que
                //el usager a sélectionné.
                Toast.makeText(this,"kelvin",Toast.LENGTH_SHORT).show();
                UnitConvertie = "K";
                break;
        }
        //Si la temparature de depart n'est pas nulle
        if(TempDepart != null){
            //On appelle la methode quelcalcul qui permet de savoir quel calcul effectuer.
            quelCalcul(UnitDepart, UnitConvertie,TempDepart);
        }
    }

    //Methode qui permet de determiner quel calcul effectuer. Elle recoit en parametre l'unite
    //de depart, l'unite de conversion et la temperature de depart

    public void quelCalcul(String Ud, String Uc, Float TemperatureDepart){
        //On assigne ces valeurs aux variables
        UnitDepart = Ud;
        UnitConvertie = Uc;
        TempDepart = TemperatureDepart;

        //Recherche l'instance du textview
        TextView tempTo = (TextView) findViewById(R.id.txtResultatTemp);

        //On vais verifier quel est la unite de depart.

        //Les choix possibles sont:

        //Unite de depart: C

        //C => F
        //C => K

        //Unite de depart: F

        //F => C
        //F => K

        //Unite de depart: K

        //K => C
        //k => F

       switch (UnitDepart){
           //Dans chaque cas, on teste l'unité de conversion
           case ("C"):
               if (UnitConvertie.equals("F")){
                   //On appelle la methode ConversionCaF.
                   TempConvertie = ConversionCaF(TempDepart);
               }else if(UnitConvertie.equals("K")){
                   //On appelle la methode ConversionCaK.
                   TempConvertie = ConversionCaK(TempDepart);
               }else{
                   TempConvertie = TempDepart;
               }
               break;
           case ("F"):
               if(UnitConvertie.equals("C")){
                   //On appelle la methode ConversionFaC.
                   TempConvertie = ConversionFaC(TempDepart);
               }else if(UnitConvertie.equals("K")){
                   //On appelle la methode ConversionFaK.
                   TempConvertie = ConversionFaK(TempDepart);
               }else{
                   //Ne requiers pas de converssion.
                   TempConvertie = TempDepart;
               }
               break;
               default:
                   if(UnitConvertie.equals("C")){
                       //On appelle la methode ConversionKaC.
                       TempConvertie = ConversionKaC(TempDepart);
                   }else if(UnitConvertie.equals("F")){
                       //On appelle la methode ConversionKaF.
                       TempConvertie = ConversionKaF(TempDepart);
                   }else{
                       //Ne requiers pas de converssion.
                       TempConvertie = TempDepart;
                   }
                   break;
       }
       //On affiche le resultat dans le textview
        tempTo.setText(numberFormat.format(TempConvertie).toString());
    }

    // Methode conversion de Celcius en Fahrenheit
    public float ConversionCaF(Float temperatureC){
        return ((temperatureC*9/5)+32);
    }

    //Methode conversion de Celcius en kelvin
    public float ConversionCaK(Float temperatureC){
        return ((temperatureC+273.15f));
    }

    //Methode conversion de Fahrenheit en celcius
    public float ConversionFaC(Float temperatureF){
        return ((temperatureF-32)*5/9);
    }

    //Methode conversion de Fahrenheit en kelvin
    public float ConversionFaK(Float temperatureF){
        return (((temperatureF-32)*5/9)+273.15f);
    }

    //Methode conversion de Kelvin en celcius
    public float ConversionKaC(float temperatureK){
        return (temperatureK-273.15f);
    }

    //Methode conversion de kelvin en fahrenheit
    public float ConversionKaF(Float temperatureK){
        return (((temperatureK-273.15f)*9/5)+32);
    }
}
