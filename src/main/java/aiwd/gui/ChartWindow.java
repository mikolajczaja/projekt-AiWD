package aiwd.gui;

import aiwd.util.ChartType;
import aiwd.util.GuiConstants;

import javax.swing.*;

public class ChartWindow extends JFrame {

    public ChartWindow(ChartType chartType, String chartColumnFieldName) {
        String chartTitle = chartColumnFieldName + chartType.getDisplayName() + GuiConstants.WINDOW_SUFFIX;
        JFrame frame = new JFrame(chartTitle);

        frame.add(chartType.getChartPanel().createNewChartPanel(chartColumnFieldName,chartTitle));

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
