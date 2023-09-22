package kishicrewbyforsihexample.kishicrew

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Krishipedia : AppCompatActivity() {

    lateinit var recyclerview: GridView
    lateinit var krishiList: ArrayList<krishiCrewModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_krishipedia)

        recyclerview = findViewById<GridView>(R.id.krishi_pedia_recyclerview)
        krishiList = ArrayList()

        krishiList.add(krishiCrewModel("Wheat", R.drawable.wheat, "https://en.wikipedia.org/wiki/Wheat"));
        krishiList.add(krishiCrewModel("Rice", R.drawable.rice, "https://en.wikipedia.org/wiki/Rice"));
        krishiList.add(krishiCrewModel("Maize", R.drawable.maize, "https://en.wikipedia.org/wiki/Maize"));
        krishiList.add(krishiCrewModel("Barley", R.drawable.barley, "https://en.wikipedia.org/wiki/Barley"));
        krishiList.add(krishiCrewModel("Apple", R.drawable.apple, "https://en.wikipedia.org/wiki/Apple"));
        krishiList.add(krishiCrewModel("Apricot", R.drawable.apricot, "https://en.wikipedia.org/wiki/Apricot"));
        krishiList.add(krishiCrewModel("Cherry", R.drawable.cherry, "https://en.wikipedia.org/wiki/Cherry"));
        krishiList.add(krishiCrewModel("Pear", R.drawable.pear, "https://en.wikipedia.org/wiki/Pear"));
        krishiList.add(krishiCrewModel("Grapes", R.drawable.grapes, "https://en.wikipedia.org/wiki/Grapes"));
        krishiList.add(krishiCrewModel("Saffron", R.drawable.saffron, "https://en.wikipedia.org/wiki/Saffron"));
        krishiList.add(krishiCrewModel("Walnut", R.drawable.walnut, "https://en.wikipedia.org/wiki/Walnut"));
        krishiList.add(krishiCrewModel("Almond", R.drawable.almond, "https://en.wikipedia.org/wiki/Almond"));
        krishiList.add(krishiCrewModel("Potato", R.drawable.potato, "https://en.wikipedia.org/wiki/Potato"));
        krishiList.add(krishiCrewModel("Cabbage", R.drawable.cabbage, "https://en.wikipedia.org/wiki/Cabbage"));
        krishiList.add(krishiCrewModel("Carrot", R.drawable.carrot, "https://en.wikipedia.org/wiki/Carrot"));
        krishiList.add(krishiCrewModel("Gram", R.drawable.gram, "https://en.wikipedia.org/wiki/Chickpea"));
        krishiList.add(krishiCrewModel("Lentils", R.drawable.lentils, "https://en.wikipedia.org/wiki/Lentil"));
        krishiList.add(krishiCrewModel("Soybean", R.drawable.soybean, "https://en.wikipedia.org/wiki/Soybean"));
        krishiList.add(krishiCrewModel("Fennel", R.drawable.fennel, "https://en.wikipedia.org/wiki/Fennel"));
        krishiList.add(krishiCrewModel("Cumin", R.drawable.cumin, "https://en.wikipedia.org/wiki/Cumin"));
        krishiList.add(krishiCrewModel("Coriander", R.drawable.coriander, "https://en.wikipedia.org/wiki/Coriander"));
        krishiList.add(krishiCrewModel("Tea", R.drawable.tea, "https://en.wikipedia.org/wiki/Tea"));
        krishiList.add(krishiCrewModel("Tobacco", R.drawable.tobacco, "https://en.wikipedia.org/wiki/Tobacco"));
        krishiList.add(krishiCrewModel("Silk", R.drawable.silk, "https://en.wikipedia.org/wiki/Silk"));


        val courseAdapter = KrishiAdapter(krishiList, applicationContext)
        recyclerview.adapter = courseAdapter


        recyclerview.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            // inside on click method we are simply displaying
            // a toast message with course name.

            val webpage: Uri = Uri.parse(krishiList[position].url)
            val intent = Intent(Intent.ACTION_VIEW, webpage)
            startActivity(intent)
        }


    }
}