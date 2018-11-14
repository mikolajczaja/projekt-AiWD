package aiwd.gui.chart;

import aiwd.data.DataRowHolder;
import aiwd.model.DataRow;
import aiwd.util.GuiConstants;
import org.apache.commons.lang3.StringUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.util.List;

public class ValueBarChartPanel implements CustomChartPanel {

    private static ValueBarChartPanel instance;

    private ValueBarChartPanel() {
    }

    public static ValueBarChartPanel getInstance() {
        if (instance == null) {
            instance = new ValueBarChartPanel();
        }
        return instance;
    }

    public ChartPanel createNewChartPanel(String chartTitle, String... columnFieldNames) {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for(DataRow singleRow:DataRowHolder.getInstance().getDataRowList()){
            Object fieldValue = DataRowHolder.getInstance().getValueByFieldName(columnFieldNames[0], singleRow);
            if(fieldValue instanceof List){
                for(Double d:(List<Double>) fieldValue){
                    dataset.addValue(d, StringUtils.EMPTY, singleRow.getId());
                }
            } else {
                dataset.addValue((Double) fieldValue, StringUtils.EMPTY, singleRow.getId());
            }
        }

        final JFreeChart chart = ChartFactory.createBarChart(chartTitle, StringUtils.capitalize(columnFieldNames[0]),
        GuiConstants.BOX_CHART_Y_AXIS_LABEL, dataset, PlotOrientation.VERTICAL, false, false, false);

        return new ChartPanel(chart);
    }

}
