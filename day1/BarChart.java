package com.training.day1;

import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BarChart extends JFrame {

    private static final long serialVersionUID = 1L;

    public BarChart (String appTitle) throws IOException, InterruptedException {
        super(appTitle);

        // Create Dataset
        CategoryDataset dataset = createDataset();

        //Create chart
        JFreeChart chart=ChartFactory.createBarChart(
                "temp vs city", //Chart Title
                "city name", // Category axis
                "temperature in celcius", // Value axis
                dataset,
                PlotOrientation.VERTICAL,
                true,true,false
        );

        ChartPanel panel=new ChartPanel(chart);
        setContentPane(panel);
    }

    private CategoryDataset createDataset() throws IOException, InterruptedException {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String[] city = {"tokyo","sydney","delhi","dubai","milan","madrid","berlin","amsterdam","washington","vancouver","Chicago","rome","lyon","turin"};
        for (String s : city) {
            var url = "http://api.weatherapi.com/v1/current.json?key=2d14c37a9ef84ef6ab980624221809&q=" + s + "&aqi=yes";
            var request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
            var client = HttpClient.newBuilder().build();
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String sb = response.body();
            String sb1 = sb.replace("{\"location\":{", "");
            String sb2 = sb1.replace("\"current\":{", "");
            String sb4 = sb2.replace("{", "\"\",");
            String sb3 = sb4.replace("}", "");
            System.out.println(sb3);
            JSONObject jsonObject = new JSONObject("{" + sb3 + "}");
            System.out.println(jsonObject.get("name"));
            dataset.addValue((Number) jsonObject.get("temp_c"), (Comparable) jsonObject.get("name"), (Comparable) jsonObject.get("name"));
        }

        return dataset;
    }

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeAndWait(()->{
            BarChart  example;
            try {
                example = new BarChart("Bar Chart");
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
            example.setSize(800, 400);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}

