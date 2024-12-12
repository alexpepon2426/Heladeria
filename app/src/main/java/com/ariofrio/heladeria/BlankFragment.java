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


    // TODO: Rename and change types and number of parameters
    //Toma como parametro las cadenas que le hemos pasado al fragment en el MAIN
    public static BlankFragment newInstance(String chocolate, String vainilla, String fresa, String eleccion) {
        BlankFragment fragment = new BlankFragment();
        //uso Bundle para empaquetar los valores y los asociamos al fragment
        Bundle args = new Bundle();
        args.putString("chocolate", chocolate);
        args.putString("vainilla", vainilla);
        args.putString("fresa", fresa);
        args.putString("eleccion", eleccion);
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
    //Metemos el contenido en el fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

   //aqui ir haciendo la lógica
   @Override
   public void onViewCreated(@NonNull View view, Bundle saveInstanceState) {
       super.onViewCreated(view, saveInstanceState);

       TextView texto, texto2, texto3, texto4, textoSpin;
       texto = view.findViewById(R.id.tv);
       texto2 = view.findViewById(R.id.tv4);
       texto3 = view.findViewById(R.id.tv5);
       texto4 = view.findViewById(R.id.tv6);
       textoSpin = view.findViewById(R.id.tvSpin);
       int a,b,c;
       //recuperas los argumentos usando getArguments
       Bundle args = getArguments();
       if (args != null) {
           String mensaje1 = args.getString("chocolate", "0");
           String mensaje2 = args.getString("vainilla", "0");
           String mensaje3 = args.getString("fresa", "0");
           String mensaje4 = args.getString("eleccion", "");
           a=Integer.parseInt(mensaje2);
           b=Integer.parseInt(mensaje1);
           c=Integer.parseInt(mensaje3);
           String cadena1 = helados(a);
           String cadena2 = helados(b);
           String cadena3 = helados(c);
           String cadena4 = eleccion(mensaje4);
           texto2.setText(cadena1);
           texto2.setTextColor(Color.YELLOW);

           texto3.setText(cadena2);
           texto3.setTextColor(Color.BLACK);

           texto4.setText(cadena3);
           texto4.setTextColor(Color.RED);
           textoSpin.setText(cadena4);


           texto.setText("De Vainilla han pedido: " + mensaje2 + "\nde Chocolate han elegido: " + mensaje1 + "\ny de fresa: " + mensaje3 + "\nY has elegido " + mensaje4);
       }
   }

    private String eleccion(String palabra){
        String retorno;
        if(palabra.equalsIgnoreCase("cucurucho")||palabra.equalsIgnoreCase("cucu")){
            return retorno="V";
        }else{
            return retorno="U";
        }

    }
    private String helados(int num) {
        String cadena = "";
        for (int i = 0; i < num; i++) {
            cadena += "O";
        }
        return cadena;
    }

    public void Acabar(View view) {
        getActivity().finish();
    }
}