package com.codekul.recyclerview;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class VersionAdapter extends RecyclerView.Adapter<VersionAdapter.VersionHolder> {

    private Context context;
    private List<AndroidVersion> list;
    private AlertDialog.Builder builder;
    private Activity activity;

    public VersionAdapter(Context context, List<AndroidVersion> list, Activity activity) {
        this.context = context;
        this.list = list;
        this.activity=activity;
    }

    @NonNull
    @Override
    public VersionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view=LayoutInflater.from(context)
               .inflate(R.layout.single_card,parent,false);
       return new VersionHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final VersionHolder holder, final int position) {

        holder.getName().setText(list.get(position).getName());
        holder.getImage().setImageResource(list.get(position).getImage());



        holder.getName().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder=new AlertDialog.Builder(context);
                builder.setCancelable(false);
                builder.setTitle("Logout");
                builder.setMessage("Are you sure?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        activity.finish();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog alertDialog=builder.create();
               // alertDialog.show();
                showDialog();
              /*  Toast.makeText(context, "position : "+position+
                        " Name : "+list.get(position).getName(),
                        Toast.LENGTH_SHORT).show();*/
                /*Snackbar snackbar = Snackbar
                        .make(holder.getLayout(), "position : "+position+
                                " Name : "+list.get(position).getName(),
                                Snackbar.LENGTH_LONG);

                snackbar.show();*/
            }
        });


    }

    private void showDialog(){
        final Dialog dialog=new Dialog(context);
        dialog.setContentView(R.layout.dialog_logout);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
        Button btnYes=dialog.findViewById(R.id.btnYes);
        Button btnNo=dialog.findViewById(R.id.btnNo);
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
            }
        });
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class VersionHolder extends RecyclerView.ViewHolder{

        public VersionHolder(@NonNull View itemView) {
            super(itemView);
        }


        TextView getName(){
            return itemView.findViewById(R.id.textView);
        }

        ImageView getImage(){
            return itemView.findViewById(R.id.imageView);
        }

        ConstraintLayout getLayout(){
            return itemView.findViewById(R.id.singleCardConstraint);
        }

    }

}
