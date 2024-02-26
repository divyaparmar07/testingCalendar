package com.example.testingcalendar

import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.widget.DatePicker
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testingcalendar.ui.theme.TestingCalendarTheme
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            TestingCalendarTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                Calender1(this@MainActivity)
//                MaterialUiCalendar()
            }
//                    Greeting("Android")
//                    ShowCalender(this)
        }

    }
}

@Composable
fun ShowCalender(context: Context) {

    val mYear: Int
    val mMonth: Int
    val mDay: Int

    //initialize a calender
    val calendar = Calendar.getInstance()

    //fetch data of current data, month and year
    mYear = calendar.get(Calendar.YEAR)
    mMonth = calendar.get(Calendar.MONTH)
    mDay = calendar.get(Calendar.DAY_OF_MONTH)

    val mDate = remember { mutableStateOf("") }

    val datePickerDialog =
        DatePickerDialog(
            context,
            { _: DatePicker, year: Int, month: Int, day: Int ->
                mDate.value = "$day/${month + 1}/$year"
            }, mYear, mMonth, mDay
        )

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {

        Text(
            text = mDate.value,
            modifier = Modifier.padding(10.dp),
            fontSize = 22.sp,
        )
        OutlinedButton(onClick = { datePickerDialog.show() }) {
            Text(text = "Open Calendar")
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MaterialUiCalendar() {

    val calendar = Calendar.getInstance()
    calendar.set(1990, 0, 22)

    val datePickerState = rememberDatePickerState(initialSelectedDateMillis = calendar.timeInMillis)

    DatePicker(state = datePickerState)

    val formatter = SimpleDateFormat("dd MMMM yyyy", Locale.ROOT)
    Text(
        text = "Selected date: ${formatter.format(Date(datePickerState.selectedDateMillis!!))}"
    )

}

@Composable
fun Calender1(context: Context) {

    val mYear: Int
    val mMonth: Int
    val mDay: Int

    //initialize a calender
    val calendar = Calendar.getInstance()

    //fetch data of current data, month and year
    mYear = calendar.get(Calendar.YEAR)
    mMonth = calendar.get(Calendar.MONTH)
    mDay = calendar.get(Calendar.DAY_OF_MONTH)

    calendar.time = Date()

    val mDate = remember { mutableStateOf("") }

    val datePickerDialog =
        DatePickerDialog(
            context,
            { _: DatePicker, year: Int, month: Int, day: Int ->
                mDate.value = "$day/$month/$year"
            }, mYear, mMonth, mDay
        )

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {

        Text(
            text = "$mDate",
            modifier = Modifier.padding(10.dp),
            fontSize = 22.sp,

            )
        OutlinedButton(onClick = { datePickerDialog.show() }) {
            Text(text = "Open Calendar")
        }
    }

}
