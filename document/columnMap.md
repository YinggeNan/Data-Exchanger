### 一个独立的task定义
1. 一个独立task主要定义为可并发的task
2. 读取一个file可以同时插入其他file、db、topic，这些都是并行操作的
3. 读取一个db也可以同时插入其他file、db、topic
4. 读取一个topic也可以同时插入其他file、db、topic
5. 不支持多个源到一个target的操作，这种join操作请使用flink job完成
6. 但是一对多的这种操作可以化简为多个task，虽然效率低了点，但是框架模型定义更简单，不易出错
#### ColumnMap
1. ColumnMap是处理source和sink两端数据的column匹配问题的json配置文件
2. 由于file、db都是平铺类型，而kafka-topic是层次类型，所以分为不同的ColumnMap类型
##### columnMap for file2db
1. 处理一个文件对一个db 
2. 一个文件对多个db的task化简为多个task
3. 多个文件对一个db需要join，请使用flink join
##### columnMap for db2file
1. 处理一个db对一个文件
2. 一个db对多个文件的操作化化简为多个task
3. 多个db对一个文件需要join，请使用flink join

##### columnMap for file2topic、db2topic
1. 处理一行平铺文本记录对一条层次结构message
2. 处理一条平铺db记录对一条层次结构message
3. 处理多条平铺db记录对一条层次结构message，请用复杂sql化简为一条平铺记录对一条层次结构message
4. 对于多条平铺文本记录导入到topic的操作，请先导入到db，再导入到topic

##### columnMap for topic2file、topic2db
1. 处理一条层次结构message到多行平铺文本记录
2. 处理一条层次结构message到多行平铺db记录