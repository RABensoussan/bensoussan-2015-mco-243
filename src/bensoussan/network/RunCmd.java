package bensoussan.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RunCmd {

	public static void main(String arg[]) {

		try {
			Runtime.getRuntime().exec(
					"java -cp ./bin bensoussan.inclass.Client");
			Process p1 = Runtime.getRuntime().exec(
					"java -cp ./bin bensoussan.inclass.Server");
			InputStream in = p1.getInputStream();
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
