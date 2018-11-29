package com.example.hphp.spetcare;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link vacunas.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link vacunas#newInstance} factory method to
 * create an instance of this fragment.
 */
public class vacunas extends Fragment {
   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vacunas, container, false);
    }
    @Override
    public void onStart(){
        super.onStart();
        int mascota = this.getArguments().getInt("mascota", -1);
        TextView textView = getActivity().findViewById(R.id.vaccine_pet_name);
        LinearLayout parentLinear = getActivity().findViewById(R.id.parent_linear_layout_vaccine);
        if(mascota == 0){
            textView.setText("Vacunas Perros");
            for(int i = 1; i<=3 ; i++){
                LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View rowView = inflater.inflate(R.layout.vaccinefield, null);
                TextView vaccineName = rowView.findViewById(R.id.vaccine_name);
                TextView vaccineTime = rowView.findViewById(R.id.vaccine_time);
                CheckBox vaccineCheck = rowView.findViewById(R.id.vaccine_check);
                vaccineName.setText("Vacuna " + i);
                vaccineTime.setText("Edad: " + i);
                vaccineCheck.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast toast = Toast.makeText(getContext(), "Vacuna seleccionada", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });
                parentLinear.addView(rowView, -1);
            }
        }else if(mascota == 1){
            textView.setText("Vacunas Gatos");
            for(int i = 1; i<=3 ; i++){
                LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View rowView = inflater.inflate(R.layout.vaccinefield, null);
                TextView vaccineName = rowView.findViewById(R.id.vaccine_name);
                TextView vaccineTime = rowView.findViewById(R.id.vaccine_time);
                CheckBox vaccineCheck = rowView.findViewById(R.id.vaccine_check);
                vaccineName.setText("Vacuna " + i);
                vaccineTime.setText("Edad: " + i);
                vaccineCheck.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast toast = Toast.makeText(getContext(), "Vacuna seleccionada", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });
                parentLinear.addView(rowView, -1);
            }
        }else if(mascota == 2){
            textView.setText("Vacunas Hamster");
            for(int i = 1; i<=2 ; i++){
                LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View rowView = inflater.inflate(R.layout.vaccinefield, null);
                TextView vaccineName = rowView.findViewById(R.id.vaccine_name);
                TextView vaccineTime = rowView.findViewById(R.id.vaccine_time);
                CheckBox vaccineCheck = rowView.findViewById(R.id.vaccine_check);
                vaccineName.setText("Vacuna " + i);
                vaccineTime.setText("Edad: " + i);
                vaccineCheck.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast toast = Toast.makeText(getContext(), "Vacuna seleccionada", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });
                parentLinear.addView(rowView, -1);
            }
        }else if(mascota == 3){
            textView.setText("Vacunas Pajaro");
            for(int i = 1; i<=5 ; i++){
                LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View rowView = inflater.inflate(R.layout.vaccinefield, null);
                TextView vaccineName = rowView.findViewById(R.id.vaccine_name);
                TextView vaccineTime = rowView.findViewById(R.id.vaccine_time);
                CheckBox vaccineCheck = rowView.findViewById(R.id.vaccine_check);
                vaccineName.setText("Vacuna " + i);
                vaccineTime.setText("Edad: " + i);
                vaccineCheck.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast toast = Toast.makeText(getContext(), "Vacuna seleccionada", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });
                parentLinear.addView(rowView, -1);
            }
        }
    }
}
