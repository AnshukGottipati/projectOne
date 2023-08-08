package com.example.projectone;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class passwordRecyclerViewAdapter extends RecyclerView.Adapter<passwordRecyclerViewAdapter.MyViewHolder> {
    private static final String TAG = "passwordRecyclerViewAdapter";
    private Context context;
    private Activity activity;
    private List<AccountPassword> details;
    private List<AccountPassword> detailsFull;

    private ArrayList<String> id,website,email,password;

    /**
    public passwordRecyclerViewAdapter(List<AccountPassword> details,Context context){
        this.details = details;
        this.detailsFull = new ArrayList<>(details);
        this.context = context;



    }
    **/
    public passwordRecyclerViewAdapter(ArrayList id,ArrayList website,ArrayList email,ArrayList password,Context context,Activity activity){

        this.activity = activity;
        this.context = context;
        this.id = id;
        this.website = website;
        this.email= email;
        this.password= password;


    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item_details, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,final int position) {

        holder.website_txt.setText(String.valueOf(website.get(position)));
        holder.email_txt.setText(String.valueOf(email.get(position)));
        holder.password_txt.setText(String.valueOf(password.get(position)));

    /**
        holder.website.setText(details.get(position).getWebsiteName());
        holder.email.setText(details.get(position).getEmail());
        holder.password.setText(details.get(position).getPassword());
     **/

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, account.class);
                String i = Integer.toString(holder.getAdapterPosition());
                intent.putExtra("id",String.valueOf(id.get(position)));
                intent.putExtra("website",String.valueOf(website.get(holder.getAdapterPosition())));
                intent.putExtra("email",String.valueOf(email.get(holder.getAdapterPosition())));
                intent.putExtra("password",String.valueOf(password.get(holder.getAdapterPosition())));
                activity.startActivityForResult(intent,1);
            }
        });


    }

    @Override
    public int getItemCount() {
        //return details.size();
        return website.size();
    }




    public class MyViewHolder extends RecyclerView.ViewHolder{
        private CardView parent;
        private TextView website_txt;
        private TextView email_txt;
        private TextView password_txt;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.parent);
            website_txt =  itemView.findViewById(R.id.txtWebsiteView);
            email_txt = itemView.findViewById(R.id.txtEmailView);
            password_txt = itemView.findViewById(R.id.txtPasswordView);
        }
    }

}
