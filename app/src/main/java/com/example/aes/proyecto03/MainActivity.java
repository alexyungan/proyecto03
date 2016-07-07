package com.example.aes.proyecto03;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


     EditText editText1;
    EditText editText2;
    TextView textViewResultadoSuma;
    TextView textViewResultadoResta;
    TextView textViewResultadoTotal;
    Button buttonCalcular;

    CheckBox checkBoxSuma;
    CheckBox checkBoxResta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        editText1 =(EditText) findViewById(R.id.et1);
        editText2 =(EditText) findViewById(R.id.et2);
        textViewResultadoResta=(TextView)findViewById(R.id.tvResulatdoResta);
        textViewResultadoSuma=(TextView)findViewById(R.id.tvResulatdoSuma);
        textViewResultadoTotal=(TextView)findViewById(R.id.tvResulatdoTotal);
        buttonCalcular=(Button)findViewById(R.id.btnCalcular);
        checkBoxSuma=(CheckBox)findViewById(R.id.checkBoxSuma);
        checkBoxResta=(CheckBox)findViewById(R.id.checkBoxResta);
        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a =Integer.parseInt(editText1.getText().toString());
                int b =Integer.parseInt(editText2.getText().toString());
                String mensaje="no esta seleccionado";
                int suma=0;
                int resta=0;
                textViewResultadoSuma.setText("");
                textViewResultadoResta.setText("");
                textViewResultadoTotal.setText("");
                if(checkBoxSuma.isChecked()==true){
                    suma=a+b;
                    textViewResultadoSuma.setText(Integer.toString(suma));
                     mensaje ="La suma es:"+suma+"  ";


                }

                if(checkBoxResta.isChecked()==true){
                    resta=a-b;
                    textViewResultadoResta.setText(Integer.toString(resta));
                    if(checkBoxSuma.isChecked()==true){

                        mensaje+="La resta  es: "+resta;
                    }else {
                        mensaje = "La resta  es: " + resta;
                    }

                }

                textViewResultadoTotal.setText(Integer.toString(suma+resta));
                Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_LONG).show();


            }
        });

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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
