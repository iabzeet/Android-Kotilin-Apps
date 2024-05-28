package com.example.fragmentdemo

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment

private const val TAG = "FirstFragment"
class FirstFragment : Fragment(R.layout.fragment_first) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "onCreate FirstFragment")
    }
}