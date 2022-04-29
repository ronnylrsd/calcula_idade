package br.unicap.c3.pwm.idade

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.unicap.c3.pwm.idade.databinding.ActivityMainBinding
import java.text.NumberFormat
import java.util.Calendar
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener{ calculateAge() }
    }

    private fun calculateAge(){
        val dayInTextField = binding.day.text.toString()
        val day = dayInTextField.toIntOrNull()
        if(day == null){
            return
        }

        val monthInTextField = binding.month.text.toString()
        val month = monthInTextField.toIntOrNull()
        if(month == null){
            return
        }

        val yearInTextField = binding.year.text.toString()
        val year = yearInTextField.toIntOrNull()
        if(year == null){
            return
        }

        //Now date
        val c = Calendar.getInstance()
        val nowDay = c.get(Calendar.DAY_OF_MONTH)
        val nowMonth = c.get(Calendar.MONTH)
        val nowYear = c.get(Calendar.YEAR)

        //calculate age
        var age = nowYear - year
        if(nowMonth < month-1){
            age -= 1
        }
        else{
            if(nowDay < day){
                age -= 1
            }
        }
        val formattedAge = age.toString()
        binding.ageResult.text = getString(R.string.age_result, formattedAge)
    }
}