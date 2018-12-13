package com.example.hphp.spetcare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class mascota extends AppCompatActivity {
    public static final String user="names";
    TextView txtUser;
    String seleccionado,seleccionado1;
    public static String nom,tip;
    DatabaseReference databaseReference;
    Button boton1;
    private EditText nombre, tipo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascota);

        boton1 = (Button)findViewById(R.id.guardarM);
        nombre = (EditText) findViewById(R.id.nombre);
        tipo = (EditText) findViewById(R.id.tipo);
        databaseReference= FirebaseDatabase.getInstance().getReference();
        txtUser =(TextView)findViewById(R.id.textser);
        String user = getIntent().getStringExtra("names");

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datos p1 = new datos("holi");
                seleccionado=nombre.getText().toString();
                seleccionado1=tipo.getText().toString();
                databaseReference.child(Welcome_Activity.prueba).child("Mi mascota es "+ seleccionado1).setValue(seleccionado);
                //databaseReference.child(Welcome_Activity.prueba).child("Mi mascota").setValue(tipo);
                Intent myintent = new Intent(getApplicationContext(),Welcome_Activity.class);
                startActivity(myintent);

            }
        });
    }
}
