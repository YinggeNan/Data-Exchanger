#### kafka->db: consume; db->kafka: produce
1. 学习kafka的java client的producer、consumer的方式
2. kafka的consumer和producer的基本配置、概念
3. kafka的序列化、反序列化方式: avro、json

#### broker的核心处理逻辑-三阶段：Read、IntermediateProcess、Sink
1. 读阶段都是单线程（需要验证是否多线程读file、db、kafka性能提升不大）
2. IntermediateProcess、Sink阶段使用多线程
#### source-target的map关系先留出一个接口，让使用者来实现map关系

#### router和broker之间的调用通过rpc来实现
1. ，定义一个rpc消息格式{configId（数据库里的taskId）:null};