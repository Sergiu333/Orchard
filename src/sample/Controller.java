package sample;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.*;
import java.io.*;

import javafx.application.HostServices;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Controller extends Main{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button PR_6;

    @FXML
    private Button PR_5;

    @FXML
    private Button PR_4;

    @FXML
    private Button PR_3;

    @FXML
    private Button PR_2;

    @FXML
    private Button PR_1;

    @FXML
    public Text PR_text;

    @FXML
    private TextField PR_imput;

    @FXML
    private Button PR_open;

    @FXML
    void initialize() {
        String fisier ="LinSpec";

        PR_1.setOnAction(event ->{
            Coloana(3);
            Rind(2);
        });

        PR_2.setOnAction(event ->{
            delete();
        });

        PR_3.setOnAction(event ->{

            PR_text.setText(neroditoar("mar"));


        });

        PR_4.setOnAction(event ->{

            PR_text.setText("Total Roada : "+Total());


        });

        PR_5.setOnAction(event ->{
            RoadaSort();
        });

        PR_6.setOnAction(event ->{
            ArrayList<Integer> line=new ArrayList<Integer>();

            ArrayList<ArrayList<Copac>> a=list();
            int s=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                {
                    if(a.get(i).get(j).nume.equals(RoadaMax()))
                    {
                        line.add(i);
                        break;
                    }
                }
            }
            // Controller.PR_6.setOnAction(event ->{});
            //Controller.PR_text.setText(line);
            //Controller c = new Controller();
            PR_text.setText(line.toString());

            System.out.println(line);

            try
            {
                BufferedWriter filescan=new BufferedWriter(new FileWriter("C:\\Users\\User\\Desktop\\LivadaPractica\\src\\sample\\LinSpec.txt"));

                for(int i:line)
                {
                    for(int j=0;j<m;j++)
                    {
                        filescan.write(a.get(i).get(j).nume+" ");
                    }
                    filescan.newLine();
                }

                filescan.close();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }

        });

        PR_open.setOnAction(event ->{
            String  textImput = PR_imput.getText().trim();
            String aux = "";
            File file = new File("C:\\Users\\User\\Desktop\\LivadaPractica\\src\\sample\\"+textImput+".txt");
            if(textImput.equals("Drum")){
                aux = "C:\\Users\\User\\Desktop\\LivadaPractica\\src\\sample\\Drum.rout";
                File file2 = new File(aux);
                HostServices hostServices = getHostServices();
                hostServices.showDocument(file2.getAbsolutePath());

            }

            if(textImput.equals("Copaci")) {
                aux = "C:\\Users\\User\\Desktop\\LivadaPractica\\src\\sample\\Copaci.in";
                File file2 = new File(aux);
                HostServices hostServices = getHostServices();
                hostServices.showDocument(file2.getAbsolutePath());

            }

            if(textImput.equals("LinSpec")) {
                aux = "C:\\Users\\User\\Desktop\\LivadaPractica\\src\\sample\\LinSpec.txt";
                File file2 = new File(aux);
                HostServices hostServices = getHostServices();
                hostServices.showDocument(file2.getAbsolutePath());

            }
            //File file3 = new File("C:\\Users\\User\\Desktop\\LivadaPractica\\src\\sample\\"+textImput+".rout.txt");

            /*HostServices hostServices = getHostServices();
            hostServices.showDocument(file2.getAbsolutePath());*/
            PR_text.setText("open "+textImput+" !");

        });




    }


}



