<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<style>
    .navbar {
        display: flex;
        justify-content: space-around;
        background-color: #333;
        color: white;
    }
    .nav-item {
        display: none;
    } /* Hide initially */
    @media (max-width: 768px) {
        .nav-item {
            display: block;
        }
    }
    @media (min-width: 769px) {
        .navbar {
            display: none;
        }
    }
</style>
<div class="header_area" id="fixed-header">
    <!--header start-->
    <div class="navbar">
        <!-- My Wishlist -->
        <a href="WishlistServlet" class="nav-item" aria-label="Yêu thích">
            <i class="fa-solid fa-heart"></i>
        </a>
        <!-- My Cart -->
        <a href="CartServlet" class="nav-item" aria-label="Giỏ hàng">
            <i class="fa-solid fa-cart-shopping"></i>
        </a>
        <!-- Login/Logout -->
        <!-- This part should be dynamically generated based on user's login status -->
        <c:if test="${sessionScope.account == null}">
            <a class="nav-item" aria-label="Đăng nhập" href="MainController?btnAction=Login" title="Login">
                Login
            </a>
        </c:if>
        <c:if test="${sessionScope.account != null}">
            <a href="${sessionScope.account.roleID == 1 ? 'AdminServlet' : 'ProfileServlet'} ">
                <i class="fa-solid fa-user"></i> ${sessionScope.account.firstName} ${sessionScope.account.lastName}!
            </a>
        </c:if>
        <c:if test="${sessionScope.account != null}">
            <a href="MainController?btnAction=Logout">
                <i class="fa-solid fa-right-from-bracket"></i>
            </a>
        </c:if>

        <!-- Logout - Example only, should replace Login when user is authenticated -->
        <!-- <a href="LogoutServlet" class="nav-item" aria-label="Logout">
          <i class="fas fa-sign-out-alt"></i>
        </a> -->
    </div>
    <div class="header_middel">
        <div class="row align-items-center" style="padding: 0; margin: 0px">
            <!--logo start-->
            <div class="col-lg-3 col-md-2 col-sm-2 col-3">
                <div class="logo" style="display: flex; justify-content: center;">
                    <a href="MainController"><img src="view\assets\home\img\logo\logo.png" alt=""></a>
                </div>
            </div>
            <!--logo end-->

            <!--search bar-->
            <div class="header_right_info col-lg-5 col-md-7 col-sm-8 col-7">
                <div class="search_bar col-lg-12 no-padding">
                    <form action="MainController" method="get" >
                        <input name="txtSearch" value="" placeholder="Bao ship 0đ - Đăng ký ngay!" type="text">
                        <button name="btnAction" value="Search" type="submit"><i class="fa fa-search"></i></button>
                    </form>
                </div>
            </div>
            <!--search bar end-->

            <!--cart-->
            <div class="col-lg-4 col-md-3 col-sm-2 col-2">
                <div class="header_bottom">
                    <div class="row" style="align-items: center">

                        <div class="col-lg-3 col-md-4 col-sm-2 col-12 shopping_cart" id="cart-icon">
                            <nav>
                                <c:if test="${sessionScope.CART != null && sessionScope.CART.size() != 0}">
                                    <a href="#"><i class="fa fa-shopping-cart"></i> ${sessionScope.CART.size()}
                                    </c:if>
                                    <c:if test="${sessionScope.CART == null || sessionScope.CART.size() == 0}">
                                    <a href="#"><i class="fa fa-shopping-cart"></i></a>
                                    </c:if>
                            </nav>
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
                                                <button style="background-color: transparent;
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

                        <div class="col-lg-7 col-md-0 col-sm-12 non-display non-padding">
                            <div class="main_menu d-none d-lg-block">
                                <nav>
                                    <ul>
                                        <li class="${requestScope.CURRENTSERVLET == "Wishlist" ? "active" : ""} col-lg-3 col-md-2 col-sm-2 non-padding"><a href="WishlistServlet">Yêu thích</a></li>
                                        <li class="${requestScope.CURRENTSERVLET == "Cart" ? "active" : ""} col-lg-4 col-md-2 col-sm-2 non-padding"><a href="CartServlet">Giỏ hàng</a></li>
                                        <c:if test="${sessionScope.account == null}">
                                            <li class="${requestScope.CURRENTSERVLET == "Login" ? "active" : ""} col-lg-5 col-md-2 col-sm-2 non-padding"><a href="MainController?btnAction=Login" title="Login">Đăng nhập</a></li>
                                        </c:if>
                                        <c:if test="${sessionScope.account != null}">
                                            <li class="${requestScope.CURRENTSERVLET == "Login" ? "active" : ""} col-lg-5 col-md-4 col-sm-2 non-padding"><a href="${sessionScope.account.roleID == 1 ? 'AdminServlet' : 'ProfileServlet'} ">${sessionScope.account.firstName}</a></li>
                                        </c:if>
                                    </ul>
                                </nav>
                            </div>
                        </div>

                        <div class="col-lg-2 col-md-2 non-display non-padding">
                            <div class="main_menu d-none d-lg-block ">
                                <nav>
                                    <c:if test="${sessionScope.account != null}">
                                        <ul>
                                            <li class="${requestScope.CURRENTSERVLET == "Login" ? "active" : ""} col-lg-12 col-md-12 non-padding"><a href="MainController?btnAction=Logout">Đăng xuất</a></li>
                                            </c:if>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--cart end-->
        </div>
    </div>
    <!--header middel end-->

</div>
