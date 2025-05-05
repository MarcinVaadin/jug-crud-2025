package com.example.application.ui.views;

import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.ChartType;
import com.vaadin.flow.component.charts.model.Configuration;
import com.vaadin.flow.component.charts.model.DataSeries;
import com.vaadin.flow.component.charts.model.DataSeriesItem;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;

/**
 * <strong>Main (default) view</strong>
 * <p>
 * <a href="https://vaadin.com/docs/latest/flow/routing/route">Route</a> marks
 * this view as default application view.
 * </p>
 */
@Route
@Menu(title = "Hello", order = 1, icon = "vaadin:comment-o") // add to menu for clarity
@PermitAll // allows logged-in users to access this view
public class MainView extends VerticalLayout { // each Vaadin view is a component

    public MainView() {
        // com.vaadin.flow.component.html contains API for classic HTML components
        add(new H1("Hello JUG!"));

        add(new Paragraph("Some text here"));

        // Prompt: "Wstaw wykres średniej liczby uczestników warszawskiego jug-u w
        // zeszłym roku"
        Chart chart = new Chart(ChartType.COLUMN);
        Configuration conf = chart.getConfiguration();
        conf.setTitle("Średnia liczba uczestników warszawskiego JUG-u w zeszłym roku");

        DataSeries series = new DataSeries();
        series.add(new DataSeriesItem("Styczeń", 50));
        series.add(new DataSeriesItem("Luty", 60));
        series.add(new DataSeriesItem("Marzec", 55));
        series.add(new DataSeriesItem("Kwiecień", 70));
        series.add(new DataSeriesItem("Maj", 65));
        series.add(new DataSeriesItem("Czerwiec", 75));
        series.add(new DataSeriesItem("Lipiec", 80));
        series.add(new DataSeriesItem("Sierpień", 85));
        series.add(new DataSeriesItem("Wrzesień", 90));
        series.add(new DataSeriesItem("Październik", 95));
        series.add(new DataSeriesItem("Listopad", 100));
        series.add(new DataSeriesItem("Grudzień", 110));

        conf.addSeries(series);
        add(chart);
    }

}
