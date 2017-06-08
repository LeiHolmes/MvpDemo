# MvpDemo
### 基于Android MVP框架搭建的Demo  
### 基本原理  
#### 什么是MVP？
M：model层，负责数据提供和数据持久化,数据库，远程服务api之类的
V: view层，负责跟用户交互显示界面 
P：presenter层， presenter意思是主持人，我觉得把他形容成中介更合理。负责将M层的数据提供给V层，负责处理一些后台任务。

#### model-view-presenter间的关系
mvp模式中的m层被完全分离出来，不会跟model层有任何直接的交互。而是通过接口与对应的presenter进行绑定。在view层中实现接口直接使用接口中的数据进行显示。
presenter层也是一个独立出来的类跟view的生命周期无关。在presenter层中进行数据请求操作和逻辑处理之后通过view的接口类调用接口方法为view提供处理好的数据。
model层则包含了各种数据实体的获取，远程api的调用获取服务器数据。将这些原始数据交给presenter层处理。

![mvp关系图（来源:泡在网上的日子）][1]
通过这张图可以比较直接的看出MVP各个层之间的关系，data与view间不会产生直接关系，而是通过代理presenter进行通信。

### 遇到问题：  
问题1：  
解决方法：  
