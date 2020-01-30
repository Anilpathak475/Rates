package com.example.rates

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rates.adapter.RateListAdapter
import com.example.rates.view_model.ViewModelMain
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.concurrent.fixedRateTimer

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private val adapter = RateListAdapter(arrayListOf())

    private val viewModel: ViewModelMain by viewModels()

    private lateinit var timer: Timer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rv_rate_list)
        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = adapter

        var alreadyObserved = false
        viewModel.currencyList.observe(this, Observer {
            if(!alreadyObserved) {
                alreadyObserved = true
                progress_bar.visibility = View.GONE
            }
            adapter.updateRates(it)
        })


        adapter.registerAdapterDataObserver(object : RecyclerView.AdapterDataObserver() {
            override fun onItemRangeMoved(fromPosition: Int, toPosition: Int, itemCount: Int) {
                super.onItemRangeMoved(fromPosition, toPosition, itemCount)
                recyclerView.scrollToPosition(0)
            }
        })

        timer = fixedRateTimer("timer", false, 0, TimeUnit.SECONDS.toMillis(1)) {
            viewModel.getNewRates(adapter.getCurrentBase() ?: "EUR")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        timer.cancel()
    }

}
