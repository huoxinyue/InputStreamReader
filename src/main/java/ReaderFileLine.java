import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2017/12/6.
 */
public class ReaderFileLine {

    public static void main(String[] args) {
        int startLine = 5, endLine = 3;
        System.out.println("第" + startLine + "行：" + listFileByRow("TestCase.txt", startLine));

        List regionList = listFileByRegionRow("TestCase.txt", startLine, endLine);
        if(!regionList.isEmpty()) {
            for(Object strLine : regionList) {
                System.out.println("第" + startLine + "行：" + strLine);
                startLine ++;
            }
        }

    }

    public static List getFileContent(String path) {
        List strList = new ArrayList();
        try {
            File file = new File(path);
            InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader reader = new BufferedReader(read);
            String line;
            while((line = reader.readLine()) != null) {
                strList.add(line);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strList;
    }

    public static String listFileByRow(String path, Integer row) {
        List strList = getFileContent(path);
        int size = strList.size();
        if(size >= (row - 1))
            return String.valueOf(strList.get(row - 1));
        else
            return "";

    }

    public static List listFileByRegionRow(String path, Integer startLine, Integer endLine) {
        List strList = getFileContent(path);
        //指定区间的值存到regionList
        List regionList = new ArrayList();
        int size = strList.size();
        if(size >= (endLine - 1)) {
            for (int i=startLine; i<=endLine; i++)
                regionList.add(strList.get(i-1));
        }
        return regionList;
    }


}
