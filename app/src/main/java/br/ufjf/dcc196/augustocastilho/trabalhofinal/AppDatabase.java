package br.ufjf.dcc196.augustocastilho.trabalhofinal;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Animal.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public static final  String DB_NAME = "animal-db" ;
    private static  AppDatabase  INSTANCE;

    public abstract AnimalDao animalDao();

    public static AppDatabase getInstance (Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            AppDatabase .class,
                            DB_NAME
                    )
                    .build();
        }
        return INSTANCE;
    }
}
