## 网络编程
- 网络编程的三要素
***
    - IP地址：唯一标识网路上的每一个计算机
            两台计算机之间通信的必备要素
    - 端口号：计算机中应用的标号（代表一个应用程序）
            0-1024系统使用或保留端口
            有效端口0-65536
    - 通信协议：通信的规则
            TCP，UDP
            
- 网络模型
***
    - OSI参考模式:开放系统互连参考模型（Open System Interconnect）
    ! [Image text](https://github.com/Zzznopay/TCP-UDPInternet/blob/master/img-folder/OSI%E5%8F%82%E8%80%83%E6%A8%A1%E5%9E%8B.png)
    - TCP/IP参考模型:传输控制/网际协议（Transfer Controln Protocol/Internet Protocol） 
    ! [Image text](https://github.com/Zzznopay/TCP-UDPInternet/blob/master/img-folder/TCP%E6%88%96IP%E5%8F%82%E8%80%83%E6%A8%A1%E5%9E%8B.png)
- IP的地址的表示方法
***
    - IP地址：32位，由4个8位二进制数组成
    - IP表示方法：点分十进制
    ! [Image text](https://github.com/Zzznopay/TCP-UDPInternet/blob/master/img-folder/IP%E8%A1%A8%E7%A4%BA%E6%96%B9%E6%B3%95.png)
    - IP地址 = 网络ID + 主机ID
        - 网络ID：标识计算机或网络设备所在的网段
        - 主机ID：标识特定主机或网络设备

- 特殊的IP地址
***
    0.0.0.0：本机
    127.0.0.1：本机回环地址，用于本机测试
    255.255.255.255：当前子网，一般用于向当前子网广播信息

- IP地址所对应的对象>InetAddress
***
    - 类InetAddress
    ! [Image text](https://github.com/Zzznopay/TCP-UDPInternet/blob/master/img-folder/%E7%B1%BBInetAddress.png)
    - 类InetAddress的方法
    public static InetAddress getLocalHost() 获取主机名和IP地址
    public String getHostAddress() 获取IP地址
    public String getHostName() 获取主机名
    public static InetAddress getByName(String host)  根据主机名获得IP地址

- 端口
***
    - 端口：port
    端口是虚拟的概念，并不是说在主机上真的有若干个端口。通过端口，可以在一个主机上运行多个网络应用程序
    
- 传输协议
***
    - UDP：相当于发短信（有数字限制），不需要建立连接。数据报的大小限制在64kb内，效率较高，**不安全**，容易丢包
    - TCP：相当于打电话，需要建立连接，效率相对比比较低，数据传输**安全**。**三次握手，四次挥手**。

- Socket套接字
***
    - 网络上的两个程序通过一个双向的通信连接实现数据的交换，这个连接的一端称为一个socket 
    - Java中使用Socket完成TCP程序的开収，使用此类可以方便的建立**可靠的、双向的、持续性的、点对点的通**讯连接 
    - 在Socket的程序开収中，服务器端使用ServerSocket等待客户端的连接，对于java的网络程序来讲，每一个客户端都使用一个Socket对象表示 
 
- 基于TCP协议的Socket编程
***
    - 进行网络通信时，Socket需要借助数据流来完成数据的传递工作 
    - 客户端和服务端 
    ! [Image text](https://github.com/Zzznopay/TCP-UDPInternet/blob/master/img-folder/%E5%AE%A2%E6%88%B7%E7%AB%AF.png)
    ! [Image text](https://github.com/Zzznopay/TCP-UDPInternet/blob/master/img-folder/%E6%9C%8D%E5%8A%A1%E7%AB%AF.png)
