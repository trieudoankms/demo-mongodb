Comment = Backbone.Model.extend({
    defaults:{
        id: '',
        bookId: '',
        comment: ''
    },
    initialize: function(){
                alert("Init Comment model");
            }
});

var comment = new Comment();

/*
// read list of comment
var comments = new Backbone.Collection;
comments.url = '/comments';
comments.fetch();*/
