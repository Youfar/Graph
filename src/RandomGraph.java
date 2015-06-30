import java.io.*;
import java.util.Random;
/**
 * Created by youfar on 15/6/30.
 * 主要操作：写文件
 */
public class RandomGraph {

    public void writeRandomFile() throws IOException {
        File writename = new File("output.txt");
        writename.createNewFile();
        BufferedWriter out = new BufferedWriter(new FileWriter(writename));
        String s1 = "1000";
        out.write(s1 + "\n");
        out.flush();

        StringBuilder sb = new StringBuilder();
        String str;
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            int v = random.nextInt(1000);
            int w = random.nextInt(1001-v) + v;
            /*sb.append(v);
            sb.append(" ");
            sb.append(w);

            str = sb.toString();
            out.write(str);*/
            String str1 = String.valueOf(v);
            String str2 = String.valueOf(w);
            out.write(str1 + " " + str2 + "\n");

        }
        //String s2 = "100";
        //out.write(s2);

        out.flush();
        out.close();
    }

    public static void main(String[] args) {
        try {
            RandomGraph rd = new RandomGraph();
            rd.writeRandomFile();

        } catch (IOException e){
            System.out.println("IO error");
        }
    }
}
