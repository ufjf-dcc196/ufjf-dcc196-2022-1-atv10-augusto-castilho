package br.ufjf.dcc196.augustocastilho.trabalhofinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AgendarConsulta extends AppCompatActivity {
    RecyclerView recyclerHorarios;
    private HorarioAdapter horarioAdapter;
    List<Horario> horarios = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendar_consulta);

        recyclerHorarios = findViewById(R.id.recyclerHorarios);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerHorarios.setLayoutManager(layoutManager);

        horarios.add(new Horario("22","08", "10:00"));
        horarios.add(new Horario("22","08", "10:30"));
        horarios.add(new Horario("22","08", "11:00"));
        horarios.add(new Horario("22","08", "11:30"));
        horarios.add(new Horario("22","08", "12:00"));
        horarios.add(new Horario("22","08", "12:30"));
        horarios.add(new Horario("22","08", "13:00"));
        horarios.add(new Horario("22","08", "13:30"));
        horarios.add(new Horario("22","08", "14:00"));
        horarios.add(new Horario("22","08", "14:30"));
        horarios.add(new Horario("22","08", "15:00"));
        horarios.add(new Horario("22","08", "15:30"));

        HorarioAdapter.onHorarioClickListener listener = new HorarioAdapter.onHorarioClickListener() {
            @Override
            public void onActivityClick(View view, int position) {
                Toast.makeText(AgendarConsulta.this, "Consulta agendada com sucesso", Toast.LENGTH_LONG).show();
                Intent resultado = new Intent();
                setResult(RESULT_OK, resultado);
                finish();
            }
        };

        horarioAdapter = new HorarioAdapter(horarios, listener);
        recyclerHorarios.setAdapter(horarioAdapter);
    }

    public void onClickVoltar(View view){
        finish();
    }
}