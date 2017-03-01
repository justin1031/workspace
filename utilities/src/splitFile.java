import java.io.*;

public class splitFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		if (args.length<3)
		{
			System.out.println("Userage: readFile <path of source file> <path of dest1 file> <path of dest2 file>");
			System.exit(0);
		}	
		

        String source = args[0];
        String dest1 = args[1];
        String dest2 = args[2];
        
        try {
        File fin = new File(source);
        FileInputStream fis = new FileInputStream(fin);
        BufferedReader in = new BufferedReader(new InputStreamReader(fis));

        FileWriter fstream1 = new FileWriter(dest1, true);
        BufferedWriter out1 = new BufferedWriter(fstream1);
        
        FileWriter fstream2 = new FileWriter(dest2, true);
        BufferedWriter out2 = new BufferedWriter(fstream2);

        String aLine = null;
        int ln = 1;
        while ((aLine = in.readLine()) != null) {
            //Process each line and add output to Dest.txt file
           if ((ln % 2)==0 ) {
        	out1.write(aLine);
            out1.newLine();
           }else {
            out2.write(aLine);
            out2.newLine();
            }
            ln++;
        }

        // do not forget to close the buffer reader
        in.close();

        // close buffer writer
        out1.close();
        out2.close();
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
		
	}

}
