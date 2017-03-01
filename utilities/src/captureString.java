import java.io.*;

public class captureString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		if (args.length < 2) {
			System.out.println("Userage: readFile <path of source 1 file> <path of dest file>");
			System.exit(0);
		}

		String source1 = args[0];
		// String source2 = args[1];
		String dest = args[1];

		try {
			File fin1 = new File(source1);
			// File fin2 = new File(source2);
			FileInputStream fis1 = new FileInputStream(fin1);
			BufferedReader in1 = new BufferedReader(new InputStreamReader(fis1));

			// FileInputStream fis2 = new FileInputStream(fin2);
			// BufferedReader in2 = new BufferedReader(new
			// InputStreamReader(fis2));

			FileWriter fstream = new FileWriter(dest, true);
			BufferedWriter out = new BufferedWriter(fstream);

			String aLine1 = null;
			// String aLine2 = null;
			String lastWord = null;

			// 1000 requests 1 document each
			// if (in1.read() != -1 ) {
			// int i = 0;
			// while ((aLine1 = in1.readLine()) != null) {
			// // Process each line and add output to Dest.txt file
			// lastWord = aLine1.substring(aLine1.lastIndexOf(" ")+1);
			// //aLine2 = in2.readLine();
			//
			// if (aLine1 != null) {
			// out.write("{\"holdsetid\": 20000" + i + ", \"entityids\":[" +
			// lastWord + "]},");
			// out.newLine();
			// //out.write(aLine2);
			// //out.newLine();
			// }
			// i++;
			// }
			// }

			// 4 requests with 250 document each
			// if (in1.read() != -1 ) {
			// int j = 0;
			// while ((aLine1 = in1.readLine()) != null) {
			// lastWord = aLine1.substring(aLine1.lastIndexOf(" ")+1);
			// out.write(lastWord + ", ");
			// j++;
			// if (j % 250 == 0)
			// out.newLine();
			// }
			// }

			// 8 requests with 125 document each
			if (in1.read() != -1) {
				int j = 0;
				while ((aLine1 = in1.readLine()) != null) {
					lastWord = aLine1.substring(aLine1.lastIndexOf(" ") + 1);
					out.write(lastWord + ", ");
					j++;
					if (j % 125 == 0)
						out.newLine();
				}
			}

			// 1 requests with 1000 documents
			// if (in1.read() != -1 ) {
			// while ((aLine1 = in1.readLine()) != null) {
			// lastWord = aLine1.substring(aLine1.lastIndexOf(" ")+1);
			// out.write(lastWord + ", ");
			// }
			// }

			// do not forget to close the buffer reader
			in1.close();
			// in2.close();

			// close buffer writer
			out.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
