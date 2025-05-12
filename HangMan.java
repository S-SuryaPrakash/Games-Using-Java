import java.util.*;

public class HangMan{
    public static void main(String args[]){
        String word="burger";
        Scanner scanner = new Scanner(System.in);
        ArrayList<Character> wordState = new ArrayList<>();
        int wrongGuesses=0;

        for(int i=0;i<word.length();i++){
            wordState.add('_');
        }
        System.out.println("*************************");
        System.out.println("Welcome to Java Hangman");
        System.out.println("*************************");
        while (wrongGuesses<4) {
            System.out.println(getHangMan(wrongGuesses));
            System.out.print("Word: ");
            for(char c: wordState){
                System.out.print(c+" ");
            }
            System.out.println();
            
            System.out.print("Guess a letter: ");
            char guess = scanner.next().toLowerCase().charAt(0);

            if(word.indexOf(guess)>=0){
                System.out.println("Correct Guess!");
                for (int i = 0; i < word.length(); i++) {
                    if(word.charAt(i)==guess){
                        wordState.set(i, guess);
                    }
                }

                if (!wordState.contains('_')) {
                    System.out.println(getHangMan(wrongGuesses));
                    System.out.println("You Win!!");
                    System.out.println("The Correct word was: "+ word);
                    break;
                }
            }
            else{
                wrongGuesses++;
                System.out.println("Wrong Guess:(");
            }
        }

           if(wrongGuesses >= 4){
            System.out.print(getHangMan(wrongGuesses));
            System.out.println("GAME OVER!");
            System.out.println("The word was: " + word);
        }
        scanner.close();
    }

    static String getHangMan(int wrongGuesses){
            return  switch(wrongGuesses){
                case 0 ->"""
                          


                         """;
                case 1->"""
                         o 


                        """;
                case 2->"""
                         o 
                         |

                        """;
                case 3->"""
                         o 
                        /|

                        """;
                case 4->"""
                         o 
                        /|\\

                        """;
                default ->"";  
            };
    }
}