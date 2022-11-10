package com.martinbg.mvvm

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.martinbg.mvvm.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: DiceRollViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRollDice.setOnClickListener {
            viewModel.rollDice()
        }

        lifecycleScope.launch {
            // logic will only be executed after Activity passes
            // onStart() state and stopped after onStop()
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect {
                    binding.tvDiceRolls.text =
                        "Number of rolls: ${it.numberOfRolls}" + System.lineSeparator() +
                                "First dice value: ${it.firstDiceValue}" + System.lineSeparator() +
                                "Second dice value: ${it.secondDiceValue}"
                }
            }
        }

    }
}