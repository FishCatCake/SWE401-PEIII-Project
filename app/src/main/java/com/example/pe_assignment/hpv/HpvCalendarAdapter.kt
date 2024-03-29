package com.example.pe_assignment.hpv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pe_assignment.R

class HpvCalendarAdapter(private val calendarList : ArrayList<HpvCalendarModel>):RecyclerView.Adapter<HpvCalendarAdapter.HpvViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HpvViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.calendar_item,
            parent,false)
        return HpvViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HpvViewHolder, position: Int) {
        val currentItem = calendarList[position]
        holder.page.text = currentItem.page.toString()
        holder.dose.text = currentItem.dose.toString()
//        holder.calendar.setBackgroundColor(calendarList[position].calendar)
    }

    override fun getItemCount(): Int {
        return calendarList.size
    }
    class HpvViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
        val page = itemView.findViewById<TextView>(R.id.hpv_page)
        val dose = itemView.findViewById<TextView>(R.id.hpv_dose)
//        val calendar = itemView.findViewById<CalendarView>(R.id.hpv_calendarView)
    }
}