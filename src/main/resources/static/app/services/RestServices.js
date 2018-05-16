angular
    .module('App')
    .service('RestServices', RestServices);
RestServices.$inject = ['$http','$q'];
function RestServices($http, $q) {
    var server = 'http://localhost:8080';

    /*Store services*/
    this.getAllStore = function() {

        var deferred = $q.defer();
        $http({
            method: 'GET',
            url: server+'/store/all'
        }).success(function success(response) {
            deferred.resolve(response)
        }).error(function error(response) {
            deferred.reject(response);
        });
        return deferred.promise;
    };

    /*this.createStore = function() {
        $http({
            method: 'POST',
            url: server+'/store/all'
        }).success(function success(response) {
            deferred.resolve(response)
        }).error(function error(response) {
            deferred.reject(response);
        });
        return deferred.promise;
    };

    this.updateStore = function() {
        $http({
            method: 'PUT',
            url: server+'/store/all'
        }).success(function success(response) {
            deferred.resolve(response)
        }).error(function error(response) {
            deferred.reject(response);
        });
        return deferred.promise;
    };

    this.deleteStore = function() {
        $http({
            method: 'DELETE',
            url: server+'/store/all'
        }).success(function success(response) {
            deferred.resolve(response)
        }).error(function error(response) {
            deferred.reject(response);
        });
        return deferred.promise;
    };*/

    /*Book services*/
    this.getAllBooks = function(){

        var deferred = $q.defer();
        $http({
            method: 'GET',
            url: server+'/book/all'
        }).success(function success(response) {
            deferred.resolve(response)
        }).error(function error(response) {
            deferred.reject(response);
        });
        return deferred.promise;
    };

    this.createBook = function(body){
        var deferred = $q.defer();

        $http.post(server+'/book/add', body)
            .success(function (data) {
                deferred.resolve(data)
            })
            .error(function (data) {
                deferred.reject(data);
            });
        return deferred.promise;
    };

    this.updateBook = function(body){
        var deferred = $q.defer();

        $http.put(server+'/book/update', body)
            .success(function (data) {
                deferred.resolve(data)
            })
            .error(function (data) {
                deferred.reject(data);
            });
        return deferred.promise;
    };

    this.deleteBook = function(body){
        var deferred = $q.defer();

        $http({
            method: 'DELETE',
            url: server+'/book/delete/'+body.id
        }).success(function (data) {
            console.log(data);
            deferred.resolve(data)
        }).error(function (data) {
            deferred.reject(data);
        });
        return deferred.promise;
    };
    /*End of booking services*/

    /*Manager services*/
    this.getAllManagers = function(){
        var deferred = $q.defer();
        $http({
            method: 'GET',
            url: server+'/manager/all'
        }).success(function success(response) {
            deferred.resolve(response)
        }).error(function error(response) {
            deferred.reject(response);
        });
        return deferred.promise;
    };

    this.createManager = function(body){
        var deferred = $q.defer();

        $http.post(server+'/manager/add', body)
            .success(function (data) {
                deferred.resolve(data)
            })
            .error(function (data) {
                deferred.reject(data);
            });
        return deferred.promise;
    };

    this.updateManager = function(body){
        var deferred = $q.defer();

        $http.put(server+'/manager/update', body)
            .success(function (data) {
                deferred.resolve(data)
            })
            .error(function (data) {
                deferred.reject(data);
            });
        return deferred.promise;
    };

    this.deleteManager = function(body){
        console.log(body);

        var deferred = $q.defer();

        $http({
            method: 'DELETE',
            url: server+'/manager/delete',
            data: body,
            headers: {'Content-Type': 'application/json'}
        }).success(function (data) {
            deferred.resolve(data);
        }).error(function (data) {
            deferred.reject(data);
        });
        return deferred.promise;
    };
}
