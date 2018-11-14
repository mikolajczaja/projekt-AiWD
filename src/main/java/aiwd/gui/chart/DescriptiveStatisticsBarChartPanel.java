package aiwd.gui.chart;

import aiwd.data.ExecutionResult;
import aiwd.model.DescriptiveStatisticOfAttribute;
import aiwd.util.GuiConstants;
import org.apache.commons.lang3.StringUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class DescriptiveStatisticsBarChartPanel implements CustomChartPanel {

    private static DescriptiveStatisticsBarChartPanel instance;

    private DescriptiveStatisticsBarChartPanel() {
    }

    public static DescriptiveStatisticsBarChartPanel getInstance() {
        if (instance == null) {
            instance = new DescriptiveStatisticsBarChartPanel();
        }
        return instance;
    }

    public ChartPanel createNewChartPanel(String chartTitle, String... columnFieldNames) {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (DescriptiveStatisticOfAttribute singleRowStatistics : ExecutionResult.getInstance().getDescriptiveStatisticOfAttributes()) {
            if (singleRowStatistics.getAttributeName().equals(columnFieldNames[0])) {
                dataset.addValue((Double) singleRowStatistics.getAvgValue(), StringUtils.EMPTY, "avg");
                dataset.addValue((Double) singleRowStatistics.getInterquartileRange(), StringUtils.EMPTY, "interQ range");
                dataset.addValue((Double) singleRowStatistics.getMaxValue(), StringUtils.EMPTY, "max");
                dataset.addValue((Double) singleRowStatistics.getMinValue(), StringUtils.EMPTY, "min");
                dataset.addValue((Double) singleRowStatistics.getMedian(), StringUtils.EMPTY, "median");
                dataset.addValue((Double) singleRowStatistics.getQuantile10(), StringUtils.EMPTY, "Q10");
                dataset.addValue((Double) singleRowStatistics.getQuantile90(), StringUtils.EMPTY, "Q90");
                dataset.addValue((Double) singleRowStatistics.getStandardDeviation(), StringUtils.EMPTY, "std Deviation");

                if (singleRowStatistics.getOutliers() != null) {
                    for (Object outlier : singleRowStatistics.getOutliers()) {
                        dataset.addValue((Double) outlier, StringUtils.EMPTY, "outlier");
                    }
                }
            }
        }

        final JFreeChart chart = ChartFactory.createBarChart(chartTitle, StringUtils.capitalize(columnFieldNames[0]),
                GuiConstants.BOX_CHART_Y_AXIS_LABEL, dataset, PlotOrientation.VERTICAL, false, false, false);

        return new ChartPanel(chart);
    }

}
