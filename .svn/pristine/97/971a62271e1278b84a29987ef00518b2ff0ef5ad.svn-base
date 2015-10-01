<%@include file="header.jsp"%>

<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<h2>Purchase Book</h2>
			
			<br>
			
			<div class="alert alert-info">
				<h3 style="text-align:center"><small style="font-size:1.4em">${listing.listingTitle}</small></h3>
				<br>
				<p style="text-align:center"><span class="lead bg-primary" style="padding:5px;font-size:2rem;border-radius:5px">$${listing.price}</span></p>
				<br>
			</div>
			
			<br>
			
			<div class="well well-sm">
				<form class="form-horizontal"
					action="<c:url value='/purchaseConfirmation' />" method="post">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
						<fieldset>
						
						<div class="col-md-offset-3"><h3><strong>Payment Details</strong></h3></div>
					
                     <div class="panel-heading display-table" >
                    <div class="row display-tr" >
                        <label class="col-md-3 control-label" ></label>
                        <div class="display-td" >                            
                            <img class="img-responsive " src="http://i76.imgup.net/accepted_c22e0.png">
                        </div>
                    </div>                    
                </div>
                
                
						<!-- Credit Card Type input -->
						<div class="form-group">
							<label class="col-md-3 control-label" for="ccType">Type</label>
							<div class="col-md-9">
								<select class="form-control" name="ccType" id="ccType">
									<option value="0">Select a type...</option>
									<option>VISA</option>
									<option>MasterCard</option>
									<option>American Express</option>
								</select>
							</div>
						</div>

						<!-- Credit Card Name input-->
						<div class="form-group" >
							<label class="col-md-3 control-label" for="ccName">Name on Card</label>
							<div class="col-md-9">
								<input id="ccName" name="ccName" type="text" class="form-control">
							</div>
						</div>

						<!-- Credit Card Number input-->
						<div class="form-group">
							<label class="col-md-3 control-label" for="ccNum">Credit Card #</label>
							<div class="col-md-9">
								<input id="ccNum" name="ccNum" type="text" class="form-control">
							</div>
						</div>
						
						<!-- Credit Card Expiration input-->
						<div class="form-group">
							<label class="col-md-3 control-label" for="ccExp">Expiration Date</label>
							<div class="col-md-9">
								<input id="ccExp" name="ccExp" type="date"
									class="form-control">
							</div>
						</div>
						<!-- Hidden username input-->
						<input type="hidden" name="buyer"
						value="${pageContext.request.userPrincipal.name}" />
						<input type="hidden" name="listingId"
						value="${listing.id}" />
						
						<input type="hidden" name="image" id="image"
						value="" />
						<!-- Form actions -->
						<div class="form-group">
							<div class="col-md-12 text-right">
								<input type="hidden" name="listingId" id="listingId" value="${listing.id}">
								<button type="submit" class="btn btn-primary btn-lg">Purchase</button>
							</div>
						</div>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</div>

<%@include file="footer.jsp"%>