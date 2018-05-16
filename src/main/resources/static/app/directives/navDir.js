angular
    .module('App')
    .directive('navDir',navDir);
function navDir(){
    return {
        restrict: 'E',
        templateUrl: 'app/directives/views/navs.html',
        controller: 'navCtrl'
    }
}