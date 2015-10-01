<%@include file="header.jsp" %>
        
         <div class="container">
            <div class="row">
              <div class="col-md-10 col-md-offset-1">
                  <h1>Listings</h1>
                  
                  <br>
                  
                  <div class="row">
                      <div class="col-md-10">
                          <div class="input-group">
                            <div class="input-group-addon">Search</div>
                            <input type="text" class="form-control" id="search">
                          </div>
                      </div>
                      <div class="col-md-2 text-right">
                          <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#filter">
                              Filter Options
                          </button>
                      </div>
                  </div>
                  
                  <div class="modal fade" id="filter" style="top: 150px">
                      <div class="modal-dialog">
                          <div class="modal-content">
                              <div class="modal-header">
                                  <button type="button" class="close" data-dismiss="modal">
                                      <span>&times;</span>
                                  </button>
                                  <h3 class="modal-title">Filter by:</h3>
                              </div>
                              <div class="modal-body">
                                  <form class="form-horizontal" style="padding:20px">
                                      <div class="form-group">
                                          <label for="college">College</label>
                                          <select class="form-control" id="college">
                                              <option>All</option>
                                              <c:forEach var="college" items="${colleges}">
                                                  <option>${college}</option>
                                              </c:forEach>
                                          </select>
                                      </div>
                                      <div class="form-group">
                                          <label for="zip">Zip Code</label>
                                          <input type="text" class="form-control" id="zip">
                                      </div>
                                  </form>
                              </div>
                              <div class="modal-footer">
                                  <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
                              </div>
                          </div>
                      </div>
                  </div>
                  
                  <br>
                  
                  <div class="row">
                    <ul class="thumbnails list-unstyled clearfix">
                        <c:forEach var="listing" items="${listings}">
                            <li class="col-md-3" style="height:400px">
                                <div class="thumbnail">
                                    <img src="${listing.image}" style="width:200px;max-height:250px">
                                    <div class="caption">
                                        <h4>${listing.listingTitle}</h4>
                                        <div class="clearfix">
                                            <p class="pull-left">${listing.price}</p>
                                            <p class="pull-right">${listing.zip}</p>
                                        </div>
                                        <p align="center"><a href="singleListing?listingId=${listing.id}" class="btn btn-primary btn-block">View</a></p>
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