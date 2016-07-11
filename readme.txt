1、编码的最高境界是没有代码！最低境界就是快速的复制粘贴、查找替换，不知其所以然，代码量急剧膨胀。
2、减少代码的途径，有重用、重构、注解、aop、泛型、多态、反射等许多方式。
3、少量、强壮的代码，能久经考验，越用越牢固，越用越灵活，越用越强大。
4、优良的代码，善于利用cpu、内存、网络等硬件资源，而不是恣意浪费。
5、在目前所有的编程语言中，没有任何语言能比java更强壮、更可靠、更值得信赖。
6、可靠的代码，都是经过测试的! debug模式+单元测试，是精确制导导弹，有着强大的威力！
7、没有规矩不成方圆，再好的东西，如果不懂得规矩，都会乱套。
8、只写纯粹的业务代码，其他的事情，比如缓存、权限、日志，交给spring
9、要知其所以然

环境要求：
maven 3.2+
jdk 1.6+
git 1.9+

使用步骤
1、建立mysql数据库
2、git clone 
3、在zhl-cloud项目目录下，执行mvn install
4、在zhl-core项目目录下，
     拷贝jdbc.sample.properties为 jdbc.properties，改用户名、密码、数据库连接字符串
     拷贝generator.sample.properties为generator.properties ，改用户名、密码、数据库连接字符串
     拷贝generatorConfig.sample.xml为generatorConfig.xml，方便以后自己生成代码
     在zhl-cloud项目目录下，有建立数据库的脚本test.sql
5、从单元测试开始使用
6、碰到红叉，而代码又没问题，就在zhl-cloud项目上，运行maven下面的update project
7、启动服务，运行mvn tomcat:run
8、sso相关的类，包名开头为net.tfedu.zhl.sso，其他开头为net.tfedu.zhl.cloud，不同的数据源，包名需要区分开来。
9、代码生成命令：在zhl-core项目目录下，运行mvn mybatis-generator:generate
