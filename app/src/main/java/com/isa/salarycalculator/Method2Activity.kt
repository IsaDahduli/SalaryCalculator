package com.isa.salarycalculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class Method2Activity : AppCompatActivity() {
    private var baseSalaryEditText: EditText? = null
    private var housingBenefitEditText: EditText? = null
    private var transportationBenefitEditText: EditText? = null
    private var healthBenefitEditText: EditText? = null
    private var vacationBenefitEditText: EditText? = null

    private var totalSalaryEditText: EditText? = null
    private var calculateTotalSalaryButton: Button? = null

    private var taxRateEditText: EditText? = null
    private var houseRentEditText: EditText? = null

    private var salaryAfterTaxRentEditText: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_method2)

        baseSalaryEditText = findViewById<View>(R.id.edit_text_base_salary) as EditText
        housingBenefitEditText = findViewById<View>(R.id.edit_text_housing_benefit) as EditText
        transportationBenefitEditText = findViewById<View>(R.id.edit_text_transportation_benefit) as EditText
        healthBenefitEditText = findViewById<View>(R.id.edit_text_health_benefit) as EditText
        vacationBenefitEditText = findViewById<View>(R.id.edit_text_vacation_benefit) as EditText

        totalSalaryEditText = findViewById<View>(R.id.edit_text_total_salary) as EditText

        calculateTotalSalaryButton = findViewById<View>(R.id.button_calculate_total_salary_before_tax) as Button

        taxRateEditText = findViewById<View>(R.id.edit_text_tax) as EditText
        houseRentEditText = findViewById<View>(R.id.edit_text_house_rent) as EditText

        salaryAfterTaxRentEditText = findViewById<View>(R.id.edit_text_salary_after_rent_and_tax) as EditText

        baseSalaryEditText!!.setText("0")
        housingBenefitEditText!!.setText("0")
        transportationBenefitEditText!!.setText("0")
        healthBenefitEditText!!.setText("0")
        vacationBenefitEditText!!.setText("0")
        totalSalaryEditText!!.setText("0")
        taxRateEditText!!.setText("0")
        houseRentEditText!!.setText("0")
        salaryAfterTaxRentEditText!!.setText("0")
        calculateTotalSalaryButton!!.setOnClickListener {
            try {
                val baseSalary = baseSalaryEditText!!.text.toString().toDouble()
                val housingBenefit = housingBenefitEditText!!.text.toString().toDouble()
                val transportationBenefit = transportationBenefitEditText!!.text.toString().toDouble()
                val healthBenefit = healthBenefitEditText!!.text.toString().toDouble()
                val vacationBenefit = vacationBenefitEditText!!.text.toString().toDouble()
                val taxRate = taxRateEditText!!.text.toString().toDouble()
                val houseRent = houseRentEditText!!.text.toString().toDouble()


                val totalSalary = housingBenefit + transportationBenefit + healthBenefit + vacationBenefit + baseSalary
                totalSalaryEditText!!.setText(totalSalary.toString())

                val salaryTax = totalSalary * taxRate / 100

                val salaryAfterTaxRent = totalSalary - salaryTax - houseRent

                salaryAfterTaxRentEditText!!.setText(salaryAfterTaxRent.toString())
            } catch (e: Exception) {
                Toast.makeText(this@Method2Activity, "Invalid Input", Toast.LENGTH_SHORT).show()
            }
        }
    }
}