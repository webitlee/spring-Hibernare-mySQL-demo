<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*, entity.Employees, dao.Modified, dao.Query"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<%
	Employees emp = (Employees)request.getAttribute("showDetail");
	int id = emp.getId();
	String name = emp.getName();
	float salary = emp.getSalary();
	int age = emp.getAge();
%>
<title>修改员工信息</title>
<script src="/gitRepository/html/jquery/jquery-3.0.0.min.js"></script>
</head>
<body>
	<form id="form">
        <div>
            <span>姓名：</span>
            <input id="ename" type="text" name="name" value="<%= name %>"/>
        </div>
        <br/>
        <div>
            <span>月薪：</span>
            <input id="salary" type="text" name="salary" value="<%= salary %>"/>
        </div>
        <br/>
        <div>
            <span>年龄：</span>
            <input id="age" type="text" name="age" value="<%= age %>"/>
        </div>
        <br/>
        <input type="hidden" name="id" value="<%= id %>"/>
        <button id="btn-save">确认修改</button>
	</form>
</body>
<script>
    $('#btn-save').click(function(){
        $('#form').submit(function(){
            return false;
        });
        var ename = $('#ename').val();
        var salary = parseFloat($('#salary').val());
        var age = parseInt($('#age').val());
        if(!$.trim(ename)){
            alert("姓名未填写");
        }else if(salary <= 0 || !/\d+/.test(salary)){
            alert('月薪填写错误');
        }else if(age <=0 || age >=200 || !/\d+/.test(age)){
            alert('年龄填写错误');
        }else{
            $.post('/gitRepository/modified', $('#form').serialize(), function(){
                alert('添加成没成功，我也不知道');
                location.assign('/gitRepository/list');
            })
        }
    })
</script>
</html>