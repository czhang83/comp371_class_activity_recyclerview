package com.example.classactivity3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ViewHolder>{
    private List<Forecast> forecasts;

    //pass this list into the constructor of the adapter
    public ForecastAdapter(List<Forecast> forecasts){
        this.forecasts = forecasts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        // inflate the customer layout
        View forcastView = inflater.inflate(R.layout.item_forecast, parent, false);
        //return a new ViewHolder
        return new ViewHolder(forcastView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // populate data into the item through holder
        Forecast forecast = forecasts.get(position);

        holder.textView_date.setText(forecast.getDate());
        holder.textView_time.setText(forecast.getTime());
        holder.textView_description.setText(forecast.getDescription());
        holder.textView_feelslike_temp.setText(forecast.getFeelsLikeTemp());
    }

    @Override
    public int getItemCount() {
        // return the total number of items in the list
        return forecasts.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView_date;
        TextView textView_time;
        TextView textView_description;
        TextView textView_feelslike_temp;

        public ViewHolder(View itemView){
            super(itemView);
            textView_date = itemView.findViewById(R.id.textView_date);
            textView_time = itemView.findViewById(R.id.textView_time);
            textView_description = itemView.findViewById(R.id.textView_description);
            textView_feelslike_temp = itemView.findViewById(R.id.textView_feelslike_temp);
        }

    }

}
