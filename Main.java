package acentuacao;

import java.io.IOException;
import java.util.Random;

public class Main {
	
	public static void main(String[] args){
		char[] specials = new char[]{
			'\'',
			'"',
			'!',
			'¹',
			'@',
			'²',
			'#',
			'³',
			'$',
			'£',
			'%',
			'¢',
			'¨',
			'¬',
			'&',
			'*',
			'(',
			')',
			'-',
			'_',
			'=',
			'+',
			'§',
			'`',
			'´',
			'[',
			'{',
			'ª',
			']',
			'}',
			'º',
			'^',
			'~',
			'/',
			'?',
			'°',
			';',
			':',
			'.',
			'>',
			',',
			'<',
			'\\',
			'|'						
		};
		Random random = new Random();
		boolean exit = false;
		do{
			int randomIndex = random.nextInt(specials.length - 1);
			char choosed = specials[randomIndex];			
			try{
				System.out.println(String.format("Insira o caractere %s e pressione Enter ou digite 0 e pressione Enter", choosed));
				char pressed = (char)System.in.read();			
				System.in.skip(Integer.MAX_VALUE);				
				if (pressed == '0'){
					exit = true;
					continue;
				}
				if (pressed == choosed){
					System.out.print(String.format("Acertou! %s", System.lineSeparator()));
				}
				else{
					System.out.print(String.format("Errou! %s", System.lineSeparator()));
				}
				
			}
			catch(IOException ex){
				System.err.println(ex.getMessage());
			}
		}
		while (!exit);
	}	
}