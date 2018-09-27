package com.example.ttl1.mvvmanddatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.ttl1.mvvmanddatabinding.databinding.ActivityDataBindingBinding



class DataBindingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_binding)

        val mainViewModel = ViewModelProviders.of(this)
                .get(MainViewModel::class.java)

        DataBindingUtil.setContentView<ActivityDataBindingBinding>(
                this, R.layout.activity_data_binding
        ).apply {
            this.setLifecycleOwner(this@DataBindingActivity)
            this.viewmodel = mainViewModel
        }

        mainViewModel.editTextContent.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
    }
}
