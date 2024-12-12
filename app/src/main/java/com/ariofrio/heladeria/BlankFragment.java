package com.ariofrio.heladeria;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BlankFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance(String param1, String param2) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }
    //aqui ir haciendo la lógica
    public void onViewCreated(@NonNull View view, Bundle saveInstanceState){
        TextView texto,texto2,texto3,texto4,textoSpin;
        int a,b,c;
        texto=view.findViewById(R.id.tv);
        texto2=view.findViewById(R.id.tv4);
        texto3=view.findViewById(R.id.tv5);
        texto4=view.findViewById(R.id.tv6);
        textoSpin=view.findViewById(R.id.tvSpin);

        Intent intent = getIntent();
        String mensaje1 = intent.getStringExtra("chocolate");
        String mensaje2 = intent.getStringExtra("vainilla");
        String mensaje3 = intent.getStringExtra("fresa");
        String mensaje4 = intent.getStringExtra("eleccion");
        a=Integer.parseInt(mensaje2);
        b=Integer.parseInt(mensaje1);
        c=Integer.parseInt(mensaje3);
        String cadena1 = vainilla(a);
        String cadena2 = chocolate(b);
        String cadena3 = fresa(c);
        String cadena4 = eleccion(mensaje4);
        texto2.setText(cadena1);
        texto2.setTextColor(Color.YELLOW);

        texto3.setText(cadena2);
        texto3.setTextColor(Color.BLACK);

        texto4.setText(cadena3);
        texto4.setTextColor(Color.RED);

        textoSpin.setText(cadena4);
        texto.setText("De chocolate han pedido: "+mensaje1+" de vainilla han elegido: "+mensaje2+" y de fresa: "+mensaje3+" Y has elegido "+mensaje4);
    }
    private String eleccion(String palabra){
        String retorno;
        if(palabra.equalsIgnoreCase("cucurucho")||palabra.equalsIgnoreCase("cucu")){
            return retorno="V";
        }else{
            return retorno="U";
        }

    }
    private String vainilla(int num){
        String cadenaO ="";
        for(int i=0;i<num;i++){
            cadenaO+="O";
        }
        return cadenaO;
    }
    private String chocolate(int num){
        String cadenaC ="";
        for(int  i=0;i<num;i++){
            cadenaC+="O";
        }
        return cadenaC;
    }
    private String fresa(int num){
        String cadenaC ="";
        for(int  i=0;i<num;i++){
            cadenaC+="O";
        }
        return cadenaC;
    }
}