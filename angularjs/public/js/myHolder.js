angular.module('myHolder', [])
    .directive('myHolder', function () {
    return {
        link: function (scope, element, attrs) {
            attrs.$set('data-src', attrs.myHolder);
            Holder.run({images:element[0]});
        }
    };
});