package com.shinayser.sample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import com.shinayser.ac.utils.livedata.*
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

		val data = DefaultLiveData<Int>()
		data(10) //direct access via invoke function

		val intValue = data() //direct access via invoke function

	}

}

class TestViewModel : ViewModel() {

	var id = IntLiveData(10)
	var timer = Timer()

	init {

		timer.schedule(timerTask {

			Handler(Looper.getMainLooper()).post {
				id.setValueTo { (Math.random() * 100).toInt() }
			}

		}, 500, 500)

	}

	override fun onCleared() {
		super.onCleared()

		timer.cancel()
	}
}