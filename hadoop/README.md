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
![Cluster Architecture](./assets/ClusterArchitecture.png)
## Big Data Tools
### MapReduce
- A framework used for large-scale data processing. It uses three operations: Map, Shuffle and Reduce.
  - `Map:` Each worker node applies the `map` function to the local data and writes the output to temporary storage, creating output keys.
  - `Shuffle:` Each worker node redistributes data based on the created output keys.
  - `Reduce:` The worker nodes process each group of output data per key, in parallel.
### YARN
- YARN separates the resource management and processing components. It consists of a ResourceManager(RM), NodeManager(NM) and Application Manager(AM).
  - `ResourceManager:` The RM is the master daemon, which keeps track of live NM and available resources, allocating them to appropriate applications and tasks. It also monitors application masters.
  - `NodeManager:` The NM provides computational resources in containers, managing the processes within them.
  - `Applicationmaster:` The AM coordinates the execution of all tasks in the application. It requests specific resource containers to run tasks.
### HDFS
- Hadoop Distributed Filesystem (HDFS) is a filesystem designed for storing very large files. It consists of Blocks, Namenodes and Datanodes.
  - `Block:` HDFS deals with data in blocks, typically a few kilobytes in size. Files are broken into block-sized chunks and stored as independent units.
  - `Namenode:` The master node which manages the filesystem namespace. It maintains all the metadata for files and directories in the tree. It also knows about where blocks in datanodes are located, but does not store block locations persistently.
  - `Datanode:` The worker nodes which store and retrieve blocks when requested, reporting back to the namenode periodically with the list of blocks they are storing.
### Hive
### Zeppelin

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