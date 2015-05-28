
requirejs.config({
    baseUrl: '/demo-mongodb/script',
    paths: {
        app: './app',
        lib: './lib'
    }
});

requirejs(['lib/jquery-1.11.3.min']);
requirejs(['app/app']);