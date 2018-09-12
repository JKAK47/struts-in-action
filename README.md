#  基于Maven 构建java web项目Module模块  环境搭建

# struts-in-action
- Struts 2.5.17  
- Spring 4.3.13.RELEASE
- Mybatis 3.4.4
- tomcat 8.x 版本 servlet 3.1 JSP 2.3, EL 3.0 
### 测试tomcat apache-tomcat-8.0.53
# pom 
```
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.vincent.struts</groupId>
    <artifactId>struts-in-action</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>war</packaging>

    <name>struts-in-action</name>
    <!-- FIXME change it to the project's website -->
    <url>http://www.example.com</url>

    <properties>
        <project.build.version>1.0.0-SNAPSHOT</project.build.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
        <spring.version>4.3.13.RELEASE</spring.version>
        <mybatis.version>3.4.4</mybatis.version>
        <mybatis.spring.version>1.3.0</mybatis.spring.version>
        <mysql.driver.version>6.0.4</mysql.driver.version>
        <druid.version>1.1.10</druid.version>
        <struts2.version>2.5.17</struts2.version>
    </properties>

    <dependencies>
        <!-- test unit begin -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
            <exclusions>
                <exclusion>
                    <groupId>org.hamcrest</groupId>
                    <artifactId>hamcrest-core</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
        <dependency>
            <groupId>org.hamcrest</groupId>
            <artifactId>hamcrest-core</artifactId>
            <version>1.3</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-test</artifactId>
            <scope>test</scope>
            <version>${spring.version}</version>
        </dependency>
        <!-- test unit end -->

        <!-- db  begin -->
        <!-- MyBatis Dependency & mybatis integer spring Begin -->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>${mybatis.version}</version>
        </dependency>
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
            <version>${mybatis.spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>${spring.version}</version>
            <exclusions>
                <exclusion>
                    <groupId>org.springframework</groupId>
                    <artifactId>spring-tx</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-tx</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/com.alibaba/druid  数据库连接池 -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>${druid.version}</version>
        </dependency>

        <!-- MyBatis Dependency End -->
        <!-- 导入Mysql数据库链接jar包
            mysql 6+ 以上版本classDriver ：com.mysql.cj.jdbc.Driver
            原来是：com.mysql.jdbc.Driver
         -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>${mysql.driver.version}</version>
        </dependency>
        <!-- 导入Mysql数据库链接jar包 End -->
        <!-- db stop -->

        <!-- spring common lib begin -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-aop</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-aspects</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-beans</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context-support</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-core</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-expression</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-instrument</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>commons-logging</groupId>
            <artifactId>commons-logging</artifactId>
            <version>1.2</version>
        </dependency>

        <!-- spring common lib begin -->

        <!-- web lib : spirng-web , struts2  begin -->
        <!-- spring-web -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-web</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <!-- struts 2.5.17  dependency lib jar begin -->
        <dependency>
            <groupId>org.apache.struts</groupId>
            <artifactId>struts2-spring-plugin</artifactId>
            <version>${struts2.version}</version>
            <exclusions>
              <!--  <exclusion>
                    <artifactId>commons-io</artifactId>
                    <groupId>commons-io</groupId>
                </exclusion>-->
                <exclusion>
                    <groupId>org.apache.struts</groupId>
                    <artifactId>struts2-core</artifactId>
                </exclusion>
                <exclusion>
                    <groupId>org.apache.commons</groupId>
                    <artifactId>commons-lang3</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
        <dependency>
            <groupId>org.apache.struts</groupId>
            <artifactId>struts2-core</artifactId>
            <version>${struts2.version}</version>
            <exclusions>
                <exclusion>
                    <groupId>commons-io</groupId>
                    <artifactId>commons-io</artifactId>
                </exclusion>
                <exclusion>
                    <groupId>org.freemarker</groupId>
                    <artifactId>freemarker</artifactId>
                </exclusion>
                <exclusion>
                    <groupId>org.apache.commons</groupId>
                    <artifactId>commons-lang3</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
        <dependency>
            <groupId>org.freemarker</groupId>
            <artifactId>freemarker</artifactId>
            <version>2.3.26-incubating</version>
        </dependency>
        <dependency>
            <groupId>org.apache.commons</groupId>
            <artifactId>commons-lang3</artifactId>
            <version>3.6</version>
        </dependency>
        <dependency>
            <groupId>commons-io</groupId>
            <artifactId>commons-io</artifactId>
            <version>2.5</version>
        </dependency>
        <!-- struts 2.5.17  dependency lib jar stop -->
        <!-- web lib : spirng-web , struts2  stop -->

        <!-- web runtime lib begin -->
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <version>3.1.0</version>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>javax.servlet.jsp</groupId>
            <artifactId>javax.servlet.jsp-api</artifactId>
            <version>2.3.0</version>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>javax.el</groupId>
            <artifactId>javax.el-api</artifactId>
            <version>3.0.0</version>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>jstl</artifactId>
            <version>1.2</version>
        </dependency>
        <!-- web runtime lib stop -->
    </dependencies>

    <build>
        <finalName>struts-in-action</finalName>
            <plugins>
                <!-- clean 清理周期插件
                         并将清理命令绑定到 打包周期的initialize阶段
                         mvn package和 mvn clean package就是等价的
                   -->
                <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-clean-plugin</artifactId>
                    <version>3.0.0</version>
                    <!-- 配置 clean 失败后是否还能继续执行其他命令
                        failOnError = false  忽略错误继续执行
                        failOnError = true  报错不继续执行
                      -->
                    <configuration>
                        <failOnError>true</failOnError>
                    </configuration>
                    <!--绑定clean 到打包周期的 initialize 阶段 -->
                    <executions>
                        <execution>
                            <id>auto-clean</id>
                            <phase>initialize</phase>
                            <goals>
                                <goal>clean</goal>
                            </goals>
                        </execution>
                    </executions>
                </plugin>
                <!-- 声明使用UTF-8编码去处理资源文件 -->
                <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-resources-plugin</artifactId>
                    <version>3.1.0</version>
                    <configuration>
                        <encoding>UTF-8</encoding>
                    </configuration>
                </plugin>

                <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-compiler-plugin</artifactId>
                    <version>3.7.0</version>
                    <configuration>
                        <encoding>UTF-8</encoding>
                        <!-- 声明代码使用什么JDK 版本进行编译 -->
                        <source>${maven.compiler.source}</source>
                        <!-- 声明编译后的代码将运行在哪个JDK版本 -->
                        <target>${maven.compiler.target}</target>
                        <!-- 设置编译插件在编译期间使用的JDK版本 -->
                        <fork>true</fork> <!-- fork = true 让compilerVersion 属性生效。
                        compilerVersion 属性设置编译器使用的jdk版本 executable 设置使用的jdk路径
                    -->
                        <compilerVersion>${maven.compiler.source}</compilerVersion>
                        <!--<executable>${JAVA8_HOME}/bin/javac</executable>-->
                        <!-- 从 3.0后的编译插件，maven默认使用的编译器 是 javax.tools.JavaCompiler
                            如果你想强制让这个插件使用javac 设置属性 forceJavacCompilerUse =true 即可。
                         -->
                        <forceJavacCompilerUse>true</forceJavacCompilerUse>
                    </configuration>
                </plugin>

                <!-- 配置打包过程中跳过测试插件， -->
                <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-surefire-plugin</artifactId>
                    <version>2.19.1</version>
                    <configuration>
                        <skip>true</skip>
                    </configuration>
                </plugin>

                <!--<plugin>
                    <artifactId>maven-war-plugin</artifactId>
                    <version>3.2.0</version>
                </plugin>
                <plugin>
                    <artifactId>maven-install-plugin</artifactId>
                    <version>2.5.2</version>
                </plugin>
                <plugin>
                    <artifactId>maven-deploy-plugin</artifactId>
                    <version>2.8.2</version>
                </plugin>-->

            </plugins>
    </build>
</project>

```
# struts 配置以及和Spring集成

