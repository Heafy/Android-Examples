package com.example.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter extends  RecyclerView.Adapter<ContactAdapter.ViewHolder>{

    private List<Contact> contactList;

    /**
     * Unique constructor.
     * Instance the list for the view
     * @param contactList The contact list to create.
     */
    public ContactAdapter(List<Contact> contactList) {
        this.contactList = contactList;
    }

    /**
     * Get the count of the item of the view.
     * @return The count of the item of the view.
     */
    @Override
    public int getItemCount() {
        return contactList.size();
    }


    /**
     * Class for instance the items of the view.
     */
    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvName;
        public Button btnMessage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            btnMessage = itemView.findViewById(R.id.btnMessage);
        }
    }

    /**
     * Create and inflate the view of the Recycler.
     * @param parent
     * @param i
     * @return The view of the RecyclerView.
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        // Inflate the view
        View contactView = inflater.inflate(R.layout.item_contacto, parent, false);
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    /**
     * Instance the items of each element of the view.
     * @param viewHolder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Contact contact = contactList.get(position);
        TextView textView = viewHolder.tvName;
        Button btnMessage = viewHolder.btnMessage;

        textView.setText(contact.getName());
        btnMessage.setText(contact.getOnline()?"Online" : "Offline");
        btnMessage.setEnabled(contact.getOnline());
    }
}
