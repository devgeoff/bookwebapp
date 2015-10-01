<%@include file="header.jsp" %>
        
        <div class="container">
            <div class="row">
              <div class="col-md-6 col-md-offset-3">
              	<h2>Edit Listing</h2>
                <div class="well well-sm">
                  <form class="form-horizontal" action="" method="post">
                  <fieldset>
            
                    <!-- Product input-->
                    <div class="form-group">
                      <label class="col-md-3 control-label" for="product">Product</label>
                      <div class="col-md-9">
                        <input id="product" name="product" type="text" class="form-control" value="${listing.product}">
                      </div>
                    </div>
            
                    <!-- ISBN input-->
                    <div class="form-group">
                      <label class="col-md-3 control-label" for="isbn">ISBN</label>
                      <div class="col-md-9">
                        <input id="isbn" name="isbn" type="text" class="form-control" value="${listing.isbn}">
                      </div>
                    </div>
                    
                    <!-- Image input-->
                    <div class="form-group">
                      <label class="col-md-3 control-label" for="image">Image</label>
                      <div class="col-md-9">
                        <input id="image" name="image" type="file" class="form-control" value="${listing.image}">
                      </div>
                    </div>
                    
                     <!-- Price input-->
                    <div class="form-group">
                      <label class="col-md-3 control-label" for="price">Price</label>
                      <div class="col-md-9">
                      	<div class="input-group">
                      		<div class="input-group-addon">$</div>
                        	<input id="price" name="price" type="number" min="0" step="0.25" class="form-control" value="${listing.price}">
                      	</div>
                      </div>
                    </div>
            
                    <!-- College input -->
                    <div class="form-group">
                      <label class="col-md-3 control-label" for="college">College</label>
                      <div class="col-md-9">
                        <select class="form-control" name="college" id="college" value="${listing.clgName}">
                        	<option value="0">Select a college...</option>
                        <c:forEach var="college" items="${colleges}">
                        	<c:choose>
	                        	<c:when test="${college == listing.clgName}">
	                        		<option selected>${college}</option>
	                        	</c:when>
	                        	<c:otherwise>
	                        		<option>${college}</option>
                        		</c:otherwise>
                       		</c:choose>
                        </c:forEach>
                        </select>
                      </div>
                    </div>
                    
                     <!-- Zip Code input-->
                    <div class="form-group">
                      <label class="col-md-3 control-label" for="zip">Zip</label>
                      <div class="col-md-9">
                        <input id="zip" name="zip" type="text" class="form-control" value="${listing.zip}">
                      </div>
                    </div>
                    
                    <!-- Form actions -->
                    <div class="form-group">
                      <div class="col-md-12 text-right">
                        <button type="submit" class="btn btn-primary btn-lg">Update</button>
                      </div>
                    </div>
                  </fieldset>
                  </form>
                </div>
              </div>
            </div>
        </div>
        
<%@include file="footer.jsp" %>