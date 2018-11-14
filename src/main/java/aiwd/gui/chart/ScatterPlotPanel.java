package aiwd.gui.chart;

import aiwd.data.DataRowHolder;
import aiwd.model.DataRow;
import org.apache.commons.lang3.StringUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.function.LineFunction2D;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.statistics.Regression;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;
import java.util.List;

public class ScatterPlotPanel implements CustomChartPanel {

    private static ScatterPlotPanel instance;

    private ScatterPlotPanel() {
    }

    public static ScatterPlotPanel getInstance() {
        if (instance == null) {
            instance = new ScatterPlotPanel();
        }
        return instance;
    }

    public ChartPanel createNewChartPanel(String chartTitle, String... columnFieldNames) {

        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries series = new XYSeries("series");
        XYSeriesCollection regressionDataset = new XYSeriesCollection();
        XYSeries regressionSeries = new XYSeries("regressionSeries");

        for (DataRow dataRow : DataRowHolder.getInstance().getDataRowList()) {
            Object xDatasetValue = DataRowHolder.getInstance().getValueByFieldName(columnFieldNames[0], dataRow);
            Object yDatasetValue = DataRowHolder.getInstance().getValueByFieldName(columnFieldNames[1], dataRow);

            if ((xDatasetValue instanceof List) && (yDatasetValue instanceof Double)) {
                for (Double d : (List<Double>) xDatasetValue) {
                    series.add(d, (Number) yDatasetValue);
                    regressionSeries.add(d, (Number) yDatasetValue);
                }
            }
            if ((xDatasetValue instanceof Double) && (yDatasetValue instanceof List)) {
                for (Double d : (List<Double>) yDatasetValue) {
                    series.add((Number) xDatasetValue, d);
                    regressionSeries.add((Number) xDatasetValue, d);
                }
            }
            if ((xDatasetValue instanceof Double) && (yDatasetValue instanceof Double)) {
                series.add((double) xDatasetValue, (double) yDatasetValue);
                regressionSeries.add((double) xDatasetValue, (double) yDatasetValue);
            }
            if ((xDatasetValue instanceof List) && (yDatasetValue instanceof List)) {
                if (((List<Double>) xDatasetValue).size() > ((List<Double>) yDatasetValue).size()) {
                    for (Double dX : (List<Double>) xDatasetValue) {
                        for (Double dY : (List<Double>) yDatasetValue) {
                            series.add(dX, dY);
                            regressionSeries.add(dX, dY);
                        }
                    }
                }
            }

        }
        dataset.addSeries(series);
        regressionDataset.addSeries(regressionSeries);

        final JFreeChart chart = ChartFactory.createScatterPlot(chartTitle, StringUtils.capitalize(columnFieldNames[0]),
                StringUtils.capitalize(columnFieldNames[1]), dataset, PlotOrientation.VERTICAL, false, false, false);

        double[] regression = Regression.getOLSRegression(regressionDataset, 0);
        LineFunction2D linefunction2d = new LineFunction2D(regression[0], regression[1]);

        XYDataset regressionLineDataset = DatasetUtilities.sampleFunction2D(linefunction2d, 0D, 300, 100, "Regression");
        XYPlot xyplot = chart.getXYPlot();
        xyplot.setDataset(1, regressionLineDataset);
        XYLineAndShapeRenderer xylineandshaperenderer = new XYLineAndShapeRenderer(true, false);
        xylineandshaperenderer.setSeriesPaint(0, Color.BLUE);
        xyplot.setRenderer(1, xylineandshaperenderer);
        return new ChartPanel(chart);
    }

}
