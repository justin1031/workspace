package utilities;

import java.io.*;
import java.math.*;

//import com.ibm.gsk.ikeyman.util.KeymanSettings.Setting;

public class regUser {


	
	public static int getNumofDigits(int n){
		int num_digits=1;
		
		while((n=n/10)>=1)
		{
			num_digits++;			
		}	
		
		
		return num_digits;
	}

	public static String intToString (int i) {
		String temp = "";
		if (i < 10) {
			temp = "000" + i;
			System.out.println(temp);
		
		}if (i <100 && i >= 10){
			temp = "00"+ i;
			System.out.println(temp);
		}if (i <1000 && i >= 100){
			temp = "0" + i;
			System.out.println(temp);
		}if (i<10000 && i>= 1000){
			temp = new Integer(i).toString();
			System.out.println(temp);
		}
		
		return temp;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String userid = null;
		String passwd = null;
		String path = null;
		int init_user;
		int num_user;
		int num_digits;
		String tempnumber;  
		int tempint;
		
		FileOutputStream fout; 

		
		if (args.length<5)
		{
			System.out.println("Userage: regUser userid passwd path init_user num_user");
			System.exit(0);
		}	
		
		
		userid = args[0];
		passwd = args[1];
		path = args[2];
		init_user = Integer.parseInt(args[3]);
		num_user = Integer.parseInt(args[4]);
		num_digits = getNumofDigits(num_user);
		tempnumber = new String();
		
		try{
			//BufferedWriter out = new BufferedWriter(new FileWriter("regUser.txt"));
			
			fout = new FileOutputStream("regUser.txt");
			for(int i=init_user;i<(init_user + num_user+1);i++)
			{
				String pre0 = new String();
				for(int n_i=getNumofDigits(i);n_i<num_digits;n_i++)
				{
					pre0 = pre0 + "0";					
				}
				System.out.println(i);
				
				if (i < 10) {
					tempnumber = "000" + i;
					System.out.println(tempnumber);
				
				}if (i <100 && i >= 10){
					tempnumber = "00"+ i;
					System.out.println(tempnumber);
				}if (i <1000 && i >= 100){
					tempnumber = "0" + i;
					System.out.println(tempnumber);
				}if (i<10000 && i>= 1000){
					tempnumber = new Integer(i).toString();
					System.out.println(tempnumber);
				}
				
				tempnumber = intToString(i);
				
				StringBuffer buf = new StringBuffer();
//				buf.append(userid+pre0+i+";;;;"+passwd+";;;;"+path+";"+userid+pre0+i+".nsf;;;;;;" + userid+pre0+i +"@svl.ibm.com;"+userid+pre0+i+";;;mail85.ntf");
				buf.append("cosmos"+i+".col.eslabs.ibm.com");
				//buf.append("call dsadd user" + " \"cn=eDisco" + tempnumber + ",cn=Users,dc=domain414,dc=svl,dc=ibm,dc=com\"" + " -disabled no -fn eDisco" + tempnumber + " -display eDisco" + tempnumber + " -pwd Passw0rd1 -pwdneverexpires yes -memberof cn=EDISCOVERYUSERS,cn=Users,dc=domain414,dc=svl,dc=ibm,dc=com");
				//buf.append("call java TCreateUserICM_csdl NAME=eDM" + tempnumber + " DESCRIPTION=eDM" + tempnumber + " PRIVILEGESETCODE=EDMSUPERUSER GRANT=EDMSUPERUSER COLLCODE=1 OBJSERVERCODE=1 DFLITEMACLCODE=1 PASSWORD=win4ecm07 DOMAINNAME=EDISCOVERYUSERS PWDEXPIRE=0");
//				buf.append("EDMUser"+ tempnumber + "* OR ");
				//buf.append("EDCUser"+ tempnumber + "@domain4527.svl.ibm.com " + "OR " );
				//buf.append("<MANY> EDCUser"+ tempnumber + "@domain4527.svl.ibm.com <IN> icc_recipient_addresses " + "OR " );
				//buf.append(userid+pre0+i+";;;;"+passwd+";;;;"+path+";"+userid+pre0+i+".nsf;;;;;;;"+userid+pre0+i+";;;mail8.ntf");
				//buf.append(userid+pre0+i+";;;;"+passwd+";;;;;"+userid+pre0+i+".nsf;;;;;;;"+userid+pre0+i+";;;CHLTest.ntf");				
//				buf.append("<entry key=\"generator.mail." + tempnumber + ".address\">" + "EDMUser" + tempnumber + "@ibm</entry>");
				//buf.append("<entry key=\"generator.mail." + i + ".address\">" + "EDCUser" + tempnumber + "@domain4527.svl.ibm.com</entry>");
//				buf.append("\n");
//				buf.append("<entry key=\"generator.mail." + tempnumber + ".password\">win4ecm07</entry>");
				//buf.append("EDCUser" + tempnumber +",EDCUser"+ tempnumber +",EDCUser"+ tempnumber +"@domain4527.svl.ibm.com");
				
//				buf.append("EDCUser" + tempnumber + ",EDCUser" + tempnumber + ",EDCUser" + tempnumber + ",Engineer,EDCUser"+ tempnumber + "@domain4527.svl.ibm.com,win4ecm07,EDCUser" + tempnumber + ",Corporate,System Administrator|Corporate,PA Field 1,PA Field 2,PA Field 3,PA Field 4,PA Field 5,ACTIVE");
//				buf.append("EDMUser" + tempnumber + ",EDMUser" + tempnumber + ",EDMUser" + tempnumber + ",Engineer,EDMUser"+ tempnumber + ",win4ecm07,EDMUser" + tempnumber + ",Corporate,System Administrator|Corporate,PA Field 1,PA Field 2,PA Field 3,PA Field 4,PA Field 5,ACTIVE");

				//buf.append("EquivalenceClass1::"+(i-1)+",Case"+i);
				
//				buf.append("EquivalenceClass1::"+(i-3000)+",Case4"+",100MST,"+ "\"{\"\"stkn\"\":\"\"-7405076202386536812\"\",\"\"searchAction\"\":\"\"search\"\",\"\"searchFormType\"\":\"\"0\"\",\"\"doctype\"\":\"\"100MST\"\",\"\"panelName\"\":\"\"SEARCHFORMUNIQUEID\"\",\"\"searchTemplateID\"\":\"\"" + "{DBA3481E-D194-468F-85EF-38931C76F077}" + "\"\",\"\"SEARCHFORMUNIQUEID_searchType\"\":\"\"archive\"\",\"\"EMAIL_DATE_sort\"\":\"\"none\"\"" + ",\"\"SENDER_FIELD\"\":\"\"EDMUser"+tempnumber+"*"+"\"\"}\"");
				//buf.append("EquivalenceClass1::"+(i-1)+",CMPLD_200_Folders"+",CMPLD,"+ "\"{\"\"searchAction\"\":\"\"search\"\",\"\"searchFormType\"\":\"\"0\"\",\"\"doctype\"\":\"\"CMPLD\"\",\"\"panelName\"\":\"\"SEARCHFORMUNIQUEID\"\",\"\"searchTemplateID\"\":\"\"" + "{DBA3481E-D194-468F-85EF-38931C76F077}" + "\"\",\"\"SEARCHFORMUNIQUEID_searchType\"\":\"\"archive\"\",\"\"EMAIL_DATE_sort\"\":\"\"none\"\"" + ",\"\"SENDER_FIELD\"\":\"\"EDMUser"+tempnumber+"\"\"}\"");
				//buf.append("\"{\"\"searchAction\"\":\"\"search\"\",\"\"searchFormType\"\":\"\"0\"\",\"\"doctype\"\":\"\"MIXCMPEX\"\",\"\"panelName\"\":\"\"SEARCHFORMUNIQUEID\"\",\"\"searchTemplateID\"\":\"\"" + "{DBA3481E-D194-468F-85EF-38931C76F077}" + "\"\",\"\"SEARCHFORMUNIQUEID_searchType\"\":\"\"archive\"\",\"\"EMAIL_DATE_sort\"\":\"\"none\"\"" + ",\"\"SENDER_FIELD\"\":\"\"EDCUser"+tempnumber+"\"\"}\"");            
				//buf.append("\"{\"\"searchAction\"\":\"\"search\"\",\"\"searchFormType\"\":\"\"0\"\",\"\"doctype\"\":\"\"MIXCMPEX\"\",\"\"panelName\"\":\"\"SEARCHFORMUNIQUEID\"\",\"\"searchTemplateID\"\":\"\"" + "{DBA3481E-D194-468F-85EF-38931C76F077}" + "\"\",\"\"SEARCHFORMUNIQUEID_searchType\"\":\"\"archive\"\",\"\"EMAIL_DATE_sort\"\":\"\"none\"\"" + ",\"\"SENDER_FIELD\"\":\"\"EDCUser"+tempnumber+ "or EDCUser"+(tempnumber+1)+"\"\"}\"");
				
				//buf.append("{\"searchAction\":\"search\",\"searchFormType\":\"0\",\"doctype\":\"MIXCMPEX\",\"panelName\":\"SEARCHFORMUNIQUEID\",\"searchTemplateID\":\"{DBA3481E-D194-468F-85EF-38931C76F077}\",\"SEARCHFORMUNIQUEID_searchType\":\"archive\",\"EMAIL_DATE_sort\":\"none\",\"SENDER_FIELD\":\"EDCUser" +tempnumber + "\"}");
				//buf.append("\n");
				
				//buf.append("call C:\\IBM\\eDM\\bin\\raltool.bat -u edmadmin -p Passw0rd1 -a getcaseinfo -resetphasecount -c Case"+ i);
				//buf.append("call C:\\IBM\\eDM\\bin\\raltool.bat -u edmadmin -p Passw0rd1 -a restarttasks -ta AddToFolder -noprompt -c Case"+ i); 
				//buf.append("\n");
				//buf.append("call C:\\IBM\\eDM\\bin\\raltool.bat -u edmadmin -p Passw0rd1 -a restarttasks -ta AddToFolder -noprompt -ts STOPPED -c Case"+ i);
				//buf.append("call C:\\IBM\\eDM\\bin\\raltool.bat -u edmadmin -p Passw0rd1 -a resumetasks -ta Recurring -noprompt -ts stopped -c Case"+ i);
				//buf.append("call C:\\IBM\\eDM\\bin\\raltool.bat -u edmadmin -p Passw0rd1 -a updatetask -notincase false -noprompt -c Case"+ i);
				//P8 SS mix workload
				//buf.append("{\"searchAction\":\"search\",\"searchFormType\":\"0\",\"doctype\":\"MIXCMPEX\",\"panelName\":\"SEARCHFORMUNIQUEID\",\"searchTemplateID\":\"{DBA3481E-D194-468F-85EF-38931C76F077}\",\"SEARCHFORMUNIQUEID_searchType\":\"archive\",\"EMAIL_DATE_sort\":\"none\",\"SENDER_FIELD\":\"EDCUser" +tempnumber +" or EDCUser"+ intToString(i+56) +" or EDCUser"+ intToString(i+74)+" or EDCUser"+ intToString(i+92)+" or EDCUser"+ intToString(i+110)+" or EDCUser"+ intToString(i+128)+" or EDCUser"+ intToString(i+146)+" or EDCUser"+intToString(i+164)+" or EDCUser"+ intToString(i+182) +" or EDCUser"+ intToString(i+200)+" or EDCUser"+ intToString(i+218)+" or EDCUser"+ intToString(i+236)+" or EDCUser"+ intToString(i+254)+" or EDCUser"+ intToString(i+272)+" or EDCUser"+intToString(i+290)+" or EDCUser"+ intToString(i+308) +" or EDCUser"+ intToString(i+326)+" or EDCUser"+ intToString(i+344)+" or EDCUser"+ intToString(i+362)+" or EDCUser"+ intToString(i+380)+" or EDCUser"+ intToString(i+398)+" or EDCUser"+intToString(i+416)+" or EDCUser"+ intToString(i+434) +" or EDCUser"+ intToString(i+452)+" or EDCUser"+ intToString(i+470)+" or EDCUser"+ intToString(i+488)+" or EDCUser"+ intToString(i+506)+" or EDCUser"+ intToString(i+524)+" or EDCUser"+intToString(i+542)+"\"}");
				
				//CM SS mix workload
				//buf.append("{\"searchAction\":\"search\",\"searchFormType\":\"0\",\"doctype\":\"MIXCMPLD\",\"panelName\":\"SEARCHFORMUNIQUEID\",\"searchTemplateID\":\"{DBA3481E-D194-468F-85EF-38931C76F077}\",\"SEARCHFORMUNIQUEID_searchType\":\"archive\",\"EMAIL_DATE_sort\":\"none\",\"SENDER_FIELD\":\"EDMUser" +tempnumber +" or EDMUser"+ intToString(i+56) +" or EDMUser"+ intToString(i+74)+" or EDMUser"+ intToString(i+92)+" or EDMUser"+ intToString(i+110)+" or EDMUser"+ intToString(i+128)+" or EDMUser"+ intToString(i+146)+" or EDMUser"+intToString(i+164)+" or EDMUser"+ intToString(i+182) +" or EDMUser"+ intToString(i+200)+" or EDMUser"+ intToString(i+218)+" or EDMUser"+ intToString(i+236)+" or EDMUser"+ intToString(i+254)+" or EDMUser"+ intToString(i+272)+" or EDMUser"+intToString(i+290)+" or EDMUser"+ intToString(i+308) +" or EDMUser"+ intToString(i+326)+" or EDMUser"+ intToString(i+344)+" or EDMUser"+ intToString(i+362)+" or EDMUser"+ intToString(i+380)+" or EDMUser"+ intToString(i+398)+" or EDMUser"+intToString(i+416)+" or EDMUser"+ intToString(i+434) +" or EDMUser"+ intToString(i+452)+" or EDMUser"+ intToString(i+470)+" or EDMUser"+ intToString(i+488)+" or EDMUser"+ intToString(i+506)+" or EDMUser"+ intToString(i+524)+" or EDMUser"+intToString(i+543)+"\"}");
				
				new PrintStream(fout).println(buf.toString());
//				new PrintStream(fout).append(buf.toString());
			
			}
			
			fout.close();		
			
		}catch(IOException e){
			e.printStackTrace();
		}
		

	}

}
