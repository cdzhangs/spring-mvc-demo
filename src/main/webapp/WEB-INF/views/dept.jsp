<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <title>部门管理</title>

    <link rel="stylesheet" href="/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/css/bootstrap-table.min.css"/>
    <link rel="stylesheet" href="/css/bootstrap-select.min.css"/>
    <link rel="stylesheet" href="/css/bootstrap-datetimepicker.min.css"/>
    <link rel="stylesheet" href="/css/bootstrap-treeview.min.css"/>
    <link rel="stylesheet" href="/css/dashboard.css"/>

    <script src="/js/jquery-2.1.1.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/bootstrap-table.min.js"></script>
    <script src="/js/bootstrap-table-zh-CN.min.js"></script>
    <script src="/js/bootstrap-select.min.js"></script>
    <script src="/js/defaults-zh_CN.min.js"></script>
    <script src="/js/bootstrap-datetimepicker.min.js"></script>
    <script src="/js/bootstrap-datetimepicker.zh-CN.js"></script>
    <script src="/js/bootstrap-treeview.min.js"></script>

</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand">加班餐报销</a>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li class="active"><a href="/overtime/list">加班餐录入</a></li>
                <li><a href="/overtime/export">加班餐导出</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

            <div id="tree" style="width: 300px;"></div>

        </div>
    </div>
</div>
</body>

<script>
    $(function () {

        var $tree = $('#tree');
        $tree.treeview({
            data: getTree(),
            showBorder : false,
            enableLinks : true,
            levels : 5,
            showTags : true
        });
    });

    function getTree() {

        var data = [
            {
                text: "Parent 1",
                tags: ['1'],
                nodes: [
                    {
                        text: "Child 1",
                        nodes: [
                            {
                                text: "Grandchild 1"
                            },
                            {
                                text: "Grandchild 2"
                            }
                        ]
                    },
                    {
                        text: "Child 2"
                    }
                ]
            },
            {
                text: "Parent 2"
            },
            {
                text: "Parent 3"
            },
            {
                text: "Parent 4"
            },
            {
                text: "Parent 5"
            }
        ];

        return data;
    }
</script>
</html>
