function deleteBook(a) {
    if (confirm("Are you sure you want to delete this book?") == true) {
        a.parentNode.submit();
    }
}