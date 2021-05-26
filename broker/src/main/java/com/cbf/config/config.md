#### Data Exchanger config
1. 三阶段处理对象都需要这个config的配置信息
2. 这个config信息是用户在web-ui提交的存放到db中，当web-ui通过router调度时，broker再查询db构造出这个config
3. config以json字符串的形式存放在db中
4. config的具体形式还需要定义

