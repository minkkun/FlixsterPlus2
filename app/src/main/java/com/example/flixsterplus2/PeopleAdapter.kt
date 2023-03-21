package com.example.flixsterplus2

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PeopleAdapter(private val ListOfPeople: List<Person>) :
    RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder>() {

    inner class PeopleViewHolder(val pView: View) : RecyclerView.ViewHolder(pView) {
        val nameTextView = pView.findViewById<TextView>(R.id.nameTV)
        val personImage = pView.findViewById<ImageView>(R.id.personImageIV)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        //inflate the custom layout
        val personView = inflater.inflate(R.layout.people_layout, parent, false)
        return PeopleViewHolder(personView)
    }

    // Involves populating data into the item through holder
    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        // Get the data model based on position
        val individualPosition: Person = ListOfPeople[position]
        // Set item views based on your views and data model
        val textView = holder.nameTextView
        textView.text = individualPosition.name

        val restOfUrlForImage = "https://image.tmdb.org/t/p/w500/"
        val actorImagePath = restOfUrlForImage.plus(individualPosition.profilePath)
        val posterPath = restOfUrlForImage.plus(individualPosition.posterPath)

        val overView = individualPosition.overview
        if (overView != null) {
            Log.e("HH", overView.toString())
        } else {
            Log.e("HH", "overview is null")
        }

        Glide.with(holder.pView).load(actorImagePath)
            .into(holder.personImage)

        holder.personImage.setOnClickListener { v ->
            val intent = Intent(holder.personImage.context, DetailActivity::class.java)
            intent.putExtra("ActorName", individualPosition.name)
            intent.putExtra("actorImagePath", actorImagePath)
            intent.putExtra("movieTitle", individualPosition.originalTitle)
            intent.putExtra("OverView", individualPosition.overview)
            intent.putExtra("PosterPath", posterPath)
            holder.personImage.context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return ListOfPeople.size
    }
}