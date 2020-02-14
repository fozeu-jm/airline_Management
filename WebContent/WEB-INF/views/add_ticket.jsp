<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="header.jsp">
	<c:param name="design" value="bleu" />
</c:import>

<c:import url="sidebar.jsp">
	<c:param name="smallactive" value="addTicket" />
	<c:param name="bigactive" value="Flight" />
</c:import>

<!-- ------------------------------------------------------END OF IMPORTS---------------------------------------------------------------------------------- -->

<section class="content">
	<div class="container-fluid">
		<div class="block-header">
			<h2>Fill form to add a ticket to this flight</h2>
		</div>

		<!-- Basic Validation -->
		<div class="row clearfix">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<div class="card">
					<div class="header">
						<h2>Register Ticket</h2>
						<!--  <ul class="header-dropdown m-r--5">
							<li class="dropdown"><a href="javascript:void(0);"
								class="dropdown-toggle" data-toggle="dropdown" role="button"
								aria-haspopup="true" aria-expanded="false"> <i
									class="material-icons">more_vert</i>
							</a>
								<ul class="dropdown-menu pull-right">
									<li><a href="javascript:void(0);">Action</a></li>
									<li><a href="javascript:void(0);">Another action</a></li>
									<li><a href="javascript:void(0);">Something else here</a></li>
								</ul></li>
						</ul> -->
					</div>
					<div class="body">
						<form id="form_validation" action="addTicket" method="POST">
							<div class="form-group form-float">
								<div class="form-line">
									<input value="${ flight.reference }" type="text" class="form-control" name=""
										required readonly>
										<input value="${ flight.id }" type="text" class="form-control d-none" name="flightId"
										required readonly>  
										<label class="form-label">Flight Reference</label>
								</div>
							</div>
							<div class="form-group">
								<div class="form-line">
								<label class="form-label" style="top: -21px;">Flying Class</label>
									<select name="flightClass" class="select2" required="required">
										<option value=""  disabled>Select Flight Class</option>
										<c:forEach items="${ clist }" var="class">
											<option value="${ class }">${ class }</option>
										</c:forEach>
									</select>

								</div>
							</div>
							
							<div class="form-group form-float">
								<div class="form-line">
									<input type="number" class="form-control" name="price"
										required> <label class="form-label">Price</label>
								</div>
							</div>
							
							<div class="form-group">
								<div class="form-line">
								<label class="form-label" style="top: -21px;">Passenger</label>
									<select name="passId" class="select2" required="required">
										<option value="" disabled>Select passenger</option>
										<option value=""></option>
										<c:forEach items="${ pslist }" var="passenger">
											<option value="${ passenger.id }">${ passenger.firstName } ${ passenger.lastName } </option>
										</c:forEach>
									</select>

								</div>
							</div>

							<button class="btn btn-primary waves-effect" type="submit">SUBMIT</button>
						</form>
					</div>
				</div>
			</div>
		</div>
		<!-- #END# Basic Validation -->

	</div>
</section>

<c:import url="footer.jsp">
</c:import>
