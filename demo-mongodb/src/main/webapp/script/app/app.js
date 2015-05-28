function deleteBook(a) {
    if (confirm("Are you sure you want to delete this book?")) {
        a.parentNode.submit();
    }
}