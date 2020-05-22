package com.example.pandemicpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.SparseBooleanArray
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_health_check.*
import kotlin.math.round

class HealthCheck : AppCompatActivity() {
    var height:Double? = null
    var weight:Double? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_health_check)

        btnImp.setOnClickListener {
            var bol= emptyCheck()
            if (bol==true){
                var res=  height?.let { it1 -> weight?.let { it2 -> fimperial(it2, it1) } }
               res= String.format("%.2f",res).toDouble()
                if (res != null) {
                    result(res)
                }
            }else{

            }

        }
        btnMetric.setOnClickListener {
            var bol= emptyCheck()
            if (bol==true){
                var res= height?.let { it1 -> weight?.let { it2 -> fmetric(it2, it1) } }
                res= String.format("%.2f",res).toDouble()
                res?.let { result(it) }
            }else{

            }

        }

    }
    fun emptyCheck():Boolean{
        if (iheight.text.isEmpty()||iweight.text.isEmpty()) {
            Toast.makeText(this, "Please fill all field", Toast.LENGTH_LONG).show()
            return false
        }
        else{
            height= iheight.text.toString().toDouble()
            weight= iweight.text.toString().toDouble()
            if( height!! <=0 || weight!! <=0 ){
                Toast.makeText(this, "weight or height must be more than 0", Toast.LENGTH_LONG).show()
                return false
            } else{
                return true
            }
        }

    }
     fun fmetric(vweight:Double, vheight:Double): Double{
         var bmi:Double? = null
        bmi= vweight/vheight/vheight*10000
        return  bmi

    }
     fun fimperial(vweight:Double, vheight:Double): Double{
         var bmi:Double? = null
        bmi= (vweight/(vheight*vheight))*703
        return  bmi

    }
    fun result(vresult:Double){
        if(vresult <18.5){
            iresultdetail.text="BMI val= $vresult - Looks like you are stressed during this quarantine. Go eat some more"
            iresultdetail.setTextColor(getResources().getColorStateList(R.color.less))
        } else if(vresult>=18.5 && vresult<25){
            iresultdetail.text="BMI val= $vresult - Looks like you are doing good during this quarantine"
            iresultdetail.setTextColor(getResources().getColorStateList(R.color.normal))
        } else if(vresult>=25 && vresult<30){
            iresultdetail.text="BMI val= $vresult -  Looks like you need reular excercies during this quarantine"
            iresultdetail.setTextColor(getResources().getColorStateList(R.color.over))
        }else if(vresult>=30){
            iresultdetail.text="BMI val= $vresult -   Looks like you need a lot of excercies during this quarantine"
            iresultdetail.setTextColor(getResources().getColorStateList(R.color.obese))
        }
    }
}
