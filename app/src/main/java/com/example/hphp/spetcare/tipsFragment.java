package com.example.hphp.spetcare;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link tipsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link tipsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class tipsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tips, container, false);
    }
    @Override
    public void onStart(){
        super.onStart();
        int mascota = this.getArguments().getInt("mascota", -1);
        TextView textView = getActivity().findViewById(R.id.pet_name);
        LinearLayout parentLinear = getActivity().findViewById(R.id.parent_linear_layout);
        if(mascota == 0){
            textView.setText("Perros");
            for(int i = 0; i<3 ; i++){
                LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View rowView = inflater.inflate(R.layout.tipfield, null);
                TextView titleText = rowView.findViewById(R.id.tip_title);
                TextView bodyText = rowView.findViewById(R.id.tip_body);
                titleText.setText("Tip " + i + "perro");
                bodyText.setText("Descripcion del tip " + i);
                parentLinear.addView(rowView, -1);
            }
        }else if(mascota == 1){
            textView.setText("Gatos");
            for(int i = 0; i<2 ; i++){
                LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View rowView = inflater.inflate(R.layout.tipfield, null);
                TextView titleText = rowView.findViewById(R.id.tip_title);
                TextView bodyText = rowView.findViewById(R.id.tip_body);
                titleText.setText("Tip " + i + " gato");
                bodyText.setText("Descripcion del tip " + i);
                parentLinear.addView(rowView, -1);
            }
        }else if(mascota == 2){
            textView.setText("Hamster");
            for(int i = 0; i<4 ; i++){
                LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View rowView = inflater.inflate(R.layout.tipfield, null);
                TextView titleText = rowView.findViewById(R.id.tip_title);
                TextView bodyText = rowView.findViewById(R.id.tip_body);
                titleText.setText("Tip " + i + " hamster");
                bodyText.setText("Descripcion del tip " + i);
                parentLinear.addView(rowView, -1);
            }
        }else if(mascota == 3){
            textView.setText("Pajaro");
            for(int i = 0; i<5 ; i++){
                LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View rowView = inflater.inflate(R.layout.tipfield, null);
                TextView titleText = rowView.findViewById(R.id.tip_title);
                TextView bodyText = rowView.findViewById(R.id.tip_body);
                titleText.setText("Tip " + i + " pajaro");
                bodyText.setText("Descripcion del tip " + i);
                parentLinear.addView(rowView, -1);
            }
        }
    }
}
