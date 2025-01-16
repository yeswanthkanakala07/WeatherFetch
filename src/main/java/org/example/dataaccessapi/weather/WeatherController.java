package org.example.dataaccessapi.weather;

import org.example.dataaccessapi.weatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WeatherController {

    // Inject API key from application.properties
    @Value("${weather.api.key}")
    private String apiKey;

    private final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";

    @GetMapping("/weather")
    public weatherResponse getWeatherByZipCode(@RequestParam String zip, @RequestParam String country) {
        String url = BASE_URL + "?zip=" + zip + "," + country + "&appid=" + apiKey;

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url,weatherResponse.class); // Return the API response
    }
}
