
package com.auto.l4z.automobile;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.auto.l4z.automobile.pojo.Car;

import java.util.List;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.MyViewHolder> {

    private List<Car> dataSet;

    public CustomerAdapter(List<Car> items) {
        this.dataSet = items;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewCarId;
        TextView textViewCarName;
        TextView textViewCarPrice;
        TextView textViewCarEngine;
        TextView textViewFuelType;
        TextView textViewProductionDate;


        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewCarName = (TextView) itemView.findViewById(R.id.carNameTextView);
            this.textViewCarPrice = (TextView) itemView.findViewById(R.id.text_view_price);
            this.textViewCarEngine = (TextView) itemView.findViewById(R.id.text_view_engine_mileage_from_server);
            this.textViewFuelType = (TextView) itemView.findViewById(R.id.text_view_engine_type_from_server);
            this.textViewProductionDate = (TextView) itemView.findViewById(R.id.text_view_production_date_from_server);
        }

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cars_list, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int listPosition) {


        TextView textViewCarName = holder.textViewCarName;
        TextView textViewCarPrice = holder.textViewCarPrice;
        TextView textViewCarEngine = holder.textViewCarEngine;
        TextView textViewFuelType = holder.textViewFuelType;
        TextView textViewProductionDate = holder.textViewProductionDate;


        textViewCarName.setText("" + dataSet.get(listPosition).getName());
        textViewCarPrice.setText("" + dataSet.get(listPosition).getPrice());
        textViewCarEngine.setText("" + dataSet.get(listPosition).getEngine());
        textViewFuelType.setText("" + dataSet.get(listPosition).getFuelType());
        textViewProductionDate.setText("" + dataSet.get(listPosition).getProductionDate());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
