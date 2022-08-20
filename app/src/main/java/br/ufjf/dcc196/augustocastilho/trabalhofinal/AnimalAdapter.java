package br.ufjf.dcc196.augustocastilho.trabalhofinal;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class AnimalAdapter extends ListAdapter<Animal, AnimalViewHolder> {
    protected AnimalAdapter(@NonNull DiffUtil.ItemCallback<Animal> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return AnimalViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder holder, int position) {
        Animal animal = getItem(position);
        holder.bind(animal.getNome(), animal.getRaca());
    }

    static class AnimalDiff extends DiffUtil.ItemCallback<Animal>{

        @Override
        public boolean areItemsTheSame(@NonNull Animal oldItem, @NonNull Animal newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Animal oldItem, @NonNull Animal newItem) {
            return oldItem.getNome().equals(newItem.getNome());
        }
    }

}
