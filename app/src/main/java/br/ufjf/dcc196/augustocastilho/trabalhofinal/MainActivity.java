package br.ufjf.dcc196.augustocastilho.trabalhofinal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerPets;
    private AnimalViewModel mAnimalViewModel;
    ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AnimalAdapter animalAdapter = new AnimalAdapter(new AnimalAdapter.AnimalDiff());

        recyclerPets = findViewById(R.id.recyclerPets);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerPets.setLayoutManager(layoutManager);
        recyclerPets.setAdapter(animalAdapter);

        mAnimalViewModel = new ViewModelProvider(this).get(AnimalViewModel.class);

        mAnimalViewModel.getTodosAnimais().observe(this, animais -> {
            animalAdapter.submitList(animais);
        });

        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        String nome;
                        String raca;
                        Bundle extras;
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            extras = result.getData().getExtras();
                            nome = extras.getString("Nome");
                            raca = extras.getString("Raca");
                            Animal animal = new Animal(nome, raca);
                            mAnimalViewModel.insert(animal);
                        }
                    }
                });
    }

    public void onClickCadastrar(View view){
        Intent intent = new Intent(MainActivity.this, Cadastrar.class);
        launcher.launch(intent);
    }

    public void onClickAgendar(View view){
        Intent intent = new Intent(MainActivity.this, Clinicas.class);
        startActivity(intent);
    }

}