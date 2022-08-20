package br.ufjf.dcc196.augustocastilho.trabalhofinal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class AnimalViewHolder extends RecyclerView.ViewHolder {
    private final TextView textViewNome;
    private final TextView textViewRaca;

    private AnimalViewHolder(View itemView) {
        super(itemView);
        textViewNome = itemView.findViewById(R.id.textViewNome);
        textViewRaca = itemView.findViewById(R.id.textViewRaca);
    }

    public void bind(String nome, String raca) {
        textViewNome.setText(nome);
        textViewRaca.setText(raca);
    }

    static AnimalViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_animal, parent, false);
        return new AnimalViewHolder(view);
    }
}
