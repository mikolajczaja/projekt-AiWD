package aiwd.gui.chart;

import org.jfree.chart.ChartPanel;

public interface CustomChartPanel {

    ChartPanel createNewChartPanel(String chartTitle, String... columnFieldNames);
}
