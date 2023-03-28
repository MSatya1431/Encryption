import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'encryption' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String encryption(String s) 
    {
    // Write your code here
        s=s.replaceAll("\\s", "");
        int length=s.length();
        double sqrtLength=Math.sqrt(length);
        int rows=(int)Math.floor(sqrtLength);
        int cols=(int)Math.ceil(sqrtLength);
        if(rows*cols<length)
        {
            rows++;
        }
        char[][] ch=new char[rows][cols];
        int i=0;
        for(int r=0;r<rows;r++)
        {
            for(int c=0;c<cols&&i<length;c++)
            {
                ch[r][c]=s.charAt(i++);
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int c=0;c<cols;c++)
        {
            for(int r=0;r<rows;r++)
            {
                char ch1=ch[r][c];
                if(ch1!=0)
                {
                    sb.append(ch1);
                }
            }
            sb.append(" ");
        }
        return sb.toString().trim();

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
