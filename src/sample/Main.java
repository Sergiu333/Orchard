package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.*;
import java.io.*;

class Copac
{
    String nume;
    int roada;
}

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("pr.fxml"));
        primaryStage.setTitle("LIVADA");
        primaryStage.setScene(new Scene(root, 700, 500));
        primaryStage.show();
    }


    public static void main(String[] args)
    {
        launch(args);

        // meniu
        Scanner cin=new Scanner(System.in);
        /*
                case 1:

                    Coloana(3);
                    Rind(2);

                    break;

                case 2:
                    delete();
                    break;

                case 3:

                    String setSpecie;
                    //System.out.print("Selectati specia -> ");
                    //setSpecie=cin.next();
                    neroditoar("mar");

                    break;

                case 4:
                    System.out.println("Total ->"+Total());
                    break;

                case 5:
                    RoadaSort();
                    break;

                case 6:
                    copyLine();
                    break;

                case 7:
                    sectorMin(8);
                    break;

                case 8:
                    PlanulLivezii(2,2);
                    break;*/


    }


    static int n,m;

    static void initializare(ArrayList<ArrayList<Copac>> a)
    {
        if(a.size()<list().size())
        {
            n-=1;
        }
        else if(a.get(0).size()<list().get(0).size())
        {
            m-=1;
        }
        try // pentru tratarea exceptjlor
        {

            BufferedWriter filescan1=new BufferedWriter(new FileWriter("C:\\Users\\User\\Desktop\\LivadaPractica\\src\\sample\\Copaci.in",false));
            BufferedWriter filescan2=new BufferedWriter(new FileWriter("C:\\Users\\User\\Desktop\\LivadaPractica\\src\\sample\\roada.in",false));

            filescan1.write(Integer.toString(n)+" "+Integer.toString(m));
            filescan1.newLine();

            for(int i=0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                {
                    filescan1.write(a.get(i).get(j).nume+" ");
                    filescan2.write(Integer.toString(a.get(i).get(j).roada)+" ");
                }
                filescan1.newLine();
                filescan2.newLine();
            }

            filescan1.close();
            filescan2.close();
        }
        catch(Exception e) // pentru tratarea exceptjlor
        {
            System.out.println(e);
        }
    }

    static ArrayList<ArrayList<Copac>> list()
    {
        ArrayList<ArrayList<Copac>> s=new ArrayList<ArrayList<Copac>>();
        Scanner filescan1=null;
        Scanner filescan2=null;
        try
        {
            // se citeste din fisiere

            filescan1=new Scanner(new File("C:\\Users\\User\\Desktop\\LivadaPractica\\src\\sample\\Copaci.in"));
            filescan2=new Scanner(new File("C:\\Users\\User\\Desktop\\LivadaPractica\\src\\sample\\Roada.in"));

            n=filescan1.nextInt();
            m=filescan1.nextInt();
            // parcurgerea
            for(int i=0;i<n;i++)
            {
                s.add(new ArrayList<Copac>());
                for(int j=0;j<m;j++)
                {
                    s.get(i).add(new Copac());

                    s.get(i).get(j).nume=filescan1.next();
                    s.get(i).get(j).roada=filescan2.nextInt();
                }
            }
        }
        catch(Exception e) // pentru tratarea exceptjlor
        {
            System.out.println(e);
        }
        return s;
    }

    static ArrayList<String> getSpec()  //returneaza specia copacului, se foloseste pentru sortarea dupa roada
    {
        ArrayList<String> s=new ArrayList<String>();
        ArrayList<ArrayList<Copac>> a=list();

        //parcurgerea

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                int set=0;
                for(String r:s)
                {
                    if(r.equals(a.get(i).get(j).nume))set=1;
                }
                if(set==0)s.add(a.get(i).get(j).nume);
            }
        }
        return s;
    }

    static void afisare()
    {
        ArrayList<ArrayList<Copac>> a=list();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                System.out.print(a.get(i).get(j).nume+" ");
            }
            System.out.println();
        }

        System.out.println();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                System.out.print(a.get(i).get(j).roada+" ");
            }
            System.out.println();
        }
    }

    static void Coloana(int c)
    {
        c-=1;
        ArrayList<ArrayList<Copac>> a=list();
        Scanner cin=new Scanner(System.in);
        for(int i=0;i<n;i++)
        {
            System.out.println("Numele copacului " + (i+1) + " : ");
            System.out.print( a.get(i).get(c).nume + ">" );
            a.get(i).get(c).nume=cin.next();

            System.out.println("roada copacului " + (i+1) +" : ");
            System.out.print( a.get(i).get(c).roada + ">" );
            a.get(i).get(c).roada=cin.nextInt();
        }
        // System.out.println(a);

        initializare(a);
    }

    static void Rind(int r)
    {
        r-=1;
        ArrayList<ArrayList<Copac>> a=list();
        Scanner cin=new Scanner(System.in);
        for(int j=0;j<m;j++)
        {
            System.out.println("Numele copacului " + (j+1) + " : ");
            System.out.print( a.get(r).get(j).nume + ">" );
            a.get(r).get(j).nume=cin.next();

            System.out.println("Roada copacului "+(j+1)+" : ");
            System.out.print( a.get(r).get(j).roada + ">" );
            a.get(r).get(j).roada=cin.nextInt();
        }
        // System.out.println(a);

        initializare(a);
    }

    static void delete()
    {
        Scanner cin=new Scanner(System.in);
        ArrayList<ArrayList<Copac>> a=list();
        ArrayList<ArrayList<Copac>> s=new ArrayList<ArrayList<Copac>>();

        String poz=null;
        System.out.println("Pozitia : ");
        do
        {
            System.out.println("+-------------------------+");
            System.out.println("| Nord | Sud | Est | Vest |");
            System.out.println("+-------------------------+");

            System.out.print("->");
            poz=cin.next();
        }
        while(!poz.equals("Nord") && !poz.equals("Sud") && !poz.equals("Est") && !poz.equals("Vest"));


        if(poz.equals("Nord"))
        {
            for(int i=0;i<n-1;i++)
            {
                s.add(new ArrayList<Copac>());
                for(int j=0;j<m;j++)
                {
                    s.get(i).add(new Copac());

                    s.get(i).get(j).nume=a.get(i+1).get(j).nume;
                    s.get(i).get(j).roada=a.get(i+1).get(j).roada;
                }
            }

        }

        if(poz.equals("Sud"))
        {
            for(int i=0;i<n-1;i++)
            {
                s.add(new ArrayList<Copac>());
                for(int j=0;j<m;j++)
                {
                    s.get(i).add(new Copac());

                    s.get(i).get(j).nume=a.get(i).get(j).nume;
                    s.get(i).get(j).roada=a.get(i).get(j).roada;
                }
            }
        }

        if(poz.equals("Est"))
        {
            for(int i=0;i<n;i++)
            {
                s.add(new ArrayList<Copac>());
                for(int j=0;j<m-1;j++)
                {
                    s.get(i).add(new Copac());

                    s.get(i).get(j).nume=a.get(i).get(j).nume;
                    s.get(i).get(j).roada=a.get(i).get(j).roada;
                }
            }
        }

        if(poz.equals("Vest"))
        {
            for(int i=0;i<n;i++)
            {
                s.add(new ArrayList<Copac>());
                for(int j=0;j<m-1;j++)
                {
                    s.get(i).add(new Copac());

                    s.get(i).get(j).nume=a.get(i).get(j+1).nume;
                    s.get(i).get(j).roada=a.get(i).get(j+1).roada;
                }
            }
        }

        initializare(s);
    }

    static String neroditoar(String specie){
        int r=0,c=0;
        ArrayList<ArrayList<Copac>> a = list();

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(a.get(i).get(j).roada>a.get(c).get(r).roada)
                {
                    if(a.get(i).get(j).nume.equals(specie))
                    {
                        c=i;
                        r=j;
                    }
                }
            }
        }
        return("Cel mai neroditor  <<"+specie+">> -> "+r+" "+c);
    }



    static String Total()
    {
        ArrayList<ArrayList<Copac>> a = list();
        int s=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                s+= a.get(i).get(j).roada;
            }
        }
        return (""+s);
    }



    static int RoadaS(String specie)
    {
        ArrayList<ArrayList<Copac>> a = list();
        int s = 0;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(a.get(i).get(j).nume.equals(specie))
                {
                    s+=a.get(i).get(j).roada;
                }
            }
        }
        return s;
    }



    static String RoadaSort()
    {
        ArrayList<String> specie = getSpec();
        int s=0;
        for(int i=0;i<specie.size();i++)
        {
            for(int j=0;j<specie.size();j++)
            {
                if(RoadaS(specie.get(i))<RoadaS(specie.get(j)))
                {
                    Collections.swap(specie,i,j);
                }
            }
        }
        for(String i: specie)
        {
            System.out.println(i+" "+RoadaS(i));
        }
        return null;
    }



    static String RoadaMax()
    {
        ArrayList<String> specie=getSpec();
        int s=0;
        for(int i=0;i<specie.size();i++)
        {
            for(int j=i;j<specie.size();j++)
            {
                if(RoadaS(specie.get(i))<RoadaS(specie.get(j)))
                {
                    Collections.swap(specie,i,j);
                }
            }
        }

        return specie.get(0);
    }


    static void copyLine()
    {
      /*  ArrayList<Integer> line=new ArrayList<Integer>();

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
        }*/
    }


    static int nrSpecii(int x1,int x2,int y1,int y2)
    {
        ArrayList<ArrayList<Copac>> a=list();

        ArrayList<String> specie=new ArrayList<String>();
        try
        {
            for(int i=x1;i<=y1;i++)
            {
                for(int j=x2;j<=y2;j++)
                {
                    int s=0;
                    for(String s2:specie)
                    {
                        if(a.get(i).get(j).nume.equals(s))
                        {
                            s=1;
                        }
                    }
                    if(s==0)specie.add(a.get(i).get(j).nume);
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        return specie.size();
    }



    public static String sectorMin(int s)
    {

        ArrayList<ArrayList<Copac>> a=list();
        int min=-1;
        int x1=0,x2=0,y1=0,y2=0;
        int n2=n,m2=m;
        for(int i=0;i<n;i++)
        {
            m2=m;
            for(int ii=0;ii<m;ii++)
            {
                for(int y=i+1;y<n2;y++)
                {
                    for(int yy=ii+1;yy<m2;yy++)
                    {
                        if(nrSpecii(i,ii,y,yy)==s)
                        {
                            if(min==-1)
                            {
                                min=(y-i+1)*(yy-ii+1);
                                x1=i;
                                x2=ii;
                                y1=y;
                                y2=yy;
                            }
                            else if((y-i+1)*(yy-ii+1)<min)
                            {
                                min=(y-i+1)*(yy-ii+1);
                                x1=i;
                                x2=ii;
                                y1=y;
                                y2=yy;
                            }
                        }
                        // System.out.println(i+" "+ii);
                        // System.out.println(y+" "+yy);
                        // for(int j=0;j<n;j++)
                        // {
                        // 	for(int jj=0;jj<m;jj++)
                        // 	{
                        // 		if(j>=i && j<=y && jj>=ii && jj<=yy)System.out.print("* ");
                        // 		else System.out.print("# ");
                        // 	}
                        // 	System.out.println();
                        // }
                        // System.out.println();
                    }
                }
            }
        }
        if(min!=-1)
            return((x1+1)+" "+(x2+1)+" "+(y1+1)+" "+(y2+1));
        return "null";
    }

    public static String test(){
        String a="succes";
        return a;
    }


    static void PlanulLivezii(int x,int y)
    {
        x--;y--;
        ArrayList<ArrayList<Copac>> a=list();
        int[][] o=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(a.get(i).get(j).nume.equals("prun"))
                {
                    o[i][j]=1;
                }
                else o[i][j]=0;
            }
        }

        int[] dx={0,1,0,-1};
        int[] dy={1,0,-1,0};
        int ok;
        for(int dir=0;dir<=3;dir++)
        {
            if(o[x+dy[dir]][y+dx[dir]]!=0)
            {
                o[x+dy[dir]][y+dx[dir]]=2;
            }
        }
        o[x][y]=0;
        int nr=2;
        do
        {
            ok=0;

            for(int i=1;i<n-1;i++)
            {
                for(int j=1;j<m-1;j++)
                {
                    for(int dir=0;dir<=3;dir++)
                    {
                        if(o[i][j]==nr)
                        {
                            if(o[i+dy[dir]][j+dx[dir]]==1 && o[i][j]!=0)
                            {
                                o[i+dy[dir]][j+dx[dir]]=o[i][j]+1;
                            }
                        }
                    }
                }
            }
            nr++;

            for(int i=0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                {
                    if(o[i][j]==1)ok=1;
                }
            }
        }
        while(ok==1);

        int min=0;
        int[] p1=new int[n*m];
        int[] p2=new int[n*m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(i==0 || j==0 || i==n-1 || j==m-1)
                {
                    if(o[i][j]!=0)
                    {
                        if(min==0)
                        {
                            min=o[i][j];
                            p1[1]=i;
                            p2[1]=j;
                        }
                        else if(o[i][j]<min)
                        {
                            min=o[i][j];
                            p1[1]=i;
                            p2[1]=j;
                        }
                    }
                }
            }
        }
        int aux=0;
        while(aux<min-1)
        {
            aux++;
            for(int dir=0;dir<=3;dir++)
            {
                if(p1[aux]==n-1 && dir==0)dir++;
                if(p1[aux]==0 && dir==2)dir++;
                if(p2[aux]==m-1 && dir==1)dir++;
                if(p2[aux]==0 && dir==3)dir++;
                if(dir==4)break;
                int ax=o[p1[aux]+dy[dir]][p2[aux]+dx[dir]];
                if(ax==min-aux)
                {
                    p1[aux+1]=p1[aux]+dy[dir];
                    p2[aux+1]=p2[aux]+dx[dir];
                    break;
                }
            }
        }

        try
        {
            BufferedWriter filescan=new BufferedWriter(new FileWriter("C:\\Users\\User\\Desktop\\LivadaPractica\\src\\sample\\Drum.rout",false));

            filescan.write(Integer.toString(min-1));
            filescan.newLine();
            filescan.write(Integer.toString(x+1)+" "+Integer.toString(y+1));
            filescan.newLine();
            for(int i=min-1;i>0;i--)
            {
                filescan.write(Integer.toString(p1[i]+1)+" "+Integer.toString(p2[i]+1));
                filescan.newLine();
            }

            filescan.close();
        }
        catch(Exception e){}

        System.out.println();
        for(int j=0;j<n;j++)
        {
            for(int jj=0;jj<m;jj++)
            {
                int ko=0;
                for(int i=min-1;i>0;i--)
                {
                    if(j==p1[i] && jj==p2[i])ko=1;
                }
                if(j==x && jj==y)System.out.print("S ");
                else if(ko==0 && o[j][jj]==0)System.out.print(o[j][jj]+" ");
                else if(ko==0 && o[j][jj]!=0)System.out.print("1 ");
                else System.out.print("* ");
            }
            System.out.println();
        }
    }
}
