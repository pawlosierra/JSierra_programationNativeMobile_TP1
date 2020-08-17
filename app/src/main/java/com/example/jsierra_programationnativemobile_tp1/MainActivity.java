package com.example.jsierra_programationnativemobile_tp1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //cette methode appellée lorsque l'utilisateur cliquer sur le bouton
    public void demarreMenuActivity(View view){
        Intent optionMenuprinciPrincipale = new Intent(this,MenuActivity.class);
        startActivity(optionMenuprinciPrincipale);
    }

   @Override
    public void onBackPressed(){

       AlertDialog.Builder DialogueQuitter = new AlertDialog.Builder(MainActivity.this);

       DialogueQuitter.setTitle(R.string.app_name);
       DialogueQuitter.setIcon(R.mipmap.ic_launcher);

       DialogueQuitter.setMessage("Voulez vous vraiment quitter?")
               .setCancelable(false)
               .setPositiveButton("Oui", new DialogInterface.OnClickListener(){
                   public void  onClick(DialogInterface dialog, int id){
                       finish();
                   }
               })
               .setNegativeButton("Non", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                       dialog.cancel();
                   }
               });
       AlertDialog alert = DialogueQuitter.create();
       alert.show();
   }

}
