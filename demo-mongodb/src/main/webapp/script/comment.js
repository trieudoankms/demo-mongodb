var bookId = $("#book_id").val();
Comment = Backbone.Model.extend({
    defaults:{
        bookId: bookId,
        comment: ''
    },
    urlRoot: '/demo-mongodb/comments.do',
    initialize: function(){
        console.log("init a comment")
    }
});

//var comment = new Comment();

CommentView = Backbone.View.extend({
        initialize: function(){
            this.model = new Comment();

            // read list of comment
            this.comments = new Backbone.Collection;
            this.comments.url = '/demo-mongodb/comments/' + bookId + '.do';

            this.render();
        },
        render: function(){
            // Compile the template using underscore
            var template = _.template( $("#comment_template").html());
            // Load the compiled HTML into the Backbone "el"
            this.$el.html(template);

            this.comments.fetch({
                success: function (collection, response) {
                    this.comments = collection;
                    this.comments.each(function(comment){
                        var commentElement = "<div>" + comment.attributes.comment +"</div>";
                        $("#list_comment").append(commentElement);
                    });
                }
            });
        },
        events: {
        	"click button": "addComment",
        	"change textarea": "updateModel"

        },
        addComment: function(){
            this.model.save(null, {
                success: function (model, response) {
                    console.log(model);
                    this.model = new Comment();
                    $("#inputComment").val('');
                    this.comments.unshift(model);
                    var commentElement = "<div>" + model.attributes.comment +"</div>";
                     $("#list_comment").append(commentElement);
                },
                error: function (model, response) {
                    console.log("error");
                },
                wait: true
            });
        },
        updateModel: function(){
            //this.model.set("comment",$("#inputComment").val());
            this.model.attributes.comment = $("#inputComment").val();
        }
    });

var commentView  = new CommentView({ el: $("#comment_container") });
