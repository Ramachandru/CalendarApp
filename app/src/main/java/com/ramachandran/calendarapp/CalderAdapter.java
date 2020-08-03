package com.ramachandran.calendarapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.ramachandran.calendarapp.databinding.CalderviewBinding;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalderAdapter extends RecyclerView.Adapter<CalderAdapter.CalendarViewHolder> {
    private CalderviewBinding calderviewBinding;
    private int DAYS_IN_YEAR=365;
    @NonNull
    @Override
    public CalendarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =LayoutInflater.from(parent.getContext());
        calderviewBinding = DataBindingUtil.inflate(layoutInflater,R.layout.calderview,parent,false);

        return new CalendarViewHolder(calderviewBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CalendarViewHolder holder, int position) {
       Date dateOfValue = getStartDate(position);
        DateFormat dateInstance = SimpleDateFormat.getDateInstance();
        holder.setDays(dateOfValue.toString(),dateInstance.format(dateOfValue.getTime()));
    }

    @Override
    public int getItemCount() {
        return DAYS_IN_YEAR;
    }
    class CalendarViewHolder extends RecyclerView.ViewHolder {
        CalderviewBinding calderBinding;
        public CalendarViewHolder(@NonNull CalderviewBinding itemView) {
            super(itemView.getRoot());
            calderBinding= itemView;
        }
        public void setDays(String day,String date){
            calderBinding.setDateInstance(day);
            calderBinding.setDate(date);
            calderBinding.executePendingBindings();
        }
    }
    private Date getStartDate(int dayCount) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getCalanderDate());
        cal.add(Calendar.DATE, dayCount);
        return cal.getTime();
    }
    private Date getCalanderDate(){
        Date date=new Date(new Date().getTime());
        return date;
    }
}
