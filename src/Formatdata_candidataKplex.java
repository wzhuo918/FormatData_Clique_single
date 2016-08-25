import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Formatdata_candidataKplex {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		if(args.length != 2){
			System.out.println("input: path, get_rate");
			return;
		}

		//String input = "D:/workspace/3.82M(D1).txt";
		
		BufferedReader reader = new BufferedReader(new FileReader(args[0]));
		FileWriter out =  new FileWriter(args[0]+"_samplenode");
		Double percent = Double.parseDouble(args[1]);
		
		Set<Integer> nodes = new HashSet<Integer>();
		String line = "";
		while((line=reader.readLine())!=null){
			StringTokenizer st = new StringTokenizer(line);
			while(st.hasMoreElements()){
				nodes.add(Integer.parseInt(st.nextToken()));
			}
		}
		Set<Integer> res = new HashSet<Integer>();
		Integer[] allnodes = nodes.toArray(new Integer[0]);
		while(res.size()<percent*allnodes.length){
			res.add(allnodes[(int)(Math.random()*allnodes.length)]);
		}
		for(int i:res){
			out.write(i+"\n");
		}
		out.flush();
		out.close();
		System.out.println(nodes.size()+" / "+res.size());
	}

}
