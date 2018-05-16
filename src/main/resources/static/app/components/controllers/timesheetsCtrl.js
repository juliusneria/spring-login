angular
    .module('App')
    .controller('timesheetsCtrl',timesheetsCtrl);
timesheetsCtrl.$inject = ['$scope','$timeout'];
function timesheetsCtrl($scope, $timeout) {

    $('#calendar').fullCalendar({
        header: {
            left: 'prev,next today',
            center: 'title',
            right: 'month,basicWeek,basicDay'
        },
        defaultDate: new Date(),
        editable: true,
        droppable: true,
        eventLimit: true
    });
}