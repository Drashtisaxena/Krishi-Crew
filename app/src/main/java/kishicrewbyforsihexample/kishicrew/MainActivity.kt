package kishicrewbyforsihexample.kishicrew

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ScrollView
import kotlin.math.log
import kotlin.math.sign

class MainActivity : AppCompatActivity() {
    lateinit var scrollView:ScrollView
    lateinit var readMoreButton:Button
    lateinit var signInButton:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        scrollView = findViewById<ScrollView>(R.id.scrollView)
        readMoreButton = findViewById(R.id.read_more_button)
        signInButton = findViewById(R.id.signInButton)

        readMoreButton.setOnClickListener{
            val loginInte = Intent(applicationContext, Krishipedia::class.java)
            startActivity(loginInte)
        }
        signInButton.setOnClickListener{
            val loginIntent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(loginIntent)
        }
    }
}