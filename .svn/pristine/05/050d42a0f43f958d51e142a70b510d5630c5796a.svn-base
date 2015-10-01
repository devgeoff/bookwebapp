<%@include file="header.jsp" %>
        
         <div class="container">
            <div class="row">
              <div class="col-md-10 col-md-offset-1">
                  <h1>My Listings</h1>
                  
                  <br>
                  
                  <div class="row">
                    <ul class="thumbnails list-unstyled clearfix">
                        <c:forEach var="listing" items="${listings}">
                            <li class="col-md-3" style="height:400px;margin-bottom:15px">
                                <div class="thumbnail">
                                    <img src="${listing.image}" style="width:200px;max-height:250px">
                                    <div class="caption clearfix">
                                        <h4>${listing.listingTitle}</h4>
                                        <div class="clearfix">
                                            <p class="pull-left">${listing.price}</p>
                                            <p class="pull-right">${listing.zip}</p>
                                        </div>
                                        <div class="col-md-6">
                                        	<p align="center"><a href="" class="btn btn-primary btn-block">Edit</a></p>
                                        </div>
                                        <div class="col-md-6">
                                        	<p align="center"><a href="" class="btn btn-danger btn-block">Delete</a></p>
                                       	</div>
                                    </div>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                  </div>
                  
              </div>
            </div>
        </div>
        
<%@include file="footer.jsp" %>