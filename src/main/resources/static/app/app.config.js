angular
    .module("App")
    .config(configure);
configure.$inject = ['$stateProvider', '$urlRouterProvider'];
function configure ($stateProvider, $urlRouterProvider) {

    $stateProvider
        .state('tasks', {
            url: '/tasks',
            templateUrl: 'app/components/views/tasks.html',
            controller: 'tasksCtrl'
        })
        .state('projects', {
            url: '/projects',
            templateUrl: 'app/components/views/projects.html',
            controller: 'projectsCtrl'
        })
        .state('timesheets', {
            url: '/timesheets',
            templateUrl: 'app/components/views/timesheets.html',
            controller: 'timesheetsCtrl'
        });

    $urlRouterProvider.otherwise("/timesheets");
}