## 在 web.xml 配置 struts2 的核心过滤器

`src\main\webapp\WEB-INF\web.xml`

```
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
                http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
         version="3.1" xmlns="http://xmlns.jcp.org/xml/ns/javaee">
  <!-- tomcat 8.x 版本 servlet 3.1 JSP 2.3, EL 3.0  -->
  <display-name>Archetype Created Web Application</display-name>
  <welcome-file-list>
    <welcome-file>index.html</welcome-file>
    <welcome-file>index.htm</welcome-file>
    <welcome-file>index.jsp</welcome-file>
    <welcome-file>default.html</welcome-file>
    <welcome-file>default.htm</welcome-file>
    <welcome-file>default.jsp</welcome-file>
  </welcome-file-list>
  <!-- Struts2的入口点是一个过滤器(Filter)。因此，Struts2要按过滤器的方式配置。下面是在web.xml中配置Struts2的代码： -->
  <!-- 配置 struts2 核心过滤器 -->
  <!--
     Struts2.5.17 版本的配置，2.3 版本及其以下的版本的 filter-class 有点不同，
    为 org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter。具体以官方参考资料为准。
  -->
  <filter>
    <filter-name>struts2</filter-name>
    <filter-class>org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter</filter-class>
  </filter>
  <filter-mapping>
    <filter-name>struts2</filter-name>
    <url-pattern>/*</url-pattern>
  </filter-mapping>

  <!-- struts 2.5 必须集成配置spring 如果只是单纯Struts2 起不来 -->

  <listener>
    <listener-class>org.springframework.web.context.ContextLoaderListener
    </listener-class>
  </listener>
  <context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>classpath:spring/ApplicationSpringContext.xml</param-value>
  </context-param>

</web-app>

```
**注意：以上的配置是 Struts2.5 版本的配置，2.3 版本及其以下的版本的 filter-class 有点不同，为 org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter。具体以官方参考资料为准。**

