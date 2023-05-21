package com.example.artelista

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.artelista.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //funcionalidad al boton Login
        binding.btnLogin.setOnClickListener {v->
            val intent = Intent(v.context, MenuActivity::class.java)
            startActivity(intent)
        }

        //funcionalidad al textview crea aqui
        binding.tvCreaUnaAqui.setOnClickListener { v ->
            val intent = Intent(v.context, ActivityCrearCuenta::class.java)
            startActivity(intent)
        }

        //------------------
        val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
        binding.btnLogin.setOnClickListener {
            if (validarUsuario()) {
                firebaseAuth.signInWithEmailAndPassword(
                    binding.editUserName.text.toString(),
                    binding.editPassword.text.toString()
                )
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            startActivity(
                                Intent(
                                    this,
                                    MenuActivity::class.java
                                )
                            )
                            Toast.makeText(
                                this, "Bienvenido",
                                Toast.LENGTH_SHORT
                            ).show()
                            binding.editUserName.setText("")
                            binding.editUserName.setText("")
                        } else {
                            Toast.makeText(
                                this,
                                getString(R.string.strInexistentUser),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
            }
        }
    }

    //Validar inicio de sesión
    private fun validarUsuario(): Boolean {
        try {
            if (binding.editUserName.text?.length?.equals(0)!!){
                binding.editUserName.requestFocus()
                binding.editUserName.error = getString(R.string.strEmailRequired)

                return false
            }
            if (binding.editPassword.text?.length?.equals(0)!!){
                binding.editPassword.requestFocus()
                binding.editPassword.error = getString(R.string.strPassRequired)

                return false
            }
            if (binding.editPassword.text?.length!! < 3 || binding.editPassword.text?.length!! > 8) {
                binding.editPassword.requestFocus()
                binding.editPassword.error = getString(R.string.strPassTooLongShort)
                return false
            }

            return true

        } catch (e: Exception) {
            e.message?.let { Log.e(getString(R.string.strErrorInValidate), it) }
            return false
        }
    }
}