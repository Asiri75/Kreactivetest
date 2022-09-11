package com.libertytech.kreactivetest.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.libertytech.kreactivetest.R
import com.libertytech.kreactivetest.databinding.ActivityMainBinding
import com.libertytech.kreactivetest.ui.result.ResultActivity
import com.libertytech.kreactivetest.ui.result.ResultActivity.Companion.FIRST_INT_KEY
import com.libertytech.kreactivetest.ui.result.ResultActivity.Companion.FIRST_STRING_KEY
import com.libertytech.kreactivetest.ui.result.ResultActivity.Companion.LIMIT_KEY
import com.libertytech.kreactivetest.ui.result.ResultActivity.Companion.SECOND_INT_KEY
import com.libertytech.kreactivetest.ui.result.ResultActivity.Companion.SECOND_STRING_KEY

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.confirmFormButton.setOnClickListener {
            if(areFieldSet()){
                goToResult()
            }
        }

    }

    /**
     * Check all form fields
     * If empty, show error message
     * We could have use TextWatcher if we also checked the format
     */
    private fun areFieldSet() = when {
        binding.firstIntEditText.text.isNullOrBlank() -> {
            binding.firstIntEditText.error = resources.getString(R.string.empty_field)
            false
        }
        binding.secondIntEditText.text.isNullOrBlank() -> {
            binding.secondIntEditText.error = resources.getString(R.string.empty_field)
            false
        }
        binding.firstStringEditText.text.isNullOrBlank() -> {
            binding.firstStringEditText.error = resources.getString(R.string.empty_field)
            false
        }
        binding.secondStringEditText.text.isNullOrBlank() -> {
            binding.secondStringEditText.error = resources.getString(R.string.empty_field)
            false
        }
        binding.limitEditText.text.isNullOrBlank() -> {
            binding.limitEditText.error = resources.getString(R.string.empty_field)
            false
        }
        else -> true
    }

    /**
     * Go to result activity passing the data of the form
     */
    private fun goToResult() {
        startActivity(
            Intent(this, ResultActivity::class.java).apply {
                putExtra(FIRST_INT_KEY, binding.firstIntEditText.text.toString())
                putExtra(SECOND_INT_KEY, binding.secondIntEditText.text.toString())
                putExtra(FIRST_STRING_KEY, binding.firstStringEditText.text.toString())
                putExtra(SECOND_STRING_KEY, binding.secondStringEditText.text.toString())
                putExtra(LIMIT_KEY, binding.limitEditText.text.toString())
            }
        )
    }
}