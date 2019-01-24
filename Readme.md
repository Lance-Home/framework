# 项目基础框架 

## 公告模块框架 [framework-common](https://github.com/fartherp/framework/tree/master/framework-common)
```
**项目通用模块**
包括各种util，例如:日期DateUtil，BigDecimalUtil等等
```

## 压缩框架 [framework-commpress](https://github.com/fartherp/framework/tree/master/framework-compress)
```
**压缩通用模块**
提供各种压缩方式
1.bzip2
2.gzip
3.jar
4.tar
5.zip
6.zlib
7.shell命令(gzip，targz)
```

## 核心框架 [framework-core](https://github.com/fartherp/framework/tree/master/framework-core)
```
**核心设计模块(不通用)，核心代码，提供基础信息**
1.基础的service，dao
2.文件上传，nfs/ftp/sftp
3.mybatis分页支持(目前mysql，可扩展)
4.整合easyui分页功能
5.验证码
6.整合easyui树结构
7.统一前端请求后的返回参数
8.发送邮件，包括html邮件
```

## db操作框架 [framework-database](https://github.com/fartherp/framework/tree/master/framework-database)
```
封装操作数据库的基本操作（增删改查）
```

## 异常体系框架 [framework-exception](https://github.com/fartherp/framework/tree/master/framework-exception)
```
**异常体系模块，封装异常信息**
1.mysql数据库返回的错误信息，转成可识别信息
2.oracle数据库返回的错误信息，转成可识别信息
3.通用的异常返回的错误信息，转成可识别信息
```

## 文件处理框架 [framework-file](https://github.com/fartherp/framework/tree/master/framework-file)
```
**file模块**
1.ftp
2.nfs
```

## net框架 [framework-net](https://github.com/fartherp/framework/tree/master/framework-net)
```
**net模块**
1.ftp
2.sftp
```

## poi框架 [framework-poi](https://github.com/fartherp/framework/tree/master/framework-poi)
```
**poi模块**
1.csv读取及下载
2.excel读取
```

## 加密解密框架 [framework-security](https://github.com/fartherp/framework/tree/master/framework-security)
```
**加密解密模块**
1.不可逆:base64，MD5
2.对称密钥:AES，DES，3DES
3.非对称密钥:RSA
```

## [framework-filter](https://github.com/fartherp/framework/tree/master/framework-filter)

```
**过滤器封装模块**
1、支持切面过滤
2、和spring环境集成
 配置方式是：
 web.xml 
     <filter>
        <filter-name>frameworkFilter</filter-name>
        <filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
        <init-param>
            <param-name>targetFilterLifecycle</param-name>
            <param-value>true</param-value>
        </init-param>
    </filter>
    <filter-mapping>
        <filter-name>frameworkFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
    spring 配置文件
      <bean id="frameworkFilter" class="cn.vanskey.filter.web.FrameworkFilterFactoryBean">
        <property name="filters"> //过滤器配置
            <util:map>
                <entry key="myfilter">
                    <bean  class="com.zrj.pay.cashier.action.demo.MyFilter"/>
                </entry>
            </util:map>
        </property>
        <property name="filterChainDefinitions">
            <value>
                /** = myfilter   //过滤器和路径的对应关系
            </value>
        </property>
    </bean>
``` 

## JDK
> 1.8
