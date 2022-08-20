package br.ufjf.dcc196.augustocastilho.trabalhofinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Clinicas extends AppCompatActivity {
    RecyclerView recyclerClinicas;
    List<Clinica> clinicas = new ArrayList<>();

    private ClinicaAdapter clinicaAdapter;
    ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clinicas);

        recyclerClinicas = findViewById(R.id.recyclerClinicas);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerClinicas.setLayoutManager(layoutManager);

        clinicas.add(new Clinica("Bicho bom", "Rua do Pastel Gaúcho, n 10"));
        clinicas.add(new Clinica("Auau", "Rua Lula da Silva, n 13"));
        clinicas.add(new Clinica("Miau", "Rua Bozonaru, n 17"));
        clinicas.add(new Clinica("PetCenter", "Rua Vereador Zé Silva Souza, n 432"));

        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if(result.getResultCode() == RESULT_OK)
                    finish();
            }
        });

        ClinicaAdapter.onClinicaClickListener listener = new ClinicaAdapter.onClinicaClickListener() {
            @Override
            public void onActivityClick(View view, int position) {
                Intent intent = new Intent(Clinicas.this, AgendarConsulta.class);
                launcher.launch(intent);
            }
        };

        clinicaAdapter = new ClinicaAdapter(clinicas, listener);
        recyclerClinicas.setAdapter(clinicaAdapter);
    }

    public void onClickVoltar(View view){
        finish();
    }
}