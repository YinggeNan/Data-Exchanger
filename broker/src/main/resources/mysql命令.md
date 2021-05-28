#### 查看所有用户
select user,host from mysql.user;
#### 密码错误、忘记、重新修改密码
1. 关闭mysql服务
    1. net stop mysql(windows)
    2. service mysqld stop(linux)
2. 跳过验证：修改myql安装目录的my.ini
```
skip_grant_tables
```
3. 启动mysql服务
    1. net start mysql(windows)
    2. service mysqld start(linux)
4. 登录mysql
```
mysql -u root -p
```
5. 使用mysql语句修改密码
```
USE mysql;
# 老版本：UPDATE user SET password=PASSWORD(‘newpasswd’)WHERE user=’root’;
update mysql.user set authentication_string=password('778632ab') where user='root';
# 刷新权限
flush privileges;
```
6. 关闭服务，删除跳过权限语句或用#注释

#### mysql创建数据库
#### mysql建表

#### java连接mysql
```
String dbName = "test";
String driverClass = "com.mysql.jdbc.Driver";
String userName = "root";
String ps = "778632ab";
String url = "jdbc:mysql://localhost:3306/";
```
#### java连接mysql的url

