package jiwang;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


//ͼ�λ���ͳ��
public class newChart1 extends javax.swing.JDialog {
	private JPanel jPanel1;
	private JPanel jPanel2;
	private JLabel jLabel1;
	private JPanel jPanel3;

	/**
	* Auto-generated main method to display this JDialog
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				newChart1 inst = new newChart1(frame);
				inst.setVisible(true);
			}
		});
	}
	
	public newChart1(JFrame frame) {
		super(frame);
		initGUI();
		this.setLocationRelativeTo(null);
	}
	
	private void initGUI() {
		//�������ӻ���ҲҪ����ģʽ�����ͬ���ݰ�Ŷ
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		if(JFrameMain.flag==0) {
			dataset.addValue(newCount.cAll, "�ܼ�", "����");
			dataset.addValue(newCount.ctcp, "TCP", "����");
			dataset.addValue(newCount.cudp, "UDP", "����");
			dataset.addValue(newCount.cTaobao, "�Ա�", "����");
			dataset.addValue(newCount.cJindong, "����", "����");
			dataset.addValue(newCount.cQQ, "QQ", "����");
		}
		if(JFrameMain.flag==1) {
			dataset.addValue(newCount.cAll, "�ܼ�", "����");
			dataset.addValue(newCount.ctcp, "TCP", "����");
			dataset.addValue(newCount.cudp, "UDP", "����");
			dataset.addValue(newCount.cTaobao, "�Ա�", "����");
		}
		if(JFrameMain.flag==2) {
			dataset.addValue(newCount.cAll, "�ܼ�", "����");
			dataset.addValue(newCount.ctcp, "TCP", "����");
			dataset.addValue(newCount.cudp, "UDP", "����");
			dataset.addValue(newCount.cJindong, "����", "����");

		}
		if(JFrameMain.flag==3) {
			dataset.addValue(newCount.cAll, "�ܼ�", "����");
			dataset.addValue(newCount.ctcp, "TCP", "����");
			dataset.addValue(newCount.cudp, "UDP", "����");

			dataset.addValue(newCount.cQQ, "QQ", "����");
		}
		if(JFrameMain.flag==4) {
			dataset.addValue(newCount.cAll, "�ܼ�", "����");
			dataset.addValue(newCount.ctcp, "TCP", "����");
			dataset.addValue(newCount.cudp, "UDP", "����");
			dataset.addValue(newCount.cUR, "�Զ������", "����");
		}
		JFreeChart barChart = ChartFactory.createBarChart("���ݰ�ͳ�ƽ��", "���ݰ�����", "����(��)", dataset,
				PlotOrientation.HORIZONTAL, true, true, false);
		//�������ӻ���Ҫ����ģʽ�����ͬ���ݰ�
		DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
		if(JFrameMain.flag==0) {
			dataset1.addValue(newCount.dAll, "�ܼ�", "����");
			dataset1.addValue(newCount.dtcp, "TCP", "����");
			dataset1.addValue(newCount.dudp, "UDP", "����");
			dataset1.addValue(newCount.dTaobao, "�Ա�", "����");
			dataset1.addValue(newCount.dJindong, "����", "����");
			dataset1.addValue(newCount.dQQ, "QQ", "����");
		}
		if(JFrameMain.flag==1) {
			dataset1.addValue(newCount.dAll, "�ܼ�", "����");
			dataset1.addValue(newCount.dtcp, "TCP", "����");
			dataset1.addValue(newCount.dudp, "UDP", "����");
			dataset1.addValue(newCount.dTaobao, "�Ա�", "����");
		}
		if(JFrameMain.flag==2) {
			dataset1.addValue(newCount.dAll, "�ܼ�", "����");
			dataset1.addValue(newCount.dtcp, "TCP", "����");
			dataset1.addValue(newCount.dudp, "UDP", "����");
			dataset1.addValue(newCount.dJindong, "����", "����");
		}
		if(JFrameMain.flag==3) {
			dataset1.addValue(newCount.dAll, "�ܼ�", "����");
			dataset1.addValue(newCount.dtcp, "TCP", "����");
			dataset1.addValue(newCount.dudp, "UDP", "����");
			dataset1.addValue(newCount.dQQ, "QQ", "����");
		}
		if(JFrameMain.flag==4) {
			dataset1.addValue(newCount.dAll, "�ܼ�", "����");
			dataset1.addValue(newCount.dtcp, "TCP", "����");
			dataset1.addValue(newCount.dudp, "UDP", "����");
			dataset1.addValue(newCount.dUR, "�Զ������", "����");
		}
		JFreeChart barChart1 = ChartFactory.createBarChart("����ͳ�ƽ��", "���ݰ�����", "����(MB)", dataset1,
				PlotOrientation.HORIZONTAL, true, true, false);
		
		try {
			{
				BorderLayout thisLayout = new BorderLayout();
				getContentPane().setLayout(thisLayout);
				{
					jPanel1 = new JPanel();
					getContentPane().add(jPanel1, BorderLayout.NORTH);
					jPanel1.setPreferredSize(new java.awt.Dimension(384, 66));
					jPanel1.setLayout(null);
					{
						jLabel1 = new JLabel();
						jPanel1.add(jLabel1);
						jLabel1.setText("\u7ed3\u679c\u56fe\u8868\u663e\u793a");
						jLabel1.setBounds(159, 12, 81, 42);
					}
				}
				{
					//�������Ǹ����
					jPanel2 = new JPanel();
					getContentPane().add(jPanel2);
					jPanel2.setPreferredSize(new java.awt.Dimension(358, 97));
					{
						ChartPanel myChart1 = new ChartPanel(barChart);
						jPanel2.add(myChart1);
						myChart1.setPreferredSize(new java.awt.Dimension(386, 173));
					}
				}
				{
					//�м������ʾ
					jPanel3 = new JPanel();
					getContentPane().add(jPanel3, BorderLayout.SOUTH);
					jPanel3.setPreferredSize(new java.awt.Dimension(384, 178));
					{
						ChartPanel myChart = new ChartPanel(barChart1);
						jPanel3.add(myChart);
						myChart.setPreferredSize(new java.awt.Dimension(386, 173));
					}
				}
				{
					
				}
			}
			this.setSize(400, 459);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
