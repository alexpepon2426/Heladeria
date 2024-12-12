package com.ariofrio.heladeria;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity2 extends AppCompatActivity {
private TextView texto,texto2,texto3,texto4,textoSpin;
    int a,b,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_2);
        texto=findViewById(R.id.tv);
        texto2=findViewById(R.id.tv4);
        texto3=findViewById(R.id.tv5);
        texto4=findViewById(R.id.tv6);
        textoSpin=findViewById(R.id.tvSpin);

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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private String eleccion(String palabra) {
        String retorno;
        if (palabra.equalsIgnoreCase("cucurucho")) {
            retorno = "V";
            textoSpin.setTextColor(Color.parseColor("#A52A2A"));
        } else if (palabra.equalsIgnoreCase("choco")) {
            retorno = "V";
            textoSpin.setTextColor(Color.parseColor("#5D4037"));
        } else {
            retorno = "U";
            textoSpin.setTextColor(Color.BLACK);
        }

        return retorno;
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