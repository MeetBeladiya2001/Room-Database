package com.example.roomdatabase

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.roomdatabase.RoomData.Note
import com.example.roomdatabase.databinding.ActivityAddDataBinding

class AddData : AppCompatActivity() {
    private lateinit var binding: ActivityAddDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAddDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.addBTN.setOnClickListener {
            val name = binding.name.text.toString()
            val number = binding.number.text.toString()
            val data = Note(null,name,number)
            Log.d("meeet2",data.toString())

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("note",data)
            startActivity(intent)
        }
    }
}