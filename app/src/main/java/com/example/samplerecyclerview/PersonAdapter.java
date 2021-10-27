package com.example.samplerecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
// RecyclerView.Adapter = Person이 복수개가 들어가 있는 list
public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder>
        implements OnPersonItemClickListener{

    ArrayList<Person> items = new ArrayList<Person>();
    OnPersonItemClickListener listener;

    @NonNull
    @Override
    //ViewHolder는 하나의 Person을 담기위한 그릇 같은 개념
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.person_item, parent, false);
        return new ViewHolder(itemView, this);
    }

    public void setListener(OnPersonItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onItemClick(ViewHolder holder, View view, int position) {
        if (listener != null) {
            listener.onItemClick(holder, view, position);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Person item = items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView1, textView2;

        public ViewHolder(View itemView, final OnPersonItemClickListener listener) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null) {
                        listener.onItemClick(ViewHolder.this, itemView, position);
                    }
                }
            });
        }

        public void setItem(Person item) {
            textView1.setText(item.getName());
            textView2.setText(item.getMobile());
        }
    }

    public void addItem(Person item) {items.add(item);}
    public Person getItem(int position) {return items.get(position);}
    public void setItems(ArrayList<Person> items) {this.items = items;}
    public void setItem(int position,Person item) {items.set(position,item);}
}
