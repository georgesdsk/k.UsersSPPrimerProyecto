package com.example.usersspprimerproyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.BoringLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.usersspprimerproyecto.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var userAdapter: UserAdapter
    private lateinit var lineaLayoutManager: RecyclerView.LayoutManager
    private lateinit var binding: ActivityMainBinding // se declara el binding hacia la futura vista

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)// se infla el binding
        setContentView(binding.root) // y se asigna al binding hacia esta ACTIVIDAD

        userAdapter = UserAdapter(mutableListOf()) // inicializacion de un listado, esta vacio
        lineaLayoutManager = LinearLayoutManager(this)

        binding.recyclerView.apply {
            layoutManager = lineaLayoutManager // el layout
            adapter = userAdapter // el adaptador
        }

    }

    private fun getUsers(): MutableList<User>{
        val users: MutableList<User>()

    }

}