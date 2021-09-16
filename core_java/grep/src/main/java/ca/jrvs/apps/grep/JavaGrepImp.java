package ca.jrvs.apps.grep;

import java.io.*;
import java.util.*;
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


        return fileList;
    }

    @Override
    public List<String> readLines(File inputFile){
        List<String> lines = new ArrayList<String>();
        return lines;
    }

    @Override
    public boolean containsPattern(String line){
        boolean contains = false;
        return contains;
    }

    @Override
    public void writeToFile(List<String> lines) throws IOException{

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