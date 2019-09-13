var app = angular.module("ExpenseManager", []);
 
// Controller Part
app.controller("ExpenseController", function($scope, $http) {
 
 
    $scope.expenses = [];
    $scope.expenseForm = {
        date:"",
        description: "",
        category:"",
        amount: ""
    };
 
    // Now load the data from server
    _refreshExpenseData();
 
    // HTTP POST/PUT methods for add/edit employee  
    // Call: http://localhost:8080/employee
    $scope.submitExpense = function() {
 
        var method = "POST";
        var url = '/new';
 
       $http({
            method: method,
            url: url,
            data: angular.toJson($scope.expenseForm),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };
 
    $scope.createExpense = function() {
        _clearFormData();
    }
 
    // HTTP DELETE- delete employee by Id
    // Call: http://localhost:8080/employee/{empId}
    $scope.deleteExpense = function(expense) {
        $http({
            method: 'DELETE',
            url: '/delete/' + expense.id,
            data:expense.id,
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };
 
    // In case of edit
    $scope.editExpense = function(expense) {
    	$scope.expenseForm.id = expense.id;
        $scope.expenseForm.date = expense.date;
        $scope.expenseForm.description = expense.description;
        $scope.expenseForm.category = expense.category;
        $scope.expenseForm.amount = expense.amount;
    };
 
    // Private Method  
    // HTTP GET- get all employees collection
    // Call: http://localhost:8080/employees
    function _refreshExpenseData() {
        $http({
            method: 'GET',
            url: '/expenses'
        }).then(
            function(res) { // success
                $scope.expense = res.data;
            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }
 
    function _success(res) {
        _refreshExpenseData();
        _clearFormData();
    }
 
    function _error(res) {
        var data = res.data;
        var status = res.status;
        var header = res.header;
        var config = res.config;
        alert("Error: " + status + ":" + data);
    }
   
    // Clear the form
    function _clearFormData() {
        $scope.expenseForm.description = "";
        $scope.expenseForm.category = "";
        $scope.expenseForm.amount = ""
    };
});