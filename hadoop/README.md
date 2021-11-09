# Hadoop Project
# Table of contents
* [Introduction](#Introduction)
* [Hadoop Cluster](#Hadoop-Cluster)
* [Hive Project](#Hive-Project)
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
### Optimization
The data was optimized to allow for faster data access and table overwriting by using two techniques, partitioning
and columnar file optimization. By partitioning the dataset by year, separating the data into over 50
different files, this cut allowed the amount of data being searched to be significantly reduced. Columnar
file optimization is used as another method for faster querying of data. This uses parquets to compress files
into smaller, more easily-accessible files, using several encoding methods. This significantly improved the 
performance of the HiveQL as it allowed the query to focus on relevant data faster.

### Zeppelin Notebook
![Jarvis Hive Project](./assets/JarvisHiveProject.png)

# Improvements
- Avoid null values in columns of all created tables.
- Create clustered and non-clustered indexes to allow for efficient and fast data access.
- Use stored procedure for any data that needs to be frequently access or any more complex queries.