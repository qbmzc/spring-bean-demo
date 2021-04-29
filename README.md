## Spring Bean生命周期

首先说一下Servlet的生命周期：实例化，初始init，接收请求service，销毁destroy；Spring上下文中
的Bean生命周期也类似，如下：

（1）实例化Bean：

对于BeanFactory容器，当客户向容器请求一个尚未初始化的bean时，或初始化bean的时候需要注入
另一个尚未初始化的依赖时，容器就会调用createBean进行实例化。对于ApplicationContext容器，当
容器启动结束后，通过获取BeanDefinition对象中的信息，实例化所有的bean。

（2）设置对象属性（依赖注入）：

实例化后的对象被封装在BeanWrapper对象中，紧接着，Spring根据BeanDefinition中的信息 以及 通
过BeanWrapper提供的设置属性的接口完成依赖注入。

（3）处理Aware接口：

接着，Spring会检测该对象是否实现了xxxAware接口，并将相关的xxxAware实例注入给Bean：
①如果这个Bean已经实现了BeanNameAware接口，会调用它实现的setBeanName(String beanId)方
法，此处传递的就是Spring配置文件中Bean的id值；
②如果这个Bean已经实现了BeanFactoryAware接口，会调用它实现的setBeanFactory()方法，传递的
是Spring工厂自身。
③如果这个Bean已经实现了ApplicationContextAware接口，会调用
setApplicationContext(ApplicationContext)方法，传入Spring上下文；

（4）BeanPostProcessor：

如果想对Bean进行一些自定义的处理，那么可以让Bean实现了BeanPostProcessor接口，那将会调用
postProcessBeforeInitialization(Object obj, String s)方法。

（5）InitializingBean 与 init-method：

如果Bean在Spring配置文件中配置了 init-method 属性，则会自动调用其配置的初始化方法。

（6）如果这个Bean实现了BeanPostProcessor接口，将会调用postProcessAfterInitialization(Object
obj, String s)方法；由于这个方法是在Bean初始化结束时调用的，所以可以被应用于内存或缓存技术
以上几个步骤完成后，Bean就已经被正确创建了，之后就可以使用这个Bean了

7）DisposableBean：

当Bean不再需要时，会经过清理阶段，如果Bean实现了DisposableBean这个接口，会调用其实现的
destroy()方法；

（8）destroy-method：

最后，如果这个Bean的Spring配置中配置了destroy-method属性，会自动调用其配置的销毁方法

## 结果

```bash
......
MyBeanProcessor构造函数
2021-04-28 23:02:03.210  WARN 16960 --- [  restartedMain] io.undertow.websockets.jsr               : UT026010: Buffer pool was not set on WebSocketDeploymentInfo, the default pool will be used
2021-04-28 23:02:03.232  INFO 16960 --- [  restartedMain] io.undertow.servlet                      : Initializing Spring embedded WebApplicationContext
2021-04-28 23:02:03.232  INFO 16960 --- [  restartedMain] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 885 ms
InstantiationAwareBeanPostProcessor===postProcessBeforeInstantiation
无参构造实例化
setName......
setAge......
BeanTest{name='张三', age=15}
InstantiationAwareBeanPostProcessor===postProcessAfterInstantiation
BeanNameAware:setBeanName
BeanFactoryAware:setBeanFactory
beanTest=============postProcessBeforeInitialization
InitializingBean:afterPropertiesSet
【init-method】调用<bean>的init-method属性指定的初始化方法
beanTest==========postProcessAfterInitialization
2021-04-28 23:02:03.565  INFO 16960 --- [  restartedMain] o.s.b.d.a.OptionalLiveReloadServer       : LiveReload server is running on port 35729
2021-04-28 23:02:03.586  INFO 16960 --- [  restartedMain] io.undertow                              : starting server: Undertow - 2.2.7.Final
2021-04-28 23:02:03.592  INFO 16960 --- [  restartedMain] org.xnio                                 : XNIO version 3.8.0.Final
2021-04-28 23:02:03.599  INFO 16960 --- [  restartedMain] org.xnio.nio                             : XNIO NIO Implementation Version 3.8.0.Final
2021-04-28 23:02:03.631  INFO 16960 --- [  restartedMain] org.jboss.threads                        : JBoss Threads version 3.1.0.Final
2021-04-28 23:02:03.683  INFO 16960 --- [  restartedMain] o.s.b.w.e.undertow.UndertowWebServer     : Undertow started on port(s) 8080 (http)
2021-04-28 23:02:03.693  INFO 16960 --- [  restartedMain] c.c.s.SpringBeanDemoApplication          : Started SpringBeanDemoApplication in 1.875 seconds (JVM running for 2.908)
2021-04-28 23:02:11.103  INFO 16960 --- [extShutdownHook] io.undertow                              : stopping server: Undertow - 2.2.7.Final
DisposableBean:destroy
【destroy-method】调用<bean>的destroy-method属性指定的初始化方法

Process finished with exit code 1
......
```
