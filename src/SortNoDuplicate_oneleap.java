import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Set;
import java.util.TreeMap;

public class SortNoDuplicate_oneleap {

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
		BufferedReader reader = null;
		reader = new BufferedReader(new FileReader(file));

		String br;
		while ((br = reader.readLine()) != null) {
			String[] s = br.split(" ");	//读入的是空格

			if (s.length == 2) {
				int a = Integer.parseInt(s[0]);
				int b = Integer.parseInt(s[1]);

				if (a > b) {
					if (keys.containsKey(b) == false) {
						TreeMap<Integer, Integer> value1 = new TreeMap<Integer, Integer>();
						value1.put(a, 0);
						keys.put(b, value1);
					} else {
						TreeMap<Integer, Integer> value2 = keys.get(b);
						value2.put(a, 0);
						keys.put(b, value2);
					}
				} else {
					if (keys.containsKey(a) == false) {
						TreeMap<Integer, Integer> value3 = new TreeMap<Integer, Integer>();
						value3.put(b, 0);
						keys.put(a, value3);
					} else {
						TreeMap<Integer, Integer> value4 = keys.get(a);
						value4.put(b, 0);
						keys.put(a, value4);
					}
				}
			}
		}//end read

		FileWriter writerfile = new FileWriter(args[1]);
		BufferedWriter bw = new BufferedWriter(writerfile);

		Set<java.util.Map.Entry<Integer, TreeMap<Integer, Integer>>> sets = keys.entrySet();
		for (java.util.Map.Entry<Integer, TreeMap<Integer, Integer>> entry : sets) {
			//System.out.print(entry.getKey() + "	");
			//System.out.println(entry.getKey());
			Set<java.util.Map.Entry<Integer, Integer>> keysets = entry.getValue().entrySet();
			for (java.util.Map.Entry<Integer, Integer> keyentry : keysets) {
				bw.write(entry.getKey() + "\t" + keyentry.getKey() + "\n"); //写出的为tab

				//System.out.println(entry.getKey()  +"	"+ keyentry.getKey());
			}
			// System.out.println();
		}

		bw.close();

	}
}
