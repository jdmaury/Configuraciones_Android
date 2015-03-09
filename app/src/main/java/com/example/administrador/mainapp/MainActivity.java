package com.example.administrador.mainapp;



import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    TextView tv;
    TextView tv1;
    TextView tv2;
    EditText et;
    EditText et1;
    EditText et2;
//    String prueba = getResources().getString(R.string.default_name);
    SharedPreferences mSharedPreferences ;
    SharedPreferences prueba;
    String key ="stringkey";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView)findViewById(R.id.textView);
        tv1 = (TextView)findViewById(R.id.textView2);
        tv2 = (TextView)findViewById(R.id.textView3);

        et=(EditText)findViewById(R.id.editText);
        et1=(EditText)findViewById(R.id.editText2);
        et2=(EditText)findViewById(R.id.editText3);


        //mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        prueba=PreferenceManager.getDefaultSharedPreferences(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        et.setKeyListener(null);
        et1.setKeyListener(null);
        et2.setKeyListener(null);
        String nombre = prueba.getString("datos_personales","default_value");
        String edad = prueba.getString("edad","default_value");
        String genero = prueba.getString("genero","default_value");
        tv.setText("Nombre");
        tv1.setText("Edad");
        tv2.setText("Género");
        et2.setText(nombre);
        et1.setText(edad);
        et.setText(genero);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this,SettingsActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
