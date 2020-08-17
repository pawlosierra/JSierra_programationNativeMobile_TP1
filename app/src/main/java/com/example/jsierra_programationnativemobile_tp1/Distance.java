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

public class Distance extends AppCompatActivity implements TextWatcher, RadioGroup.OnCheckedChangeListener {

    String UniteDepart = "cm";
    String UniteConvertie = "m";

    Float DistDepart = null;
    Float DistConvertie = null;

    DecimalFormat numberFormat = new DecimalFormat("0.00");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distance);

        RadioGroup rgFrom = (RadioGroup) findViewById(R.id.radioGroupDepartDist);
        RadioGroup rgTo = (RadioGroup) findViewById(R.id.radioGroupFinDist);

        EditText distFrom = (EditText) findViewById(R.id.txtDist);

        rgFrom.setOnCheckedChangeListener(this);
        rgTo.setOnCheckedChangeListener(this);

        distFrom.addTextChangedListener(this);
    }

    //Methodes requises par l'interface textwatcher. Elles doivent etre déclarées mémes si elle 
    // ne sont pas utiliseé.

    public void afterTextChanged(Editable s) {

        EditText distFrom = (EditText) findViewById(R.id.txtDist);

        if(distFrom.getText().toString().isEmpty()) {

            TextView distTo = (TextView) findViewById(R.id.txtResultatDist);

            distTo.setText("");

            DistDepart = null;
        }

        else if (distFrom.getText().toString().equals("-") || (distFrom.getText().toString().equals("+"))) {
            distFrom = null;
        }
        else{

            DistDepart = Float.valueOf(distFrom.getText().toString());

            quelcalculDist(UniteDepart,UniteConvertie,DistDepart);
        }
        }

    public void beforeTextChanged(CharSequence s,int start, int count, int after) {

        //Rien à faire
    }

    public void onTextChanged(CharSequence argO, int start, int before, int count) {

        //Rien à faire
    }


    //Méthode appellée lorsqu'un radio bouton est cliqué. 
    // La méthode reçoit en parametre le groupe de bouton et le bouton sélectionné.

    @Override

    public void onCheckedChanged(RadioGroup group, int chechedId) {

        RadioButton radioboutonEnCours = (RadioButton) findViewById(chechedId);

        //En utilisant l'option que l'utilisateur a choisi, le switch utilisara el id de chaque
        //élément d'entrée.
        switch (radioboutonEnCours.getId()) {

            case R.id.rbDecentimetre:

                //Bouton radio de centimetre. 
                Toast.makeText(this,"centimetre",Toast.LENGTH_SHORT).show();
                UniteDepart = "cm";
                break;

            case R.id.rbDemetre:
                //Bouton radio de mètre 
                Toast.makeText(this,"centimetre",Toast.LENGTH_SHORT).show();
                UniteDepart = "m";
                break;

            case R.id.rbDekilometre:
                //Bouton radio de kilomètre
                Toast.makeText(this,"centimetre",Toast.LENGTH_SHORT).show();
                UniteDepart = "km";
                break;

            case R.id.rbDepouce:
                //Bouton radio de pouce 
                Toast.makeText(this,"centimetre",Toast.LENGTH_SHORT).show();
                UniteDepart = "pouce";
                break;

            case R.id.rbDepied:
                //Bouton radio de pied
                Toast.makeText(this,"centimetre",Toast.LENGTH_SHORT).show();
                UniteDepart = "pied";
                break;

            case R.id.rbDemile:
                //Bouton radio de mile.
                Toast.makeText(this,"centimetre",Toast.LENGTH_SHORT).show();
                UniteDepart = "mile";
                break;

            //Ce groupe de boutons sert à définir l'unité que on souhaitons obtenir.
            case R.id.rbFincentimetre:

                //Bouton radio de centimetre (unité souhaitée)
                Toast.makeText(this,"centimetre",Toast.LENGTH_SHORT).show();
                UniteConvertie = "cm";
                break;

            case R.id.rbFinmetre:
                //Bouton radio de mètre (unité souhaitée)
                Toast.makeText(this,"centimetre",Toast.LENGTH_SHORT).show();
                UniteConvertie = "m";
                break;

            case R.id.rbFinkilometre:
                //Bouton radio de kilomètre (unité souhaitée)
                Toast.makeText(this,"centimetre",Toast.LENGTH_SHORT).show();
                UniteConvertie = "km";
                break;

            case R.id.rbFinpouce:
                //Bouton radio de pouce (unité souhaitée)
                Toast.makeText(this,"centimetre",Toast.LENGTH_SHORT).show();
                UniteConvertie = "pouce";
                break;

            case R.id.rbFinpied:
                //Bouton radio de pied (unité souhaitée)
                Toast.makeText(this,"centimetre",Toast.LENGTH_SHORT).show();
                UniteConvertie = "pied";
                break;

            case R.id.rbFinmile:
                //Bouton radio de mile (unité souhaitée)
                Toast.makeText(this,"centimetre",Toast.LENGTH_SHORT).show();
                UniteConvertie = "mile";
                break;

        }

        if (DistDepart != null) {
            //On appelle la méthode quelcalculDist qui permet de savoir quel calcul effectuers 
            quelcalculDist(UniteDepart, UniteConvertie, DistDepart);
        }
    }

    //Méthode qui permet de determiner quel calcul effectuer. Elle recoit en parametre l'unité 
    //de depart, l'unité  de conversion et la distance de depart


    public void quelcalculDist(String uDe, String uCon, Float DistanceDepart) {
        //On assigne ces valeurs aux variables  
        UniteDepart = uDe;
        UniteConvertie = uCon;
        DistDepart = DistanceDepart;

        //Rechercher l'instance du textview
        TextView distTo = (TextView) findViewById(R.id.txtResultatDist);

        //On vais verifier quel est la unite de depart.

        //Les choix possibles sont:

        //Unite de depart: cm

        //cm => m
        //cm => km
        //cm => pouce
        //cm => pied
        //cm => mile

        //Unite de depart: m

        //m => cm
        //m => km
        //m => pouce
        //m => pied
        //m => mile

        //Unite de depart: km

        //km => cm
        //km => m
        //km => pouce
        //km => pied
        //km => mile

        //Unite de depart: pouce

        //pouce => cm
        //pouce => m
        //pouce => km
        //pouce => pied
        //pouce => mile

        //Unite de depart: pied

        //pied => cm
        //pied => m
        //pied => km
        //pied => pouce
        //pied => mile

        //Unite de depart: mile

        //mile => cm
        //mile => m
        //mile => km
        //mile => pouce
        //mile => pied

        //les choix possibles sont:

        switch (UniteDepart) {
            case ("cm"):
                if (UniteConvertie.equals("m")) {
                    DistConvertie = ConversionCMaM(DistDepart);
                } else if (UniteConvertie.equals("km")) {
                    DistConvertie = ConversionCMaKM(DistDepart);
                } else if (UniteConvertie.equals("pouce")) {
                    DistConvertie = ConversionCMaPOUCE(DistDepart);
                } else if (UniteConvertie.equals("pied")) {
                    DistConvertie = ConversionCMaPIED(DistDepart);
                } else if (UniteConvertie.equals("mile")) {
                    DistConvertie = ConversionCMaMILE(DistDepart);
                } else {
                    DistConvertie = DistDepart;
                }
                break;
            case ("m"):
                if (UniteConvertie.equals("cm")) {
                    DistConvertie = ConversionMaCM(DistDepart);
                } else if (UniteConvertie.equals("km")) {
                    DistConvertie = ConversionMaKM(DistDepart);
                } else if (UniteConvertie.equals("pouce")) {
                    DistConvertie = ConversionMaPOUCE(DistDepart);
                } else if (UniteConvertie.equals("pied")) {
                    DistConvertie = ConversionMaPIED(DistDepart);
                } else if (UniteConvertie.equals("mile")) {
                    DistConvertie = ConversionMaMILE(DistDepart);
                } else {
                    DistConvertie = DistDepart;
                }
                break;

            case ("km"):
                if (UniteConvertie.equals("cm")) {
                    DistConvertie = ConversionKMaCM(DistDepart);
                } else if (UniteConvertie.equals("m")) {
                    DistConvertie = ConversionKMaM(DistDepart);
                } else if (UniteConvertie.equals("pouce")) {
                    DistConvertie = ConversionKMaPOUCE(DistDepart);
                } else if (UniteConvertie.equals("pied")) {
                    DistConvertie = ConversionKMaPIED(DistDepart);
                } else if (UniteConvertie.equals("mile")) {
                    DistConvertie = ConversionKMaMILE(DistDepart);
                } else {
                    DistConvertie = DistDepart;
                }
                break;
            case ("pouce"):
                if (UniteConvertie.equals("cm")) {
                    DistConvertie = ConversionPOUCEaCM(DistDepart);
                } else if (UniteConvertie.equals("m")) {
                    DistConvertie = ConversionPOUCEaM(DistDepart);
                } else if (UniteConvertie.equals("km")) {
                    DistConvertie = ConversionPOUCEaKM(DistDepart);
                } else if (UniteConvertie.equals("pied")) {
                    DistConvertie = ConversionPOUCEaPIED(DistDepart);
                } else if (UniteConvertie.equals("mile")) {
                    DistConvertie = ConversionPOUCEaMILE(DistDepart);
                } else {
                    DistConvertie = DistDepart;
                }
                break;
            case ("pied"):
                if (UniteConvertie.equals("cm")) {
                    DistConvertie = ConversionPIEDaCM(DistDepart);
                } else if (UniteConvertie.equals("m")) {
                    DistConvertie = ConversionPIEDaM(DistDepart);
                } else if (UniteConvertie.equals("km")) {
                    DistConvertie = ConversionPIEDaKM(DistDepart);
                } else if (UniteConvertie.equals("pouce")) {
                    DistConvertie = ConversionPIEDaPOUCE(DistDepart);
                } else if (UniteConvertie.equals("mile")) {
                    DistConvertie = ConversionPIEDaMILE(DistDepart);
                } else {
                    DistConvertie = DistDepart;
                }
                break;
            default:
                if (UniteConvertie.equals("cm")) {
                    DistConvertie = ConversionMILEaCM(DistDepart);
                } else if (UniteConvertie.equals("m")) {
                    DistConvertie = ConversionMILEaM(DistDepart);
                } else if (UniteConvertie.equals("km")) {
                    DistConvertie = ConversionMILEaKM(DistDepart);
                } else if (UniteConvertie.equals("pouce")) {
                    DistConvertie = ConversionMILEaPOUCE(DistDepart);
                } else if (UniteConvertie.equals("pied")) {
                    DistConvertie = ConversionMILEaPIED(DistDepart);
                } else {
                    DistConvertie = DistDepart;
                }
                break;
        }
        //On affiche le resultat text view

        distTo.setText(numberFormat.format(DistConvertie).toString());
    }
    //===========================CM=======================================================
        //Methode conversion Conversion de cm à m 
        public float ConversionCMaM(Float distancecm){ return distancecm*0.01f; }
        //Methode conversion conversion de cm à km 
        public float ConversionCMaKM(Float distancecm) { return (distancecm/500000);}
        //Methode conversion conversion de cm à pouce 
        public float ConversionCMaPOUCE(Float distancecm) { return (distancecm/2.54f);}
        //Methode conversion Conversion de cm à pied 
        public float ConversionCMaPIED(Float distancecm) { return (distancecm/30.48f);}
        //Methode conversion Conversion de cm à mile 
        public float ConversionCMaMILE(Float distancecm) { return (distancecm/160934);}

    //===========================M=======================================================
    //Methode conversion Conversion de m à cm 
    public float ConversionMaCM(Float distancem){ return distancem*100; }
    //Methode conversion conversion de m à km 
    public float ConversionMaKM(Float distancem) { return (distancem/1000);}
    //Methode conversion conversion de m à pouce 
    public float ConversionMaPOUCE(Float distancem) { return (distancem*39.37f);}
    //Methode conversion Conversion de m à pied 
    public float ConversionMaPIED(Float distancem) { return (distancem*3.281f);}
    //Methode conversion Conversion de m à mile 
    public float ConversionMaMILE(Float distancem) { return (distancem/1609);}

    //===========================KM=======================================================
    //Methode conversion Conversion de km à cm 
    public float ConversionKMaCM(Float distancekm){ return distancekm*100000; }
    //Methode conversion conversion de km à m 
    public float ConversionKMaM(Float distancekm) { return (distancekm*1000);}
    //Methode conversion conversion de km à pouce 
    public float ConversionKMaPOUCE(Float distancekm) { return (distancekm*39370);}
    //Methode conversion Conversion de km à pied 
    public float ConversionKMaPIED(Float distancekm) { return (distancekm*3281);}
    //Methode conversion Conversion de km à mile 
    public float ConversionKMaMILE(Float distancekm) { return (distancekm/1.609f);}

    //===========================POUCE=======================================================
    //Methode conversion Conversion de pouce à cm 
    public float ConversionPOUCEaCM(Float distancepouce){ return distancepouce*2.54f; }
    //Methode conversion conversion de pouce à m 
    public float ConversionPOUCEaM(Float distancepouce) { return (distancepouce/39.37f);}
    //Methode conversion conversion de pouce à km 
    public float ConversionPOUCEaKM(Float distancepouce) { return (distancepouce/39370);}
    //Methode conversion Conversion de pouce à pied 
    public float ConversionPOUCEaPIED(Float distancecm) { return (distancecm/12);}
    //Methode conversion Conversion de pouce à mile 
    public float ConversionPOUCEaMILE(Float distancecm) { return (distancecm/63360);}

    //===========================PIED=======================================================
    //Methode conversion Conversion de pied à cm 
    public float ConversionPIEDaCM(Float distancepied){ return distancepied*30.48f; }
    //Methode conversion conversion de pied à m 
    public float ConversionPIEDaM(Float distancepied) { return (distancepied/3.281f);}
    //Methode conversion conversion de pied à km 
    public float ConversionPIEDaKM(Float distancepied) { return (distancepied/3281);}
    //Methode conversion Conversion de pied à pouce 
    public float ConversionPIEDaPOUCE(Float distancepied) { return (distancepied*12);}
    //Methode conversion Conversion de pied à mile 
    public float ConversionPIEDaMILE(Float distancepied) { return (distancepied/5280);}

    //===========================MILE=======================================================
    //Methode conversion Conversion de mille à cm 
    public float ConversionMILEaCM(Float distancemile){ return distancemile*160934; }
    //Methode conversion conversion de mille à m 
    public float ConversionMILEaM(Float distancemile) { return (distancemile*1609);}
    //Methode conversion conversion de mille à km 
    public float ConversionMILEaKM(Float distancemile) { return (distancemile*1.609f);}
    //Methode conversion Conversion de mille à pouce 
    public float ConversionMILEaPOUCE(Float distancemile) { return (distancemile*63360);}
    //Methode conversion Conversion de mille à pied 
    public float ConversionMILEaPIED(Float distancemile) { return (distancemile*5280);}

    }
