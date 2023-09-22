package kishicrewbyforsihexample.kishicrew;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class NPKDetectionActivity extends AppCompatActivity {

    EditText n,p,k,temp,ph,rain,hum;
    Button predict;
    TextView result;
    private ProgressBar progressBar;

    private ProgressBar mainProgressBar;
    private LinearLayout mainLinearLayout;
    private TextView progressText;
    private RelativeLayout progress_layout;
    double i = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_npkdetection);

        n = findViewById(R.id.n_value);
        p = findViewById(R.id.p_value);
        k = findViewById(R.id.k_value);
        temp = findViewById(R.id.temp_value);
        ph = findViewById(R.id.ph_value);
        rain = findViewById(R.id.rain_value);
        hum = findViewById(R.id.hum_value);
        predict = findViewById(R.id.krishak_submit_button);
        result = findViewById(R.id.krishak_result_show);
        progressBar = findViewById(R.id.progress_bar);
        progressText = findViewById(R.id.progress_text);
        progress_layout = findViewById(R.id.progress_layout);

        mainProgressBar = findViewById(R.id.progressBarNPKDetection);
        mainLinearLayout = findViewById(R.id.linear_layout_mainNPKDetection);

        predict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainProgressBar.setVisibility(View.VISIBLE);
                mainLinearLayout.setVisibility(View.GONE);
                fetchData();
            }
        });


    }

    private void fetchData() {

        String url = "https://sih-api-u9o1.onrender.com/predict";

        Map<String, String> stringMap = new HashMap<>();

        // Add entries to the map
        Map<String, String> pythonMap = new HashMap<>();
        pythonMap.put("0", "apple"); pythonMap.put("1", "banana"); pythonMap.put("2", "blackgram");
        pythonMap.put("3", "chickpea"); pythonMap.put("4", "coconut"); pythonMap.put("5", "coffee");
        pythonMap.put("6", "cotton"); pythonMap.put("7", "grapes"); pythonMap.put("8", "jute");
        pythonMap.put("9", "kidneybeans"); pythonMap.put("10", "lentil"); pythonMap.put("11", "maize");
        pythonMap.put("12", "mango"); pythonMap.put("13", "mothbeans"); pythonMap.put("14", "mungbean");
        pythonMap.put("15", "muskmelon"); pythonMap.put("16", "orange"); pythonMap.put("17", "papaya");
        pythonMap.put("18", "pigeonpeas"); pythonMap.put("19", "pomegranate"); pythonMap.put("20", "rice");
        pythonMap.put("21", "watermelon");

        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {

                            JSONObject js = new JSONObject(response);
                            String predict_result = js.getString("predict_result");
                            String accuracy = js.getString("accuracy");

                            mainProgressBar.setVisibility(View.GONE);
                            mainLinearLayout.setVisibility(View.VISIBLE);

                            result.setText("Predicted Crop: "+pythonMap.get(predict_result)+"\n"+"Accuracy");
//                            Toast.makeText(NPKDetectionActivity.this, predict_result, Toast.LENGTH_SHORT).show();

                            progress_layout.setVisibility(View.VISIBLE);
                            final Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    // set the limitations for the numeric
                                    // text under the progress bar
                                    if (i <= Float.parseFloat(accuracy.substring(0, Math.min(accuracy.length(), 4)))) {
                                        progressText.setText("" + i + "%");
                                        progressBar.setProgress((int) i);
                                        i++;
                                        handler.postDelayed(this, 50);
                                    } else {
                                        handler.removeCallbacks(this);
                                    }
                                }
                            }, 50);



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                result.setText(error.getMessage().toString());
            }
        }){
            @Override
            protected Map getParams(){
                Map params = new HashMap<>();
                params.put("N",n.getText().toString());
                params.put("P",p.getText().toString());
                params.put("K",k.getText().toString());
                params.put("temperature",temp.getText().toString());
                params.put("rainfall",rain.getText().toString());
                params.put("ph",ph.getText().toString());
                params.put("humidity",hum.getText().toString());

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);



    }
}