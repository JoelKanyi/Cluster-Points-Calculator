package com.example.clusterpointscalculator

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import kotlin.math.sqrt

class HomeFragment : Fragment(){

    val TAG = "HomeFragment"
    private lateinit var selected:String
    private lateinit var gradeSelected1:String
    private lateinit var gradeSelected2:String
    private lateinit var gradeSelected3:String
    private lateinit var gradeSelected4:String
    private lateinit var calculateC: Button
    private lateinit var resultC: TextView
    private lateinit var subject1:TextView
    private lateinit var subject2:TextView
    private lateinit var subject3:TextView
    private lateinit var subject4:TextView
    private lateinit var totalPoint: EditText

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        Log.d(TAG,"onCreateView")
        //!! means the inflater should not be null
        val view: View = inflater.inflate(R.layout.home_fragment,container,false)

        calculateC = view.findViewById(R.id.calculate)
        resultC = view.findViewById(R.id.result)
        subject1 = view.findViewById(R.id.subject1)
        subject2 = view.findViewById(R.id.subject2)
        subject3 = view.findViewById(R.id.subject3)
        subject4 = view.findViewById(R.id.subject4)
        totalPoint = view.findViewById(R.id.editText5)
        val spinner1 = view.findViewById<Spinner>(R.id.spinner)

        val options = arrayOf("Cluster 1","Cluster 2","Cluster 3","Cluster 4",
            "Cluster 5","Cluster 6","Cluster 7","Cluster 8","Cluster 9","Cluster 10","Cluster 11",
            "Cluster 12","Cluster 13","Cluster 14","Cluster 15","Cluster 16","Cluster 17","Cluster 18",
            "Cluster 19","Cluster 20","Cluster 21","Cluster 22")

        val grades = arrayOf("A","A-","B+","B","B-","C+","C","C-","D+","D","D-","E")


        //parameters for the adapter - the context,my custom layout and the array of options
        spinner1?.adapter = ArrayAdapter(activity?.applicationContext!!,R.layout.spinner_row,options)
        spinner1?.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                selected = parent?.getItemAtPosition(position).toString()

