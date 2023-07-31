package test1;

import java.util.ArrayList;
import java.util.List;

public class StringManager {

    //metoda koja vraca stringove iz zadatog niz stringova cija se duzina poklapa sa zadatim argumentom
    //povratni tip metode : List<String>
    //argumenti metode
    public List<String> returnListOfString(String[] stringArray, int lenght) {
        return null;
    }



    //public List<String> returnListString(String[] stringArray, char c) {
    public String[] returnListString(String[] stringArray, char c) {
        //kreira sa prazna lista Stringova
        //List<String> toReturn = new ArrayList<>();
        String[] toReturn = new String[10];
        int i = 0;
        //for(String s : stringArray) {
            //if(s.charAt(0) == c) {
                //toReturn.add(s);
                //toReturn[i] = s;
               // i++;
           // }
       // }

        //i = 0;
        for(int j = 0; j < stringArray.length; j++) {
            if(stringArray[j].charAt(0) == c) {
                //toReturn.add(stringArray[i]);
                toReturn[i] = stringArray[j];
                i++;
            }
            else {
                System.out.println("Item : " + stringArray[j] + " is not in matched");
            }

        }



        return toReturn;
    }

    //vraiti max broj od zadatog niza celih brojeva
    public int maxNumber(int[] arrayOfInt) {
        int max = arrayOfInt[0];

        for(int i = 1; i < arrayOfInt.length; i++) {
            if(max > arrayOfInt[i]) {
               //max = arrayOfInt[i];
            }
            else {
                max = arrayOfInt[i];
            }
        }

        return max;
    }

    public void printMaxNumber(int[] arrayOfInt) {
        int max = arrayOfInt[0];

        for(int i = 1; i < arrayOfInt.length; i++) {
            if(max > arrayOfInt[i]) {
                //max = arrayOfInt[i];
            }
            else {
                max = arrayOfInt[i];
            }
        }

        System.out.println(max);
    }

    public List<String> returnListWithoutDuplicate(List<String> listOfString) {
        List<String> listaBezDuplikata = new ArrayList<>();

        listaBezDuplikata.add(listOfString.get(0));

        for(int i = 1; i < listOfString.size(); i++) {
            //if(!listaBezDuplikata.contains(listOfString.get(i))) {
                //listaBezDuplikata.add(listOfString.get(i));
            //}

            if(listaBezDuplikata.contains(listOfString.get(i))) {

            }
            else {
                listaBezDuplikata.add(listOfString.get(i));
            }
        }

        return listaBezDuplikata;
    }


}
