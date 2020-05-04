<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
  <title>Very Simple Web Shop</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> 
   <link rel="stylesheet" href="../SimpleWebShop/resources/style.css"> 
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/SimpleWebShop">Web Shop</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
    </div>
  </div>
</nav>

<div class="container-fluid text-center">
  <div class="row content">
    <div class="col-sm-2 sidenav">
      <div class="col-sm-3 sidenav hidden-xs">
      <h3>Categories</h3>
      <ul class="nav nav-pills nav-stacked">
        <li><a href="/SimpleWebShop/items?item=cars">Cars</a></li>
        <li><a href="/SimpleWebShop/items?item=shoes">Shoes</a></li>
        <li><a href="/SimpleWebShop/items?item=diamonds">Diamonds</a></li>
        <li><a href="/SimpleWebShop/items?item=cart">View Cart</a></li>
        <li><a href="/SimpleWebShop/items?item=emptycart">Empty Cart</a></li>
        <li><a href="<c:url value="/logout" />" > Logout</a></li>
      </ul><br>
    </div>
    <br>
    </div>
    <div class="col-sm-8 text-left">
      <c:if test="${products != null}">
      <h3>Products</h3>
      <table class="table">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">Product name</th>
            <th scope="col">Category</th>
            <th scope="col">Price</th>
          </tr>
        </thead>
        <tbody>
          <!-- loop over and print our customers -->
          <c:forEach var="product" items="${products}">
            <tr>
              <th scope="row">${product.id}</th>
              <td> ${product.name} </td>
              <td> ${product.category}</td>
              <td> ${product.price} </td>
              <c:if test="${!(product['class'].simpleName == 'CartEntity')}">
              		<td> <button type="button" onclick="event.preventDefault(); addToCart(this, ${product.id}, '${product.name}', '${product.category}', '${product.price}')">Add to cart</button></td>
              </c:if>
            </tr>
          </c:forEach>
        </tbody>
      </table>
      </c:if>
    </div>
    <div class="col-sm-2 sidenav">
      <h5>Cart</h5>
      <div id="cart_container" >
      </div>
    </div>
  </div>
</div>

<footer class="container-fluid text-center" style="bottom: 0;">
  <p>Youngculture.SimpleWebShop</p>
</footer>

<script>
    function addToCart(element, id, name, category, price) {
      $.ajax({
    	  url: '/SimpleWebShop/cart/item',
          type: 'POST',
          data: {
        	  id: id,
              name: name,
              category: category,
              price: price
          },
          success: function () {
            var elementForCart = "<div class=\"well\"><p>" +
            element.parentElement.parentElement.getElementsByTagName('td')[0].innerText;
            elementForCart += "</p></div>";
            $("#cart_container").append(elementForCart);
          }
      });
      return false;
    }
</script>


</body>
</html>