<%@include file="header.jsp"%>
<script type="application/javascript">
function loadJSON()
{
   var isbn = document.getElementById("isbn").value; 
   if(isbn == null || (isbn.length!=13 && isbn.length!=10)){
	   
	   alert("Invalid ISBN. ISBN should have 13 or 10 characters.");
   }
   else{
   
   var data_file = "https://www.googleapis.com/books/v1/volumes?q=isbn:" + isbn;
   console.log(data_file);
   var http_request = new XMLHttpRequest();
   try{
      // Opera 8.0+, Firefox, Chrome, Safari
      http_request = new XMLHttpRequest();
   }catch (e){
      // Internet Explorer Browsers
      try{
         http_request = new ActiveXObject("Msxml2.XMLHTTP");
      }catch (e) {
         try{
            http_request = new ActiveXObject("Microsoft.XMLHTTP");
         }catch (e){
            // Something went wrong
            alert("Your browser broke!");
            return false;
         }
      }
   }
   http_request.onreadystatechange  = function(){
      if (http_request.readyState == 4  )
      {
        // Javascript function JSON.parse to parse JSON data
        var jsonObj = JSON.parse(http_request.responseText);

        
        if(jsonObj.totalItems == 0){
        	alert("Unable to fetch data using ISBN, please fill the details manually");
        	document.getElementById("imageUpload").style.display="inline";
        	document.getElementById("imageDisplay").style.display="none";        	
        }
        else{
        document.getElementById("listingTitle").value  = jsonObj.items[0].volumeInfo.title;
        var imgSrc = jsonObj.items[0].volumeInfo.imageLinks.thumbnail;
        if(imgSrc.indexOf("http" >= 0)){
        	document.getElementById("imageUpload").style.display="none";
        	document.getElementById("imageDisplay").style.display="inline";
        	document.getElementById("coverImage").setAttribute("src", imgSrc);
            document.getElementById("image").value  = imgSrc;

        }
        }
      }
   }
   http_request.open("GET", data_file, true);
   http_request.send();
   }
}
</script>
<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<h2>Add Listing</h2>
			<div class="well well-sm">
				<form class="form-horizontal"
					action="<c:url value='/addedlisting' />" method="post">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
					<fieldset>

						

						<!-- ISBN input-->
						<div class="form-group">
							<label class="col-md-3 control-label" for="isbn">ISBN</label>
							<div class="col-md-9">
								<input id="isbn" name="isbn" type="text" class="form-control">
								<button type="button" onclick="loadJSON()">Update Details Based on ISBN</button>
							
							</div>
							
						</div>
						
						<!-- Product input-->
						<div class="form-group">
							<label class="col-md-3 control-label" for="listingTitle">Book Title</label>
							<div class="col-md-9">
								<input id="listingTitle" name="listingTitle" type="text"
									class="form-control">
							</div>
						</div>
						

						<!-- Image input-->
						<div class="form-group" id="imageUpload" >
							<label class="col-md-3 control-label" for="image">Image</label>
							<div class="col-md-9">
								<input id="imageUpld" name="imageUpld" type="file" class="form-control">
							</div>
						</div>
						
						<!-- Image view-->
						<div class="form-group" id="imageDisplay" style = "display:none">
							<label class="col-md-3 control-label" for="image"></label>
							<div class="col-md-9">
								<img id = "coverImage" alt= "Book Cover" src = "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcTGD0NUGnxyhQ8AdSRxMxfKEo1vN5xnVETO9DQRxt_3N4SuYVqN"/>
							</div>
						</div>

						<!-- College input -->
						<div class="form-group">
							<label class="col-md-3 control-label" for="clgName">College</label>
							<div class="col-md-9">
								<select class="form-control" name="clgName" id="clgName">
									<option value="0">Select a college...</option>
									<!-- <c:forEach var="college" items="${colleges}">
                        	<option>${college}</option>
                        </c:forEach> -->
									<option value="Franklin University">Franklin
										University</option>
									<option value="Ohio State University">Ohio State
										University</option>
									<option value="Devry University">Devry University</option>
									<option value="Otterbein University">Otterbein
										University</option>
								</select>
							</div>
						</div>
						<!-- Product input-->
						<div class="form-group">
							<label class="col-md-3 control-label" for="zip">Zip Code</label>
							<div class="col-md-9">
								<input id="zip" name="zip" type="number" min="0" max="5"
									placeholder="5 digit Code" class="form-control">
							</div>
						</div>
						

						<!-- Price input-->
						<div class="form-group">
							<label class="col-md-3 control-label" for="price">Price</label>
							<div class="col-md-9">
								<input id="price" name="price" type="number" min="0" step="0.25"
									class="form-control">
							</div>
						</div>
						
						<!-- College input -->
						<div class="form-group">
							<label class="col-md-3 control-label" for="quality">Book State</label>
							<div class="col-md-9">
								<select class="form-control" name="quality" id="quality">
									<option value="0">Select a book state...</option>
									<!-- <c:forEach var="college" items="${colleges}">
                        	<option>${college}</option>
                        </c:forEach> -->
									<option value="New">New</option>
									<option value="Like New">Like New</option>
									<option value="Used">Used</option>
									<option value="Acceptable">Acceptable</option>
								</select>
							</div>
						</div>
						<!-- Hidden username input-->
						<input type="hidden" name="username"
						value="${pageContext.request.userPrincipal.name}" />
						<!-- Hidden image input-->
						<input type="hidden" name="image" id="image"
						value="https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcTGD0NUGnxyhQ8AdSRxMxfKEo1vN5xnVETO9DQRxt_3N4SuYVqN" />

						<!-- Form actions -->
						<div class="form-group">
							<div class="col-md-12 text-right">
								<button type="submit" class="btn btn-primary btn-lg">Add</button>
							</div>
						</div>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</div>

<%@include file="footer.jsp"%>