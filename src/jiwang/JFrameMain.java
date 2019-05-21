package jiwang;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JSeparator;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

//import netcap.*;
import jpcap.*;
import jpcap.packet.*;
import java.util.*;
import java.sql.Timestamp;

//�������Ҫui+ip��ַ���˹���
public class JFrameMain extends javax.swing.JFrame implements ActionListener {

	private JMenuItem exitMenuItem;
	private JSeparator jSeparator2;
	
	private JMenuItem stopMenuItem;
	private JMenuItem startMenuItem;
	private JMenu Menu;
	private JMenuBar jMenuBar1;
	private JMenuItem newJD;
	private JMenuItem newQQ;
	private JMenuItem newTB;
	private JMenuItem newUR;
	private JMenuItem newAnalysis;
	private JMenuItem newChart;
	public static int flag=0;//���Ƴ���ִ��ģʽ
	JTable tabledisplay = null;
	Vector rows, columns;
	DefaultTableModel tabModel;
	JScrollPane scrollPane;
	JLabel statusLabel;

	Netcaptor captor = new Netcaptor();

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		JFrameMain inst = new JFrameMain();
		inst.setVisible(true);
		
		////////////////////////////////////////////
		//��ʼ�����������txt��·��������˵��·��������Ѽ
		File TB = new File("TB.txt");
		rule.read(TB, rule.TBA);
		File JD = new File("JD.txt");
		rule.read(JD, rule.JDA);
		File QQ = new File("QQ.txt");
		rule.read(QQ, rule.QQA);
		File UR = new File("USERRULE.txt");
		////////////////////////////////////////
		
		
		
