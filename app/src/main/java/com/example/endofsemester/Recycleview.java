package com.example.endofsemester;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;




    public class Recycleview extends android.support.v7.widget.RecyclerView.Adapter<Recycleview.ViewHoledr>
    {


        @NonNull
        @Override
        public ViewHoledr onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler,viewGroup,false);

            return new ViewHoledr(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHoledr viewHoledr, int i) {
//            viewHoledr.id.setText(SearchByfilters.ulamArrayList.get(i).getCity());

        }



        @Override
        public int getItemCount() {
            return SearchByfilters.resaultUlaml.size();
        }

        public  class ViewHoledr extends RecyclerView.ViewHolder {
            public TextView id;
            public TextView name;
            public TextView name1;
            public TextView name2;
            public ImageView image;
            // public ImageView image;


            public ViewHoledr(@NonNull View itemView) {
                super(itemView);
                id=itemView.findViewById(R.id.textView11);
                name=itemView.findViewById(R.id.textView12);
                name1=itemView.findViewById(R.id.textView13);
                name2=itemView.findViewById(R.id.textView16);
                image=itemView.findViewById(R.id.image);
            }
        }


}
