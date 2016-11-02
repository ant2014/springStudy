需要注意的：

1. 当前项目的作用是整个大项目的容器，如果要在当前目录下创建子模块，必须先把当前pom.xml的packaging改为pom

2. maven创建项目，顶级的目录应该就是代码相关的，即该目录中应该有pom.xml，不能那个在上面一层，
否则会报“Java class located out of the source root”错误

3. 命令行mvn archetype:generate创建的项目，导入到intellij中后，需要在project structure中指定source和test目录，
分别制定到main/java 和test/java两个目录，不指定，指定不正确，都可能导致“Java class located out of the source root”

