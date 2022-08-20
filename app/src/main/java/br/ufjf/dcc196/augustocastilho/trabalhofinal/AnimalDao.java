package br.ufjf.dcc196.augustocastilho.trabalhofinal;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface AnimalDao {
    @Insert
    void insertAnimal (Animal novoAnimal);

    @Query("SELECT * FROM animal")
    LiveData<List<Animal>> findAll();

    @Query("SELECT * FROM animal WHERE id=:id LIMIT 1 ")
    Animal findById(Long id);

    @Update
    void save(Animal animal);

    @Delete
    void delete(Animal animal);

    @Query("DELETE FROM animal")
    void deleteAll();
}
