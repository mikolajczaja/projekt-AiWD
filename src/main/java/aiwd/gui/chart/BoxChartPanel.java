package aiwd.gui.chart;

import aiwd.data.DataRowHolder;
import aiwd.util.GuiConstants;
import org.apache.commons.lang3.StringUtils;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.BoxAndWhiskerToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BoxAndWhiskerRenderer;
import org.jfree.data.statistics.DefaultBoxAndWhiskerCategoryDataset;

import java.awt.*;

public class BoxChartPanel implements CustomChartPanel {

    private static BoxChartPanel instance;

    private BoxChartPanel() {
    }

    public static BoxChartPanel getInstance() {
        if (instance == null) {
            instance = new BoxChartPanel();
        }
        return instance;
    }

    public ChartPanel createNewChartPanel(String chartTitle, String... columnFieldNames) {

        final CategoryAxis xAxis = new CategoryAxis(StringUtils.capitalize(columnFieldNames[0]));
        final NumberAxis yAxis = new NumberAxis(GuiConstants.BOX_CHART_Y_AXIS_LABEL);
        final BoxAndWhiskerRenderer renderer = new BoxAndWhiskerRenderer();

        renderer.setFillBox(false);
        renderer.setMaximumBarWidth(0.1);
        renderer.setMeanVisible(false);
        //renderer.setMedianVisible(false); //czarna kropka smierci
        renderer.setToolTipGenerator(new BoxAndWhiskerToolTipGenerator());

        DefaultBoxAndWhiskerCategoryDataset dataset = new DefaultBoxAndWhiskerCategoryDataset();
        dataset.add(DataRowHolder.getInstance().getAllColumnDataSortedByColumnNames().get(columnFieldNames[0]),
                StringUtils.EMPTY, StringUtils.EMPTY);


        final CategoryPlot plot = new CategoryPlot(dataset, xAxis, yAxis, renderer);
        final JFreeChart chart = new JFreeChart(chartTitle, new Font("SansSerif", Font.BOLD, 14), plot, false);

        return new ChartPanel(chart);
    }
}