# struts.xml 文件定义一些struts全局性变量
struts 框架会自动读取struts.xml配置文件并不需要再 web.xml 中配置struts配置文件。


`\src\main\resources\struts.xml`
```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE struts PUBLIC
        "-//Apache Software Foundation//DTD Struts Configuration 2.0//EN"
        "http://struts.apache.org/dtds/struts-2.0.dtd">

<struts>
    <constant name="struts.locale" value="zh_CN" />
    <constant name="struts.devMode" value="true"></constant>
    <constant name="struts.i18n.encoding" value="UTF-8"></constant>
    <include file="context/struts-action.xml"/>
</struts>
```
# struts-action.xml 定义所有的action 
`\src\main\resources\context\struts-action.xml`


```
<?xml version="1.0" encoding="UTF-8" ?>

<!DOCTYPE struts PUBLIC
        "-//Apache Software Foundation//DTD Struts Configuration 2.0//EN"
        "http://struts.apache.org/dtds/struts-2.0.dtd">

<struts>
    <!-- action demo  -->
    <package name="struts2demo" namespace="/mystruts"
             extends="struts-default">
        <!-- 定义了一个action， 如果需要调用到这个action，需要通过 //mystruts/sum.action 才能调用到;result 是针对action 执行返回的结果可以返回两个jsp给浏览器。 -->
        <action name="sum" class="org.vincent.struts.action.FirstAction">
            <result name="positive">/WEB-INF/pages/positive.jsp</result>
            <result name="negative">/WEB-INF/pages/negative.jsp</result>
        </action>
    </package>
</struts>

```
# Spring 总配置文件
## 需要在struts 启动时候通过 listener 配置启动Spring 容器
### web.xml 文件中新增配置
```
<!-- struts 2.5 必须配置spring 如果只是单纯Struts2 起不来 begin -->
  <listener>
    <listener-class>org.springframework.web.context.ContextLoaderListener
    </listener-class>
  </listener>
  <context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>classpath:spring/ApplicationSpringContext.xml</param-value>
  </context-param>
  <!-- struts 2.5 必须配置spring 如果只是单纯Struts2 起不来 stop -->
```
### `\src\main\resources\spring\ApplicationSpringContext.xml`
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
						http://www.springframework.org/schema/beans/spring-beans-4.0.xsd
						http://www.springframework.org/schema/context
						http://www.springframework.org/schema/context/spring-context-4.0.xsd
						 "
       default-autowire="byName" default-lazy-init="false">
    <!-- 采用注释的方式配置bean -->
    <context:annotation-config/>


    <!--自动扫描 :通过注解过滤被扫描的类 -->
    <!--<context:component-scan base-package="org.sei" use-default-filters="false">
        <context:include-filter type="annotation" expression="org.springframework.stereotype.Repository"/>
        <context:include-filter type="annotation" expression="org.springframework.stereotype.Service"/>
    </context:component-scan>-->

    <!-- 配置要扫描的包 -->
    <!--<context:component-scan base-package="org.vincent.web.dao"/>-->

    <!-- 导入 Spring Bean 配置文件 -->
    <import resource="spring-mybatis.xml"/>

    <!-- 配置 属性文件 -->
    <bean class="org.springframework.beans.factory.config.PreferencesPlaceholderConfigurer">
        <property name="locations">
            <list>
                <!-- 可以配置多个 属性文件源 -->
                <!-- 导入数据源配置  -->
                <value>classpath:db/jdbc.properties</value>

            </list>
        </property>
    </bean>
