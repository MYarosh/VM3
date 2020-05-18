import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;

import static java.lang.Math.abs;

public class Graphic {
    public void draw(double a, double b, Equation func){
        XYSeries series = new XYSeries("2,335x^3+3,98x^2−4,52x−3,11");
        double d = abs(a-b)/1000;
        for(double x = a-abs(a+b)/5; x < b+abs(a+b)/5; x+=d){
            series.add(x, func.getEq(x));
        }

        XYDataset xyDataset = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory
                .createXYLineChart("y = 2,335x^3+3,98x^2−4,52x−3,11", "x", "y",
                        xyDataset,
                        PlotOrientation.VERTICAL,
                        true, true, true);
        JFrame frame =
                new JFrame("Graphic");
        // Помещаем график на фрейм
        frame.getContentPane()
                .add(new ChartPanel(chart));
        frame.setSize(400,300);
        frame.show();
    }
}
