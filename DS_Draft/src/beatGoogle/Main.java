import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in)); 
		System.out.print("Please enter your height and weight: "); 
		String text = buf.readLine(); 
		String[] data = text.split(" ");
		double res = getBMI(data);
		String dia = getDiagnosis(res);
		System.out.println(dia + " BMI: " + res); 
		////////
               
	}
	
	public static double getBMI(String[] data) {
		// calculate the bmi
		double a=Double.parseDouble(data[0])/100.0;
		double b=Double.parseDouble(data[1]);
		double bmi=b/(a*a);
		double BMI=Double.parseDouble(String.format("%.2f", bmi));
		return BMI ;
		
	}
	
	public static String getDiagnosis(double bmi) {
		// give comments depending on bmi
		String s="";
		if(bmi>=30) {
			s="You are not in shape. Actually, you are not even close.";
		}else if(bmi<30&&bmi>=26) {
			s="To be honest, you are not in shape.";
		}else if(bmi<26&&bmi>=20) {
			s="You are in shape";
		}else {
			s="You are under shape";
		}
        return s;
	}
}