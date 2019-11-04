提要：创建maven项目，创建所需要的文件夹，并添加tomcat的运行包
	  https://blog.csdn.net/bigname22/article/details/79380238


#1.集成springMvc
	一、pom添加spring-mvc的依赖
	二、web.xml中添加dispatchServlet
	三、创建一个spring所需要的spring-mvc.xml文件
	四、创建所需要的文件信息，添加controller注解进行测试  

#2、添加slf4j+ log4j2
	一、添加pom依赖：slf4j-api / log4j-core /lo4j-api /[桥接器] slf4j-log4j-impl
	二、在src/main/resource目录下创建以log4j2开始的xml文件【由于默认从这里查找 故直接创建在这里将不再需要在web.xml文件中进行配置】
	三、引入lombok的jar包，在需要打印的地方添加类注解@Slf4j，然后直接使用log对象输出对应信息即可。
	四、问题：从官网复制粘贴的依赖，项目一切运行正常，但最后打印的时候控制台无法输出，检查核实是因为slf4j到log4j2的适配器的依赖有效范围为test，去掉给范围设置，日志信息成功打印。

#3、集成spring
	一、pom添加spring-core核心依赖
	二、web.xml中添加spring容器的监听
	三、创建对应的spring配置文件
	四、添加对应的类测试是否可以进行对象的依赖注入功能
	
#4、集成mybatis
	一、添加依赖druid 、mybatis 、mysql-connect-java
	二、创建数据库的配置文件
	三、在spring的配置文件中集成mybatis
	四、利用mybatis自动生成功能生成数据库对应的实体和dao层
	==========================================
		集成mybatis-generator:
		1.pom集成mytais-genetor的plugin，plugin配置在默认情况下 项目会从resource项目下查找generatorConfig.xml文件，
		故如果项目文件及路径不是默认值时，则进行configuration的配置。同时，可在plugin中的dependencies中配置mysql的连接驱动。
		使用generator会需要三个jar包：mybatis的jar包、
		mybatis-generator的jar包，mysql-connection驱动jar。ssm框架项目中，通过配置mybatis-generator-maven-plugin后直接包含了mybaits和generator的jar包，故只需要再指定mysql-connection的jar即可。需要注意若不成功时，可尝试是使用mysql的驱动版本号为：5.1.30
	==========================================
	五、联测

	
	