package com.batuhanmercan.kullanicigirisuygulamas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.batuhanmercan.kullanicigirisuygulamas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

   private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var girisemail = ""
        var girisparola = ""

        binding.tvuyeol.setOnClickListener{
            //alert Dialog oluşturuyoruz.
            var activity_uyeOl = LayoutInflater.from(this).inflate(R.layout.activity_uyeol,null)
            var alertDialog = AlertDialog.Builder(this)
            alertDialog.setView(activity_uyeOl)
            alertDialog.setNegativeButton("Kapat"){dialog,which -> }
            alertDialog.show()

            //Yeni üye kaydı yapıyoruz.

            val kaydetbutton = activity_uyeOl.findViewById<TextView>(R.id.kaydetbutton)
            kaydetbutton.setOnClickListener {
                val etkayitolemail = activity_uyeOl.findViewById<TextView>(R.id.etkayitolemail).text.toString().trim()
                val etkayitolparola = activity_uyeOl.findViewById<TextView>(R.id.etkayitolparola).text.toString().trim()
                 girisemail = etkayitolemail
                 girisparola = etkayitolparola
                Toast.makeText(applicationContext,"Başarılı",Toast.LENGTH_SHORT).show()
            }
        }

        //Giriş işlemini yapıyoruz
            binding.girisyapbutton.setOnClickListener {
            val etemail = binding.etemail.text.toString().trim()
            val etparola = binding.etparola.text.toString().trim()

               if (etemail.isEmpty()){
                   binding.etemail.error = "Lütfen e-mail adresinizi giriniz"
               }
                if (etparola.isEmpty()){
                    binding.etparola.error = "Lütfen parolanızı giriniz"
                } else{
                    if ((girisemail == etemail) && (girisparola == etparola)){
                        var alertDialog = AlertDialog.Builder(this)
                        alertDialog.setTitle("Başarılı")
                        alertDialog.setMessage("Giriş işlemini başarılı bir şekilde gerçekleştirdiniz.")
                        alertDialog.setNegativeButton("Kapat"){dialog,which -> }
                        alertDialog.show()

                    }
                    else {
                        var alertDialog = AlertDialog.Builder(this)
                        alertDialog.setTitle("Hatalı")
                        alertDialog.setMessage("Giriş işlemi başarısız.")
                        alertDialog.setNegativeButton("Kapat"){dialog,which -> }
                        alertDialog.show()
                    }
                }
            }
    }
}