package aiwd.gui;

import aiwd.data.DataRowHolder;
import aiwd.util.ChartType;
import aiwd.util.GuiConstants;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainGuiWindow extends JFrame {

    public MainGuiWindow() {
        JFrame frame = new JFrame(GuiConstants.MAIN_FRAME_NAME);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();

        String[] comboBoxLabels = DataRowHolder.getInstance().getAllFieldNames();
        JComboBox columnNameComboBox = new JComboBox(comboBoxLabels);
        columnNameComboBox.setSelectedIndex(0);
        columnNameComboBox.setSize(200, 50);
        columnNameComboBox.setLocation(20, 20);
        mainPanel.add(columnNameComboBox);


        JButton generateBoxChartButton = new JButton(GuiConstants.GENERATE_BOX_CHART_BUTTON_LABEL);
        generateBoxChartButton.setSize(200, 50);
        generateBoxChartButton.setLocation(20, 120);
        generateBoxChartButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                new ChartWindow(ChartType.BOX_CHART, (String) columnNameComboBox.getSelectedItem());
            }
        });
        mainPanel.add(generateBoxChartButton);


        frame.add(mainPanel);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
