import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.*;
import java.util.*;
/**
 * 好用的list graph
 * Created by youfar on 15/6/23.
 */
public class MyListGraph{
    class GraphList {
        int id;
        GraphList next;

        GraphList(int id, GraphList next){
            this.id = id;
            this.next = next;
        }
    }

    GraphList[] list;

    /*public NewListGraph(String f) throws IOException, FileNotFoundException {
        FileReader fr = new FileReader(f);
        Scanner n = new Scanner(fr);

        while(n.hasNextInt()) {
            int d1 = n.nextInt();
            if(n.hasNextInt()){
                int d2 = n.nextInt();
                this.addEdge(d1,d2);
            }
        }
        fr.close();
    }*/

    public MyListGraph(FileInputStream f) throws IOException{

        Scanner n = new Scanner(f);
        if(n.hasNextInt()){
            int size = n.nextInt() + 1;
            list = new GraphList[size];
        }

        while(n.hasNextInt()) {
            int d1 = n.nextInt();
            if(n.hasNextInt()){
                int d2 = n.nextInt();
                this.addEdge(d1,d2);
            }
        }
        //f.close();
    }

    public void addEdge(int x, int y){
        connect(x, y);
        connect(y, x);
    }

    public void connect(int x, int y){
        list[x] = new GraphList(y, list[x]);
    }

    public String graphPrint(){
        String s = "";
        //StringBuilder
        for(int i = 0; i < list.length; i++)
            for(GraphList t = list[i]; t != null; t = t.next)
                s += i+" "+t.id+"\n";
        return s;
    }






}
