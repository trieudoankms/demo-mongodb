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

CommentCollection = Backbone.Collection.extend({
    model: Comment
});

// var self;
CommentView = Backbone.View.extend({
        initialize: function(){
            this.model = new Comment();

            // read list of comment
            this.comments = new CommentCollection();
            this.startPosition = 0;
            this.number = 5;
            this.updateGetCommentsUrl();
            this.render();
        },
        updateGetCommentsUrl: function(){
             this.comments.url = '/demo-mongodb/comments/' + bookId + '/' + this.startPosition + '/' + this.number + '.do';
        },
        render: function(){
            // Compile the template using underscore
            var template = _.template( $("#comment_template").html());
            // Load the compiled HTML into the Backbone "el"
            this.$el.html(template);

            var self = this;
            this.comments.fetch({
                success: function (collection, response) {
                    self.comments.each(function(comment){
                        self.createCommentView(comment);
                    });
                    console.log(self.comments);
                }
            });
        },
        events: {
        	"click #btnComment": "addComment",
        	"click #btnLoadMore": "addMoreComment",
        	"click .btnDelete": "deleteComment",
        	"change textarea": "updateModel"

        },
        addComment: function(){
            var self = this;
            this.model.save(null, {
                success: function (model, response) {
                    console.log(model);
                    self.model = new Comment();
                    $("#inputComment").val('');
                    self.comments.unshift(model);
                    self.createCommentView(model);
                },
                error: function (model, response) {
                    console.log("error");
                },
                wait: true
            });
        },
        addMoreComment: function(){
            this.startPosition += this.number;
            this.updateGetCommentsUrl();
            var self = this;
            var commentCollectionLoading = new CommentCollection();
            commentCollectionLoading.url = this.comments.url;
            commentCollectionLoading.fetch({
                success: function (collection, response) {
                    console.log(self.comments);
                    collection.each(function(comment){
                        self.comments.push(comment);

                        self.createCommentView(comment);
                    });
                    console.log(self.comments);
                }
            });
        },
        deleteComment: function(event){
            var id =  $(event.currentTarget).data('id');
           if (confirm("Are you sure you want to delete this comment?")) {
                var comment = this.comments.get(id);
                console.log(comment);
                comment.url = "/demo-mongodb/comments/" + comment.attributes.id + ".do";
                console.log(comment);
                var self = this;
                comment.destroy({success: function(model, response) {
                    //self.comments.remove(comment);
                    $(event.currentTarget).closest("div[class^='comment_border']").remove();
                }});
                console.log(comment);
           }
        },
        updateModel: function(){
            //this.model.set("comment",$("#inputComment").val());
            this.model.attributes.comment = $("#inputComment").val();
        },
        createCommentView: function(comment){
            var commentElement = "<div class='comment_border'><div class='comment_detail'><img src='/demo-mongodb/images/user.jpg' alt='User' height='42' width='42'> <span>"
                                + comment.attributes.comment +"</span></div><div><button class='btnDelete' data-id='" + comment.attributes.id + "'>Delete</button></div></div>";
            $("#list_comment").append(commentElement);
        }
    });

var commentView  = new CommentView({ el: $("#comment_container") });
