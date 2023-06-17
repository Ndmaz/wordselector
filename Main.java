import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //the scanner section
        //   entry file address
        System.out.println("enter the entry file address:\n");
        Scanner patheg= new Scanner(System.in);
        String path= patheg.nextLine();
        // output file address
        System.out.println("\nenter output file address to be written on:\n");
        Scanner passeg=new Scanner(System.in);
        String path2=passeg.nextLine();

        // length of the words
        System.out.println("\nenter the length of  the words:\n");
        Scanner numoflength = new Scanner(System.in);
        int numofit = numoflength.nextInt();

        // the loop number to rerun as much as asked.

        System.out.println( "\nenter the amount of output u want on the written file:\n");
        Scanner numer=new Scanner(System.in);
        int numar=numer.nextInt();


        try{
            //input file
            File textfile = new File(path);
            Scanner Reader = new Scanner(textfile);
            StringBuilder data= new StringBuilder();
            String mata;


            while ( Reader.hasNextLine()) {

                mata= Reader.nextLine();
                data.append(mata);

            }
            Reader.close();
//spliting the word and puting them in an array
            String[] words = data.toString().split(" ");
            int limit=10000000;
            int length = words.length;
            String b;
            String kj=".txt";
            StringBuilder cj = null;
            StringBuilder path3=null;
            String bj;
            String [] Yds= new String[numofit];
            String[] filedataholder=new String[limit+1];
            StringBuilder g = null;

            int counter=0;
            int filecounnter=0;
            int i = 0;
            int q=0;
            int j=0;

            int filedataholdercounter=0;
            //randomly choosing words out of that array



            for(;q<numar;q++){

                for (; i < numofit; i++) {

                    b = words[(int) (Math.random() * length)];
                    Yds[i] = b;
                    g = new StringBuilder(g + Yds[i]+" ");


                }



                filedataholder[filedataholdercounter]= String.valueOf(g);

                g =new StringBuilder();
                i=0;


                if (counter==limit){



                    bj=Integer.toString(filecounnter);
                    cj= new StringBuilder(bj + kj);
                    path3 = new StringBuilder(path2 + cj);

                    File create=new File(String.valueOf(path3));
                    if(create.createNewFile()){
                        System.out.println("true");
                    }else{
                        System.out.println("not true");
                    }
                    FileWriter myWriter = new FileWriter(String.valueOf(path3));
                    for(;j<limit;j++){
                        myWriter.write(filedataholder[j]+"\n");
                    }
                    j=0;
                    myWriter.close();






                    counter=0;
                    filecounnter++;
                    path3= new StringBuilder();
                    filedataholdercounter=0;

                }

                filedataholdercounter++;
                counter++;

            }



        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();



        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
