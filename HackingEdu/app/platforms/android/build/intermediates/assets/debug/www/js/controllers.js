angular.module('starter.controllers', [])

.controller('AppCtrl', function($scope, $ionicModal, $timeout) {

  // With the new view caching in Ionic, Controllers are only called
  // when they are recreated or on app start, instead of every page change.
  // To listen for when this page is active (for example, to refresh data),
  // listen for the $ionicView.enter event:
  //$scope.$on('$ionicView.enter', function(e) {
  //});

  /*// Form data for the login modal
  $scope.loginData = {};

  // Create the login modal that we will use later
  $ionicModal.fromTemplateUrl('templates/login.html', {
    scope: $scope
  }).then(function(modal) {
    $scope.modal = modal;
  });

  // Triggered in the login modal to close it
  $scope.closeLogin = function() {
    $scope.modal.hide();
  };

  // Open the login modal
  $scope.login = function() {
    $scope.modal.show();
  };

  // Perform the login action when the user submits the login form
  $scope.doLogin = function() {
    console.log('Doing login', $scope.loginData);

    // Simulate a login delay. Remove this and replace with your login
    // code if using a login system
    $timeout(function() {
      $scope.closeLogin();
    }, 1000);
  };*/
})

/*.controller('DashCtrl', function($scope, BlogEntry) {
  BlogEntry.query().$promise.then(function(response){
    $scope.blog_entries = response;
  });
})*/

.controller('LoginCtrl', function($scope, $location, UserSession, $ionicPopup, $rootScope) {
$scope.data = {};

$scope.login = function() {
  var user_session = new UserSession({ user: $scope.data });
  user_session.$save(
    function(data){
      window.localStorage['userId'] = data.id;
      window.localStorage['userName'] = data.name;
      $location.path('app/home');
    },
    function(err){
      var error = err["data"]["error"] || err.data.join('. ')
      var confirmPopup = $ionicPopup.alert({
        title: 'An error occured',
        template: error
      });
    }
  );
}
})


.controller('ExploreCtrl', function($scope) {
  $scope.projects = [
    { title: 'Job Club', channel: 'JPMC Code for Good', id: 1, tags: ['Design', 'Tech', 'Development'] },
    { title: 'Pomelo', channel: "Qualcomm's EmpowHERment Summit", id: 4, tags: ['Design', 'Tech', 'Development']  },
    { title: 'Accio', channel: 'PearlHacks at UNC-Chapel Hill', id: 5, tags: ['Design', 'Tech', 'Development'] },
  ];
})

.controller('ChannelsCtrl', function($scope) {
  $scope.curr_channels = [
    { title: 'JPMC Code for Good', id: 1, img: '/img/Code4Good.jpg' }
  ];

    $scope.past_channels = [
    { title: 'HackGT at Georgia Tech', id: 2, img: '/img/HackGT.jpg' },
    { title: "Qualcomm's EmpowHERment Summit", id: 3, img: '/img/qualcomm.jpg' },
    { title: 'Grace Hopper Celebration 2015', id: 4, img: '/img/GraceHopper.jpg' }
  ];
})

.controller('ProjectsCtrl', function($scope) {
  $scope.curr_projects = [
    { title: 'Job Club', channel: 'JPMC Code for Good', id: 1 },
  ];

    $scope.past_projects = [
    { title: 'Pomelo', channel: "Qualcomm's EmpowHERment Summit", id: 4 },
    { title: 'Accio', channel: 'PearlHacks at UNC-Chapel Hill', id: 5 },
  ];
})
