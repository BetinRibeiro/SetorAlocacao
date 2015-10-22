package Painel.Dinamico;

import java.util.List;

import javax.swing.JPanel;

import org.hibernate.engine.jndi.JndiException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


import javax.swing.border.LineBorder;

import java.awt.Color;

@SuppressWarnings("serial")
public class graficoDepoisDeletar extends JPanel {

	
	float efetivadas = 83;
	float total = 100;
	float pendencia = 10;
	float desmarcadas = total-efetivadas-pendencia;

	public graficoDepoisDeletar() {
		setForeground(new Color(255, 255, 255));

		setBounds(0, 0,  555, 240);

		DefaultCategoryDataset dataSet = new DefaultCategoryDataset();


		dataSet.setValue(total, "", "Total");
		dataSet.setValue(efetivadas, "", "Efetivadas");
		dataSet.setValue(pendencia, "", "Pendencia");
		dataSet.setValue(desmarcadas, "", "Desmarcadas");

		JFreeChart grafico = ChartFactory.createBarChart3D("Utimos 30 dias",
				"", "", dataSet, PlotOrientation.HORIZONTAL,
				false, false, false);
		setLayout(null);

		ChartPanel chartPanel = new ChartPanel(grafico);
		chartPanel.setBackground(new Color(240, 248, 255));
		grafico.setBackgroundPaint(new Color(240, 248, 255));
		
		chartPanel.setBounds(0, 0, 555, 240);

		add(chartPanel);

	}

}
