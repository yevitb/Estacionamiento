package com.example.invitado.estacionamiento;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    TextView total;
    EditText editHora;
    EditText editFra;
    TimePicker timeIn;
    TimePicker timeOut;
    Button outTotal;

    double a, b, c, horas, minuto, horaIn, modulo;
    int  minutoIn, horaOut, minutoOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        total= (TextView) findViewById(R.id.total);
        editHora= (EditText) findViewById(R.id.editHora);
        editFra = (EditText) findViewById(R.id.editFra);
        timeIn= (TimePicker) findViewById(R.id.timeIn);
        timeOut= (TimePicker) findViewById(R.id.timeOut);
        outTotal= (Button) findViewById(R.id.outTotal);

        outTotal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                horaIn = timeIn.getHour();
                minutoIn = timeIn.getMinute();
                horaOut = timeOut.getHour();
                minutoOut = timeOut.getMinute();
                a = Double.parseDouble(editHora.getText().toString());
                b = Double.parseDouble(editFra.getText().toString());
                horas=1;

                if(horaIn>=horaOut){
                    if(horaIn==horaOut&&minutoOut>minutoIn) {
                        horas=0;

                    }
                    //horaIn=12-horaIn;
                    else if(!(horas==0)){
                        horaIn=24-horaIn;
                        horas = horaIn + horaOut;

                    }
                }
                else {
                    horas = (horaOut - horaIn);
                }
                minuto = (minutoOut - minutoIn);
                modulo = minuto % 15;
                minuto = minuto / 15;
                if (!(modulo == 0)) {
                    minuto = minuto + 1;
                }
                minuto = (int) minuto;

                if (horas == 1) {
                    minuto = (minuto) * b;
                    c = minuto + a;
                }
                else if (horas == 0) {
                    c = a;
                }
                else if (!(horas == 1 && horas == 0)) {
                    minuto = minuto * b;
                    c = ((((horas - 1) * 4) * b) + a + minuto);
                }

                total.setText("El total a pagar es: " + c);


            }
        });
    }
}
