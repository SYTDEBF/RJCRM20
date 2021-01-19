# RJCRM20
Javafx 程序
Github 地址 https://github.com/SYTDEBF/RJCRM20
环境 jdk14 MySQL5.7 Idea2020.3中文版
需要javafx16版本 下载地址 https://gluonhq.com/download/javafx-16-ea-sdk-windows/
Javafx页面 https://gluonhq.com/products/javafx/ https://openjfx.io/openjfx-docs/
将项目导入idea
文件->项目结构->库 将下载好的javafx lib文件夹作为库导入

新建数据库db_crm 字符集编码utf-8将文件 db_crm.sql导入数据库db_crm中
/res/config/Mybatis-config.xml中修改数据库用户名与密码

修改Main的运行配置

修改—module-path后面的路径 ，将其改为自己的javafx lib的路径

如果没有这个框，请在修改选项中添加vm选项

最后点击运行即可
 
