<%@include file="header.jsp" %>
        
       <div class="container">
    <div class="row">
        <div class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">
            <div class="row">
               
                <div class="col-xs-6 col-sm-6 col-md-6 text-right">
                    <p>
                        <em><strong id="date">Date: 1st November, 2013 </strong></em>
                    </p>
                    <p>
                        <em id = "receipt">Receipt #: $7856589H</em>
                    </p>
                </div>
            </div>
            <div class="row">
                <div class="text-center">
                    <h1>Receipt</h1>
                </div>
               
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Product/Book Title</th>
                            <th>Quantity</th>
                            <th class="text-center">Total Price</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td class="col-md-9"><h4><em>${listing.listingTitle}</em></h4></td>
                            <td class="col-md-1" style="text-align: center"> 1 </td>
                            <td class="col-md-1 text-center">$${userTransaction.transactionAmount}</td>
                        </tr>
                       
                        <tr>
                            
                            <td></td>
                            <td class="text-right">
                            <p>
                                <strong>Subtotal:</strong>
                            </p>
                            <p>
                                <strong>Tax:</strong>
                            </p></td>
                            <td class="text-center">
                            <p>
                                <strong id="book_amount">$${userTransaction.transactionAmount}</strong>
                            </p>
                            <p>
                                <strong id="tax_amount">$${userTransaction.transactionAmount*0.06}</strong>
                            </p></td>
                        </tr>
                        <tr>
                            <td></td>                            
                            <td class="text-right"><h4><strong>Total:</strong></h4></td>
                            <td class="text-center text-danger"><h4><strong id="total_amount">$${userTransaction.transactionAmount+userTransaction.transactionAmount*0.06}</strong></h4></td>
                        </tr>                       
                    </tbody>
                </table>
                 <p>Thank you for your purchase</p>
              </div>
            </div>
        </div>
    </div>
    
<script>
var date =  new Date();
document.getElementById("date").innerHTML = "Date: " + (date.getMonth()+1) +'/' + date.getDate() + '/'+ date.getFullYear();
var bookAmount = parseInt((document.getElementById("book_amount").innerHTML).substring(1));
document.getElementById("tax_amount").innerHTML = '$'+(bookAmount * 0.06).toFixed(2);
	document.getElementById("total_amount").innerHTML = '$'+ (bookAmount + (bookAmount * 0.06));
	var randomnumber=Math.floor(Math.random()*9999999);
	document.getElementById("receipt").innerHTML = 'Receipt #: ' +randomnumber;

</script>
        
<%@include file="footer.jsp" %>
