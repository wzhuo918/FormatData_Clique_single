import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Set;
import java.util.TreeMap;


public class SSC_Format_oneleap {

	public static TreeMap<Integer, TreeMap<Integer, Integer>> keys = new TreeMap<Integer, TreeMap<Integer, Integer>>();

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {

		//windows 本地运行时的程序
		//		String fileName = "E:/博士/论文/自己/SelfClique/房clique/dataset/ssc/ssca-20-40_oneleap";
		//		String outfileName="E:/博士/论文/自己/SelfClique/房clique/dataset/ssc/ssca-20-40_davi";

		//集群运行时的程序
		if (args.length != 2) {
			System.out.println("two parameters: input output");
		}

		System.out.println("running ..........");
		
		File file = new File(args[0]);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		
		FileWriter writerfile = new FileWriter(args[1]);
		BufferedWriter bw = new BufferedWriter(writerfile);
		
		String br;
		while ((br = reader.readLine()) != null) {
			String[] s = br.split(" ");

			if (s.length == 4) {
				if(s[0].equals("a")){
					bw.write(s[1] + " "+ s[2] + "\n"); //写出的是空格
				}
			}
		}//end read

		reader.close();
		bw.close();

	}
}

