package com.example.rvpractice

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

data class Person(val name: String, val age: Int)

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "onCreate")
        setContentView(R.layout.activity_main)
        // Step 3: Initialize RecyclerView
        val rvContacts: RecyclerView = findViewById(R.id.rvContacts)

        //6 STEPS OF IMPLEMENTING RecyclerView
        //1. Add RecyclerView Androidx Library to the Gradle build file  -- DONE
        //2. Define a model class to use as the data source     -- DONE
        val contacts = createContacts()                         //data source
        //3. Add a RecyclerView to your activity to display the items -- DONE

        //4. Create a custom row layout XML file to visualize the item -- DONE

        //5. Create a RecyclerView.Adapter and ViewHolder to render the item
        rvContacts.adapter = ContactsAdapter(this, contacts)
        //6. Bind the adapter to the data source to populate the RecyclerView
        //add layout manager into RecyclerView
        rvContacts.layoutManager = LinearLayoutManager(this)
    }

    override fun onStart() {
        Log.i(TAG, "onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.i(TAG, "onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.i(TAG, "onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.i(TAG, "onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.i(TAG, "onDestroy")
        super.onDestroy()
    }

        private fun createContacts(): List<Person> {
            val contacts = mutableListOf<Person>()
            for (i in 1..100) {
                contacts.add(Person("Person $i", i))
            }
            return contacts
        }
    }