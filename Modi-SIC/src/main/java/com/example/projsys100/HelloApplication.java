package com.example.projsys100;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class HelloApplication extends Application {

        @Override
        public void start(Stage primaryStage) {

            primaryStage.setTitle("Systems Prog GUI");
            Button button1= new Button("Absolute Loader");

            StackPane layout= new StackPane();
            layout.getChildren().add(button1);

            Scene scene1= new Scene(layout, 300, 250);
            primaryStage.setScene(scene1);

            primaryStage.show();
        }

        public static void main(String[] args) throws FileNotFoundException {

            launch();

            //////////////////////////////////////////////////////////////////////////////////
            //////////////////////////////////////////////////////////////////////////////////


//        File HteR = new File("sic_trec");
//        File sic_memory=new File("sic_memory");
//        PrintWriter sic_mem_write=new PrintWriter(sic_memory);
//        int[] sic_mem = new int[20000];
//        for (int i = 0; i < 20000; i++)
//            sic_mem[i] = 0;
//        Scanner s1 = new Scanner(HteR);
//        int prog_start=0;
//        while (s1.hasNext()) {
//            String temp = s1.nextLine();
//            if (temp.charAt(0) == 'H') {
//                StringBuilder s1z = new StringBuilder(temp);
//                StringBuilder s2z = new StringBuilder();
//                int p=7;
//                for(int i=0;i<6;i++){
//                    s2z.insert(i,s1z.charAt(p++));
//                }
//                prog_start=Integer.parseInt(s2z.toString(),16)*2;
//            }
//            if (temp.charAt(0) == 'T') {
//                StringBuilder temp1 = new StringBuilder(temp);
//                StringBuilder starting_address = new StringBuilder();
//                StringBuilder size = new StringBuilder();
//                size.insert(0, temp1.charAt(7));
//                size.insert(1, temp1.charAt(8));
//                int hhh=1;
//                for (int x = 0; x < 6; x++) {
//                    starting_address.insert(x, temp1.charAt(hhh++));
//                }
//                for (int x = 0; x < 9; x++) {
//                    temp1.deleteCharAt(0);
//                }
//                int t_addr = Integer.parseInt(starting_address.toString(), 16);
//                t_addr*=2;
//                int t_size = Integer.parseInt(size.toString(), 16) * 2;
//                int counter = 0;
//                String clean_t = temp1.toString();
//                for (int i = t_addr+prog_start; i < t_addr + t_size+prog_start; i++) {
//                    //String tempp= String.valueOf(clean_t.charAt(counter));
//                    sic_mem[i] = Integer.parseInt(String.valueOf(clean_t.charAt(counter)), 16);
//                    counter++;
//                }
//            }
//        }
//        sic_mem_write.println("          0    1    2    3    4    5    6    7    8    9    A    B    C    D    E    F");
//                int j=0;
//                int kk=0;
//                int fi=0;
//                int i=0;
//                for (int l = 0; l < 8000;l++ ) {
//                    if ((i == 0 || i % 16 == 0)&&fi==0) {
//                        sic_mem_write.println();
//                        sic_mem_write.print(ToHex(String.valueOf(i),5));
//                        sic_mem_write.print("     ");
//                    }
//                    //if(l%2==0)
//                        i++;
//                    if(j<20000) {
//                        sic_mem_write.print(ToHex(String.valueOf(sic_mem[j]), 1));
//                        sic_mem_write.print(ToHex(String.valueOf(sic_mem[(j + 1)]), 1));
//                    }
//                    j+=2;
//                    kk++;
//                    sic_mem_write.print("   ");
//                }
//                sic_mem_write.close();




            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////


            ///////////////////////////////////////////////////////////////////////////////////////////////
            //////////////////////////////////////////////////////////////////////////////////////////////


            File sicxefile = new File("sicxe_trec");
            File sicxe_memory = new File("sicxe_memory");
            PrintWriter sicxew = new PrintWriter(sicxe_memory);
            int[] sicxe_mem = new int[20000];
            for (int i = 0; i < 10000; i++)
                sicxe_mem[i] = 0;
            Scanner s1 = new Scanner(sicxefile);
            int prog_start = 0;
            int[] programs_size = new int[99];
            int counter = 0;
            while (s1.hasNext()) {
                String temp = s1.nextLine();
                if (temp.charAt(0) == 'H') {
                    StringBuilder s1z = new StringBuilder(temp);
                    StringBuilder s2z = new StringBuilder();
                    int z = 13;
                    for (int k = 0; k < 6; k++) {
                        s2z.insert(k, s1z.charAt(z++));
                    }
                    int prog_size = Integer.parseInt(s2z.toString(), 16);
                    programs_size[counter] = prog_size;
                    //System.out.println("am innnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn" + programs_size[counter]);
                    counter++;
                }
            }
            Scanner sc= new Scanner(System.in);    //System.in is a standard input stream
            System.out.print("Enter the number of programs->");
            int n= sc.nextInt();
            System.out.print("Enter the application starting address->");
            Scanner myObj = new Scanner(System.in);
            String sss=myObj.nextLine();
            int app_starting_add = Integer.parseInt(sss,16);//b3d ma at7wel la base 10
            int[] programs_order = new int[99];
            System.out.print("Enter the programs Order->");
            for(int i=0;i<n;i++){
                programs_order[i]=sc.nextInt();
            }
            int temp = 0;
            int[] programs_address = new int[99];
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    programs_address[programs_order[i] - 1] = app_starting_add;
                } else {
                    programs_address[programs_order[i] - 1] = programs_address[programs_order[i - 1] - 1] + programs_size[programs_order[i - 1] - 1];
                }
            }
            Scanner s2 = new Scanner(sicxefile);
            int program_counter = -1;
            File ext_sym_table = new File("ext_sym_table");
            PrintWriter extw = new PrintWriter(ext_sym_table);
            while (s2.hasNext()) {
                String tempp = s2.nextLine();
                if (tempp.charAt(0) == 'H') {
                    program_counter++;
                    StringBuilder hrecc = new StringBuilder(tempp);
                    StringBuilder progname = new StringBuilder();
                    //StringBuilder progname = new StringBuilder();
                    hrecc.deleteCharAt(0);
                    // System.out.println("Zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz"+hrecc.toString());
                    for (int i = 0; i < 6; i++) {
                        progname.insert(i, hrecc.charAt(i));
                    }
                    extw.println(progname.toString() + "     " + ToHex(Integer.toString(programs_address[program_counter]), 6));
                    System.out.println(progname.toString() + "     " + programs_address[program_counter]);
                }
                if (tempp.charAt(0) == 'D') {
                    StringBuilder Drec = new StringBuilder(tempp);
                    StringBuilder p = new StringBuilder();
                    Drec.deleteCharAt(0);
                    int flagg = 0;
                    for (int i = 0; i < Drec.length() - 1; i++) {
                        if (i % 6 == 0 && i != 0)
                            Drec.insert(i, ' ');
                    }
                    Scanner sd = new Scanner(Drec.toString());
                    while (sd.hasNext()) {
                        extw.print(sd.next());
                        extw.print("     ");
                        String sz = sd.next();
                        int place = Integer.parseInt(sz, 16) + programs_address[program_counter];
                        extw.println(ToHex(Integer.toString(place), 6));
                    }

                }
            }
            extw.close();
            Scanner s3 = new Scanner(sicxefile);
            program_counter = -1;
            while (s3.hasNext()) {
                String temppp = s3.nextLine();
                if (temppp.charAt(0) == 'H') {
                    program_counter++;
                }
                if (temppp.charAt(0) == 'T') {
                    StringBuilder s11 = new StringBuilder(temppp);
                    StringBuilder starting_add = new StringBuilder();
                    StringBuilder size = new StringBuilder();
                    size.insert(0, s11.charAt(7));
                    size.insert(1, s11.charAt(8));
                    //System.out.println(Integer.parseInt(size.toString(), 16) + "   the size");
                    s11.deleteCharAt(0);
                    for (int x = 0; x < 6; x++) {
                        starting_add.insert(x, s11.charAt(x));
                    }
                    for (int x = 0; x < 8; x++) {
                        s11.deleteCharAt(0);
                    }
                    int t_addr = Integer.parseInt(starting_add.toString(), 16);
                    t_addr *= 2;
                    //System.out.println(t_addr + "the address");
                    int t_size = Integer.parseInt(size.toString(), 16) * 2;
                    //System.out.println(t_size + "the size");
                    int counterz = 0;
                    String clean_t = s11.toString();
                    //System.out.println(clean_t);
                    for (int i = t_addr + (programs_address[program_counter] * 2); i < t_addr + t_size + (programs_address[program_counter] * 2); i++) {
                        //String tempp= String.valueOf(clean_t.charAt(counter));
                        sicxe_mem[i] = Integer.parseInt(String.valueOf(clean_t.charAt(counterz)), 16);
                        //System.out.println(Integer.parseInt(String.valueOf(clean_t.charAt(counterz)), 16) + "           sheet");
                        //System.out.println(i+"dehk");
                        counterz++;
                    }
                }
            }
            Scanner s4 = new Scanner(sicxefile);
            program_counter = -1;
            while (s4.hasNext()) {
                String tempppp = s4.nextLine();
                if (tempppp.charAt(0) == 'H') {
                    program_counter++;
                }
                if (tempppp.charAt(0) == 'M') {
                    StringBuilder s11 = new StringBuilder(tempppp);
                    StringBuilder addressm = new StringBuilder();
                    StringBuilder labelm = new StringBuilder();
                    s11.deleteCharAt(0);
                    for (int x = 0; x < 6; x++) {
                        addressm.insert(x, s11.charAt(x));
                    }
                    char operator = s11.charAt(8);
                    int kl = 0;
                    for (int i = 9; i < 15; i++) {
                        labelm.insert(kl, s11.charAt(i));
                        kl++;
                    }
                    Scanner ext = new Scanner(ext_sym_table);
                    String labeladd = new String();
                    while (ext.hasNext()) {
                        labeladd = ext.next();
                        if (labeladd.equals(labelm)) {
                            labeladd=ext.next();
                            break;
                        }
                    }
                    //System.out.println("M rec mod label xxxxxxxxxxxxxx    "+labeladd);
                    int shift = Integer.parseInt(addressm.toString(), 16) + programs_address[program_counter];

                    StringBuilder memval=new StringBuilder();
                    int gg=0;
                    for(int i=((shift*2));i<((shift*2)+6);i++){
                        memval.insert(gg,ToHex(Integer.toString(sicxe_mem[i]),1));
                        gg++;
                    }
                    String finalval=new String();
                    if(operator=='+'){
                        int tempo1=Integer.parseInt(memval.toString(),16);
                        int tempo2=Integer.parseInt(labeladd,16);
                        int tempo=tempo1+tempo2;
                        finalval=ToHex((Integer.toString(tempo)),6);
                    }else{
                        int tempo1=Integer.parseInt(memval.toString(),16);
                        int tempo2=Integer.parseInt(labeladd,16);
                        int tempo=tempo1-tempo2;
                        if(tempo>0){
                            finalval=ToHex((Integer.toString(tempo)),6);
                        }else{
                            String kent=Integer.toHexString(tempo);
                            StringBuilder kent2=new StringBuilder();
                            int kent3=0;
                            for(int i=kent.length()-1-5;i<kent.length()-1;i++) {
                                kent2.insert(kent3,kent.charAt(i));
                                kent3++;
                            }
                            finalval = kent2.toString();
                        }
                    }
                    int topg=0;
                    for(int i=((shift*2));i<((shift*2)+6);i++){
                        sicxe_mem[i]=Integer.parseInt(String.valueOf(finalval.charAt(topg)),16);
                        System.out.println(Integer.parseInt(String.valueOf(finalval.charAt(topg)),16)+"vvvvvvvvvvv");
                        topg++;
                    }

                }
            }


            sicxew.println("          0    1    2    3    4    5    6    7    8    9    A    B    C    D    E    F");


            int j = 0;
            int kk = 0;
            int fi = 0;
            int i = 0;
            for (int l = 0; l < 8000; l++) {
                if ((i == 0 || i % 16 == 0) && fi == 0) {
                    sicxew.println();
                    sicxew.print(ToHex(String.valueOf(i), 5));
                    sicxew.print("     ");
                }
                //if(l%2==0)
                i++;
                if (j < 20000) {
                    sicxew.print(ToHex(String.valueOf(sicxe_mem[j]), 1));
                    sicxew.print(ToHex(String.valueOf(sicxe_mem[(j + 1)]), 1));
                }
                j += 2;
                kk++;
                sicxew.print("   ");
            }


        }

        public static String ToHex(String Temp, int size) {
            Temp = Integer.toHexString(Integer.parseInt(Temp));
            String Temp2 = "0";
            if (size == Temp.length())
                return Temp;
            for (int ff = size - Temp.length() - 1; ff > 0; ff--) {
                Temp2 += "0";
            }
            Temp2 = Temp2.concat(Temp);
            return Temp2;
        }
    }
