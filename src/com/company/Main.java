package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);//initiliaze scanner to get user input

    public static void main(String[] args) {

        System.out.println("Please enter your command:  Encode, Decode, or Exit");
        System.out.println("Then enter the number you wish you encode or decode your text by.");
        System.out.println("And finally enter your file path to the text or the text you wish to edit.");

        boolean keeprunning = true;

            String str = sc.nextLine();

            String delims = "[ ]+";

            String[] parts = str.split(delims);

            if (parts[2].contains("C:\\")) {
                try {
                        FileReader reader = new FileReader(parts[2]);
                        BufferedReader bufferedReader = new BufferedReader(reader);

                        String line;

                        while ((line = bufferedReader.readLine()) != null){
                            System.out.println(line);
                            if (parts[0].contains("encode")){
                                encodefile(parts, line);
                            }
                            else if (parts[0].contains("decode")) {
                                decodefile(parts, line);
                            }
                    }

                    if (bufferedReader != null){
                        try {
                            bufferedReader.close();
                        }
                        catch (IOException e){
                            e.printStackTrace();
                        }
                    }

                    try {
                        FileWriter writer = new FileWriter(parts[2], true);
                        BufferedWriter bufferedWriter = new BufferedWriter(writer);
                        if (parts[0].contains("encode")){
                            bufferedWriter.write(encodefile(parts, line));
                        }
                        else if (parts[0].contains("decode")){
                            bufferedWriter.write(decodefile(parts, line));

                        }
                        if (bufferedWriter != null){
                            try {
                                bufferedWriter.close();
                            }
                            catch (IOException e){
                                e.printStackTrace();
                            }
                        }
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }
                }
                catch (IOException e){
                    e.printStackTrace();
                }



                }
            else {
                switch (parts[0]) {
                    case "Encode":
                    case "encode":
                        encode(parts);
                        break;

                    case "decode":
                    case "Decode":
                        decode(parts);
                        break;
                    default:
                        System.out.println("Invalid command");
                }
            }
    }

    private static String encode(String[] parts){
        int increment = Integer.parseInt(parts[1]);

        String strencoded = new String();

        for (int i = 0; i < parts[2].length(); i++) {
            strencoded += (char) (parts[2].charAt(i) + increment);
        }

        System.out.println(strencoded);

        return strencoded;
    }

    private static String decode (String[] parts){
        int decrement = Integer.parseInt(parts[1]);

        String strdecoded = new String();

        for (int i = 0; i < parts[2].length(); i++) {
            strdecoded += (char) (parts[2].charAt(i) - decrement);
        }
        System.out.println(strdecoded);

        return strdecoded;
    }

    private static String encodefile(String[] parts, String line){
        int increment = Integer.parseInt(parts[1]);

        String strencoded = new String();

        for (int i = 0; i < line.length(); i++) {
            strencoded += (char) (line.charAt(i) + increment);
        }

        System.out.println(strencoded);

        return strencoded;
    }

    private static String decodefile (String[] parts, String line){
        int decrement = Integer.parseInt(parts[1]);

        String strdecoded = new String();

        for (int i = 0; i < line.length(); i++) {
            strdecoded += (char) (line.charAt(i) - decrement);
        }
        System.out.println(strdecoded);

        return strdecoded;
    }

}