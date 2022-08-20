package br.ufjf.dcc196.augustocastilho.trabalhofinal;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class AnimalViewModel extends AndroidViewModel {

    private RepoAnimal mRepositorio;

    private final LiveData<List<Animal>> todosAnimais;

    public AnimalViewModel(@NonNull Application application) {
        super(application);
        mRepositorio = new RepoAnimal(application);
        todosAnimais = mRepositorio.getAllAnimais();
    }

    LiveData<List<Animal>> getTodosAnimais() { return todosAnimais; }

    public void insert(Animal animal) { mRepositorio.insertAnimal(animal); }

}
