##### 表结构设计
1. user表
```
id, user_name, user_email, user_phone_number, user_qq_number, 
user_weixin_number, is_delete, is_vip, create_time, update_time
```
2. task表
```
id, task_name, reader_type, reader_json_config, sinker_type, sinker_json_config,
intermediateProcessor_className, blocking_queue_size, column_map_json_config, concurrent_number, is_delete, create_time, update_time
```
3. user_task表
```
id, user_id, task_id, is_delete, create_time, update_time
```

4. schedule_task表

```
id, task_id, schedule_json_config, is_delete, create_time, update_time, 
```
5. task_execution_log表
```
id, task_id, task_state, create_time
```
task_state  
1. start(router插入)  
2. running(broker插入)  
3. failed(broker插入, 当broker执行过程中报错了; router插入，当router超过10分钟没有感应到broker的心跳(zk的临时节点))
4. completed(broker插入)
##### web_ui用户接口设计
1. register接口
2. login in/off接口
3. task select、insert、delete(置is_delete为true)、update
4. task trigger
5. execution progress view
6. task suspension of execution、continue execution
7. task config grammar check
8. task config check with trying running(尝试插入db后将脏数据删除)
9. call router to execute the task.
10. task execution log select
11. task current statue select(with current time查询task_execution_log表，若对task无当前时间之后的记录，就是未开始，有记录则是对应状态)