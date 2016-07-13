<%--
  Created by IntelliJ IDEA.
  User: kingstones
  Date: 16/3/15
  Time: 下午4:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
  String path=request.getContextPath();
  String basePath =request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
  <head>
    <base href="<%=basePath%>">
    <title></title>
  </head>
  <body>
      this is a index jsp
  </body>
</html>

<!-- scripts jquery-->
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">


  $(document).ready(function() {


    var content =[];
    var data = {};
    data.userName = "汪雷厄里";
    data.userId = "a";
    data.userAge = 3;
    content.push(data);
    var data2 = {};
    data2.userName = "favxxx22";
    data2.userId = "a22";
    data2.userAge = 322;
    content.push(data2);
    $.ajax({
      url: "getFavUserList",    //请求的url地址
      dataType: "json",   //返回格式为json
      async: false, //请求是否异步，默认为异步，这也是ajax重要特性
      type: "POST",   //请求方式
      contentType:"application/json",
      data:JSON.stringify(content),
      success: function(data) {
        //请求成功时处理

      },
      error: function() {
        //请求出错处理
        alert("网络异常");
      }
    });
  })

</script>



