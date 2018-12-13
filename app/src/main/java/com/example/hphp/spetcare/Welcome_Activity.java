package com.example.hphp.spetcare;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Welcome_Activity extends AppCompatActivity {
    public static final String user="names";
    public static String prueba;
    TextView txtUser;
    String seleccionado;
    Button mascota;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart(){
        super.onStart();
        setContentView(R.layout.activity_welcome);
        mascota= findViewById(R.id.mascota);
        txtUser =(TextView)findViewById(R.id.textser);
        String user = getIntent().getStringExtra("names");
        txtUser.setText("Bienvenido "+ user);
        databaseReference= FirebaseDatabase.getInstance().getReference();
        setContentView(R.layout.activity_welcome);
        final String email = FirebaseAuth.getInstance().getCurrentUser().getEmail();
        int pos = email.indexOf("@");
        final String userm = email.substring(0, pos);
        prueba=userm;
        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                seleccionado = Integer.toString(position);
                datos p1 = new datos(seleccionado);
                Intent intent = new Intent(getBaseContext(), tabActivity.class);
                intent.putExtra("animal", position);
                if(seleccionado.equals("0")){
                    databaseReference.child(userm).child("Animal").child("Perro").setValue(seleccionado);}
                else if (seleccionado.equals("1")){
                    databaseReference.child(userm).child("Animal").child("Gato").setValue(seleccionado);}
                else if (seleccionado.equals("2")){
                    databaseReference.child(userm).child("Animal").child("Hamster").setValue(seleccionado);}
                else{
                    databaseReference.child(userm).child("Animal").child("Ave").setValue(seleccionado);}
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_tab, menu);
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
            FirebaseAuth.getInstance().signOut();
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void miMascota(View view){
        Intent intent = new Intent(getBaseContext(),mascota.class);
        startActivity(intent);
    }

    public class ImageAdapter extends BaseAdapter {
        private Context mContext;

        public ImageAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return mThumbIds.length;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        // create a new ImageView for each item referenced by the Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView == null) {
                // if it's not recycled, initialize some attributes
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(360, 360));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(8, 8, 8, 8);
            } else {
                imageView = (ImageView) convertView;
            }

            imageView.setImageResource(mThumbIds[position]);
            return imageView;
        }

        // references to our images
        private Integer[] mThumbIds = {
                R.drawable.perro, R.drawable.gato,
                R.drawable.hamster, R.drawable.ave

        };
    }
}
