package bensoussan.inclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RunCmd {

	public static void main(String arg[]) {

		Runtime rt = Runtime.getRuntime();
		try {

			Process p1 = rt.exec("java -cp ./bin bensoussan.network.Client");
			InputStream in = p1.getErrorStream();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
