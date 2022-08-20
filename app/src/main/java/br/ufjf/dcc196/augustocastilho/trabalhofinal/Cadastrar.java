package br.ufjf.dcc196.augustocastilho.trabalhofinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Cadastrar extends AppCompatActivity {
    EditText editTextNome;
    EditText editTextRaca;
    EditText editTextPeso;
    EditText editTextDate;
    EditText editTextVacinas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        editTextNome = findViewById(R.id.editTextNome);
        editTextRaca = findViewById(R.id.editTextRaca);
        editTextPeso = findViewById(R.id.editTextPeso);
        editTextDate = findViewById(R.id.editTextDate);
        editTextVacinas = findViewById(R.id.editTextVacinas);
    }

    public void onClickSalvarPet(View view){
        String nome = editTextNome.getText().toString();
        String raca = editTextRaca.getText().toString();
        Intent resultado = new Intent(getApplicationContext(), MainActivity.class);
        resultado.putExtra("Nome", nome);
        resultado.putExtra("Raca", raca);
        setResult(RESULT_OK, resultado);
        finish();
    }

    public void onClickCancelarPet(View view){
        setResult(RESULT_CANCELED);
        finish();
    }
}