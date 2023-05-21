package com.example.artelista

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.artelista.databinding.ActivityCrearcuentaBinding
import com.google.firebase.auth.FirebaseAuth
import java.util.regex.Pattern

class ActivityCrearCuenta : AppCompatActivity() {
   private  lateinit var binding: ActivityCrearcuentaBinding

    private val PASSWORD_PATTERN: Pattern = Pattern.compile(
        "^" +
                "(?=.*[@#$%^&+=*])" +  // Al menos 1 caracter es especial
                "(?=\\S+$)" +  // No espacios en blanco
                ".{3,}" +  // Al menos 3 caracteres
                "$"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCrearcuentaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.tbCrearCuenta)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        // Botón Crear Cuenta
        binding.btnSingin.setOnClickListener {
            if (valida()) {
                addCuentaUsuario()
            }
        }
    }

    private fun valida(): Boolean {
        try {
            //-- Usuario muy largo
            if (binding.editName.text?.length!! > 15) {
                binding.editName.requestFocus()
                binding.editName.error = getString(R.string.strUserTooLong)
                return false
            }

            //-- El email es un valor requerido
            if (binding.editEmail.text?.length?.equals(0)!!) {
                binding.editEmail.requestFocus()
                binding.editEmail.error = getString(R.string.strEmailRequired)
                return false
            }

            //-- La contraseña es un valor requerido
            if (binding.editPassword.text?.length?.equals(0)!!) {
                binding.editPassword.requestFocus()
                binding.editPassword.error = getString(R.string.strPassRequired)
                return false
            }

            //-- La contraseña es menor que 3 o mayor que 8
            if (binding.editPassword.text?.length!! < 3 || binding.editPassword.text?.length!! > 8) {
                binding.editPassword.requestFocus()
                binding.editPassword.error = getString(R.string.strPassTooLongShort)
                return false
            }

            if (!PASSWORD_PATTERN.matcher(binding.editPassword.text).matches()){
                binding.editPassword.requestFocus()
                binding.editPassword.error = getString(R.string.strPassTooWeak)
                return false
            }

            //La confirmación de contraseña es un valor requerido
            if (binding.editPasswordConfirm.text?.length?.equals(0)!!) {
                binding.editPasswordConfirm.requestFocus()
                binding.editPasswordConfirm.error = getString(R.string.strPassConfirmRequired)
                return false
            }

            //La contraseña debe ser igual a la confirmación de la contraseña
            val strPassword: String = if (binding.editPassword.text != null) binding.editPassword.text.toString() else ""
            val strPassConfirm:String = if (binding.editPasswordConfirm.text != null) binding.editPasswordConfirm.text.toString() else ""
            if (strPassword != strPassConfirm)
            {
                binding.editPassword.requestFocus()
                binding.editPassword.error = getString(R.string.strPassEquals)
                return false
            }

            return true

        } catch (e: Exception) {
            e.message?.let { Log.e(getString(R.string.strErrorInValidate), it) }
            return false
        }
    }

    //-- Metodo agregar Usuario
    private fun addCuentaUsuario()
    {
        val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
        firebaseAuth.createUserWithEmailAndPassword(binding.editEmail.text
            .toString(), binding.editPassword.text.toString())
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, getString(R.string.strRegistred),
                        Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    Toast.makeText(this, getString(R.string.strNotRegistered),
                        Toast.LENGTH_SHORT).show()
                }
            }
    }
}