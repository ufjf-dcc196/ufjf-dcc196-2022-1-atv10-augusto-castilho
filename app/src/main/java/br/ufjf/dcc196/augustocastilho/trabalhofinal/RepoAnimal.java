package br.ufjf.dcc196.augustocastilho.trabalhofinal;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class RepoAnimal {
    private AnimalDao mAnimalDao;
    private LiveData<List<Animal>> mAllAnimais;

    RepoAnimal(Application application) {
        AppDatabase db = AppDatabase.getInstance(application);
        mAnimalDao = db.animalDao();
        mAllAnimais = mAnimalDao.findAll();
    }

    LiveData<List<Animal>> getAllAnimais()  {
            return mAllAnimais;
    }

    void insertAnimal(Animal animal){
        AppDatabase.databaseWriteExecutor.execute(() -> {
            mAnimalDao.insertAnimal(animal);
        });
    }
}
