package vn.edu.devpro.testjson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import vn.edu.devpro.testjson.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    String json = "{\"coord\": { \"lon\": 139,\"lat\": 35},\n" +
            "  \"weather\": [" +"{" + "\"id\": 800," + "\"main\": \"Clear\"," + "\"description\": \"clear sky\",\n" + "\"icon\": \"01n\"" +"}" + "],\n" +
            "  \"base\": \"stations\",\n" +
            "  \"main\": {\n" + "\"temp\": 289.92," + "\"pressure\": 1009," +"\"humidity\": 92," + "\"temp_min\": 288.71," + " \"temp_max\": 290.93" + "  },\n" +
            "  \"wind\": {\n" +
            "    \"speed\": 0.47,\n" +
            "    \"deg\": 107.538\n" +
            "  },\n" +
            "  \"clouds\": {\n" +
            "    \"all\": 2\n" +
            "  },\n" +
            "  \"dt\": 1560350192,\n" +
            "  \"sys\": {\n" +
            "    \"type\": 3,\n" +
            "    \"id\": 2019346,\n" +
            "    \"message\": 0.0065,\n" +
            "    \"country\": \"JP\",\n" +
            "    \"sunrise\": 1560281377,\n" +
            "    \"sunset\": 1560333478\n" +
            "  },\n" +
            "  \"timezone\": 32400,\n" +
            "  \"id\": 1851632,\n" +
            "  \"name\": \"Shuzenji\",\n" +
            "  \"cod\": 200\n" +
            "}";

    TextView tvMain, tvWeather;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

//        tvMain = findViewById(R.id.tvMain);

        try {
            JSONObject jsonObject = new JSONObject(json);

            JSONArray weather = jsonObject.getJSONArray("weather");
            JSONObject weather_object = weather.getJSONObject(0);
            int id = weather_object.getInt("id");
            String str_main = weather_object.getString("main");
            String description = weather_object.getString("description");
            String icon = weather_object.getString("icon");
            binding.tvWeather.setText("id: "+ id +"\nMain: "+ str_main + "\nDescription: "+
                    description +"\nIcon: "+ icon);

            JSONObject main = jsonObject.getJSONObject("main");
            double temp = main.getDouble("temp");
            int pressure = main.getInt("pressure");
            int humidity = main.getInt("humidity");
            double temp_min = main.getDouble("temp_min");
            double temp_max = main.getDouble("temp_max");
            binding.tvMain.setText("Temperature: " + temp + "\nPressure: " + pressure + "\nHumidity: " +
                    + humidity + "%\nMin temperature: " + temp_min + "\nMax temperature: "+ temp_max);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
