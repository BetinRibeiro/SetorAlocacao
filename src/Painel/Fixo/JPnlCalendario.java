package Painel.Fixo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.SystemColor;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Calendar;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;




public class JPnlCalendario extends JPanel {
	
	
	public JPnlCalendario() {
	
		setBorder((Border) new LineBorder(new Color(0, 0, 0)));
		setBounds(0, 0, 260, 190);
		setLayout(null);
	
	JCalendar calendario = new JCalendar();
	calendario.setSize(260, 190);
	calendario.setWeekOfYearVisible(false);
	add(calendario);
	
	
	
	Calendar calend = calendario.getCalendar();
	
	
	JPanel painel = new JPanel();
	painel.setVisible(true);
	add(painel);
	
	}

}
