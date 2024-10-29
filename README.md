AMA Coding Challenge

Task: implement a simple security framework which reads the header
`x-user-id:` to get a username, and applies authorization to search/read
books based on the user's "clearance".

Books have a "classification" of either `TOP_SECRET` or `UNCLASSIFIED`
Users have a "clearance" of the same enum.

Users with `TOP_SECRET` clearance can read all books.
Users with `UNCLASSIFIED` clearance can only read `UNCLASSIFIED` books.

There are 2 books and 2 users in the database as committed. 

Feel free to write tests!

The postman collection could be helpful in manual testing.
