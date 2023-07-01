package com.example.projectone;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class passwordRecyclerViewAdapter extends RecyclerView.Adapter<passwordRecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "passwordRecyclerViewAdapter";

    private ArrayList<AccountPassword> details = new ArrayList<>();

    public passwordRecyclerViewAdapter(MainActivity2 mainActivity2) {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_details,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: Called");
        holder.website.setText(details.get(position).getWebsiteName());
        holder.email.setText(details.get(position).getEmail());
        holder.password.setText(details.get(position).getPassword());

    }

    @Override
    public int getItemCount() {
        return details.size();
    }

    public void setDetails(ArrayList<AccountPassword> details) {
        this.details = details;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private CardView parent;
        private TextView website;
        private TextView email;
        private TextView password;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.parent);
            website = itemView.findViewById(R.id.txtWebsiteView);
            email = itemView.findViewById(R.id.txtEmailView);
            password = itemView.findViewById(R.id.txtPasswordView);
        }
    }
}
