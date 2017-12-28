package com.shinayser.sample

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.shinayser.ac.utils.livedata.IntLiveData
import com.shinayser.ac.utils.livedata.observe
import com.shinayser.ac.utils.viewmodel.modify
import com.shinayser.ac.utils.viewmodel.setValueTo
import java.util.*
import kotlin.concurrent.timerTask

class MainActivity : AppCompatActivity() {

    private lateinit var testViewModel: TestViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testViewModel = ViewModelProviders.of(this).get(TestViewModel::class.java)

        testViewModel.id.observe(this) {
            (findViewById<TextView>(R.id.textView)).text = "The current value is: $it"
        }

    }

}

class TestViewModel : ViewModel() {

    var id = IntLiveData(10)
    var timer = Timer()

    init {

        timer.schedule(timerTask {

            Handler(Looper.getMainLooper()).post {
                id.setValueTo{ (Math.random() * 100).toInt() }
            }

        }, 500, 500)

    }

    override fun onCleared() {
        super.onCleared()

        timer.cancel()
    }
}