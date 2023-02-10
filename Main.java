package acentuacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {	

    public static void main(String[] args){
        boolean exit = false;
        List<Integer> chars = new ArrayList<>();
        int totalChars = 0;
        for (int i = 32; i < 127; i++){
            chars.add(i);
            totalChars++;
        }         
        double right = 0;
        double wrong = 0;
        double ratio = 0.0;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        chars.forEach((c) -> System.out.print(Character.toString(c)));
        System.out.println();
        do{
            if (right > 0){
                ratio = (right / (totalChars + wrong)) * 10;
            }
            if (chars.isEmpty()){
                
                System.out.println("Parabéns! Você digitou todos os caracteres!");
                System.out.println(String.format("Erros: %.0f | Acertos: %.0f | Nota: %.2f", wrong, right, ratio));
                System.out.println("Pressione ENTER para encerrar.");
                scanner.nextLine();
                exit = true;
                continue;
            }
            int index = random.nextInt(chars.size());
            int selected = chars.get(index);
            System.out.println(String.format("Erros: %.0f | Acertos: %.0f | Nota: %.2f", wrong, right, ratio));
            System.out.println(String.format("Digite o caractere %s", Character.toString(selected)));
            String text = scanner.nextLine();
            if (text.length() == 1 && text.contains(Character.toString(selected))){
                System.out.println("Acertou!");
                chars.remove(index);
                right += 1;
            }
            else if (text.length() > 1){
                System.out.println("Digite apenas o caractere indicado!");
                wrong += 1;
            }
            else{
                System.out.println("Errou!");
                wrong += 1;
            }
            System.out.println();
        }
        while(!exit);
    }
    
}