package ca.jrvs.apps.grep;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import java.util.regex.*;
import org.slf4j.*;
import org.apache.log4j.BasicConfigurator;
import java.util.function.Consumer;
import java.util.stream.*;

public class JavaGrepLambdaImp extends JavaGrepImp {

    public static void main(String[] args) {
        if (args.length != 3) {
            JavaGrepLambdaImp javaGrepLambdaImp = new JavaGrepLambdaImp();
            javaGrepLambdaImp.setRegex(args[0]);
            javaGrepLambdaImp.setRootPath(args[1]);
            javaGrepLambdaImp.setOutFile(args[2]);

            try {
                javaGrepLambdaImp.process();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public JavaGrepLambdaImp() {
        super();
    }

    @Override
    public List<File> listFiles(String rootDir) {
        List<File> files = new ArrayList<File>();
        try {
            files = Files.list(Paths.get(rootDir))
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .collect(Collectors.toList());
            return files;
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return files;
    }

    @Override
    public List<String> readLines(File inputFile) throws IOException {
        List<String> lines = Files.lines(Paths.get(inputFile.getAbsolutePath()))
                .collect(Collectors.toList());
        return lines;
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
}