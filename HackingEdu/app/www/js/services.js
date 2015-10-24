angular.module('starter.services', [])

/*.factory('BlogEntry', function($resource) {
  return $resource("http://localhost:3000/blog_entries/:id.json");
})*/

.factory('UserSession', function($resource) {
  return $resource("http://ec2-54-144-102-52.compute-1.amazonaws.com:8080/users/sign_in.json");
})