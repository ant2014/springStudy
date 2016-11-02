需要注意的：

1. 由于是在命令行中创建的项目，所以可能会不完整，项目的目录结构一定要是
src/main/java
src/main/resources
src/test/java
src/test/resources
配置文件放在resources目录下，如果不放在这个目录下，打包会打不进去，程序也无法运行

2. 如果有的xml配置文件一定要放在src/main/java下面，则可以使用以下两种方案
<build>
    <finalName>test</finalName>
    <!--  这样也可以把所有的xml文件，打包到相应位置。-->
    <resources>
        <resource>
            <directory>src/main/resources</directory>
            <includes>
                <include>**/*.properties</include>
                <include>**/*.xml</include>
                <include>**/*.tld</include>
            </includes>
            <filtering>false</filtering><--这里是false，用true会报 数据库连接 错误-->
        </resource>
        <resource>
            <directory>src/main/java</directory>
            <includes>
                <include>**/*.properties</include>
                <include>**/*.xml</include>
                <include>**/*.tld</include>
            </includes>
            <filtering>false</filtering>
        </resource>
    </resources>
</build>

方案二：使用插件
</plugins>
        ...
        <!--
        此plugin可以用
        利用此plugin，把源代码中的xml文件，打包到相应位置，
        这里主要是为了打包Mybatis的mapper.xml文件
        -->
        <plugin>
            <artifactId>maven-resources-plugin</artifactId>
            <version>2.5</version>
            <executions>
                <execution>
                    <id>copy-xmls</id>
                    <phase>process-sources</phase>
                    <goals>
                        <goal>copy-resources</goal>
                    </goals>
                    <configuration>
                        <outputDirectory>${basedir}/target/classes</outputDirectory>
                        <resources>
                            <resource>
                                <directory>${basedir}/src/main/java</directory>
                                <includes>
                                    <include>**/*.xml</include></includes>
                            </resource>
                        </resources>
                    </configuration>
                </execution>
            </executions>
        </plugin>
        ...
    </plugins>

