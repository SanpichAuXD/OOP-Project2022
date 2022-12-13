/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Charactor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author sanpi
 */
public class GetVo {
    public static ArrayList<String> getWords(String file) throws FileNotFoundException {
        
        Scanner input =  new Scanner(new File(file));
       
        ArrayList<String> words = new ArrayList<String>();
        while(input.hasNext()) {
            words.add(input.next());
        }
        input.close();
        return words;
    }
}
