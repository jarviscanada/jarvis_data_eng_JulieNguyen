# Hadoop Project
# Table of contents
* [Introduction](#Introduction)
* [Hadoop Cluster](#Hadoop%20Cluster)
* [Hive Project](#Hive%20Project)
* [Improvements](#Improvements)

# Introduction
This project works with processing Big Data given by the data analytics team. Hadoop Clusters are
provisioned in GCP, containing one master node and two worker nodes. The data is then stored in
Hive tables and analyzed using HiveQL queries. The project uses Core Hadoop components, such as MapReduce, HDFS and
YARN, as well as Apache Hive and Zeppelin Notebook to help solve business problems. Once the data
is analyzed, it is then optimized using techniques such as hive partitioning and columnar file optimization.
The data is tested for correctness using table views and queries.

# Hadoop Cluster
- cluster architecture diagram
    - 1 master and 2 workers nodes
    - HDFS, YARN, Zeppelin, Hive (hive Server, hive metastore, RDBMS), etc.
- Big data tools you evaluated (e.g. MapReduce, YARN, HDFS, Hive, Zeppelin, etc..)
- hardware specifications

# Hive Project
- Discuss how you optimized Hive queries? (e.g. partitions, columnar, etc..)

### Optimization

### Optimization


- Post your Zeppelin Notebook screenshot here
    - Make sure your Notebook is nice and clean as hiring managers will visit your project
    - use `Full Page Screen Capture` chrome extension to capture a webpage as a picture

![Jarvis Hive Project](./assets/JarvisHiveProject.png)

# Improvements
- Avoid null values in columns of all created tables.
- Create clustered and non-clustered indexes to allow for efficient and fast data access.
- Use stored procedure for any data that needs to be frequently access or any more complex queries.