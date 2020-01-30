package com.example.rates

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rates.view.RateListAdapter
import com.example.rates.view_model.ViewModelMain
import java.util.concurrent.TimeUnit
import kotlin.concurrent.fixedRateTimer

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private val adapter = RateListAdapter(arrayListOf())

    private val viewModel: ViewModelMain by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rv_rate_list)
        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = adapter

        viewModel.currencyList.observe(this, Observer {
            adapter.updateRates(it)
        })


        fixedRateTimer("timer", false, 0, TimeUnit.SECONDS.toMillis(1)) {
            viewModel.updateCurrency(adapter.getCurrentBase() ?: "EUR")
        }
    }

}
