package jiwang;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import jpcap.packet.IPPacket;
import jpcap.packet.Packet;
//��txt�ж�ȡip����ip��ַƥ��
public class rule {

	public static String [] TBA = new String [50];
	public static String [] JDA = new String [50];
	public static String [] QQA = new String [50];
	public static String [] UA = new String [50];
    public static int read(File file,String[] a){//���ļ�
        try{
        	int i=0;
            BufferedReader br = new BufferedReader(new FileReader(file));//����һ��BufferedReader������ȡ�ļ�
            String s = null;
            while((s = br.readLine())!=null){//ʹ��readLine������һ�ζ�һ��
                a[i]=s;
                i++;
            }
            br.close();    
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    public static int iprule(String[] a,Packet packet){//ƥ��

    	for(int x=0;x<50;x++)
    	{
    		if(((IPPacket) packet).dst_ip.toString().equals(a[x])||((IPPacket) packet).src_ip.toString().equals(a[x]))
    		{
    			return 1;
    		}
    	}

        
        return 0;
    }
}
