# 一言句子包解析工具
爬取一言社区的句子包，并插入Mysql。
一言句子包仓库：https://github.com/hitokoto-osc/sentences-bundle

## 如何使用？
### 非科学上网

1. 下载一言句子包的数据文件：
  https://github.com/hitokoto-osc/sentences-bundle/tree/master/sentences（其中的a.json、b.json等.json文件）
2. 创建数据库
```sql
# 执行sql语句
CREATE DATABASE `db_sentences`  DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
```

3. 修改仓库代码
   `src/java/qzk/resolve/init/FilePath.java`

```java
// 将其中的 path/x.json 修改为正确的文件目录
    ANIME("a", "path/a.json", "动漫"),
    COMIC("b", "path/b.json", "漫画"),
    GAME("c", "path/c.json", "游戏"),
    LITERATURE("d", "path/d.json", "文学"),
    ORIGIN("e", "path/e.json", "原创"),
    INTERNET("f", "path/f.json", "来自网络"),
    OTHER("g", "path/g.json", "其他"),
    MOVIE("h", "path/h.json", "影视"),
    POEM("i", "path/i.json", "诗词"),
    NETEASE("j", "path/j.json", "网易云"),
    PHILOSOPHY("k", "path/k.json", "哲学");
```

4. 修改数据库配置文件

**修改url、username、password为你系统环境的值**

```xml
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3306/db_sentences?useSSL=false&amp;allowPublicKeyRetrieval=true"/>
                <property name="username" value="root"/>
                <property name="password" value="12345678"/>
            </dataSource>
        </environment>
    </environments>
    <!-- 使用classpath引用映射文件 -->
    <mappers>
        <mapper resource="mapper/SentenceMapper.xml" />
    </mappers>
</configuration>
```

5. 运行`src/java/qzk/resolve/init/InitTable.java`生成数据库表**注意选择本地文件**
6. 运行`src/java/qzk/resolve/insert/InsertData2Databse`插入数据**注意选择本地文件**

### 科学上网

1. 创建数据库

```sql
# 执行sql语句
CREATE DATABASE `db_sentences`  DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
```

2. 修改数据库配置文件

**修改url、username、password为你系统环境的值**

```xml
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3306/db_sentences?useSSL=false&amp;allowPublicKeyRetrieval=true"/>
                <property name="username" value="root"/>
                <property name="password" value="12345678"/>
            </dataSource>
        </environment>
    </environments>
    <!-- 使用classpath引用映射文件 -->
    <mappers>
        <mapper resource="mapper/SentenceMapper.xml" />
    </mappers>
</configuration>
```

5. 运行`src/java/qzk/resolve/init/InitTable.java`生成数据库表**注意选择爬去github模式，注释本地模式**
6. 运行`src/java/qzk/resolve/insert/InsertData2Databse`插入数据**注意选择爬去github模式，注释本地模式**
