package com.example.roomdatabase.Adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase.RoomData.Note
import com.example.roomdatabase.UpdateNote
import com.example.roomdatabase.databinding.NoteAdapterBinding

class NoteAdapter(private val context: Context): RecyclerView.Adapter<NoteAdapter.ViewHolder>() {
    val data = ArrayList<Note>()

    class ViewHolder(val binding: NoteAdapterBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(NoteAdapterBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = data[position]
        holder.binding.name.text = data.name
        holder.binding.number.text = data.contact

        holder.binding.container.setOnClickListener() {
            Log.d("meet",data.toString())
            val intent = Intent(context, UpdateNote::class.java)
            intent.putExtra("editData", data)
            context.startActivity(intent)
        }
    }

    fun setData(data2: List<Note>){
        data.clear()
        data.addAll(data2)
        notifyDataSetChanged()
    }
}