package com.example.pocketnime.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.pocketnime.MainActivity
import com.example.pocketnime.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private val binding by lazy {ActivityLoginBinding.inflate(layoutInflater)}
    private val viewModel by viewModels<LoginViewModel> {LoginViewModel.provideFactory(this, this)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            if (binding.tietEmail.text.isNullOrEmpty()) {
                binding.tietEmail.error = "Masukan Email terlebih dahulu"
            } else if (binding.tietPassword.text.isNullOrEmpty()) {
                binding.tietPassword.error = "Masukan Password terlebih dahulu"
            } else {
                binding.tietEmail.error = null
                binding.tietPassword.error = null
                viewModel.login(
                    binding.tietEmail.text.toString(),
                    binding.tietPassword.text.toString()
                )
            }
        }



        viewModel.success.observe(this) { isSuccess ->
            if (isSuccess) {
                startActivity(Intent(this, MainActivity::class.java))
            }
        }


    }
}
