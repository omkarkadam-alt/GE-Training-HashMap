package data_structures_java;

import data_structures_java.HashMap.HashMap;

public class Main {

    static String cleanString(String inputString){
        String lowerCaseInputString = inputString.toLowerCase();

        StringBuilder outputString = new StringBuilder();

        for(int i = 0; i < lowerCaseInputString.length(); i++){
            if(Character.isLetterOrDigit(lowerCaseInputString.charAt(i)) || lowerCaseInputString.charAt(i) == ' '){
                outputString.append(lowerCaseInputString.charAt(i));
            }else{
                outputString.append(" ");
            }
        }

        return outputString.toString();
    }
    public static void main(String[] args) {
        
        HashMap<String, Integer> myMap = new HashMap<String, Integer>();

        myMap.display();

        String inputString = "To be or not to be";
        String formattedInputString = cleanString(inputString);
        String words[] = formattedInputString.split(" ");
        
        for(String currWord: words){

            if(myMap.find(currWord)){
                myMap.put(currWord, myMap.get(currWord) + 1);
            }else{
                myMap.put(currWord, 1);
            }
        }

        myMap.display();
    }
}
