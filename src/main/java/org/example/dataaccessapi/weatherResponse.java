package org.example.dataaccessapi;

import lombok.Data;

@Data
public class weatherResponse {
    private Main main;
    private Weather weather[];
    private String name;

    @Data
    public static class Main {
        private double temp;
        private double feels_like;
        private int pressure;
        private int humidity;
    }

    @Data
    public static class Weather {
        private String main;
        private String description;
    }
}
