# Java Grep App
# Introduction
This Java Grep App is made to replicate the Linux `grep` command, searching files in a directory and matching strings to within the files. 
There are two different implementations, one using BufferedReader and FileOutputStream to read and write files and one using Lambda functions and Stream APIs to perform the same functionality.
It implements Maven, Stream APIs, Regex and Lambda and is tested using the main method and JUnit testing. The application is contained in a Docker container.

# Quick Start
The following variables are required to run the program:
* `regex_pattern`: the regex pattern to be searched
* `src_dir`: the root directory path
* `outfile`: the output file name

The application can be run in two different ways:

1. Using the Jar file:
```bash
java -cp target/grep-1.0-SNAPSHOT.jar ${regex_pattern} ${src_dir} ./out/${outfile}

#verify
cat out/$outfile
```
2. Using the Docker image:
```bash
docker run --rm -v `pwd`/data:/data -v `pwd`/out:/out jrvs/grep ${regex_pattern} ${src_dir} /out/${outfile}

#verify 
cat out/$outfile
```

#Implemenation
## Pseudocode
write `process` method pseudocode.

## Performance Issue
(30-60 words)
Discuss the memory issue and how would you fix it

# Test
How did you test your application manually? (e.g. prepare sample data, run some test cases manually, compare result)

# Deployment
How you dockerize your app for easier distribution?

# Improvement
List three things you can improve in this project.
