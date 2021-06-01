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