#### kafka->db: consume; db->kafka: produce
1. 学习kafka的java client的producer、consumer的方式
2. kafka的consumer和producer的基本配置、概念
3. kafka的序列化、反序列化方式: avro、json

#### broker的核心处理逻辑-三阶段：Read、IntermediateProcess、Sink
1. 读阶段都是单线程（需要验证是否多线程读file、db、kafka性能提升不大）
2. IntermediateProcess、Sink阶段使用多线程
#### source-target的map关系先留出一个接口，让使用者来实现map关系

#### broker集群，router调度
1. broker在zk集群中注册自己的信息，接受来自router的调度，router和broker之间的调用通过rpc来实现
2. 定义一个rpc消息格式{configId（数据库里的taskId）:null}
#### intermediateProcess和sink阶段的多线程采用可配置的方式调整

#### config.json在序列化时就可以指定某些字段不能为空, 为空直接抛错


#### 系统架构图、类图、trigger task的时序图、use case文档、部署图

#### 单元测试、集成测试

#### 性能测试

#### gson、jackson对json的自定义序列化、注解、设置数字、日期等的自定义序列化、默认值等


#### broker接口设计
1. 接受router调用执行task