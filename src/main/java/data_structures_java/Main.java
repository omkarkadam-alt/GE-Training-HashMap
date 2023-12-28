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

        StringBuilder finalOutputString = new StringBuilder();

        int i = 0;
        int spaceCount = 0;
        while(i < outputString.length()){
            if(outputString.charAt(i) == ' ')
            {
                if(spaceCount == 0){
                    finalOutputString.append(" ");
                    spaceCount++;
                } else { 
                    spaceCount++;                
                }
            }else{
                finalOutputString.append(outputString.charAt(i));
                spaceCount = 0;
            }
            i++;
        }

        return finalOutputString.toString();
    }
    public static void main(String[] args) {
        
        HashMap<String, Integer> myMap = new HashMap<String, Integer>();

        myMap.display();

        String inputString = "Paranoids are not\n" + //
                "                                paranoid because they are paranoid but\n" + //
                "                                because they keep putting themselves\n" + //
                "                                deliberately into paranoid avoidable\n" + //
                "                                situations";

        String formattedInputString = cleanString(inputString);
        String words[] = formattedInputString.split(" ");
        
        for(String currWord: words){

            if(myMap.find(currWord)){
                int updatedFreq = myMap.get(currWord) + 1;
                myMap.put(currWord, updatedFreq);
            }else{
                myMap.put(currWord, 1);
            }
            myMap.display();
        }

        myMap.display();
    }
}
