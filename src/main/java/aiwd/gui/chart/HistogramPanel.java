package aiwd.gui.chart;

import aiwd.data.DataRowHolder;
import aiwd.util.GuiConstants;
import org.apache.commons.lang3.StringUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.statistics.HistogramDataset;

import java.util.List;

public class HistogramPanel implements CustomChartPanel {

    private static HistogramPanel instance;

    private HistogramPanel() {
    }

    public static HistogramPanel getInstance() {
        if (instance == null) {
            instance = new HistogramPanel();
        }
        return instance;
    }

    public ChartPanel createNewChartPanel(String chartTitle, String... columnFieldNames){

        HistogramDataset dataset = new HistogramDataset();
        List<Double> doubleList = DataRowHolder.getInstance()
                .getAllParsableToDoubleColumnDataFieldsSortedByColumnNames().get(columnFieldNames[0]);
        double[] primitiveDoubleArray = doubleList.stream().mapToDouble(Double::doubleValue).toArray();

        if (primitiveDoubleArray.length > 0) {
            dataset.addSeries(columnFieldNames[0], primitiveDoubleArray, doubleList.size() * 10);
        }
        final JFreeChart chart = ChartFactory.createHistogram(chartTitle, StringUtils.capitalize(columnFieldNames[0]),
                GuiConstants.HISTOGRAM_Y_AXIS_LABEL, dataset, PlotOrientation.VERTICAL, false, false, false);

        return new ChartPanel(chart);
    }
}
