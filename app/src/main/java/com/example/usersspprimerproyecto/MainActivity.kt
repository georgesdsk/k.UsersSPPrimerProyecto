package com.example.usersspprimerproyecto

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.BoringLayout
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.usersspprimerproyecto.databinding.ActivityMainBinding


/*

Para agregar las fotos hay que añadir la dependencia al
 */

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var userAdapter: UserAdapter
    private lateinit var lineaLayoutManager: RecyclerView.LayoutManager
    private lateinit var binding: ActivityMainBinding // se declara el binding hacia la futura vista

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)// se infla el binding
        setContentView(binding.root) // y se asigna al binding hacia esta ACTIVIDAD

        userAdapter = UserAdapter(rellenarLista(),this) // inicializacion de un listado, esta vacio
        lineaLayoutManager = LinearLayoutManager(this)

        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = lineaLayoutManager // el layout
            adapter = userAdapter // el adaptador
        }

        //almacenamiento

        val preferences = getPreferences(Context.MODE_PRIVATE)
        val isFirstTime = preferences.getBoolean(getString(R.string.sp_first_time), true)// por si no encuentra ningun valor, que devuelva true
        Log.i("SP", "${getString(R.string.sp_first_time)} = $isFirstTime")

    }

 private fun rellenarLista() : MutableList<User>{

     var users = mutableListOf<User>() // hay que ponerle el contructor por defecto

     val alain = User(1, "Alain", "Nicolás", "https://frogames.es/wp-content/uploads/2020/09/alain-1.jpg")
     val samanta = User(2, "Samanta", "Meza", "https://upload.wikimedia.org/wikipedia/commons/b/b2/Samanta_villar.jpg")
     val javier = User(3, "Javier", "Gómez", "https://live.staticflickr.com/974/42098804942_b9ce35b1c8_b.jpg")
     val emma = User(4, "Emma", "Cruz", "https://upload.wikimedia.org/wikipedia/commons/d/d9/Emma_Wortelboer_%282018%29.jpg")

     users.add(alain)
     users.add(samanta)
     users.add(javier)
     users.add(emma)
     users.add(alain)
     users.add(samanta)
     users.add(javier)
     users.add(emma)
     users.add(alain)
     users.add(samanta)
     users.add(javier)
     users.add(emma)
     users.add(alain)
     users.add(samanta)
     users.add(javier)
     users.add(emma)

    return users
 }
    ///Extiende del clickListener, por lo que tiene que implementar este codigo
    override fun onClick(user: User, position: Int) {
        Toast.makeText(this,"$position: ${user.name}" ,Toast.LENGTH_SHORT).show()
    }


}