package com.example.artelista

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.artelista.databinding.ActivityCrearcuentaBinding
import com.google.firebase.auth.FirebaseAuth

class ActivityCrearCuenta : AppCompatActivity() {
   private  lateinit var binding: ActivityCrearcuentaBinding
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
            var validaok = false

            //-- El email es un valor requerido
            if (binding.editEmail.text?.length?.equals(0)!!) {
                binding.editEmail.requestFocus()
                binding.editEmail.error = getString(R.string.strEmailRequired)
                return validaok
            }

            //-- La contraseña es un valor requerido
            if (binding.editPassword.text?.length?.equals(0)!!) {
                binding.editPassword.requestFocus()
                binding.editPassword.error = getString(R.string.strPassRequired)
                return validaok
            }

            //La confirmación de contraseña es un valor requerido
            if (binding.editPasswordConfirm.text?.length?.equals(0)!!) {
                binding.editPasswordConfirm.requestFocus()
                binding.editPasswordConfirm.error = getString(R.string.strPassConfirmRequired)
                return validaok
            }

            //La contraseña debe ser igual a la confirmación de la contraseña
            val strpassword: String = if (binding.editPassword.text != null) binding.editPassword.text.toString() else ""
            val strpasswordconfirmar:String = if (binding.editPasswordConfirm.text != null) binding.editPasswordConfirm.text.toString() else ""
            if (strpassword != strpasswordconfirmar)
            {
                binding.editPassword.requestFocus()
                binding.editPassword.error = getString(R.string.strPassEquals)
                return validaok
            }
            validaok = true
            return validaok
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
                    Toast.makeText(this, getString(R.string.strNotRegistred),
                        Toast.LENGTH_SHORT).show()
                }
            }
    }
}