package com.example.roomdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomdatabase.Adapter.NoteAdapter
import com.example.roomdatabase.RoomData.Note
import com.example.roomdatabase.RoomData.NoteViewModel
import com.example.roomdatabase.databinding.ActivityMainBinding

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: NoteViewModel
    private lateinit var adapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory(application))[NoteViewModel::class.java]

        val inputData = intent.getSerializableExtra("note") as? Note
        Log.d("meeet",inputData.toString())
        if (inputData != null) {
            viewModel.insertNote(inputData)
        }

        val editedData = intent.getSerializableExtra("editedData") as? Note
        if (editedData != null) {
            val id = editedData.id
            val title = editedData.name
            val contact = editedData.contact
            viewModel.updateNote(id!!, title, contact)
        }

        binding.recView.setHasFixedSize(true)
        adapter = NoteAdapter(this)
        binding.recView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.recView.adapter = adapter

        viewModel.getAllNotes.observe(this) { list ->
            adapter.setData(list)
        }

    }

    fun addBTN(view: View) {
        startActivity(Intent(this,AddData::class.java))
    }

    fun deleteBTN(view: View) {
        viewModel.getAllNotes.observe(this) { list ->
            list?.let { viewModel.deleteNote(list.map { it.id }) }
        }
    }
}