/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toto;
import toto.szolgaltatas.TotoSzolgaltatas;
public class Alk {
    
    public static void main(String[] args) {
        TotoSzolgaltatas toto = new TotoSzolgaltatas();
        System.out.println("A legnagyobb nyeremeny amit rogzitettek: " + toto.getLegmagasabNyeremeny("Ft"));
        System.out.print("Statisztika: ");
        System.out.print("#1 csapat nyert: " + toto.getHazaiSzazalek() + " %");
        System.out.print(", #2 csapat nyert: " + toto.getIdegenSzazalek() + " %");
        System.out.print(", dontetlen: " + toto.getDontetlenSzazalek() + " %");
        System.out.println();
        
        
        
         
    }
}
