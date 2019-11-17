** 注意事项

	[WARNING] No mapping for GET /demo/spring/index/test
	当父级容器开启扫描而子容器不开启扫描时  controller无法被匹配到  因为子容器具有访问父级容器的功能，父级容器不能访问子级容器。譬如：controller可以引入service ，但在service层是不能引入controller的。
	spring为父级容器   springmvc为子级容器
	
	
	使用tomcat7-maven-plugin，运行@Slf4j时  日志无法正常打印，原因有待确认
	严重: Unable to process Jar entry [META-INF/versions/9/module-info.class] from Jar [jar:file:/D:/maven/maven-rep/local/org/apache/logging/log4j/log4j-api/2.12.1/log4j-api-2.12.1.jar!/] for annotationsorg.apache.tomcat.util.bcel.classfile.ClassFormatException: Invalid byte tag in constant pool: 19
	
	
	Invalid shutdown command [GET /20191117demo/index.jsp HTTP/1.1] received：查看tomcat的访问端口是否正确
	
	
** 项目部署过程
	
	1.创建maven项目 ，然后设置项目的jre运行包，会直接将没有显示的文件夹自动进行显示。
	2.当前eclise已经集成了spring tools所以xml的配置及命名空间的设置，直接在xml窗口中选择左下角的namespace模式进行勾选即可。
		A，设置xml文件默认以spring edit xml的编辑模式显示的方法：进入系统配置---》general---》edit---》file association---》选择或者添加*.xml ===》设置此类文件的打开方式默认为spring config  edit ===>apply 确认
		
		B，命名空间的选项只有beans，没有mvc等其他的命名空间的勾选项，操作方式====》进入系统配置，选择spring ---》beans support--->namespace---》去掉第二个勾选框【需去掉勾选框的大概意思：从项目的配置中加载命名空间】   将这个勾选框去掉，否则命名空间只能看到beans其他的命名空间无法显示===。apply 确认
		
