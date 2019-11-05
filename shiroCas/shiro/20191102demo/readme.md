一、集成springMvc

	1、pom添加spring-mvc的依赖
	2、web.xml中添加dispatchServlet
	3、创建一个spring所需要的spring-mvc.xml文件
	4、创建所需要的文件信息，添加controller注解进行测试  

二、添加slf4j + log4j2

	1、添加pom依赖：slf4j-api / log4j-core /lo4j-api /[桥接器] slf4j-log4j-impl
	2、在src/main/resource目录下创建以log4j2开始的xml文件【由于默认从这里查找 故直接创建在这里将不再需要在web.xml文件中进行配置】
	3、引入lombok的jar包，在需要打印的地方添加类注解@Slf4j，然后直接使用log对象输出对应信息即可。
	4、问题：从官网复制粘贴的依赖，项目一切运行正常，但最后打印的时候控制台无法输出，检查核实是因为slf4j到log4j2的适配器的依赖有效范围为test，去掉给范围设置，日志信息成功打印。
	
三、集成spring

	1、由于此项目已经集成了spring-mvc子容器，故可以不再引入spring-core spring-web依赖，因为子容器中已经提供了父级容器所需依赖。
	2、web.xml中添加spring容器的监听
	3、创建application,xml 若只集成spring的功能，只需要开启包的扫描就可以了，注解功能无需再次开启，因为在spring-mvc容器中已经开启了注解功能。
	4、创建service等类，在子容器的controller视图层利用@Autowrite注入server层，检测spring依赖注入的功能是否正常。
	
四、利用mybatis-generator.xml自动生成代码
	
	1、pom中添加plugin：mybatis-generator-maven-plugin，若配置文件不在src/main/resource路径下或者名称不为generator,则在plugin中通过configurationFile标签指定配置文件的路径，格式为src/main/resource/具体路径。由于mybatis-generator-maven-plugin已经包含mybatis mybatis-generator的依赖 ，故在plugin只需要指定mysql-connector-java的依赖即可。
	2、创建配置文件，在文件中无需配置引擎等jar的路径了，因为在plugin已经引入。
	3、maven-build === 选择工作空间中的项目位置，global为mybatis-generator:gegerate ，换需要注意maven的路径是否为本机maven的实际安装路径，然后运行该命令。
	4.控制台执行成功以后，使用F5或者refresh按钮刷新该项目查看对应的mappe和dao、entity是否创建成功。
	4、问题：注意数据驱动的版本号、注意mybatis-generator指定重复执行会导致mapper中的接口重复增加，出现相同id的接口，此时需要手动删除多余接口或删除mapper文件重新再生成皆可
	
五、集成mybatis

	1、pom添加依赖：mybatis mybatis-spring mysql-connector-java druid spring-tx spring-jdbc.
		若没有spring-tx 则报错为：java.lang.NoClassDefFoundError: org/springframework/dao/support/DaoSupport 
		若没有spring-jdbc  则报错为：NoClassDefFoundError: org/springframework/jdbc/datasource/TransactionAwareDataSourceProxy
	
	2、创建jdbc的连接配置文件
	3、在spring的配置文件application中添加mybatis的配置，最简单的是创建datasource  sqlsessionfatory 指定dao的文件位置
	4、搭建完毕，进行测试即可。
	5、问题：若程序执行serviceImpl中是，没有执行sql，出现日志信息如下：
		DEBUG org.mybatis.spring.SqlSessionUtils - Creating a new SqlSession
		DEBUG org.mybatis.spring.SqlSessionUtils - SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@3db35900] was not registered for synchronization because synchronization is not active
		DEBUG org.mybatis.spring.transaction.SpringManagedTransaction - JDBC Connection [com.mysql.jdbc.JDBC4Connection@7e71817e] will not be managed by Spring
		DEBUG org.mybatis.spring.SqlSessionUtils - Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@3db35900]
		
	通过JDBC Connection [com.mysql.jdbc.JDBC4Connection@7e71817e] will not be managed by Spring可以推测为mybatis-spring的版本号太低 推荐换高版本再进行尝试。
	
六、集成shiro
	
