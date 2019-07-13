## 版本说明


|      |   版本号   |  备注    |
| ---- | ---- | ---- |
|  SpringBoot    | 2.1.6.RELEASE     |      |
|  SpringCloud    | Greenwich.SR1     |      |
|  Gradle    |   5.4.1   |      |


## 模块说明

|      |   端口号   |  备注    |
| ---- | ---- | ---- |
| springcloud-api | 无 |  |
|  enreka    | 19990     |      |
|  SpringCloud Gateway    | 19995     | 路由和简单鉴权，基于token，只对用户名为admin，spring，cloud的用户授权访问。 |
|  student-service    |   19991   |      |
|  course-service    |   19992   |      |
|  teacher-service    |   19993   |      |
|  account-service    |   19996   |      |
|  business-service    |   19997   |      |
|  order-service    |   19998   |      |
|  storage-service    |   19999   |      |
|  txlcn-tm    |   19994   |      |
| springcloud-oauth | 无 | 请求拦截器,用于微服务之间调用时进行鉴权 |

## 服务提供者说明

springcloud-provider模块中的子模块 主要结合 txlcn-tm 使用。需要开启 txlcn-tm 分布式事务协调器。
springcloud-provider2模块中的子模块，主要结合seate使用。

## 启动

#### 使用 Eureka 作为注册中心启动，通过 txlcn 来进行分布式事务管理。


1、依次启动 **EurekaServer19990**  , **GatewayApplication1995** , **TMApplication19994** , **CourseProvider19992** , **TeacherProvider19993** , **TeacherProvider19991** 。

启动TM后，我们在 http://localhost:19994/admin/index.html 可以进行登录，默认密码为 codingapi 。也可以在 application.yml 文件 通过 tx-lcn.manager.admin-key 属性 指定密码。

![TM](D:\Desktop\tm.png)

2、有关TM控制台的详细信息说明，请参考https://www.txlcn.org/zh-cn/docs/manageradmin.html

3、关于TM使用的注意事项：

- 关于application.yml配置文件不生效。

  我们需要在路径下配置一个空的application.properties文件

- 报错：attempts to join the non-existent transaction group.

  发起方事务传播不能设置为 `DTXPropagation.SUPPORTS`

-  TXC模式定义表的实际主键

  ```java
  @Component
  public class MysqlPrimaryKeysProvider implements PrimaryKeysProvider {
  
      @Override
      public Map<String, List<String>> provide() {
          //t_demo 表的回滚主键为 kid字段
          return Maps.newHashMap("t_demo", Collections.singletonList("kid"));
      }
  }
  
  ```

  

## 参考文档

[CodingApi官方文档](https://www.txlcn.org/zh-cn/docs/preface.html)

