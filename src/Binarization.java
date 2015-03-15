import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Stack;


public class Binarization {

	public static void main(String[] args) {
		String input = "";
		String output = "";
		if(args != null){
			if(args[0].equals("-input")){
				input = args[1];
				System.out.println("input file: " + input);
			}
			if(args != null && args[2].equals("-output")){
				output = args[3];
				System.out.println("output file: " + output);
			}
		}
		
		try{
			File in = new File(input);
			File out = new File(output);
		
			BufferedReader br = new BufferedReader(new FileReader(in));
			BufferedWriter bw = new BufferedWriter(new FileWriter(out));
			String currentLine = br.readLine();
			
			while(currentLine != null){
				if(currentLine.length() > 1){
					String binarized = binarizeSosha(currentLine);
					bw.write(binarized + "\n\n");
				}
				currentLine = br.readLine();
			}
			br.close();
			bw.close();
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	private static String binarizeSosha(String currentLine) {

		Stack<String> prefixes = new Stack<String>();
		String[] splitLine = currentLine.split(" ");
		String result = splitLine[0] + " " + splitLine[1] + " ";
		prefixes.push("");
		prefixes.push("(@"+ splitLine[1].replace("(", "") +"->");

		for(int i = 2; i < splitLine.length; i++) {
			String nextNode = splitLine[i];	
			int closings = numberOfClosings(nextNode);
			if(closings == 0 ){
				String previous = prefixes.pop();
				if(!isNewPrefix(previous)) {
					result += previous + " ";
				} 
	
				result += nextNode +" ";
				prefixes.push(previous + "_" +nextNode.replace("(", ""));
				prefixes.push("(@"+nextNode.replace("(", "")+"->");
			} else {
				result += nextNode;
				prefixes.pop();
				for(int c = 1; c < closings; c++){
					String previous = prefixes.pop();
					for (int cc = 0; cc < numOfCharInString("_", previous)-1; cc++) {
						result += ")";
					}
				}
				result += " ";
			}
		}
		return result;
	}


	private static int numberOfClosings(String string){
		return string.length() - string.replace(")", "").length();
	}


	private static int numOfCharInString(String c, String string){
		return string.length() - string.replace(c, "").length();
	}


	private static boolean isNewPrefix(String prefix) {
		return prefix.charAt(prefix.length()-1) == '>';
	}
}


