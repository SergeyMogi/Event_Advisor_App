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
           viewHoledr.price.setText(""+SearchByfilters.resaultUlaml.get(i).getPrice());
            viewHoledr.muzmanim.setText(""+SearchByfilters.resaultUlaml.get(i).getMuzmanim());
            viewHoledr.type.setText(""+SearchByfilters.resaultUlaml.get(i).getType());
            viewHoledr.image.setImageResource(SearchByfilters.resaultUlaml.get(i).getImage());
         //   viewHoledr.city.setText(SearchByfilters.ulamArrayList.get(i).getCity());
        }



        @Override
        public int getItemCount() {
            return SearchByfilters.resaultUlaml.size();
        }

        public  class ViewHoledr extends RecyclerView.ViewHolder {

            public TextView price;
           public TextView muzmanim;
           public TextView type;
           // public TextView city;
             public ImageView image;


            public ViewHoledr(@NonNull View itemView) {
                super(itemView);
                price=itemView.findViewById(R.id.textView_price);
                muzmanim=itemView.findViewById(R.id.textView_muzmanim);
               type=itemView.findViewById(R.id.textView_type);
                image=itemView.findViewById(R.id.image);
               // city=itemView.findViewById(R.id.textView16);
               // city=itemView.findViewById(R.id.image);
            }
        }


}
