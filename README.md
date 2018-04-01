# team-blog
超强大的团队博客，基于微服务架构，一切为技术而生

# 目标

打造一个基于微服务架构的团队技术博客，在平台之上提供多样化的微服务，如用户中心、博文社区、后台管理、即时通讯、系统推送、搜索服务、短信邮件、数据分析等。目前使用Spring Boot + Spring Cloud全家桶搭建基础架构，使用Angular搭建前端平台。

# 模块拆分

#### 基础架构

- team-blog-common：公共组件
- team-blog-gateway（port 7004）：Zuul API 网关
- team-blog-registry（port 7002）：Eureka 注册中心，服务发现
- team-blog-config：配置中心
- team-blog-monitor：监控平台
- team-blog-trace：zipkin链路追踪
- ...

#### 业务模块

- team-blog-user-service（port 7006）
- team-blog-article-service（port 7008）
- team-blog-admin-service
- team-blog-im-service
- team-blog-recommend-service
- team-blog-search-service
- team-blog-message-service
- team-blog-analysis-service
- ...

# 技术准备

### Spring Cloud全家桶

- Eureka：服务注册与发现
- Feign：远程调用客户端
- Ribbon：负载均衡
- Zuul：路由网关
- Hystrix：熔断器

### 视图层

- Angular

### 安全控制层

处理认证、授权、会话管理

- Spring Security（or Shiro？） 

### 分发控制层

- Zuul
- Spring MVC

### 服务接口层

这一层主要是本地服务的接口

### API层（Client接口）

为本地程序提供远程调用接口，基于RESTful HTTP

- Feign
- Ribbon

### 服务实现层

分布式事务

### 数据访问层

这里主要指与关系型数据库的交互

- Druid连接池
- MyBaits（or Spring-Data-JPA）

### 领域模型层

PO/DTO 控制实体粒度粗细

### 公共组件

- 缓存中间件
- 消息中间件
- 日志
- 异常
- 国际化
- JSON序列化

### 平台管理

- Jenkins
- Maven / Gradle
- Git

### 部署

- Docker
- Linux

# 理论支撑

### 1、远程服务调用

### 2、集群负载均衡

### 3、消息队列

### 4、分布式事务

### ...

# 技术补充

### 1、实现PO和DTO的转换

### ...
