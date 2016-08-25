import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;


public class Formatdata_sampleoneleapToonekey {

	public static HashSet<Integer> sampledata = new HashSet<Integer>();
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {

		//windows 本地运行时的程序
//				String fileName = "E:/brock200_2.clq";
//				String outfileName="E:/brock200_2.clq_davi";

		//集群运行时的程序
		if (args.length != 1) {
			System.out.println("one parameters: input file");
		}

		System.out.println("running ..........");
		
		File file = new File(args[0]);
		BufferedReader reader = null;
		reader = new BufferedReader(new FileReader(file));

		String br;
		while ((br = reader.readLine()) != null) {
			String[] s = br.split(" ");	//读入的是空格
			
			if(s.length !=2 ){
				s = br.split("\t");
			}

			if (s.length == 2) {
				int a = Integer.parseInt(s[0]);
				int b = Integer.parseInt(s[1]);
				
				if(!sampledata.contains(a)){
					sampledata.add(a);
				}
				if(!sampledata.contains(b)){
					sampledata.add(b);
				}
			}
		}//end read

		FileWriter writerfilesample = new FileWriter(args[0]+"_samplenode");
		BufferedWriter bwsample = new BufferedWriter(writerfilesample);
		
		java.util.Iterator<Integer> iterator=sampledata.iterator();
		while(iterator.hasNext()){
			//System.out.println(iterator.next());
			Integer out = iterator.next();
			bwsample.write( out + "\n");
		}
		bwsample.close();

	}
}
