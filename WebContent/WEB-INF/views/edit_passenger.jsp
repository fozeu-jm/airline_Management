<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:import url="header.jsp">
	<c:param name="design" value="bleu" />
</c:import>

<c:import url="sidebar.jsp">
	<c:param name="smallactive" value="editPassenger" />
	<c:param name="bigactive" value="Passenger" />
</c:import>

<!-- ------------------------------------------------------END OF IMPORTS---------------------------------------------------------------------------------- -->

<section class="content">
	<div class="container-fluid">
		<div class="block-header">
			<h2>Fill form to save passenger</h2>
		</div>

		<!-- Basic Validation -->
		<div class="row clearfix">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<div class="card">
					<div class="header">
						<h2>EDIT PASSENGER</h2>
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
						<form id="form_validation" action="editPassenger" method="POST">
							<div class="form-group form-float">
								<div class="form-line">
									<input type="text" class="form-control" name="firstName"
										value="${ requestScope.p.firstName }" required> <label
										class="form-label">First name</label>
										
										<input type="text" class="form-control" name="pid"
										value="${ requestScope.p.id }" readonly style="display: none;">
								</div>
							</div>
							<div class="form-group form-float">
								<div class="form-line">
									<input type="text" class="form-control" name="lastName"
										value="${ requestScope.p.lastName }" required> <label
										class="form-label">Last name</label>
								</div>
							</div>
							<div class="form-group">
								<div class="form-line" id="bs_datepicker_container">
									<fmt:formatDate value="${requestScope.p.dob}" var="pdob"
										type="date" pattern="dd-MM-yyyy" />
									<input type="text" value="${ pdob }" readonly name="dob"
										class="form-control" data-date-format="dd-mm-yyyy"
										placeholder="Date of birth..." />
								</div>
							</div>
							<div class="form-group form-float">
								<div class="form-line">
									<input type="number" value="${ requestScope.p.passNo }"
										class="form-control" name="passNumber" required> <label
										class="form-label">Passport number</label>
								</div>
							</div>
							<!-- <div class="form-group">
								<div class="form-line">
									<select name="flightClass" class="form-control show-tick"
										required="required">
										<option value="" selected disabled>Select Flight
											Class</option>
										<option value="Economy">Economy</option>
										<option value="Business">Business</option>
										<option value="First">First</option>
									</select>

								</div>
							</div>-->
							<div class="form-group form-float">
								<div class="form-line">
									<input type="email" value="${ requestScope.p.email }"
										class="form-control" name="email" required> <label
										class="form-label">Email</label>
								</div>
							</div>
							<div class="form-group">
								

								<c:choose>
									<c:when test="${requestScope.p.gender == 'Male'}">
										<input checked type="radio" value="Male" name="gender" id="male"
										class="with-gap"> <label for="male">Male</label>
									</c:when>
									
									<c:when test="${requestScope.p.gender != 'Male'}">
										<input type="radio" value="Male" name="gender" id="male"
										class="with-gap"> <label for="male">Male</label>
									</c:when>
								</c:choose>
								
								<c:choose>
									<c:when test="${requestScope.p.gender == 'Female'}">
										<input checked type="radio" value="Female" name="gender" id="female"
									class="with-gap"> <label for="female" class="m-l-20">Female</label>
									</c:when>
									
									<c:when test="${requestScope.p.gender != 'Female'}">
										<input type="radio" value="Female" name="gender" id="female"
									class="with-gap"> <label for="female" class="m-l-20">Female</label>
									</c:when>
									
								</c:choose>

								
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
