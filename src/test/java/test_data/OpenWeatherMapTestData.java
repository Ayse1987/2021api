package test_data;

import java.util.*;

public class OpenWeatherMapTestData {
     /*
     {
										    "coord": {
										        "lon": -0.13,
										        "lat": 51.51
										    },
										    "weather": [
										        {
										            "id": 801,
										            "main": "Clouds",
										            "description": "few clouds",
										            "icon": "02n"
										        }
										    ],
										    "base": "stations",
										    "main": {
										        "temp": 284.57,
										        "feels_like": 280.6,
										        "temp_min": 283.71,
										        "temp_max": 285.37,
										        "pressure": 1007,
										        "humidity": 81
										    },
										    "visibility": 10000,
										    "wind": {
										        "speed": 5.1,
										        "deg": 160
										    },
										    "clouds": {
										        "all": 20
										    },
										    "dt": 1608329611,
										    "sys": {
										        "type": 1,
										        "id": 1414,
										        "country": "GB",
										        "sunrise": 1608278540,
										        "sunset": 1608306738
										    },
										    "timezone": 0,
										    "id": 2643743,
										    "name": "London",
										    "cod": 200
										}

     */


    public Map<String, Float> coordSetUp(){
        Map<String, Float> coord = new HashMap<>();
        coord.put("lon", -0.1257f);
        coord.put("lat", 51.5085f);
        return coord;
    }

    public Map<String, Object> weatherSetUp(){
        Map<String, Object> weather = new HashMap<>();
        weather.put("id", 501);
        weather.put("main", "Rain");
        weather.put("description", "moderate rain");
        weather.put("icon", "10d");
        return weather;
    }
    List<Map> weather = Arrays.asList(weatherSetUp());

    public Map<String, Float> mainSetUp(){
        Map<String, Float> main = new HashMap<>();
        main.put("temp", 286.2f);
        main.put("feels_like", 285.18f);
        main.put("temp_min", 284.82f);
        main.put("temp_max", 288.15f);
        main.put("pressure", 998f);
        main.put("humidity", 76f);
        return main;
    }

    public Map<String, Float> windSetUp(){
        Map<String, Float> wind = new HashMap<>();
        wind.put("speed", 5.14f);
        wind.put("deg", 230f);
        return wind;
    }

    public Map<String, Float> rainSetUp(){
        Map<String, Float> rain = new HashMap<>();
        rain.put("1h", 1.42f);
        return rain;
    }

    public Map<String, Float> cloudsSetUp(){
        Map<String, Float> cloud = new HashMap<>();
        cloud.put("all", 75f);
        return cloud;
    }

    public Map<String, Object> sysSetUp(){
        Map<String, Object> sys = new HashMap<>();
        sys.put("type", 1);
        sys.put("id", 1414);
        sys.put("country", "GB");
        sys.put("sunrise", 1621138025);
        sys.put("sunset", 1621194411);
        return sys;
    }

    public Map<String, Object> expectedDataSetUp(){
        Map<String, Object> expected = new HashMap<>();
        expected.put("coord", coordSetUp());
        expected.put("weather", weatherSetUp());
        expected.put("base", "stations");
        expected.put("main", mainSetUp());
        expected.put("visibility", 10000);
        expected.put("wind", windSetUp());
        expected.put("rain",rainSetUp());
        expected.put("clouds", cloudsSetUp());
        expected.put("dt", 1621173209);
        expected.put("sys", sysSetUp());
        expected.put("timezone", 3600);
        expected.put("id", 2643743);
        expected.put("name", "London");
        expected.put("cod", 200);
        return expected;
    }

}
