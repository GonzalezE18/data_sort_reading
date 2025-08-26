
package cop2805;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.io.*;
import java.util.*;

public class Homework4 {
	List<Double> ReadFile(String file) {
		List<Double> list = new ArrayList<Double>();
		BufferedReader br = null;
		try {
			br=new BufferedReader(new FileReader(file));
			String data = br. readLine();
			while (data !=null) {
				list.add(Double.parseDouble(data));
				data = br.readLine();
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	void WriteFile(List<Double> data, String file) {
		try {
			FileWriter writer= new FileWriter(file);
			PrintWriter pw = new PrintWriter(writer);
			for (Object value : data) {
				pw.println(value);
				pw.flush();
			}
			writer.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[]args) {
		Homework4 program = new Homework4();
		List<Double> data = program.ReadFile("data.txt");
		Collections.sort(data);
		program.WriteFile(data, "data-sorted.txt");
	}
	

}
