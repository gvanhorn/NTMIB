import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


public class Binarization {

	public static void main(String[] args) {
		String input = "";
		String output = "";
		if(args != null && args[0].equals("-input")){
			input = args[1];
			System.out.println("input file: " + input);
		}
		if(args != null && args[2].equals("-output")){
			output = args[3];
			System.out.println("output file: " + output);
		}
		
		try{
			File in = new File(input);
			File out = new File(output);
		
			BufferedReader br = new BufferedReader(new FileReader(in));
			BufferedWriter bw = new BufferedWriter(new FileWriter(out));
			String currentLine = br.readLine();
			
			while(currentLine != null){
				
				String binarized = binarize(currentLine);
				bw.write(binarized);
				currentLine = br.readLine();
				
			}
				

			br.close();
			bw.close();
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	
	
	private static String binarize(String currentLine) {
		
		/* 
		 *for(every non-terminal in line)
		 * 			if non terminal has more than 2 children,
		 * 				newSymbol = create new nonterminal symbol as: @{Parent} -> {symbol for previous nonterminal}
		 * 				add non-terminal as child newSymbol
		 * 				add the rest of the children of non-terminal to newSymbol.
		 * 				editedLine = replace non-terminal in currentLine with newSymbol.
		 * 				binarize(editedLine)
		 * 			else
		 * 				do nothing
		 * 
		 * When the loop is escaped that means that none of the nonterminals has more than 2 children, so we can return currentLine;
		 * return currentLine;
		 */
		
		
		return null;
	}
	


}


