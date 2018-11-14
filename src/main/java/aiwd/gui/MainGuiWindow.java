package aiwd.gui;

import aiwd.data.DataRowHolder;
import aiwd.util.ChartType;
import aiwd.util.GuiConstants;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainGuiWindow extends JFrame {

    private static final int WINDOW_WIDTH = 500;
    private static final int WINDOW_HEIGHT = 500;

    public MainGuiWindow() {
        JFrame frame = new JFrame(GuiConstants.MAIN_FRAME_NAME);
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();

        String[] comboBoxLabels = DataRowHolder.getInstance().getAllFieldNamesExceptBooleanAndStringFields();
        JComboBox xAxiscolumnNameComboBox = new JComboBox(comboBoxLabels);
        xAxiscolumnNameComboBox.setSelectedIndex(0);
        xAxiscolumnNameComboBox.setSize(200, 50);
        xAxiscolumnNameComboBox.setLocation(20, 50);
        mainPanel.add(xAxiscolumnNameComboBox);

        JComboBox yAxiscolumnNameComboBox = new JComboBox(comboBoxLabels);
        yAxiscolumnNameComboBox.setSelectedIndex(0);
        yAxiscolumnNameComboBox.setSize(200, 50);
        yAxiscolumnNameComboBox.setLocation(20, 350);
        mainPanel.add(yAxiscolumnNameComboBox);


        JButton generateBoxChartButton = new JButton(GuiConstants.GENERATE_BOX_CHART_BUTTON_LABEL);
        generateBoxChartButton.setSize(200, 50);
        generateBoxChartButton.setLocation(20, 150);
        generateBoxChartButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                new ChartWindow(ChartType.BOX_CHART, (String) xAxiscolumnNameComboBox.getSelectedItem());
            }
        });
        mainPanel.add(generateBoxChartButton);

        JButton generateHistogramButton = new JButton(GuiConstants.GENERATE_HISTOGRAM_BUTTON_LABEL);
        generateHistogramButton.setSize(200, 50);
        generateHistogramButton.setLocation(20, 200);
        generateHistogramButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                new ChartWindow(ChartType.HISTOGRAM, (String) xAxiscolumnNameComboBox.getSelectedItem());
            }
        });
        mainPanel.add(generateHistogramButton);

        JButton generateScatterPlotButton = new JButton(GuiConstants.GENERATE_SCATTER_PLOT_BUTTON_LABEL);
        generateScatterPlotButton.setSize(200, 50);
        generateScatterPlotButton.setLocation(20, 250);
        generateScatterPlotButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                new ChartWindow(ChartType.SCATTER_PLOT, (String) xAxiscolumnNameComboBox.getSelectedItem(), (String) yAxiscolumnNameComboBox.getSelectedItem());
            }
        });
        mainPanel.add(generateScatterPlotButton);

        JButton generateValueBarChartButton = new JButton(GuiConstants.GENERATE_VALUE_BAR_CHART_BUTTON_LABEL);
        generateValueBarChartButton.setSize(200, 50);
        generateValueBarChartButton.setLocation(20, 300);
        generateValueBarChartButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                new ChartWindow(ChartType.VALUE_BAR_CHART, (String) xAxiscolumnNameComboBox.getSelectedItem());
            }
        });
        mainPanel.add(generateValueBarChartButton);

        JButton generateDescriptiveStatisticsBarChartButton = new JButton(GuiConstants.GENERATE_DESCRIPTIVE_STATISTICS_BAR_CHART_BUTTON_LABEL);
        generateDescriptiveStatisticsBarChartButton.setSize(200, 50);
        generateDescriptiveStatisticsBarChartButton.setLocation(20, 350);
        generateDescriptiveStatisticsBarChartButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                new ChartWindow(ChartType.DESCRIPTIVE_STATISTICS_BAR_CHART, (String) xAxiscolumnNameComboBox.getSelectedItem());
            }
        });
        mainPanel.add(generateDescriptiveStatisticsBarChartButton);

        frame.add(mainPanel);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
