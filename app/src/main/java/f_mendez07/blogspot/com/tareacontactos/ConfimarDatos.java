package f_mendez07.blogspot.com.tareacontactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfimarDatos extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvFecha;
    private TextView tvTelefono;
    private TextView tvEmail;
    private TextView tvDescripcion;

    private String nombre;
    private String fecha;
    private String telefono;
    private String email;
    private String descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confimar_datos);


        tvNombre = findViewById(R.id.tvNombre);
        tvFecha = findViewById(R.id.tvFecha);
        tvTelefono = findViewById(R.id.tvTelefono);
        tvEmail = findViewById(R.id.tvEmail);
        tvDescripcion = findViewById(R.id.tvDescripcion);

        obtener();

        Button btnEditar = findViewById(R.id.btnEditar);
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editar();
            }
        });




    }

    public void obtener(){
        Bundle parametros = getIntent().getExtras();
        if (parametros!=null){
            nombre = parametros.getString(getResources().getString(R.string.key_nombre));
            fecha =parametros.getString(getResources().getString(R.string.key_fecha));
            telefono  = parametros.getString(getResources().getString(R.string.key_telefono));
            email = parametros.getString(getResources().getString(R.string.key_email));
            descripcion = parametros.getString(getResources().getString(R.string.key_descripcion));
        }

        tvNombre.setText(nombre);
        tvFecha.setText(fecha);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDescripcion.setText(descripcion);
    }

   public void editar(){
        Intent intent = new Intent(ConfimarDatos.this,MainActivity.class);
        intent.putExtra(getResources().getString(R.string.key_nombre),nombre);
        intent.putExtra(getResources().getString(R.string.key_fecha),fecha);
        intent.putExtra(getResources().getString(R.string.key_telefono),telefono);
        intent.putExtra(getResources().getString(R.string.key_email),email);
        intent.putExtra(getResources().getString(R.string.key_descripcion),descripcion);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if (keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(ConfimarDatos.this,MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }

}
