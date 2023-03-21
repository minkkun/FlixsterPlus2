package com.example.flixsterplus2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide


class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        val actorImage = findViewById<ImageView>(R.id.actorImageIV)
        val posterImage = findViewById<ImageView>(R.id.posterImageIV)
        val actorName = findViewById<TextView>(R.id.nameOfActorTV)
        val movieTitle = findViewById<TextView>(R.id.movieNameTV)
        val overView = findViewById<TextView>(R.id.overViewTV)


        val ActorName = intent.getStringExtra("ActorName")
        actorName.text = ActorName

        val profilePath = intent.getStringExtra("actorImagePath")
        Glide.with(this).load(profilePath).into(actorImage)

        val originalTitle = intent.getStringExtra("movieTitle")
        if (originalTitle != null) {
            movieTitle.text = originalTitle
        } else {
            val status = "no movie title"
            movieTitle.text = status
        }

        val description = intent.getStringExtra("OverView")
        overView.text = description


        val moviePosterPath = intent.getStringExtra("PosterPath")
        Glide.with(this).load(moviePosterPath).into(posterImage)

        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }
}