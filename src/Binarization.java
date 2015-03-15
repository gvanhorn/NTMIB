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
		 * while(currentLine not binarized)
		 * 		for(every non terminal in line)
		 * 			if non terminal has more than 2 children,
		 * 				binarize(Non terminal and its children)
		 * 			else
		 * 				do nothing
		 */
		
		
		return null;
	}

}