		rule.read(UR, rule.UA);
	}

	public JFrameMain() {
		super("һ�����������ͳ����");
		initGUI();
		
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//��֤ͨ�����Ͻ��˳������Ҳ�����
	}

	private void initGUI() {
		try {
			setSize(800, 600);
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				{
				
					//���ò˵�
					Menu = new JMenu();
					jMenuBar1.add(Menu);
					Menu.setText("�˵�");
					Menu.setPreferredSize(new java.awt.Dimension(35, 21));
					{
						startMenuItem = new JMenuItem();
						Menu.add(startMenuItem);
						startMenuItem.setText("�Ǹ�����ץ");
						startMenuItem.setActionCommand("start");
						startMenuItem.addActionListener(this);
					}
					{
						stopMenuItem = new JMenuItem();
						Menu.add(stopMenuItem);
						stopMenuItem.setText("ֹͣ");
						stopMenuItem.setActionCommand("stop");
						stopMenuItem.addActionListener(this);
					}
					{
						newAnalysis = new JMenuItem();
						Menu.add(newAnalysis);
						newAnalysis.setText("���ͳ��");
						newAnalysis.setActionCommand("newanalysis");
						newAnalysis.addActionListener(this);
					}
					//10-10 new add.
					{
						newChart=new JMenuItem();
						Menu.add(newChart);
						newChart.setText("ͼ����ʾ");
						newChart.setActionCommand("newchart");
						newChart.addActionListener(this);
					}
					{
						newTB=new JMenuItem();
						Menu.add(newTB);
						newTB.setText("ֻץ�Ա���");
						newTB.setActionCommand("TB");
						newTB.addActionListener(this);
					}
					{
						newJD=new JMenuItem();
						Menu.add(newJD);
						newJD.setText("ֻץ������");
						newJD.setActionCommand("JD");
						newJD.addActionListener(this);
					}
					{
						newQQ=new JMenuItem();
						Menu.add(newQQ);
						newQQ.setText("ֻץQQ��");
						newQQ.setActionCommand("QQ");
						newQQ.addActionListener(this);
					}
					{
						newUR=new JMenuItem();
						Menu.add(newUR);
						newUR.setText("�Զ������ץ��");
						newUR.setActionCommand("userrule");
						newUR.addActionListener(this);
					}
					{
						jSeparator2 = new JSeparator();
						Menu.add(jSeparator2);
					}
					{
						exitMenuItem = new JMenuItem();
						Menu.add(exitMenuItem);
						exitMenuItem.setText("��������");
						exitMenuItem.setActionCommand("exit");
						exitMenuItem.addActionListener(this);
					}
					
				}
			}

			rows = new Vector();
			columns = new Vector();

			columns.addElement("���ݱ�ʱ��");
			columns.addElement("ԴIP��ַ");
			columns.addElement("Ŀ��IP��ַ");
			columns.addElement("�ײ�����");
			columns.addElement("���ݳ���");
			columns.addElement("�Ƿ�ֶ�");
			columns.addElement("�ֶ�ƫ����");
			columns.addElement("�ײ�����");
			columns.addElement("��������");

			tabModel = new DefaultTableModel();
			tabModel.setDataVector(rows, columns);
			tabledisplay = new JTable(tabModel);

			statusLabel = new JLabel("");
			this.getContentPane().add(statusLabel, BorderLayout.SOUTH);
			{
				getContentPane().add(new JScrollPane(tabledisplay), BorderLayout.CENTER);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent event) {//�˵���ÿ���Ĺ���ʵ�֣�����Ͳ˵�һ��
		String cmd = event.getActionCommand();
		if (cmd.equals("start")) {
			flag=0;
			captor.capturePacketsFromDevice();
			captor.setJFrame(this);
		} else if (cmd.equals("stop")) {
			captor.stopCapture();
		} else if (cmd.equals("exit")) {
			System.exit(0);
		}else if(cmd.equals("newanalysis")) {
			new newCount(this).setVisible(true);
		}else if(cmd.equals("TB")) {
			flag=1;
			captor.capturePacketsFromDevice();
			captor.setJFrame(this);
		}else if(cmd.equals("JD")) {
			flag=2;
			captor.capturePacketsFromDevice();
			captor.setJFrame(this);
		}else if(cmd.equals("QQ")) {
			flag=3;
			captor.capturePacketsFromDevice();
			captor.setJFrame(this);
		}else if(cmd.equals("userrule")) {
			flag=4;
			captor.capturePacketsFromDevice();
			captor.setJFrame(this);
		}else if(cmd.equals("newchart")) {
			new  newChart1(this).setVisible(true);
		}
	}
	
	@SuppressWarnings("unchecked")
	public void dealPacket(Packet packet) {
		try {
			Vector r = new Vector();
			String strtmp;
			Timestamp timestamp = new Timestamp((packet.sec * 1000) + (packet.usec / 1000));
			if(flag==0||(flag==2&&rule.iprule(rule.JDA, packet)==1)||(flag==1&&rule.iprule(rule.TBA, packet)==1)||(flag==3&&rule.iprule(rule.QQA, packet)==1)||(flag==4&&rule.iprule(rule.UA, packet)==1)) {
			r.addElement(timestamp.toString()); // ���ݱ�ʱ��
			r.addElement(((IPPacket) packet).src_ip.toString()); // ԴIP��ַ
			r.addElement(((IPPacket) packet).dst_ip.toString()); // Ŀ��IP��ַ
			//tb,qq,jd	
			
			if(rule.iprule(rule.TBA, packet)==1) {
				newCount.cTaobao++;
				newCount.dTaobao+=(double)packet.len/1024;
			}if(rule.iprule(rule.JDA, packet)==1) {
				newCount.cJindong++;
				newCount.dJindong+=(double)packet.len/1024;
			}if(rule.iprule(rule.QQA, packet)==1) {
				newCount.cQQ++;
				newCount.dQQ+=(double)packet.len/1024;
			}
			if(flag==4&&rule.iprule(rule.UA, packet)==1) {
				newCount.cUR++;
				newCount.dUR+=(double)packet.len/1024;
			}
			
			
			
				r.addElement(packet.header.length); // �ײ�����
				r.addElement(packet.data.length); // ���ݳ���
				r.addElement(((IPPacket) packet).dont_frag == true ? "�ֶ�" : "���ֶ�"); // �Ƿ񲻷ֶ�
				r.addElement(((IPPacket) packet).offset); // ���ݳ���
				strtmp = "";
				for (int i = 0; i < packet.header.length; i++) {
					strtmp += Byte.toString(packet.header[i]);
				}
				r.addElement(strtmp); // �ײ�����

				strtmp = "";
				for (int i = 0; i < packet.data.length; i++) {
					strtmp += Byte.toString(packet.data[i]);
				}
				r.addElement(strtmp); // ��������
				rows.addElement(r);
				tabledisplay.addNotify();
			}

		} catch (Exception e) {

		}
	}
}