package br.ufjf.dcc196.augustocastilho.trabalhofinal;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface AnimalDao {
    @Insert
    void insetAnimal (Animal novoAnimal);

    @Query("SELECT * from animal")
    List<Animal> findAll();

    @Query("SELECT * from animal WHERE id=:id LIMIT 1 ")
    Animal findById(Long id);

    @Update
    void save(Animal animal);

    @Delete
    void delete(Animal animal);
}
