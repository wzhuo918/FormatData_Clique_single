import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;


public class GeneratotDaviData {


	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int totalnumber =  0;
		int maxkey  =0;
		HashSet<Integer> key=new HashSet<Integer>();
		
		//windows 本地运行时的程序		
//		String inputfile_path = "E:/博士/论文/自己/SelfClique/房clique/dataset/";		
//		String outputfile_path = "E:/博士/论文/自己/SelfClique/self/dataset/dataset_davi/";
//		
//		String infile_name = "ssc/ssca-20-40_davi";
//		String outfile_name = "ssc/ssca-20-40_davi";
//
//		File filein = new File(inputfile_path + infile_name);
//		BufferedReader readerin = new BufferedReader(new FileReader(filein));
//
//		FileWriter writerfile = new FileWriter(outputfile_path + "tempdata/" + "temp_data.txt");
//		BufferedWriter bw = new BufferedWriter(writerfile);
		
		//集群运行时的程序
		if (args.length != 2) {
			System.out.println("two parameters: input output");
		}
		
		File filein = new File(args[0]);
		BufferedReader readerin = new BufferedReader(new FileReader(filein));

		FileWriter writerfile = new FileWriter(args[1] + "_temp_data.txt");
		BufferedWriter bw = new BufferedWriter(writerfile);
		
		
		System.out.println("running ..........");
		
		String brin;
		while ((brin = readerin.readLine()) != null) {
			totalnumber++;
			
			String[] testDu = brin.split("\t");

			int a = Integer.parseInt(testDu[0]);
			int b = Integer.parseInt(testDu[1]);
			
			if(a > maxkey){
				maxkey =a ;
			}
			
			if(b > maxkey){
				maxkey =b ;
			}
			key.add(a);
			key.add(b);
			bw.write(b+","+a+"\n");
			bw.write(a+","+b+"\n");
		}
		
		System.out.println("key.size = " + key.size());
		System.out.println("maxkey = " + maxkey);
		System.out.println("totalnumber = " + 2*totalnumber);
		readerin.close();
		bw.close();
		
		File fileinout = new File(args[1] + "_temp_data.txt");
		BufferedReader readerinout = new BufferedReader(new FileReader(fileinout));
		FileWriter writerfileout = new FileWriter(args[1]);
		BufferedWriter bwout = new BufferedWriter(writerfileout);
		
		String brinout;
		int maxkeynum = maxkey+1;
		
		System.out.println("maxkeynum = " + maxkeynum);
		bwout.write(maxkeynum + "\n");
		bwout.write(2*totalnumber + "\n");
		while ((brinout = readerinout.readLine()) != null) {
			
			bwout.write(brinout + "\n");

		}
		readerinout.close();
		bwout.close();

		fileinout.delete();
	}

}
