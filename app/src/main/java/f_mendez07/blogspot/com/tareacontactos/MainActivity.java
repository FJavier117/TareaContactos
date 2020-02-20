package f_mendez07.blogspot.com.tareacontactos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edtNombre;
    private EditText edtTelefono;
    private EditText edtEmail;
    private EditText edtDescripcion;
    private DatePicker dtpFecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNombre       = findViewById(R.id.edtNombre);
        dtpFecha = findViewById(R.id.dtpFecha);
        edtTelefono     = findViewById(R.id.edtTelefono);
        edtEmail        = findViewById(R.id.edtEmail);
        edtDescripcion  = findViewById(R.id.edtDescripcion);
        Button btnSiguiente = findViewById(R.id.btnSiguiente);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                siguiente();
            }
        });

        obtener();
    }

    public String onDateSet(){

        int year;
        int month;
        int day;

        year = dtpFecha.getYear();
        month = dtpFecha.getMonth()+1;
        day = dtpFecha.getDayOfMonth();
        return day +"/"+ month+"/"+ year;
    }



    public void siguiente(){
        Intent intent = new Intent(MainActivity.this,ConfimarDatos.class);
        intent.putExtra(getResources().getString(R.string.key_nombre),edtNombre.getText().toString());
        intent.putExtra(getResources().getString(R.string.key_fecha),onDateSet());
        intent.putExtra(getResources().getString(R.string.key_telefono),edtTelefono.getText().toString());
        intent.putExtra(getResources().getString(R.string.key_email),edtEmail.getText().toString());
        intent.putExtra(getResources().getString(R.string.key_descripcion),edtDescripcion.getText().toString());
        startActivity(intent);
        finish();
    }

   public void obtener() {
        String nombre = null;
        String fecha = null;
        String telefono = null;
        String email = null;
        String descripcion = null;
        int year = 0;
        int month= 0;
        int day =  0;

        Bundle parametros = getIntent().getExtras();
        if (parametros != null){
            nombre = parametros.getString(getResources().getString(R.string.key_nombre));
            fecha = parametros.getString(getResources().getString(R.string.key_fecha));
            telefono = parametros.getString(getResources().getString(R.string.key_telefono));
            email = parametros.getString(getResources().getString(R.string.key_email));
            descripcion = parametros.getString(getResources().getString(R.string.key_descripcion));

        }

        if (fecha!=null){
            int pos1 = fecha.indexOf("/");
            int pos2 = fecha.lastIndexOf("/");

            String sDia = fecha.substring(0,pos1);
            day = Integer.parseInt(sDia);

            String sMes = fecha.substring(pos1+1,pos2);
            month = Integer.parseInt(sMes);

            String sYear = fecha.substring(pos2+1);
            year = Integer.parseInt(sYear);
        }


        edtNombre.setText(nombre);
        dtpFecha.updateDate(year,month,day);
        edtTelefono.setText(telefono);
        edtEmail.setText(email);
        edtDescripcion.setText(descripcion);
   }

}
