package br.ufjf.dcc196.augustocastilho.trabalhofinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ClinicaAdapter extends RecyclerView.Adapter<ClinicaAdapter.ClinicaViewHolder>{
    List<Clinica> clinicas;
    private onClinicaClickListener listener;

    public ClinicaAdapter(List<Clinica> clinicas, onClinicaClickListener listener){
        this.clinicas = clinicas;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ClinicaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context contexto = parent.getContext();
        LayoutInflater inflator = LayoutInflater.from(contexto);
        View clinicaView = inflator.inflate(R.layout.layout_clinica, parent, false);
        ClinicaViewHolder viewHolder = new ClinicaViewHolder(clinicaView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ClinicaViewHolder holder, int position) {
        Clinica clinica = clinicas.get(position);
        holder.textViewNome.setText(clinica.getNome());
        holder.textViewEndereco.setText(clinica.getEndereco());
    }

    @Override
    public int getItemCount() {
        return clinicas.size();
    }

    public class ClinicaViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewNome;
        private TextView textViewEndereco;
        public ClinicaViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNome = itemView.findViewById(R.id.textViewNomeClinica);
            textViewEndereco = itemView.findViewById(R.id.textViewEndereco);
            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    listener.onActivityClick(v, getAdapterPosition());
                }
            });
        }
    }

    interface onClinicaClickListener {
        void onActivityClick(View view, int position);
    }
}
