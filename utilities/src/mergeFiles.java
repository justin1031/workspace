import java.io.*;

public class mergeFiles {

	/**
	 * @param args
	 */
	public static void main(String[] args) {


		if (args.length < 3) {
			System.out
					.println("Userage: readFile <path of source 1 file> <path of source 2 file> <path of dest file>");
			System.exit(0);
		}


		String source1 = args[0];
		String source2 = args[1];
		String dest = args[2];

		try {
			File fin1 = new File(source1);
			File fin2 = new File(source2);
			FileInputStream fis1 = new FileInputStream(fin1);
			BufferedReader in1 = new BufferedReader(new InputStreamReader(fis1));

			FileInputStream fis2 = new FileInputStream(fin2);
			BufferedReader in2 = new BufferedReader(new InputStreamReader(fis2));

			FileWriter fstream = new FileWriter(dest, true);
			BufferedWriter out = new BufferedWriter(fstream);

			String aLine1 = null;
			String aLine2 = null;

			if (in1.read() != -1 || in2.read() != -1) {

				while ((aLine1 = in1.readLine()) != null
						|| (aLine2 = in2.readLine()) != null) {
					// Process each line and add output to Dest.txt file

					aLine2 = in2.readLine();

					if (aLine1 != null && aLine2 != null) {
						out.write(aLine1);
						out.newLine();
						out.write(aLine2);
						out.newLine();
					} else if (aLine1 == null && aLine2 != null) {
						out.write(aLine2);
						out.newLine();
					} else if (aLine2 == null && aLine1 != null) {
						out.write(aLine1);
						out.newLine();
					}

				}
			}
			// do not forget to close the buffer reader
			in1.close();
			in2.close();

			// close buffer writer
			out.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
