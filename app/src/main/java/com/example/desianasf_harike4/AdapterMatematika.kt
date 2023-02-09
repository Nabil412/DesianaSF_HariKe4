package com.example.desianasf_harike4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterMatematika (private val dataSet: MutableList<DataMtk>):
        RecyclerView.Adapter<AdapterMatematika.MatematikHolder>(){
            class MatematikHolder(view: View) : RecyclerView.ViewHolder(view){
                val Bilangan1 = view.findViewById<TextView>(R.id.tvBil1)
                val Bilangan2 = view.findViewById<TextView>(R.id.tvBil2)
                val textHasil = view.findViewById<TextView>(R.id.txtHasil)
                val hapus = view.findViewById<ImageView>(R.id.ivHps)
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatematikHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.activity_adapter_matematika,parent,false
        )
        return MatematikHolder(view)
    }

    override fun onBindViewHolder(holder: MatematikHolder, position: Int) {
        val data = dataSet[position]
        holder.Bilangan1.text = dataSet[position].bilSatu
        holder.Bilangan2.text = dataSet[position].bilDua
        holder.textHasil.text = dataSet[position].hasil
        holder.hapus.setOnClickListener {
            dataSet.removeAt(position)
            notifyItemRangeRemoved(position,dataSet.size)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}