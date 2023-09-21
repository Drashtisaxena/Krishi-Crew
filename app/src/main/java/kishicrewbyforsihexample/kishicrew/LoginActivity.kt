package kishicrewbyforsihexample.kishicrew

import android.app.ProgressDialog
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    lateinit var linearLayout1:LinearLayout
    lateinit var selectedChoice:String
    lateinit var signInButton:Button
    lateinit var progressDialog: ProgressBar
    lateinit var linearLayout: LinearLayout
    lateinit var rootLayout: RelativeLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        progressDialog = findViewById(R.id.progressBarLogin)
        linearLayout = findViewById(R.id.loginSecondLayout)
        rootLayout = findViewById(R.id.loginRootLayout)

        selectedChoice = "sih"
        linearLayout1 = findViewById(R.id.select_ur_choice)
        signInButton  = findViewById(R.id.sign_in_button)
        signInButton.setOnClickListener{

            progressDialog.visibility = VISIBLE
            linearLayout.visibility = GONE

            if(selectedChoice=="sih"){
                Toast.makeText(applicationContext,"Please select who are you!",Toast.LENGTH_SHORT).show()
                progressDialog.visibility = GONE
                linearLayout.visibility = VISIBLE
            }else if(selectedChoice=="0"){
                Handler().postDelayed({
                    val loginIntent = Intent(applicationContext, FarmerActivity::class.java)
                    loginIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    startActivity(loginIntent)
                    finish()
                }, 2000)

            }else if(selectedChoice=="1"){
                Handler().postDelayed({
                    val loginIntent = Intent(applicationContext, GovermentActivity::class.java)
                    loginIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    startActivity(loginIntent)
                    finish()
                }, 2000)
            }else if(selectedChoice=="2"){
                Handler().postDelayed({
                    val loginIntent = Intent(applicationContext, ConsumerActivity::class.java)
                    loginIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    startActivity(loginIntent)
                    finish()
                }, 2000)
            }
        }

        Quiz()

    }

    private fun Quiz(){
        for(i in 0..2){
            linearLayout1.getChildAt(i).setOnClickListener{
                enableOptions(true)
                selectedChoice = i.toString()
                markAsCheck(i,it as LinearLayout)
            }
        }
    }

    private fun markAsCheck(tick :Int,view:LinearLayout){
        view.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#14E39A")))
    }
    private fun enableOptions(enable:Boolean){
        for(i in 0..2){
            if(enable){
                linearLayout1.getChildAt(i).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFFFFF")))
            }
        }
    }
}