package com.example.ivpractice

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.squareup.picasso.Picasso

private const val IMAGE_URL = "https://pluspng.com/img-png/android-png-android-logo-png-1024.png"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnTwo: View = findViewById(R.id.btnTwo)
        val ivAndroid: ImageView = findViewById(R.id.ivAndroid)

        Picasso.get().load(IMAGE_URL).into(ivAndroid)
        btnTwo.visibility = View.GONE
    }
}