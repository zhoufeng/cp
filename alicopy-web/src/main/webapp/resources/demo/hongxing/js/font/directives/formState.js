(function(){var n,r;n=[],r=function(){var n;return n=function($timeout){return{restrict:"A",link:function(n,r,i){var t,e,s,u,a,o,l,c,d,f,v,h;for(v=i.formState.split("."),u=v[0],s=v[1],e=function(){return n[u][s]},l=null,t=r.find("div"),c=f=0,h=t.length;h>=0?h>=f:f>=h;c=h>=0?++f:--f)if(t.eq(c).hasClass("errors")){l=t.eq(c);break}return d=r.find("input"),d.on("keydown",function(){return $timeout(function(){return e()?e().$stateVisible=!1:void 0})}).on("blur",function(){var n;return(null!=(n=e())?n.$dirty:void 0)?$timeout(function(){return e()?e().$stateVisible=!0:void 0}):void 0}),a=function(n){return n[u][s].$stateVisible&&n[u][s].$invalid},o=function(n){var r;return n[u][s].$stateVisible&&(null!=(r=e())?r.$valid:void 0)},n.$watch(a,function(n){return n?(r.addClass("has-error"),l.removeClass("invisible")):(r.removeClass("has-error"),l.addClass("invisible"))}),n.$watch(o,function(n){return n?r.addClass("has-success"):r.removeClass("has-success")})}}}},define(n,r)}).call(this);