package com.planetearthsolution.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {
    private List<Person> mPeopleList;
    private Context mContext;
    private RecyclerView mRecyclerV;


    public void add(int position, Person person) {
        mPeopleList.add(position, person);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        mPeopleList.remove(position);
        notifyItemRemoved(position);
    }

    public PersonAdapter(List<Person> myDataset, Context context, RecyclerView recyclerView) {
        mPeopleList = myDataset;
        mContext = context;
        mRecyclerV = recyclerView;
    }

    @NonNull
    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =inflater.inflate(R.layout.rv_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.ViewHolder holder, final int position) {
        final Person person = mPeopleList.get(position);
        holder.personNameTxtV.setText(person.getFirst_name());
        holder.personGender.setText(person.getGender());
        holder.personAddress.setText(person.getPermanent_address());
        holder.personPhoneNumber.setText(person.getPh_no());

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setTitle("Choose option");
                builder.setMessage("Update or delete user?");
                builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        //go to update activity
                        Toast.makeText(mContext, "Update", Toast.LENGTH_SHORT).show();

                    }
                });
                builder.setNeutralButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        PersonDBHelper dbHelper = new PersonDBHelper(mContext);
                        dbHelper.deletePersonRecord(person.getId(), mContext);
                        mPeopleList.remove(position);
                        mRecyclerV.removeViewAt(position);
                        notifyItemRemoved(position);
                        notifyItemRangeChanged(position, mPeopleList.size());
                        notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create().show();
            }
        });



    }

    @Override
    public int getItemCount() {
        return mPeopleList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView personNameTxtV;
        public TextView personGender;
        public TextView personAddress;
        public TextView personPhoneNumber;
        public View layout;

        public ViewHolder(View itemView) {
            super(itemView);
            layout = itemView;
            personNameTxtV = itemView.findViewById(R.id.nameTv);
            personGender = itemView.findViewById(R.id.genderTv);
            personAddress = itemView.findViewById(R.id.permanentAddressTv);
            personPhoneNumber = itemView.findViewById(R.id.phoneTv);

        }
    }
}
