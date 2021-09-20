package ca.jrvs.apps.grep;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.*;
import org.slf4j.*;
import org.apache.log4j.BasicConfigurator;


public class JavaGrepImp implements JavaGrep {

    final Logger logger = LoggerFactory.getLogger(JavaGrep.class);

    private String regex;
    private String rootPath;
    private String outFile;

    public static void main(String[] args){
        if(args.length != 3){
            throw new IllegalArgumentException("Usage: JavaGrep regex rootPath outFile");
        }

        //Use default logger config
        BasicConfigurator.configure();

        JavaGrepImp javaGrepImp = new JavaGrepImp();
        javaGrepImp.setRegex(args[0]);
        javaGrepImp.setRootPath(args[1]);
        javaGrepImp.setOutFile(args[2]);

        try {
            javaGrepImp.process();
        } catch (Exception ex) {
            javaGrepImp.logger.error(ex.getMessage(), ex);
        }
    }

    @Override
    public void process() throws IOException {
        ArrayList<String> matchedLines = new ArrayList<String>();
        for (File file : listFiles(getRootPath())) {
            for (String line : readLines(file)) {
                if (containsPattern(line)) {
                    matchedLines.add(line);
                }
            }
        }
        writeToFile(matchedLines);
    }

    @Override
    public List<File> listFiles(String rootDir){
        List<File> fileList = new ArrayList<File>();
        File rootFile = new File (rootDir);

        File[] rootFiles = rootFile.listFiles();

        if(rootFiles!=null) {
            for (File file : rootFiles) {
                if (file.isFile()) {
                    fileList.add(file);
                } else if (file.isDirectory()) {
                    fileList.addAll(listFiles(file.getAbsolutePath()));
                }
            }
        }
        return fileList;
    }

    @Override
    public List<String> readLines(File inputFile) throws IOException {
        List<String> lines = new ArrayList<String>();
        String line = "";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));

        line = bufferedReader.readLine();

        while(line!=null){
            lines.add(line);
            line = bufferedReader.readLine();
        }

        bufferedReader.close();

        return lines;
    }

    @Override
    public boolean containsPattern(String line){
        boolean isPattern = Pattern.matches(getRegex(), line);
        return isPattern;
    }

    @Override
    public void writeToFile(List<String> lines) throws IOException{
        FileOutputStream fileOutput = new FileOutputStream(getOutFile(), false);

        for(String line : lines) {
            byte b[] = line.getBytes();
            fileOutput.write(b);
            fileOutput.write("\n".getBytes());
        }
        fileOutput.close();
    }

    @Override
    public String getRootPath(){
        return rootPath;
    }

    @Override
    public void setRootPath(String rootPath){
        this.rootPath = rootPath;
    }

    @Override
    public String getRegex(){
        return regex;
    }

    @Override
    public void setRegex(String regex){
        this.regex = regex;
    }

    @Override
    public String getOutFile(){
        return outFile;
    }

    @Override
    public void setOutFile(String outFile){
        this.outFile = outFile;
    }

}