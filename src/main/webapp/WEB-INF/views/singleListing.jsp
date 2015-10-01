<%@include file="header.jsp" %>
        
        <div class="container">
            <div class="row">
            	<div class="col-md-6 col-md-offset-4">
              		<a href="" class="btn btn-default" style="margin-bottom:15px">&larr;</a>
              	</div>
                <div class="col-md-5">
                    <img  align="right" src="${listing.image}" class="img-thumbnail">
                </div>
                <div class="col-md-7">
                    <h2>${listing.listingTitle}<br><small>${listing.isbn}</small></h2>
                    <br>
                    <p>
                        <strong style="text-transform:uppercase;margin-right:10px">Price</strong>
                        <span class="lead bg-primary" style="padding:5px;font-size:2rem;border-radius:5px">${listing.price}</span>
                    </p>
                    <p>
                        <strong style="text-transform:uppercase;margin-right:10px">College</strong>
                        <span class="lead">${listing.clgName}</span>
                    </p>
                    <p>
                        <strong style="text-transform:uppercase;margin-right:10px">Zip Code</strong>
                        <span class="lead">${listing.zip}</span>
                    </p>
                     <p>
                        <strong style="text-transform:uppercase;margin-right:10px">Date Listed</strong>
                        <span class="lead">${listing.listingDate}</span>
                    </p>
                    <br><br>
                    <p>
                        <strong style="text-transform:uppercase;margin-right:10px">Contact</strong>
                        <span class="lead">${user.userName}</span>
                    </p>
                    <p>
                        <strong style="text-transform:uppercase;margin-right:10px">Email</strong>
                        <span class="lead"><a href="mailto:${user.emailAddress}">${user.emailAddress}</a></span>
                    </p>
                    <p>
                        <strong style="text-transform:uppercase;margin-right:10px">Phone Number</strong>
                        <span class="lead">${user.phoneNumber}</span>
                    </p>
                    
                   
                    
                    <c:choose>
                    <c:when test ="${pageContext.request.userPrincipal.name == null}">
                     <div class="col-md-5"> 
                     <p align="center"><a href="login" class="btn btn-success btn-block">Log in to purchase online</a></p>                    
                    </div>
                    </c:when>
                    <c:otherwise>  
                    <div class="col-md-4">                  
                     <p align="center"><a href="purchase/?listingId=${listing.id}" class="btn btn-success btn-block">Purchase Book</a></p>                    
                    </div>
                    </c:otherwise>
                    
                    
                    
                    </c:choose>
                </div>
            </div>
        </div>
        
<%@include file="footer.jsp" %>
