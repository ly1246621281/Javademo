package aaaa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;

public class WriterDemo {
public static void main(String[] args) {
	 try {
  	   File file=new File("D://webmagic//us-cert.txt");
  	   if(!file.exists())
			file.createNewFile();
  	   FileWriter  fw=new FileWriter(file, true);
  	   BufferedWriter bw=new BufferedWriter(fw);
  	   bw.write("zjamglao"+"\n"+"fdsf");
//  	   bw.write(vlubd.getId()+"/n"+vlubd.getVulnerability_ID()+"\n"+vlubd.getVulnerability_Name()+"\n"+vlubd.getVulnerability_Sender()+"\n"+
//  	   vlubd.getPublic_date()+"/n"+vlubd.getCVSS_Metrics()+"\n"+vlubd.getImpact()+"\n"+vlubd.getCVE_ID()+"\n"+vlubd.getDescription()+"\n"+
//  	   vlubd.getReferences()+"/n"+vlubd.getSolution()+"/n"+vlubd.getCredit()+"/n"+vlubd.getVendor_Information()+"/n"+
//  	   vlubd.getDate_First_Published()+"/n"+vlubd.getDate_Last_Updated()+"/n");
  	   bw.write("\n");
  	   bw.flush();
  	   BufferedReader br=new BufferedReader(new FileReader(file));
  	   //br.readLine();
  	   String c;StringBuffer buff;
  	   while((c=br.readLine())!=null){
  		   System.out.println(c);
  	   }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
