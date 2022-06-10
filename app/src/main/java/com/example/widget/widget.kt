package com.example.widget

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.view.Window
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.widget.databinding.ActivityWidgetBinding
import com.google.android.material.snackbar.Snackbar

// Membuat variabel binding
   private lateinit var binding : ActivityWidgetBinding

class widget : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //inisialsasi binding
        binding = ActivityWidgetBinding.inflate(layoutInflater)
        //memanggil layout dengan menggunakan binding.root
        setContentView(binding.root)

        //Button Toast
        binding.btnToast.setOnClickListener {
            Toast.makeText(this, "ini adalah Toast", Toast.LENGTH_SHORT).show()
        }

        //Button Snackbar
        binding.btnSnackbar.setOnClickListener {
            Snackbar.make(it, "Ini adalah Snackbar", Snackbar.LENGTH_SHORT).show()
        }

        //Button Alert
        binding.btnAlert.setOnClickListener {
            AlertDialog.Builder(this).apply {
                setTitle("Message")
                setMessage("Ini adalah Alert")

                setPositiveButton("Ok") { dialog, _ ->
                    Toast.makeText(applicationContext, "Anda click OK", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }

                setNegativeButton("Back") { dialog, _ ->
                    Toast.makeText(applicationContext, "Anda click back", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()

                }

            }.show()
        }

        //Button Custom Dialog
        binding.btnCustomDialog.setOnClickListener {
            Dialog(this).apply {
                requestWindowFeature(Window.FEATURE_NO_TITLE)
                setCancelable(false)
                setContentView(R.layout.custom_dialog)

                val btnCancel = this.findViewById<Button>(R.id.btnCancel)
                val btnContinue = this.findViewById<Button>(R.id.btnContinue)

                btnCancel.setOnClickListener {
                    Toast.makeText(applicationContext,"Anda click cancel",Toast.LENGTH_SHORT).show()
                    this.dismiss()
                }
                btnContinue.setOnClickListener {
                    Toast.makeText(applicationContext,"Anda click continue",Toast.LENGTH_SHORT).show()
                    this.dismiss()
                }
            }.show()
        }





    }
}

