package aiwd.util;

import aiwd.gui.BoxChartPanel;
import aiwd.gui.CustomChartPanel;

public enum ChartType {

    BOX_CHART(" Box Chart", BoxChartPanel.getInstance());

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
