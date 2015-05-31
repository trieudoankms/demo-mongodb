requirejs.config({
    baseUrl: '/demo-mongodb/script',
    paths: {
        app: './app',
        lib: './lib'
    }
});

requirejs(['lib/jquery-1.11.3.min']);
requirejs(['lib/underscore-min']);
requirejs(['lib/backbone-min']);
requirejs(['app/app']);
requirejs(['app/comment']);