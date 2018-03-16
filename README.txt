
JVM启动参数配置:

-javaagent:/Users/guangzhong.wgz/.m2/repository_local/org/springframework/springloaded/1.2.8.RELEASE/springloaded-1.2.8.RELEASE.jar -noverify
-Dspring.profiles.active=daily


注意事项:

热部署生效: 文件保存后，要后动编译, 包括java, ftl文件


项目模块说明:


- yisutech-iisp
    - starter
        项目全局配置，打包，全局控制

    - webapp
        项目模板（view), 控制逻辑 (controller)

    - iisp_search
        项目搜索模块，实现搜索功能

    - iisp_dataops
        项目数据引擎模块, 实现对mysql, redis, mongoDB管理