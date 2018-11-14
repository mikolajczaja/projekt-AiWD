package aiwd.gui;

import aiwd.util.ChartType;
import aiwd.util.GuiConstants;

import javax.swing.*;

public class ChartWindow extends JFrame {

    public ChartWindow(ChartType chartType, String... chartColumnFieldNames) {
        String chartTitle = chartColumnFieldNames[0];
        if(chartColumnFieldNames.length>1){
            chartTitle=chartTitle+" to "+chartColumnFieldNames[1];
        }
        chartTitle=chartTitle + chartType.getDisplayName() + GuiConstants.WINDOW_SUFFIX;
        JFrame frame = new JFrame(chartTitle);

        frame.add(chartType.getChartPanel().createNewChartPanel(chartTitle,chartColumnFieldNames));

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
