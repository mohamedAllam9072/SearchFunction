package com.example.search;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class adapter extends RecyclerView.Adapter<adapter.mVH> implements Filterable {
    ArrayList<data> list1 ;
    ArrayList<data>list2;

    public adapter(ArrayList<data> list1) {
        this.list1 = list1;
        list2 = new ArrayList<>(list1);
    }

    @NonNull
    @Override
    public mVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item,parent,false);
        mVH mVH = new mVH(view);
        return mVH;
    }

    @Override
    public void onBindViewHolder(@NonNull mVH holder, int position) {
        holder.textView1.setText(list1.get(position).getString1());
        holder.textView2.setText(list1.get(position).getString2());

    }

    @Override
    public int getItemCount() {
        return list1.size();
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }
    private Filter exampleFilter =new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            ArrayList<data> filtered_list = new ArrayList<>();
            if (charSequence ==null || charSequence.length()==0){
                filtered_list.addAll(list2);
            }else {
                String filterPattern =charSequence.toString().toLowerCase().trim();
                for (data data_item :list2 ){
                    if (data_item.getString1().toLowerCase().contains(filterPattern)){
                        filtered_list.add(data_item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values =filtered_list;
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            list1.clear();
            list1.addAll((List)filterResults.values);
            notifyDataSetChanged();
        }
    };

    public class mVH extends RecyclerView.ViewHolder {
        TextView textView1,textView2;
        public mVH(@NonNull View itemView) {
            super(itemView);
            textView1 =itemView.findViewById(R.id.text_view1);
            textView2 =itemView.findViewById(R.id.text_view2);
        }
    }
}
