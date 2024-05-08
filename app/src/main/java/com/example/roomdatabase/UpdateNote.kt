package com.example.roomdatabase

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.roomdatabase.RoomData.Note
import com.example.roomdatabase.databinding.ActivityUpdateNoteBinding

class UpdateNote : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateNoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityUpdateNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val getData = intent.getSerializableExtra("editData") as Note

        binding.name.setText(getData.name)
        binding.number.setText(getData.contact)

        binding.editBTN.setOnClickListener() {
            val id = getData.id
            val name = binding.name.text.toString()
            val number = binding.number.text.toString()
            val data = Note(id, name, number)

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("editedData", data)
            startActivity(intent)
        }

    }
}