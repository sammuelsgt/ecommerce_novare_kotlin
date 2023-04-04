package ph.stacktrek.novare.ecommerce.tuliao.sammuel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar
import ph.stacktrek.novare.ecommerce.tuliao.sammuel.databinding.ActivityLoginBinding
import ph.stacktrek.novare.ecommerce.tuliao.sammuel.utility.PreferenceUtility

class LoginActivity : AppCompatActivity() {

    private lateinit var binding:ActivityLoginBinding


    private val launchRegister = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        val data = result.data


//        val username = data!!.getStringExtra("register_username")
//        val password = data!!.getStringExtra("register_password")
//        binding.usernametext.setText(username)
//        binding.passwordtext.setText(password)

        Snackbar.make(binding.root,
            "Registered ${data!!.getStringExtra("register_username")}",
            Snackbar.LENGTH_LONG).show()
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registerButton.setOnClickListener {
            val goToRegister = Intent(
                applicationContext,
                RegisterActivity::class.java
            )

            launchRegister.launch(goToRegister)
        }

        binding.loginButton.setOnClickListener {
            var username = binding.usernametext.text.toString()
            var password = binding.passwordtext.text.toString()

            if(username.equals("admin") && password.equals("admin")){
                val goToMain = Intent(applicationContext,
                    MainActivity::class.java)

                goToMain.putExtra("username",username)
                val bundle = Bundle()
                bundle.putString("bundle_username",username)
                goToMain.putExtras(bundle)

//                PreferenceUtility(applicationContext).apply {
//                    saveStringPreferences("username",binding.usernametext.toString())
//                    saveStringPreferences("password",binding.passwordtext.toString())
//                }
                startActivity(goToMain)
                finish()

            }else{
                Snackbar.make(binding.root,"Please provide admin/admin", Snackbar.LENGTH_SHORT).show()
            }

        }
//        PreferenceUtility(applicationContext).apply {
//            binding.usernametext.setText(getStringPreferences("username"))
//            binding.passwordtext.setText(getStringPreferences("password"))
//
//        }


    }

}