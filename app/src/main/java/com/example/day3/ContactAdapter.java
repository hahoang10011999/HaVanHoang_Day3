package com.example.day3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.Viewhoder> {
    List<Contact> contacts;
    IonclickContact ionclickContact;

    public void setIonclickContact(IonclickContact ionclickContact){
        this.ionclickContact = ionclickContact;
    }
    public ContactAdapter(List<Contact> contacts){this.contacts = contacts;}
    @NonNull
    @Override
    public ContactAdapter.Viewhoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item,parent,false);
        Viewhoder viewhoder = new Viewhoder(view);
        return viewhoder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.Viewhoder holder, final int position) {
        final Contact contact = contacts.get(position);

        holder.tvName.setText(contact.getName());
        holder.tvNumber.setText(contact.getNumber());

        holder.tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ionclickContact.onClickName(contact.getName(),position);
            }
        });
        holder.tvNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ionclickContact.onClickPhone(contact,position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class Viewhoder extends RecyclerView.ViewHolder {
        TextView tvName , tvNumber;
        public Viewhoder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvNumber = itemView.findViewById(R.id.tvNumber);
        }
    }
}