</beans>
```

# helloworld 案例
## 现金sum.jsp 
### `\src\main\webapp\sum.jsp`

```
 <%--
  Created by IntelliJ IDEA.
  User: PengRong
  Date: 2018/9/12
  Time: 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
    <title>输入操作数</title>
</head>

<body>
求代数和
<br/>
<%--
 action="mystruts/sum.action" 就是 context/struts-action.xml 中定义的 package 的 namespace="/mystruts"
 加上 action name="sum" 属性拼接起来的
--%>
<s:form action="mystruts/sum.action" >
    <s:textfield name="operand1" label=" 操作数1"/>
    <s:textfield name="operand2"  label=" 操作数2" />
    <s:submit value="代数和" />
</s:form>
</body>
</html>
```

## sum.jsp 提交后跳转的action类：
### FirstAction.java

```
package org.vincent.struts.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by PengRong on 2018/9/12.
 */
public class FirstAction extends ActionSupport {
    @Override
    public String execute() throws Exception {

        if (getSum() >= 0)  // 如果代码数和是非负整数，跳到positive.jsp页面
        {
            return "positive";
        }
        else  // 如果代码数和是负整数，跳到negative.jsp页面
        {
            return "negative";
        }

    }

    private int operand1;
    private int operand2;


    public int getOperand1()
    {
        return operand1;
    }

    public void setOperand1(int operand1)
    {
        System.out.println(operand1);
        this.operand1 = operand1;
    }

    public int getOperand2()
    {
        return operand2;
    }
    public void setOperand2(int operand2)
    {
        System.out.println(operand2);
        this.operand2 = operand2;
    }
    public int getSum()
    {
        return operand1 + operand2;  // 计算两个整数的代码数和
    }
}

```
# 针对这个action执行的两种结果可选择两个不同的jsp。

### `\src\main\webapp\WEB-INF\pages\negative.jsp`

```
<%--
  Created by IntelliJ IDEA.
  User: PengRong
  Date: 2018/9/12
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <title>显示代数和</title>
</head>

<body>
代数和为负整数<h1><s:property value="sum" /></h1>

</body>
</html>

```



### `\src\main\webapp\WEB-INF\pages\positive.jsp`


```
<%--
  Created by IntelliJ IDEA.
  User: PengRong
  Date: 2018/9/12
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <title>显示代数和</title>
</head>

<body>
代数和为非负整数<h1><s:property value="sum" /></h1>
</body>
</html>

```


# mybatis 配置
### `\src\main\resources\mybatis\mybatis-config.xml`

```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">

<configuration>
    <settings>
        <setting name="cacheEnabled" value="false" />
        <setting name="useGeneratedKeys" value="true" />
        <setting name="defaultExecutorType" value="REUSE" />
        <setting name="lazyLoadingEnabled" value="true" />
        <setting name="aggressiveLazyLoading" value="false" />
    </settings>
    <typeAliases>
    </typeAliases>
    <mappers>

    </mappers>
