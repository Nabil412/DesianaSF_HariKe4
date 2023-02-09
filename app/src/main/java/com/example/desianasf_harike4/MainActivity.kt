package com.example.desianasf_harike4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var bilSatu: EditText
    private lateinit var bilDua: EditText
    private lateinit var kali: Button
    private lateinit var bagi: Button
    private lateinit var tambah: Button
    private lateinit var kurang: Button
    private lateinit var hapus: Button
    private lateinit var simpan: Button
    private lateinit var hasil: TextView
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bilSatu = findViewById(R.id.etBil1)
        bilDua = findViewById(R.id.etBil2)
        kali = findViewById(R.id.btKali)
        bagi = findViewById(R.id.btBagi)
        tambah = findViewById(R.id.btTambah)
        kurang = findViewById(R.id.btKurang)
        hasil = findViewById(R.id.tvHasil)
        hapus = findViewById(R.id.btHapus)
        simpan = findViewById(R.id.btSimpan)
        recyclerView = findViewById(R.id.listData)

        val data = mutableListOf<DataMtk>()
        viewManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerAdapter = AdapterMatematika(data)
        recyclerView.adapter = recyclerAdapter
        recyclerView.layoutManager = viewManager

        kali.setOnClickListener { kali () }
        bagi.setOnClickListener { bagi () }
        tambah.setOnClickListener { plus () }
        kurang.setOnClickListener { kurang () }
        hapus.setOnClickListener { delete() }

        simpan.setOnClickListener {
            val satu = bilSatu.text.toString()
            val dua = bilDua.text.toString()
            val hasil = hasil.text.toString()

            val dataMTK = DataMtk(satu, dua, hasil)
            data.add(dataMTK)
            recyclerAdapter.notifyDataSetChanged()
        }
    }
    fun plus(){
        val hitung = bilSatu.text.toString().toDouble() + bilDua.text.toString().toDouble()
        hasil.text = hitung.toString()
    }
    fun kurang(){
        val hitung = bilSatu.text.toString().toDouble() - bilDua.text.toString().toDouble()
        hasil.text = hitung.toString()
    }
    fun bagi(){
        val hitung = bilSatu.text.toString().toDouble() / bilDua.text.toString().toDouble()
        hasil.text = hitung.toString()
    }
    fun kali(){
        val hitung = bilSatu.text.toString().toDouble() * bilDua.text.toString().toDouble()
        hasil.text = hitung.toString()
    }
    fun delete(){
        hasil.text= 0.toString()
        bilSatu.text.clear()
        bilDua.text.clear()
    }
}