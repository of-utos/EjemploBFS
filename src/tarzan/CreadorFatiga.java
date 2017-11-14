package tarzan;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CreadorFatiga {
	public CreadorFatiga() {
		try {
			PrintWriter pr = new PrintWriter(new FileWriter("fatiga.in"));
			int imprimo = 0;
			int offset = 35;
			for (int i = 0; i < 500; i++) {
				pr.println(imprimo + " " + imprimo);
				imprimo += 35;
				System.out.println(i);
			}
			imprimo = -35;
			for (int i = 500; i < 999; i++) {
				pr.println(offset + " " + imprimo);
				offset += 35;
				imprimo -= 35;
				System.out.println(i);
			}
			// pr.println(offset + " " +imprimo);
			pr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
