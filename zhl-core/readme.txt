代码生成前，需要配置一下jdbc，并把mysql-connector-java-5.1.27.jar放到的d:\下

代码生成命令
mvn mybatis-generator:generate

建表规范：
1、建表时，字段名称建议用"_"分隔多个单词，比如:user_id...，这样生成的entity，属性名称就会变成漂亮的驼峰命名，即: userId
2、每个字段需要设置缺省值，可以避免无数的null判断。
3、表和字段，统一都用小写，容易阅读。
4、考虑到数据导入问题，主键用uuid生成比较好，避免不同数据库同步时，容易重复。

所有的java entity对象，都必须使用封装类型，而不是基本类型。
比如：private Integer userid; 这个是正确的写法；
      private int userid;    这个是错误的写法，会自动赋值一个缺省值，不利于更新。

为了统一权限管理，对数据库做了些增减，详细见group_add.sql

