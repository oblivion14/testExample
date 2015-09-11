package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Melvin on 15. 9. 10..
 */

public class ReadData {

    ArrayList<String> arrayList_usedata = new ArrayList<String>();

    String filename = "test.txt";

    public ArrayList<String> getArrayList_usedata() {
        return arrayList_usedata;
    }

//    public void setArrayList_usedata(ArrayList<String> arrayList_usedata) {
//        this.arrayList_usedata = arrayList_usedata;
//    }

    public void SetArrayList(){


        try{
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);

            String temp;

            for(; (temp=br.readLine())!=null ;){

                arrayList_usedata.add(temp);
            }

            br.close();
            fr.close();

        }
        catch (IOException e){
            e.printStackTrace();
        }

        for(String e: arrayList_usedata){

            System.out.println(e);

        }


    }
}
