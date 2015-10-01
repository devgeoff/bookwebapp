<!DOCTYPE html>
<html lang="en">

<%@include file="header.jsp" %>

<div class="container">
	<div class="row">
	<div class="col-md-7col-md-offset-2">
  <h2 align = "center">Administration Page</h2>
  <p> Posted Books</p>            
  <table class="table">
    <thead>
      <tr>
        <th>Book Title</th>
        <th>Book Cover</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody>
     <c:forEach var="listing" items="${currentUserListings}">
     <tr>
        <td>${listing.listingTitle}</td>
        <td>
        <img id = "coverImage" alt= "Book Cover" width="50px" height ="50px" src = ${listing.image}/>        
        </td>
        <td>
        <p align="center"><a href="deleteListing?listingdetails=${listing.id}-${pageContext.request.userPrincipal.name}" class="btn btn-primary btn-block">Delete Listing</a></p>
        
        </td>
      </tr>
    </c:forEach>    
     </tbody>
  </table>
  
    <h2 align = "center">Transaction History</h2>
     <h3>Sales</h3>    
     <table class="table">
    <thead>
      <tr>
        <th>Transaction Date</th>
        <th>Buyer</th>
        <th>Amount</th>
      </tr>
    </thead>
    <tbody>
     <c:forEach var="saletransaction" items="${sellingTransactions}">
     <tr>
        
        <td>${saletransaction.transactionDate}</td>
        <td>${saletransaction.buyer}</td>
        <td>${saletransaction.transactionAmount}</td>
        
      </tr>
    </c:forEach>    
     </tbody>
  </table>
  
       <h2 >Purchases</h2>
       
        <table class="table">
    <thead>
      <tr>
        <th>Transaction Date</th>
        <th>Buyer</th>
        <th>Amount</th>
      </tr>
    </thead>
    <tbody>
     <c:forEach var="saletransaction" items="${buyingTransactions}">
     <tr>
        
        <td>${saletransaction.transactionDate}</td>
        <td>${saletransaction.buyer}</td>
        <td>${saletransaction.transactionAmount}</td>
        
      </tr>
    </c:forEach>    
     </tbody>
  </table>
  
  </div>
  </div>
</div>

</body>
</html>
