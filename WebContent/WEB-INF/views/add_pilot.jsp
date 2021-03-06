<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="header.jsp">
	<c:param name="design" value="bleu" />
</c:import>

<c:import url="sidebar.jsp">
	<c:param name="smallactive" value="addPilot" />
	<c:param name="bigactive" value="Pilot" />
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
						<h2>ADD PILOT</h2>
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
						<form id="form_validation" action="addPilot" method="POST">
							<div class="form-group form-float">
								<div class="form-line">
									<input type="text" class="form-control" name="firstName"
										required> <label class="form-label">First name</label>
								</div>
							</div>
							<div class="form-group form-float">
								<div class="form-line">
									<input type="text" class="form-control" name="lastName"
										required> <label class="form-label">Last name</label>
								</div>
							</div>
							
							<div class="form-group form-float">
								<div class="form-line">
									<input type="number" class="form-control" name="pilotLicence"
										required> <label class="form-label">Pilot Licence No</label>
								</div>
							</div>
							
							<div class="form-group">
								<div class="form-line">
									<select name="rank" class="form-control show-tick"
										required="required">
										<option value="" selected disabled>Select Pilot Rank</option>
										<c:forEach items="${ requestScope.ranklist }" var="rank">
											<option value="${ rank }">${ rank }</option>
										</c:forEach>
									</select>

								</div>
							</div>
							
							<div class="form-group form-float">
								<div class="form-line">
									<input type="number" class="form-control" name="phoneNo"
										required> <label class="form-label">Phone No</label>
								</div>
							</div>
							
							<div class="form-group form-float">
								<div class="form-line">
									<input type="email" class="form-control" name="email" required>
									<label class="form-label">Email</label>
								</div>
							</div>
							<div class="form-group">
								<input type="radio" value="Male" name="gender" id="male"
									class="with-gap"> <label for="male">Male</label> <input
									type="radio" value="Female" name="gender" id="female"
									class="with-gap"> <label for="female" class="m-l-20">Female</label>
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
