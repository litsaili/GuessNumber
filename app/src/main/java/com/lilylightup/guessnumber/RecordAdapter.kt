package com.lilylightup.guessnumber

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lilylightup.guessnumber.data.Record
import kotlinx.android.synthetic.main.activity_record.view.*
import kotlinx.android.synthetic.main.row_record.view.*

class RecordAdapter(var records : List<Record>):RecyclerView.Adapter<RecordViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecordViewHolder {
        return RecordViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.row_record,parent,false))
    }

    override fun getItemCount(): Int {
        return records.size
    }

    override fun onBindViewHolder(holder: RecordViewHolder, position: Int) {
        holder.nicktext.text=records.get(position).nickname
        holder.countertext.text=records.get(position).counter.toString()
    }

}

class RecordViewHolder(view :View) : RecyclerView.ViewHolder(view){
    var nicktext = view.record_nickname
    var countertext =view.record_counter
}