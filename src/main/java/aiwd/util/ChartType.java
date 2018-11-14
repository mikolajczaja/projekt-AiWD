package aiwd.util;

import aiwd.gui.chart.*;

public enum ChartType {

    BOX_CHART(" Box Chart", BoxChartPanel.getInstance()),
    HISTOGRAM(" Histogram", HistogramPanel.getInstance()),
    SCATTER_PLOT(" Scatter Plot", ScatterPlotPanel.getInstance()),
    VALUE_BAR_CHART(" Value Bar Chart", ValueBarChartPanel.getInstance()),
    DESCRIPTIVE_STATISTICS_BAR_CHART(" Descriptive Statistics Bar Chart", DescriptiveStatisticsBarChartPanel.getInstance());

    private final String displayName;
    private final CustomChartPanel chartPanel;

    ChartType(final String displayName, final CustomChartPanel chartPanel) {
        this.displayName = displayName;
        this.chartPanel = chartPanel;
    }

    public String getDisplayName() {
        return displayName;
    }

    public CustomChartPanel getChartPanel() {
        return chartPanel;
    }
}