                when(selected){
                    "Cluster 1" -> {
                        subject1.text = "ENG/KIS"
                        subject2.text = "MAT A/MATB/ANY GROUP II"
                        subject3.text = "ANY GROUP III"
                        subject4.text = "ANY GROUP II/2nd GROUP III/ANY GROUP IV/ANY GROUP V"}

                    "Cluster 2" -> {
                        subject1.text = "ENG/KIS"
                        subject2.text = "MAT A/MAT B"
                        subject3.text = "any GROUP II or any GROUP III"
                        subject4.text = "a GROUP II or a GROUP III or any GROUP IV or any GROUP V"}

                    "Cluster 3" -> {
                        subject1.text = "ENG/KIS"
                        subject2.text = "MAT A/MATB/ANY GROUP II"
                        subject3.text = "ANY GROUP III"
                        subject4.text = "ANY GROUP II/2nd GROUP III/ANY GROUP IV/ANY GROUP V"}

                    "Cluster 4" -> {
                        subject1.text = "MAT A"
                        subject2.text = "PHY"
                        subject3.text = "BIO or CHE or GEO"
                        subject4.text = "a GROUP II or any GROUP III or any GROUP IV or any GROUP V"}

                    "Cluster 5" -> {
                        subject1.text = "ENG/KIS"
                        subject2.text = "BIO or GSC"
                        subject3.text = "any GROUP III"
                        subject4.text = "MAT A / MAT B or 2nd GROUP II or 2nd GROUP III or any GROUP IV or any GROUP V"}

                    "Cluster 6" -> {
                        subject1.text = "KIS"
                        subject2.text = "ENG or MAT A / MAT B or any GROUP II"
                        subject3.text = "any GROUP III"
                        subject4.text = "any GROUP II or 2nd GROUP III or any GROUP IV or any GROUP V"}

                    "Cluster 7" -> {
                        subject1.text = "MAT A"
                        subject2.text = "PHY"
                        subject3.text = "CHE"
                        subject4.text = "BIO or any GROUP III or any GROUP IV or any GROUP V"}

                    "Cluster 8" -> {
                        subject1.text = "MAT A"
                        subject2.text = "PHY"
                        subject3.text = "any GROUP III"
                        subject4.text = "2nd GROUP II or 2nd GROUP III or any GROUP IV or any GROUP V"}

                    "Cluster 9" -> {
                        subject1.text = "mat a"
                        subject2.text = "PHY"
                        subject3.text = "2nd GROUP II or any GROUP III"
                        subject4.text = "a GROUP II or a GROUP III or any GROUP IV or any GROUP V"}

                    "Cluster 10" -> {
                        subject1.text = "MAT A"
                        subject2.text = "BIO"
                        subject3.text = "PHY or CHEM"
                        subject4.text = "3rd GROUP II or any GROUP III or any GROUP IV or any GROUP V"}

                    "Cluster 11" -> {
                        subject1.text = "MAT A"
                        subject2.text = "any GROUP II"
                        subject3.text = "2nd GROUP II"
                        subject4.text = "3rd GROUP II or any GROUP III or any GROUP IV or any GROUP V"}

                    "Cluster 12" -> {
                        subject1.text = "MAT A"
                        subject2.text = "any GROUP II"
                        subject3.text = "any GROUP III"
                        subject4.text = "2nd GROUP II or 2nd GROUP III or a GROUP IV or any GROUP V"}

                    "Cluster 13" -> {
                        subject1.text = "CHEM"
                        subject2.text = "MAT A/MAT B or PHY"
                        subject3.text = "BIO or HSC"
                        subject4.text = "ENG/KIS or any GROUP III or a GROUP IV or any GROUP V"}

                    "Cluster 14" -> {
                        subject1.text = "BIO or GSC"
                        subject2.text = "MAT A / MAT B"
                        subject3.text = "any GROUP II or any GROUP III"
                        subject4.text = "ENG/KIS or a GROUP II or a GROUP III or any GROUP IV or any GROUP V"}

                    "Cluster 15" -> {
                        subject1.text = "BIO"
                        subject2.text = "CHEM"
                        subject3.text = "MAT A or PHY"
                        subject4.text = "ENG/KIS or 3rd GROUP II or any GROUP III or any GROUP IV or any GROUP V"}

                    "Cluster 16" -> {
                        subject1.text = "HAG"
                        subject2.text = "ENG/KIS"
                        subject3.text = "MAT A / MAT B or any GROUP II"
                        subject4.text = "a GROUP II or 2nd GROUP III or any GROUP IV or any GROUP V"}

                    "Cluster 17" -> {
                        subject1.text = "BIO"
                        subject2.text = "CHEM"
                        subject3.text = "MAT A or PHY or GEO"
                        subject4.text = "ENG/KIS or 3rd GROUP II or a GROUP III or any GROUP IV or any GROUP V"}

                    "Cluster 18" -> {
                        subject1.text = "GEO"
                        subject2.text = "MAT A / MAT B"
                        subject3.text = "any GROUP II"
                        subject4.text = "2nd GROUP II or 2nd GROUP III or any GROUP IV or any GROUP V"}

                    "Cluster 19" -> {
                        subject1.text = "FRE"
                        subject2.text = "ENG/KIS"
                        subject3.text = "MAT A / MAT B or any GROUP II or any GROUP III"
                        subject4.text = "a GROUP II or a GROUP III or any GROUP IV or 2nd GROUP V"}

                    "Cluster 20" -> {
                        subject1.text = "GER"
                        subject2.text = "ENG/KIS"
                        subject3.text = "MAT A / MAT B or any GROUP II or any GROUP III"
                        subject4.text = "a GROUP II or a GROUP III or any GROUP IV or 2nd GROUP V"}

                    "Cluster 21" -> {
                        subject1.text = "MUS"
                        subject2.text = "ENG/KIS"
                        subject3.text = "MAT A / MAT B or any GROUP II or any GROUP III"
                        subject4.text = "a GROUP II or a GROUP III or any GROUP IV or 2nd GROUP V"}

                    "Cluster 22" -> {
                        subject1.text = "ENG"
                        subject2.text = "MAT A/MAT B or any GROUP II"
                        subject3.text = "2nd GROUP II or any GROUP III"
                        subject4.text = "KIS or 3rd GROUP II or 2nd GROUP III or any GROUP IV or any GROUP V"}
                }
            }

        }

        val spinnner2 = view.findViewById<Spinner>(R.id.subj1)
        spinnner2?.adapter = ArrayAdapter(activity?.applicationContext!!,R.layout.spinner_row,grades)
        spinnner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                gradeSelected1 = parent?.getItemAtPosition(position).toString()
            }

        }

        val spinner3 = view.findViewById<Spinner>(R.id.subj2)
        spinner3?.adapter = ArrayAdapter(activity?.applicationContext!!,R.layout.spinner_row,grades)
        spinner3.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                gradeSelected2 = parent?.getItemAtPosition(position).toString()
            }

        }

        val spinner4 = view.findViewById<Spinner>(R.id.subj3)
        spinner4?.adapter = ArrayAdapter(activity?.applicationContext!!,R.layout.spinner_row,grades)
        spinner4.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                gradeSelected3 = parent?.getItemAtPosition(position).toString()
            }

        }

        val spinner5 = view.findViewById<Spinner>(R.id.subj4)
        spinner5?.adapter = ArrayAdapter(activity?.applicationContext!!,R.layout.spinner_row,grades)
        spinner5.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                gradeSelected4 = parent?.getItemAtPosition(position).toString()
            }

        }
        calculateC.setOnClickListener(View.OnClickListener {

            var points = totalPoint.text.toString()

            if(points == ""){
                totalPoint.error = "Please enter your total points"
            }
            else
            resultC.text = ("Your Points are : ${"%.3f".format(calculatePoints(points.toInt(),convertSubj(gradeSelected1),convertSubj(gradeSelected2),
                convertSubj(gradeSelected3),convertSubj(gradeSelected4)))}")
        })

        return view
    }

    fun calculatePoints(totalPoints:Int,subj1:Int,subj2:Int,subj3:Int,subj4:Int) : Double {

        var x:Double = (subj1+subj2+subj3+subj4).toDouble()

        var z:Double = x/48 * ((totalPoints.toDouble())/84)

        var z_sqrt:Double = sqrt(z)

        var c:Double = z_sqrt*48

        return c
    }

    fun convertSubj(subj:String): Int {
        var points:Int = 0
        when(subj){
            "A" -> points = 12
            "A-" -> points =  11
            "B+" -> points =  10
            "B" -> points =  9
            "B-" -> points =  8
            "C+" -> points =  7
            "C" -> points =  6
            "C-" -> points =  5
            "D+" -> points =  4
            "D" -> points =  3
            "D-" -> points =  2
            "E" -> points =  1
        }
        return points
    }
}