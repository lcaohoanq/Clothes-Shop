<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="header_area" id="fixed-header">
    <!--header start--> 
    <div class="header_middel">
        <div class="row align-items-center" style="padding: 0">
            <!--logo start-->
            <div class="col-lg-1 col-md-1">
                <div class="logo">
                    <a href="DispatchServlet"><img src="view\assets\home\img\logo\logo.jpg.png" alt=""></a>
                </div>
            </div>
            <!--logo end-->
            <div class="header_bottom col-lg-7 col-md-7">
                <div class="row">
                    <div class="col-12 non-padding">
                        <div class="main_menu d-none d-lg-block">
                            <nav>
                                <ul>
                                    <li class="${requestScope.CURRENTSERVLET == "Home" ? "active" : ""} col-lg-2 col-md-2 non-padding"><a href="DispatchServlet">Home</a></li>
                                    <li class="${requestScope.CURRENTSERVLET == "Shop" ? "active" : ""} col-lg-2 col-md-2 non-padding"><a href="ShopServlet">SHOP</a></li>
                                    <li class="${requestScope.CURRENTSERVLET == "Contact" ? "active" : ""} col-lg-2 col-md-2 non-padding"><a href="ContactServlet">Contact Us</a></li>
                                    <li class="${requestScope.CURRENTSERVLET == "Wishlist" ? "active" : ""} col-lg-2 col-md-2 non-padding"><a href="WishlistServlet">My Wishlist</a></li>
                                    <li class="${requestScope.CURRENTSERVLET == "Cart" ? "active" : ""} col-lg-2 col-md-2 non-padding"><a href="CartServlet">My Cart</a></li>
                                        <c:if test="${sessionScope.account == null}">
                                        <li class="${requestScope.CURRENTSERVLET == "Login" ? "active" : ""} col-lg-2 col-md-2 non-padding"><a href="DispatchServlet?btnAction=Login" title="Login">Login</a></li>  
                                        </c:if>
                                        <c:if test="${sessionScope.account != null}">
                                        <li class="${requestScope.CURRENTSERVLET == "Login" ? "active" : ""} col-lg-2 col-md-2 non-padding"><a href="${sessionScope.account.roleID == 1 ? 'AdminServlet' : 'ProfileServlet'} ">Hello, ${sessionScope.account.firstName} ${sessionScope.account.lastName}!</a></li>
                                        </c:if>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-4">
                <div class="header_right_info">
                    <div class="search_bar col-lg-7 no-padding">
                        <form action="DispatchServlet" method="get" >
                            <input name="txtSearch" value="" placeholder="Search..." type="text">
                            <button name="btnAction" value="Search" type="submit"><i class="fa fa-search"></i></button>
                        </form>
                    </div>
                    <div class="shopping_cart col-lg-2" id="cart-icon">
                        <c:if test="${sessionScope.CART != null && sessionScope.CART.size() != 0}">
                            <a href="#"><i class="fa fa-shopping-cart"></i> ${sessionScope.CART.size()} Items <i class="fa fa-angle-down"></i></a>
                            </c:if>
                            <c:if test="${sessionScope.CART == null || sessionScope.CART.size() == 0}">
                            <a href="#"><i class="fa fa-shopping-cart"></i><i class="fa fa-angle-down"></i></a>
                                </c:if>

                        <!--mini cart-->
                        <div class="mini_cart" >
                            <div style="max-height: 300px; overflow-y: auto;">
                                <c:forEach items="${sessionScope.CART}" var="c">
                                    <div class="cart_item">
                                        <div class="cart_img">
                                            <a href="SingleProductServlet?product_id=${c.product.id}"><img src="${c.product.images[0]}" alt=""></a>
                                        </div>
                                        <div class="cart_info">
                                            <a href="SingleProductServlet?product_id=${c.product.id}">${c.product.name}</a>
                                            <span class="cart_price">${c.product.getSalePrice()}&#273;</span>
                                            <span class="quantity">X ${c.quantity}</span>
                                        </div>
                                        <div class="cart_remove">
                                            <!--<a title="Remove this item" href="CartServlet?action=Delete&product_id=${c.product.id}&curPage=header.jsp"><i class="fa fa-times-circle"></i></a>-->
                                            <button style="    background-color: transparent;
                                                    border: none;
                                                    color: #28a745;" onclick="deleteProducOnICon('Delete',${c.product.id}, 'header.jsp')"><i class="fa fa-times-circle"></i></button>

                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                            <div class="total_price">
                                <span> Total </span>
                                <span class="prices">  
                                    <c:set var="totalPrice" value="0" />
                                    <c:forEach items="${sessionScope.CART}" var="c">
                                        <c:set var="productTotal" value="${c.product.getSalePrice() * c.quantity}" />
                                        <c:set var="totalPrice" value="${totalPrice + productTotal}" />
                                    </c:forEach>
                                    ${totalPrice}&#273;
                                </span>
                            </div>
                            <div class="cart_button">
                                <a href="CheckoutServlet"> Check out</a>
                            </div>
                        </div>
                        <!--mini cart end-->
                    </div>

                    <div class="main_menu d-none d-lg-block">
                        <c:if test="${sessionScope.account != null}">
                            <nav>
                                <ul>
                                    <li class="${requestScope.CURRENTSERVLET == "Login" ? "active" : ""}"><a href="DispatchServlet?btnAction=Logout">Logout</a></li>
                                    </c:if>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </div>     
    <!--header middel end-->      

</div>
