package com.example.usersspprimerproyecto

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.usersspprimerproyecto.databinding.ItemUserBinding

class UserAdapter(private val users: List<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    private lateinit var context: Context /*la varibla se va a inicializar despues*/



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false)

        return ViewHolder(view) // se devuelve el viewHolder con el binding hacia la vista del ITEM
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = users.get(position)

        with(holder){ // se va a alimentar cada propiedad de la vista con los datos de cada user
            binding.tvOrder.text = (position + 1).toString()
            binding.tvName.text = user.name
            Glide.with(context)
                .load(user.url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .circleCrop()
                .into(binding.imageView)
        }
    }



    override fun getItemCount(): Int = users.size



    // definicion de la clase
    inner class ViewHolder(view : View ): RecyclerView.ViewHolder(view){
        val binding = ItemUserBinding.bind(view) // no entiendo que es el itemUser
    }

}