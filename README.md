# WebShare
## 1.功能介绍
 通过GET 请求可实现将URL从任意地方发送至电脑端，并自动打开相应网页。

## 2.服务器配置
 * 服务器采用JavaEE技术，可下载源码自行编译或下载编译过的程序于Tomcat运行
 * 编译过服务器端程序：https://github.com/549876099/WebShare/tree/master/out/artifacts/WebsitShareServer_war_exploded
 * 已搭建好服务器地址请求：http://share.qust.cc:8080/WebsitShareServer/url

## 3.电脑客户端配置
 * 客户机需要安装jre运行环境，请前往Oracle官网下载
 * 打包好客户端：https://github.com/549876099/WebShare/tree/master/out/artifacts/WebsitShareClient_jar

## 4.请求说明
 * 以已搭建好服务器为例：
 * 请求打开网址为：http://www.baidu.com
 * 客户端设置的识别码为：123456
 * 请求URL：http://share.qust.cc:8080/WebsitShareServer/url?url=www.baidu.com&code=123456

## 5.IOS用户
 * IOS用户可通过Workflow快速分享网页（Workflow请于AppStore自行下载）
 * Workflow分享地址：https://workflow.is/workflows/a8a0868872b54f6f9f7a8ae3ffaf4dae
 * 使用该Workflow仅需修改第一个Text中的客户端识别代码，浏览网页时，将该网页分享至此Workflow即可