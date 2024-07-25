package clothingstore.constant;

public class DatabaseQueries {
    
    // Category
    public static final String GETDATA = "SELECT * FROM Categories";
    public static final String GET_QUANTITY_BY_NAME = "SELECT COUNT(*) AS Total FROM Categories WHERE categoryname = ?";
    public static final String GET_CATEGORY_BYID = "SELECT * FROM Categories WHERE categoryid = ?";
    public static final String INSERT_CATEGORY = "INSERT INTO Categories VALUES (?,?)";
    public static final String DELETE_CATEGORY = "DELETE FROM Categories WHERE categoryid = ?";
    public static final String GET_CATEGORY_BY_TYPEID = "SELECT * FROM Categories WHERE type_id = ?";
    public static final String UPDATE_CATEGORY = "UPDATE Categories SET categoryname = ?, Type_id = ? WHERE categoryid = ?";
    
    // Order
    public static final String GET_TOTAL_SALE = "SELECT SUM(totalprice) AS TotalSale from [Orders]";
    public static final String GET_TOTAL_MONEY_YEAR = "SELECT SUM(totalprice) AS TotalSale from [Orders] where year([orderdate]) = ? AND Status = 1";
    public static final String GET_TOTAL_MONEY_MONTH = "SELECT SUM(totalprice) AS TotalSale from [Orders] where month([orderdate]) = ? AND Status = 1";
    public static final String GET_NUMBER_ORDERS = "SELECT COUNT(*) AS Total FROM [Orders]";
    public static final String GET_TOTAL_ORDERS = "SELECT * FROM [Orders]";
    public static final String GET_TOTAL_SALE_TODAY = "SELECT sum(totalprice) AS TotalSale FROM [Orders] "
        + " WHERE cast(orderdate as Date) = cast(getdate() as Date)";
    public static final String GET_ORDERS_USER = "SELECT * FROM [Orders] WHERE username = ?";
    public static final String GET_ORDERS_BYID = "SELECT * FROM [Orders] WHERE order_id = ?";
    public static final String GET_RECENT_ORDERS = "SELECT Top 10 * FROM Orders ORDER BY orderdate DESC";
    public static final String UPDATE_STATUS = "UPDATE [Orders] SET status = 1 WHERE order_id = ?";
    public static final String GET_LATEST_ORDER = "SELECT TOP 1 * FROM Orders ORDER BY order_id DESC";
    public static final String CREATE_ORDER = "INSERT INTO [dbo].[Orders]\n"
        + "           ([orderdate]\n"
        + "           ,[totalprice]\n"
        + "           ,[paymentid]\n"
        + "           ,[username]\n"
        + "           ,[status])\n"
        + "     VALUES(?,?,?,?, 0)";
    
    // OrderItem
    public static final String GET_ORDER_ITEM_BY_ORDER_ID = "SELECT order_id, product_id, SUM(quantity) AS quantity, price FROM OrderItem WHERE order_id = ? GROUP BY order_id, product_id, price";
    public static final String CREATE_NEW_ORDER_ITEM = "INSERT INTO [dbo].[OrderItem]\n"
        + "           ([quantity]\n"
        + "           ,[price]\n"
        + "           ,[product_id]\n"
        + "           ,[order_id])\n"
        + "     VALUES (?,?,?,?)";
    
    // Payment
    public static final String GET_PAYMENTNAME_BYID = "SELECT * FROM Payments WHERE paymentid = ?";
    public static final String GET_PAYMENTNAME_DATA = "SELECT * FROM Payments";
    
    // Product
    public static final String GET_DATA = "SELECT * FROM Products WHERE status = 1";
    public static final String GET_TOTAL_PRODUCTS = "SELECT COUNT(*) AS Total FROM Products WHERE status = 1";
    public static final String GET_QUANTITY_SOLD = "SELECT SUM(unitSold) AS Total from Products";
    public static final String GET_STOCK = "SELECT stock AS Total FROM Products WHERE id = ?";
    public static final String GET_PRODUCTS_LOW_QUANTITY = "SELECT COUNT(*) AS Total from Products WHERE Stock < 10 AND status = 1";
    public static final String GET_PRODUCTS_BY_ID = "SELECT * FROM Products WHERE id = ? AND status = 1";
    public static final String GET_PRODUCTS_BY_TYPE_ID = "SELECT * FROM Products WHERE typeid = ? AND status = 1";
    public static final String GET_PRODUCTS_BY_CATEGORY_ID = "SELECT * FROM Products WHERE categoryid = ? AND status = 1";
    public static final String GET_PRODUCTS_BY_SUPPLIER_ID = "SELECT * FROM Products WHERE supplierid = ? AND status = 1";
    public static final String GET_PRODUCTS_NEW_YEAR = "SELECT * from Products WHERE year(releasedate) = 2024 AND status = 1";
    public static final String GET_PRODUCTS_BEST_SELLER = "SELECT TOP(5) * from Products WHERE status = 1 order by unitSold desc";
    public static final String GET_PRODUCTS_BY_SEARCH = "SELECT * FROM Products WHERE productname LIKE ? AND status = 1";
    public static final String DELETE_PRODUCT = "UPDATE Products SET status = 0 WHERE id = ?";
    public static final String UPDATE_QUANTITY_PRODUCT = "UPDATE Products SET [stock] = ? WHERE id = ?";
    public static final String INSERT_PRODUCT = "INSERT INTO Products VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    
    // Supplier
    public static final String GETDATASUPPLIER = "SELECT * FROM Suppliers";
    public static final String GETSUPPLIERBYID = "SELECT * FROM Suppliers WHERE supplierid = ?";
    
    // Type
    public static final String GET_TYPE_BY_ID = "SELECT * FROM Types WHERE id = ?";
    public static final String GET_ALL_TYPE= "SELECT * FROM Types";
    
    // User
    public static final String LOGIN = "SELECT * FROM Users WHERE (username=? OR email = ?) AND password=? and status=1";
    public static final String GET_PASSWORD = "SELECT password FROM Users WHERE username = ?";


    public static final String GET_DATA_USER = "SELECT * FROM Users WHERE status = 1 Order by roleid asc";

    public static final String GET_USER_BY_NAME = "SELECT * FROM Users WHERE username = ? AND status = 1";

    public static final String GET_USER_BY_EMAIL = "SELECT * FROM Users WHERE email = ? AND status = 1";

    public static final String GET_TOTAL_USERS = "SELECT COUNT(*) AS Total FROM Users WHERE status = 1 AND roleid=2";

    public static final String UPDATE_USER = "UPDATE Users SET firstName = ?, lastName = ?, email = ?, address = ?, phone = ?, avatar = ?, roleid = ? WHERE username = ?";

    public static final String UPDATE_PASSWORD_FOR_USER = "UPDATE Users SET password = ? WHERE username = ?";

    public static final String CHECK_USERNAME_DUPLICATE = "SELECT * FROM Users WHERE userName = ? or email = ? and [status] = 1";

    public static final String DELETE_USER = "UPDATE Users SET status = 0 WHERE id = ?";

    public static final String REGISTER_USER = "INSERT INTO [dbo].[Users]\n"
        + "           ([firstname]\n"
        + "           ,[lastname]\n"
        + "           ,[email]\n"
        + "           ,[avatar]\n"
        + "           ,[username]\n"
        + "           ,[password]\n"
        + "           ,[address]\n"
        + "           ,[phone]\n"
        + "           ,[roleid]\n"
        + "           ,[status])\n"
        + "     VALUES\n"
        + "           (?,?,?,?,?,?,?,?,?,?)";
}
