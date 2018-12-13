package com.example.hphp.spetcare;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity implements View.OnClickListener{

    private EditText TextEmail;
    private EditText TextPassword;
    private EditText TextPassword2;
    private FirebaseAuth firebaseAuth;
    private Button btnRegistrar;
    private ProgressDialog progressDialog;

    public static String usuario, pass;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firebaseAuth = FirebaseAuth.getInstance();
        TextEmail = (EditText) findViewById(R.id.email);
        TextPassword = (EditText) findViewById(R.id.password);
        TextPassword2 = (EditText) findViewById(R.id.password2);
        btnRegistrar = (Button) findViewById(R.id.btn_register);
        progressDialog = new ProgressDialog(this);

        btnRegistrar.setOnClickListener(this);

    }

    private void registrarUsuario(){
        //Obtenemos el email y la contraseña desde las cajas de texto
        String email = TextEmail.getText().toString().trim();
        String password = TextPassword.getText().toString().trim();
        String password2 = TextPassword2.getText().toString();
        //Verificamos que las cajas de texto no esten vacías
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Se debe ingresar un email", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Falta ingresar la contraseña", Toast.LENGTH_LONG).show();
            return;
        }
        if (password.length() < 6){
            Toast.makeText(this, "Contraseña muy corta", Toast.LENGTH_LONG).show();
            return;
        }
        if (password.equals(password2)){
            progressDialog.setMessage("Realizando registro en linea...");
            progressDialog.show();
            //creating a new user
            firebaseAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            //checking if success
                            if (task.isSuccessful()) {
                                Toast.makeText(Register.this, "Se ha registrado el usuario con el email: " + TextEmail.getText(), Toast.LENGTH_LONG).show();
                                loguearUsuario();
                            } else {
                                if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                                    Toast.makeText(Register.this, "Ese usuario ya existe ", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(Register.this, "No se pudo registrar el usuario ", Toast.LENGTH_LONG).show();
                                }
                            }
                            progressDialog.dismiss();
                        }
                    });
        }
        else{
            Toast.makeText(this, "La contraseña no coincide", Toast.LENGTH_LONG).show();
        }
    }

    private void loguearUsuario() {
        //Obtenemos el email y la contraseña desde las cajas de texto
        final String email = TextEmail.getText().toString().trim();
        final String password = TextPassword.getText().toString().trim();
        //Verificamos que las cajas de texto no esten vacías
        if (TextUtils.isEmpty(email)) {//(precio.equals(""))
            Toast.makeText(this, "Se debe ingresar un email", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Falta ingresar la contraseña", Toast.LENGTH_LONG).show();
            return;
        }
        progressDialog.setMessage("Realizando consulta en linea...");
        progressDialog.show();
        //loguear usuario
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success

                        if (task.isSuccessful()) {
                            int pos = email.indexOf("@");
                            String user = email.substring(0, pos);
                            Toast.makeText(Register.this, "Bienvenido: " + TextEmail.getText(), Toast.LENGTH_LONG).show();
                            Intent intencion = new Intent(getApplication(), Welcome_Activity.class);
                            intencion.putExtra(Welcome_Activity.user, user);
                            usuario=user;
                            pass=password;
                            saveData();
                            startActivity(intencion);
                            finish();
                            MainActivity.getInstance().finish();
                        } else {
                            if (task.getException() instanceof FirebaseAuthUserCollisionException) {//si se presenta una colisión
                                Toast.makeText(Register.this, "Ese usuario ya existe ", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(Register.this, "No se pudo registrar el usuario ", Toast.LENGTH_LONG).show();
                            }
                        }
                        progressDialog.dismiss();
                    }
                });
    }

    private void saveData() {
        SharedPreferences.Editor spe = getPreferences(MODE_PRIVATE).edit();

        StringBuilder sb = new StringBuilder();
        sb.append(usuario);
        sb.append(pass);

        spe.putString("login", sb.toString());
        spe.commit();
    }


    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_register:
                System.out.println("CASI");
                //Invocamos al método:
                registrarUsuario();
                break;
            default:
                break;
        }
    }


}
