function deleteBook(a) {
    if (confirm("Are you sure you want to delete this book?")) {
        a.parentNode.submit();
    }
}

var addCSRFToken = function () {
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    console.log("token: " + token);
    console.log("header: " + header);
    $(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });
}

addCSRFToken();