</configuration>
```
# Spring +mybatis 集成配置
### `\src\main\resources\spring\spring-mybatis.xml`
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:tx="http://www.springframework.org/schema/tx"
       xsi:schemaLocation="
    http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-3.2.xsd
    http://www.springframework.org/schema/tx
    http://www.springframework.org/schema/tx/spring-tx-3.2.xsd
     ">

    <!--
        Spring + mybatis + diuid  Spring 管理数据源集成配置

        基于Druid数据库链接池的数据源配置
        [Druid数据库连接池的使用和详解](https://blog.csdn.net/u011271894/article/details/45220079)
    -->
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource"
          destroy-method="close"  init-method="init">
        <property name="driverClassName" value="${jdbc.driver_class}" />
        <property name="url" value="${jdbc.url}" />
        <property name="username" value="${jdbc.username}" />
        <property name="password" value="${jdbc.password}" />
        <!-- 配置初始化大小、最小、最大 -->
        <!-- 通常来说，只需要修改initialSize、minIdle、maxActive -->
        <!-- 初始化连接大小 -->
        <property name="initialSize" value="${initialSize}"></property>
        <!-- 连接池最大数量 -->
        <property name="maxActive" value="${maxActive}"></property>
        <!-- 连接池最小空闲 -->
        <property name="minIdle" value="${minIdle}"></property>

        <!-- 获取连接最大等待时间 -->
        <property name="maxWait" value="${maxWait}"/>

        <!-- 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒 -->
        <property name="timeBetweenEvictionRunsMillis" value="60000" />
        <property name="testOnBorrow" value="true" />
        <!-- 指明连接是否被空闲连接回收器(如果有)进行检验.如果检测失败,则连接将被从池中去除.注意: 设置为true后如果要生效,validationQuery参数必须设置为非空字符串 -->
        <property name="testWhileIdle" value="true" />
        <!-- SQL查询,用来验证从连接池取出的连接,在将连接返回给调用者之前.如果指定,则查询必须是一个SQL SELECT并且必须返回至少一行记录 -->
        <property name="validationQuery" value="select 1 FROM DUAL" />
        <!-- 默认值是 flase, 当从把该连接放回到连接池的时，验证这个连接是否有效 -->
        <property name="testOnReturn" value="false" />

        <!-- 超过时间限制是否回收 -->
        <property name="removeAbandoned" value="true" />
        <!-- 超时时间；单位为秒。180秒=3分钟 -->
        <property name="removeAbandonedTimeout" value="1800" />
        <!-- 关闭abanded连接时输出错误日志 -->
        <property name="logAbandoned" value="true" />
        <!-- 配置一个连接在池中最小生存的时间，单位是毫秒 -->
        <property name="minEvictableIdleTimeMillis" value="30000" />

    </bean>

    <!-- spring和MyBatis完美整合， 将数据源映射到sqlSessionFactory中  -->
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="dataSource" />
        <!-- 引入mybatis 配置文件  -->
        <property name="configLocation" value="classpath:mybatis/mybatis-config.xml"/>
    </bean>

    <!-- SqlSession模板类实例 -->
    <bean id="sqlSessionTemplate" class="org.mybatis.spring.SqlSessionTemplate"
          destroy-method="close" scope="prototype">
        <constructor-arg index="0" ref="sqlSessionFactory" />
    </bean>

    <!-- DAO接口所在包名，Spring会自动查找其下的类 -->
    <!--<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="basePackage" value="org.sei.dao" />
        <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"></property>
    </bean>-->

    <!--======= 事务配置 Begin ================= -->
    <!-- 事务管理器（由Spring管理MyBatis的事务） -->
    <!-- (事务管理)transaction manager, use JtaTransactionManager for global tx -->
    <bean id="transactionManager"
          class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <!-- 关联数据源 -->
        <property name="dataSource" ref="dataSource" />
    </bean>
    <!-- 声明使用注解式事务 -->
    <tx:annotation-driven transaction-manager="transactionManager" />
    <!--======= 事务配置 End =================== -->
</beans>
```


# 测试 在项目根目录下执行maven 构建指令 `mvn clean install`
在`项目根目录/target/struts-in-action.war` war 文件复制到tomcat 目录下webapps 目录 ，启动tomcat 测试


![](http://one17356s.bkt.clouddn.com/18-9-12/14703277.jpg)

**随机输入几个数 ，action 执行后根据计算结果正负 返回positive.jsp, negative.jsp 两个文件中其中一个。**
![](http://one17356s.bkt.clouddn.com/18-9-12/84826142.jpg)



---
# 完成了spring ，struts2 ，mybatis 集成

# 参考

[Maven 学习 Maven 整合 Struts2](https://blog.csdn.net/hochenchong/article/details/79110794)

[使用Maven配置Struts2 集成Spring](https://blog.csdn.net/shuiguolan/article/details/51736033)

[Struts 2 + Spring + Hibernate integration example](http://www.mkyong.com/struts2/struts-2-spring-hibernate-integration-example/)



[Struts2教程1：第一个Struts2程序 不依赖spring](http://www.blogjava.net/nokiaguy/archive/2008/04/15/193229.html)

[Struts2、Spring、Hibernate 高效开发的最佳实践](https://www.ibm.com/developerworks/cn/java/j-lo-ssh/index.html)

