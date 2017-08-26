/**
 * AdminUI - Responsive Admin Theme
 *
 */
(function () {
    angular.module('AdminUI', [
        'ui.router',                   // Routing
        'oc.lazyLoad',                // ocLazyLoad
        'ui.bootstrap',               // Ui Bootstrap      
        'ngResource',
        'ui.select',
        'ngSanitize',
        'monospaced.elastic'
    ])
})();

// Other libraries are loaded dynamically in the config.js file using the library ocLazyLoad