package com.example.myapplication.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.contactActivity;
import com.example.myapplication.models.contacts;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactHolder> {

    private List<contacts> ContactsList;

    public ContactAdapter(List<contacts> ContactsList){
        this.ContactsList = ContactsList;
    }

     @NonNull
    @Override
    public ContactAdapter.ContactHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
         LayoutInflater lo = LayoutInflater.from(parent.getContext());
         View view = lo.inflate(R.layout.item, parent, false);
         return new ContactHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ContactHolder holder, int position){
        contacts C = ContactsList.get(position);
        holder.setdata(C);

        holder.tvName.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Context context = view.getContext();
                Intent i = new Intent(context, contactActivity.class);
                i.putExtra("contact", C);
                context.startActivity(i);
            }
        });

        holder.tvTel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:" + C.getTel()));
                view.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount(){
        return ContactsList.size();
    }

    public class ContactHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        TextView tvTel;
        contacts contacts;

        public ContactHolder(@NonNull View itemView){
            super(itemView);
            tvName = itemView.findViewById(R.id.name);
            tvTel  = itemView.findViewById(R.id.tel);
        }

        public void setdata(contacts C) {
            contacts = C;
            if (tvName != null) {
                tvName.setText(C.getName());
            }
            if (tvTel != null) {
                tvTel.setText(C.getTel());
            }
        }
    }
}
