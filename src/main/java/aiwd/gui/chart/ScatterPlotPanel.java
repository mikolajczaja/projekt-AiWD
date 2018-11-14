package aiwd.gui.chart;

import aiwd.data.DataRowHolder;
import aiwd.model.DataRow;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.statistics.Regression;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

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
        XYSeries series = new XYSeries("series1");

        for (DataRow dataRow : DataRowHolder.getInstance().getDataRowList()) {
            Object xDatasetValue = DataRowHolder.getInstance().getValueByFieldName(columnFieldNames[0], dataRow);
            Object yDatasetValue = DataRowHolder.getInstance().getValueByFieldName(columnFieldNames[1], dataRow);
           // Regression.getOLSRegression()
            if ((xDatasetValue instanceof List) && (yDatasetValue instanceof Double)) {
                for (Double d : (List<Double>) xDatasetValue) {
                    series.add(d, (Number) yDatasetValue);
                }
            }
            if ((xDatasetValue instanceof Double) && (yDatasetValue instanceof List)) {
                for (Double d : (List<Double>) yDatasetValue) {
                    series.add((Number) xDatasetValue, d);
                }
            }
            if ((xDatasetValue instanceof Double) && (yDatasetValue instanceof Double)) {
                series.add((double) xDatasetValue, (double) yDatasetValue);
            }
            if ((xDatasetValue instanceof List) && (yDatasetValue instanceof List)) {
                if (((List<Double>) xDatasetValue).size() > ((List<Double>) yDatasetValue).size()) {
                    for (Double dX : (List<Double>) xDatasetValue) {
                        for (Double dY : (List<Double>) yDatasetValue) {
                            series.add(dX, dY);
                        }
                    }
                }
            }

        }
        dataset.addSeries(series);

        final JFreeChart chart = ChartFactory.createScatterPlot(chartTitle, StringUtils.capitalize(columnFieldNames[0]),
                StringUtils.capitalize(columnFieldNames[1]), dataset, PlotOrientation.VERTICAL, false, false, false);

        return new ChartPanel(chart);
    }

}
