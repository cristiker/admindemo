<html>
    <head>
        <title>test angularjs</title>
        <script src="${base}/static/js/angularjs/angular.js" type="text/javascript"></script>
        <script src="${base}/static/js/angularjs/test.js" type="text/javascript"></script>
    </head>

    <body ng-app="app">
        <div ng-controller="MainController">
            {{test}}
            <img ng-src="{{imgUrl}}" style="width:200px">
        </div>
    </body>
</html>