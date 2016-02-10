package com.vaadin.addon.charts.examples.declarative;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.declarative.ChartComponentMapper;
import com.vaadin.addon.charts.examples.AbstractVaadinChartExample;
import com.vaadin.addon.charts.model.TreeSeries;
import com.vaadin.addon.charts.model.TreeSeriesItem;
import com.vaadin.addon.charts.model.style.SolidColor;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.ui.Component;
import com.vaadin.ui.declarative.Design;

@DesignRoot(value="treemap_with_levels.html")
public class TreemapWithLevels extends AbstractVaadinChartExample {

    Chart myChart;

    @Override
    public String getDescription() {
        return "Tree map levels using declarative format";
    }

    @Override
    protected void setup() {
        Design.setComponentMapper(new ChartComponentMapper());
        Design.read(this);
        myChart.getConfiguration().addSeries(createSeries());
    }

    private TreeSeries createSeries() {
        TreeSeries series = new TreeSeries();

        TreeSeriesItem apples = new TreeSeriesItem("A", "Apples");
        apples.setColor(new SolidColor("#EC2500"));

        TreeSeriesItem bananas = new TreeSeriesItem("B", "Bananas");
        bananas.setColor(new SolidColor("#ECE100"));

        TreeSeriesItem oranges = new TreeSeriesItem("O", "Oranges");
        oranges.setColor(new SolidColor("#EC9800"));

        TreeSeriesItem anneA = new TreeSeriesItem("Anne", apples, 5);
        TreeSeriesItem rickA = new TreeSeriesItem("Rick", apples, 3);
        TreeSeriesItem peterA = new TreeSeriesItem("Peter", apples, 4);

        TreeSeriesItem anneB = new TreeSeriesItem("Anne", bananas, 4);
        TreeSeriesItem rickB = new TreeSeriesItem("Rick", bananas, 10);
        TreeSeriesItem peterB = new TreeSeriesItem("Peter", bananas, 1);

        TreeSeriesItem anneO = new TreeSeriesItem("Anne", oranges, 1);
        TreeSeriesItem rickO = new TreeSeriesItem("Rick", oranges, 3);
        TreeSeriesItem peterO = new TreeSeriesItem("Peter", oranges, 3);

        TreeSeriesItem susanne = new TreeSeriesItem("Susanne", 2);
        susanne.setParent("Kiwi");
        susanne.setColor(new SolidColor("#9EDE00"));

        series.addAll(apples, bananas, oranges, anneA, rickA, peterA, anneB,
            rickB, peterB, anneO, rickO, peterO, susanne);

        return series;
    }

    @Override
    protected Component getChart() {
        return null;
    }

}
