package br.ufjf.dcc196.augustocastilho.trabalhofinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HorarioAdapter extends RecyclerView.Adapter<HorarioAdapter.HorarioViewHolder>{
    List<Horario> horarios;
    private onHorarioClickListener listener;

    public HorarioAdapter(List<Horario> horarios, onHorarioClickListener listener) {
        this.horarios = horarios;
        this.listener = listener;
    }

    @NonNull
    @Override
    public HorarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context contexto = parent.getContext();
        LayoutInflater inflator = LayoutInflater.from(contexto);
        View horarioView = inflator.inflate(R.layout.layout_horarios, parent, false);
        HorarioViewHolder viewHolder = new HorarioViewHolder(horarioView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HorarioViewHolder holder, int position) {
        Horario horario = horarios.get(position);
        holder.textViewDia.setText(horario.getDia());
        holder.textViewMes.setText(horario.getMes());
        holder.textViewHora.setText(horario.getHora());
    }

    @Override
    public int getItemCount() {
        return horarios.size();
    }

    public class HorarioViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewDia;
        private TextView textViewMes;
        private TextView textViewHora;
        public HorarioViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewDia = itemView.findViewById(R.id.textViewDia);
            textViewMes = itemView.findViewById(R.id.textViewMes);
            textViewHora = itemView.findViewById(R.id.textViewHora);
            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    listener.onActivityClick(v, getAdapterPosition());
                }
            });
        }
    }

    public interface onHorarioClickListener{
        void onActivityClick(View view, int position);
    }
}
